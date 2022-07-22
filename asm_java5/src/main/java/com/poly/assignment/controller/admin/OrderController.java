package com.poly.assignment.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.servlet.ModelAndView;

import com.poly.assignment.entities.Order;
import com.poly.assignment.entities.OrderDetail;

import com.poly.assignment.repositories.CustomerRepository;
import com.poly.assignment.repositories.OrderDetailsRepository;

import com.poly.assignment.services.OrderService;

@Controller
@RequestMapping("/admin/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	OrderDetailsRepository detailsRepository;

	@RequestMapping(value = " ", method = { RequestMethod.GET, RequestMethod.POST })
	public String list(ModelMap model) {
		List<Order> list = orderService.findAll();
		model.addAttribute("orders", list);

		return "admin/orders/list";
	}

	@GetMapping("/orderDetail/{orderId}")
	public ModelAndView orderDetail(ModelMap model, @PathVariable("orderId") Integer orderId) {
		Order order = new Order();
		order = orderService.getById(orderId);
		List<OrderDetail> result = null;
		result = detailsRepository.findByOrder(order);
		model.addAttribute("orderDetail", result);

		return new ModelAndView("site/orders/list", model);
	}

	@GetMapping("delete/{orderId}")
	public ModelAndView delete(ModelMap model, @PathVariable("orderId") Integer orderId) {

		orderService.deleteById(orderId);
		return new ModelAndView("redirect:/admin/orders ", model);
	}

	@GetMapping("edit/{orderId}")
	public ModelAndView edit(ModelMap model, @PathVariable("orderId") Integer orderId) {
		Order order = orderService.getById(orderId);
		short sttDefault = 0;
		short sttEdit = 1;
		if (order.getStatus() == sttDefault) {
			Integer shortcv = 1;
			short stt = shortcv.shortValue();
			order.setStatus(stt);
		} else if (order.getStatus() == sttEdit) {
			order.setStatus(sttDefault);
		}

		orderService.save(order);
		return new ModelAndView("redirect:/admin/orders ", model);
	}
}
