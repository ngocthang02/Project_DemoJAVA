package com.poly.assignment.controller.site;

import com.poly.assignment.dto.VegetableDTO;
import com.poly.assignment.entities.Vegetable;
import com.poly.assignment.repositories.VegetableRepository;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("site/vegetable")
public class VegetableControllerSite {
	
	@Autowired
	VegetableRepository productsRepository;
	
	@RequestMapping("/detail/{productId}")
	public ModelAndView test(ModelMap model,
			@PathVariable("productId") Long productId) {
			
			Optional<Vegetable> opt = productsRepository.findById(productId);
			VegetableDTO dto = new VegetableDTO();
			if(opt.isPresent()) {
				Vegetable entity = opt.get();
				BeanUtils.copyProperties(entity, dto);
				
				model.addAttribute("product", dto);
				
				return new ModelAndView("site/vegetables/vegetabledetail", model);
			}
			
		model.addAttribute("product", new VegetableDTO());
		
		return new ModelAndView("site/vegetables/vegetabledetail", model);
	}
}
