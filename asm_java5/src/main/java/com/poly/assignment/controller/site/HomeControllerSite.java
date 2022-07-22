package com.poly.assignment.controller.site;

import com.poly.assignment.entities.Vegetable;
import com.poly.assignment.services.SessionService;
import com.poly.assignment.services.VegetableService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;




@Controller
@RequestMapping("site/home")
public class HomeControllerSite {

    @Autowired
//    VegetableRepository productsRepository;
    VegetableService vegetableService;
    @Autowired
    SessionService sessionService;

//	@ModelAttribute("customerName")
//	public String getName(Model model) {
//		Customer customer = sessionService.get("customer");
//		model.addAttribute("customerId", customer != null ? customer.getCustomerId(): null);
//		return customer != null ?  customer.getName() :"Người dùng";
//	}

//    @RequestMapping("")
//    public String home() {
//        return "site/products/home";
//    }

    @RequestMapping(value = "sp", method = { RequestMethod.GET, RequestMethod.POST })
    public String search(ModelMap model,@RequestParam(name = "pageNumber", defaultValue = "0", required = false) int pageNumber) {


        Page<Vegetable> list = vegetableService.findPage(pageNumber);

        model.addAttribute("productPage", list);
        return "site/vegetables/vegetablehome";
    }
    
    @RequestMapping("/searchpaginated")
    	public String search() {
    		return "";
    	}

}
