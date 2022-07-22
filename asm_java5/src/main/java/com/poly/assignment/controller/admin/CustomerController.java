package com.poly.assignment.controller.admin;


 
import com.poly.assignment.dto.CustomerDTO;
import com.poly.assignment.entities.Customer;
  
import com.poly.assignment.services.CustomerService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("admin/customers")
public class CustomerController {

    @Autowired
    CustomerService  customerService;


    @RequestMapping("/add")
    public String add(Model model) {
        model.addAttribute("customer", new CustomerDTO());
        return "admin/customers/add-edit";
    }

    @PostMapping("/saveOrUpdate")
    public ModelAndView saveOrUpdate(ModelMap model,
                                     @Valid @ModelAttribute("customer") CustomerDTO dto,
                                     BindingResult result) {


        Customer entity = new Customer();
        BeanUtils.copyProperties(dto, entity);

        customerService.save(entity);

        model.addAttribute("message", "customer is save");

        return new ModelAndView("forward:/admin/customers/", model);
    }

    @RequestMapping(value = " ", method = {RequestMethod.GET, RequestMethod.POST})
    public String list(ModelMap model) {

        List<Customer> list = customerService.findAll();


		model.addAttribute("customers",list);
		return"admin/customers/list";
}

    @GetMapping("/edit/{customerId}")
    public ModelAndView edit(ModelMap model,
                             @PathVariable("customerId") Integer customerId) {

        Optional<Customer> opt = customerService.findById(customerId);
        CustomerDTO dto = new CustomerDTO();

        if (opt.isPresent()) {
            Customer entity = opt.get();

            BeanUtils.copyProperties(entity, dto);
            dto.setIsEdit(true);

            model.addAttribute("customer", dto);
            return new ModelAndView("admin/customers/add-edit", model);
        }
        model.addAttribute("message", "Customer is not exits");
        return new ModelAndView("forward:admin/customers/", model);
    }

    @GetMapping("/delete/{customerId}")
    public ModelAndView delete(ModelMap model,
                               @PathVariable("customerId") Integer customerId) {

    	customerService.deleteById(customerId);

        return new ModelAndView("forward:/admin/customers/", model);
    }

}
