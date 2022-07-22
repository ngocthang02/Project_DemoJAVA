package com.poly.assignment.controller.site;

import com.poly.assignment.dto.CartItemDTO;
import com.poly.assignment.entities.Vegetable;
import com.poly.assignment.repositories.VegetableRepository;
import com.poly.assignment.services.ShoppingCartService;
import com.poly.assignment.services.VegetableService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("site/shoppingCart")
public class ShoppingCartController {

	@Autowired
	VegetableService vegetableService;

	@Autowired
	ShoppingCartService shoppingCartService;

	@RequestMapping("/list")
	public String list(Model model) {
		Collection<CartItemDTO> cartItem = shoppingCartService.getProduct();
		model.addAttribute("cartItem", cartItem);
		model.addAttribute("total", shoppingCartService.getAmount());
		model.addAttribute("NoOfItems", shoppingCartService.getCount());

		return "site/shoppingCarts/list";
	}

	@GetMapping("/add/{productID}")
	public String add(@PathVariable("productID") Long productId) {
		Optional<Vegetable> opt = vegetableService.findById(productId);
		if (opt.isPresent()) {
			Vegetable product = opt.get();
			CartItemDTO item = new CartItemDTO();

			BeanUtils.copyProperties(product, item);

			item.setQuantity(1);
			shoppingCartService.add(item);
		}
		return "redirect:/site/shoppingCart/list";
	}

	@GetMapping("/remove/{productID}")
	public String remove(@PathVariable("productID") Long productId) {

		shoppingCartService.remove(productId);
		;

		return "redirect:/site/shoppingCart/list";
	}

	@PostMapping("/update")
	public String update(@RequestParam("productID") Long productId, @RequestParam("quantity") Integer quantity) {
		Vegetable vegetable = vegetableService.getById(productId);
		
		if (quantity > vegetable.getQuantity()) {
			quantity = vegetable.getQuantity();
		
			return "redirect:/site/shoppingCart/list";

		}
		
		shoppingCartService.update(productId, quantity);

		return "redirect:/site/shoppingCart/list";
	}

}
