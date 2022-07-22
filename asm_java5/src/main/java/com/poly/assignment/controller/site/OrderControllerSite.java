package com.poly.assignment.controller.site;

import com.poly.assignment.dto.CartItemDTO;
import com.poly.assignment.dto.OrderDetailDTO;
import com.poly.assignment.entities.Customer;
import com.poly.assignment.entities.Order;
import com.poly.assignment.entities.OrderDetail;
import com.poly.assignment.entities.Vegetable;
import com.poly.assignment.repositories.OrderDetailsRepository;

import com.poly.assignment.services.OrderService;
import com.poly.assignment.services.SessionService;
import com.poly.assignment.services.ShoppingCartService;
import com.poly.assignment.services.VegetableService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("site/orders")
public class OrderControllerSite {
	@Autowired
	ShoppingCartService cartService;
	@Autowired
	// VegetableRepository productsRepository;
	VegetableService vegetableService;
	@Autowired
	OrderService orderService;

	@Autowired
	SessionService sessionService;

	@Autowired
	OrderDetailsRepository orderDetailsRepository;

	@Autowired
	VegetableService service;

	@RequestMapping("/add/{total}")
	public String add(Model model, @PathVariable("total") BigDecimal total) {

		Customer customer = new Customer();
		try {
			customer = sessionService.get("customer");
			if (customer != null) {
				Date date = new Date();

				Order order = new Order();
				order.setAmount(total);
				order.setCustomer(customer);
				order.setOrderDate(date);
				orderService.save(order);
				Collection<CartItemDTO> cartItemDTOs = cartService.getProduct();
				for (CartItemDTO cartItemDTO : cartItemDTOs) {
					OrderDetailDTO detailDTO = new OrderDetailDTO();
					OrderDetail detail = new OrderDetail();
					detailDTO.setQuantity(cartItemDTO.getQuantity());
					detailDTO.setUnitPrice(cartItemDTO.getUnitPrice());

					detailDTO.setOrderId(order.getOrderId());
					//detail.setProductId(vegetableService.f)
					 detailDTO.setProductId(vegetableService.findByIda(cartItemDTO.getProductID()));

					System.out.println(order.getOrderId());

					org.springframework.beans.BeanUtils.copyProperties(detailDTO, detail);

					orderDetailsRepository.save(detail);

					Vegetable vegetable = vegetableService.findByIda(cartItemDTO.getProductID());
					int productID = vegetable.getQuantity();
					int sl = detailDTO.getQuantity();
					int updateQuantity = productID - sl;
					service.updateQuantity(vegetable.getProductID(), updateQuantity);
					orderDetailsRepository.save(detail);

				}
				sessionService.set("order", order);
				model.addAttribute("message", "Create billing");
			} else {
				model.addAttribute("message", "You must Login");
				return "site/orders/ordertb";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", "Login error");
		}

		return "redirect:/site/orderdetail/add";
	}

	@RequestMapping("/list")
	public ModelAndView list(ModelMap model, @RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size) {

		Customer customer = new Customer();
		customer = sessionService.get("customer");

		List<Order> resultPage = null;
		if (customer != null) {
			resultPage = orderService.findByCutomer(customer);

			System.out.println("oke7");
		}
		model.addAttribute("orders", resultPage);
		return new ModelAndView("site/orders/list", model);
	}
}
