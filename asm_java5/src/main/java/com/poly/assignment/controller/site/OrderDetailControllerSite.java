package com.poly.assignment.controller.site;

import com.poly.assignment.dto.CartItemDTO;
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
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;
import java.util.List;

@Controller
@RequestMapping("site/orderdetail")
public class OrderDetailControllerSite {

	@Autowired
	OrderDetailsRepository orderDetailsRepository;
//	@Autowired
//	OrdersRepository ordersRepository;
//	
	@Autowired
	OrderService orderService;
	@Autowired
	SessionService sessionService;

	@Autowired
	ShoppingCartService shoppingCartService;

//	@Autowired
//	VegetableRepository productsRepository;
	@Autowired
	VegetableService service;

	@RequestMapping("/add")
	public ModelAndView add(ModelMap model) {
		Collection<CartItemDTO> cartItem = shoppingCartService.getProduct();
		for (CartItemDTO item : cartItem) {
			OrderDetail entityOD = new OrderDetail();

			Vegetable product = service.getById(item.getProductID());
			Order order = sessionService.get("order");

			entityOD.setOrder(order);
			entityOD.setProduct(product);
			entityOD.setQuantity(item.getQuantity());
			entityOD.setUnitPrice(item.getUnitPrice());
		}
		model.addAttribute("message", "Create billing successfully. Input infomation");
		sessionService.remove("order");
		shoppingCartService.clear();
		return new ModelAndView("site/orders/ordertb", model);
	}

	@RequestMapping("/list/{orderId}")
	public ModelAndView list(ModelMap model, @PathVariable("orderId") Integer orderId) {

		Order order = new Order();
		order = orderService.getById(orderId);

//		System.out.println("oke41");
//
//		System.out.println("oke51");

		List<OrderDetail> resultPage = null;

		
		if (order != null) {
			resultPage = orderDetailsRepository.findByOrder(order);

			
		}
		model.addAttribute("orderdetails", resultPage);
		return new ModelAndView("site/ordersdetail/list", model);
	}
}
