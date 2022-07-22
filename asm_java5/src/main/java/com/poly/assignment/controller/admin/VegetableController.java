package com.poly.assignment.controller.admin;

import com.poly.assignment.dto.CategoryDTO;
import com.poly.assignment.dto.VegetableDTO;
import com.poly.assignment.entities.Category;
import com.poly.assignment.entities.Vegetable;

import com.poly.assignment.services.CategoryServices;
import com.poly.assignment.services.ShoppingCartService;
import com.poly.assignment.services.StorageService;
import com.poly.assignment.services.VegetableService;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import java.util.stream.Collectors;


@Controller
@RequestMapping("admin/vegetables/")
public class VegetableController {
	@Autowired
	VegetableService vegetableService;

	@Autowired
	CategoryServices categoryServices;

	@Autowired
	StorageService storageService;
	@Autowired
	ShoppingCartService shoppingCartService;
	@ModelAttribute("categories")
	public List<CategoryDTO> getcategory() {
		return categoryServices.findAll().stream().map(item -> {
			CategoryDTO dto = new CategoryDTO();
			BeanUtils.copyProperties(item, dto);
			return dto;
		}).collect(Collectors.toList());
	}

	@GetMapping("add")
	public String add(Model model) {
		model.addAttribute("product", new VegetableDTO());
		
		return "admin/vegetables/add-edit";
	}

	@GetMapping("edit/{productID}")
	public ModelAndView edit(ModelMap model, @PathVariable("productID") Long productID) {
		VegetableDTO dto = new VegetableDTO();

		Optional<Vegetable> opt = vegetableService.findById(productID);

		if (opt.isPresent()) {
			Vegetable entity = opt.get();
			BeanUtils.copyProperties(entity, dto);

			dto.setCategoryID(entity.getCategory().getCategoryID());
			//dto.setEnteredDate(new Date());
			dto.setIsEdit(true);

			model.addAttribute("product", dto);

			return new ModelAndView("admin/vegetables/add-edit");
		}

		// khi không thấy product thì hiện thị lại list product
		model.addAttribute("message", "Category is not existed");

		return new ModelAndView("forward:/admin/vegetables/sp/", model);
	}

	@PostMapping(value = "saveOrUpdate")
	public ModelAndView saveOrUpdate(ModelMap model, VegetableDTO dto, BindingResult result) {

//        //check nếu lỗi thì trả lại view trang add hoặc edit
//        if (result.hasErrors()) {
//            return new ModelAndView("admin/products/add-edit");
//        }

		// System.out.println("image is null " + dto.getImage() == null);

		Vegetable entity = new Vegetable();
		//entity.setEnteredDate(new Date());
		BeanUtils.copyProperties(dto, entity);

		Category category = new Category();
		category.setCategoryID(dto.getCategoryID());
		entity.setCategory(category);

		if (!dto.getImageFile().isEmpty()) {
			UUID uuid = UUID.randomUUID();
			String uuString = uuid.toString();

			entity.setImage(storageService.getStoredFilename(dto.getImageFile(), uuString));
			storageService.store(dto.getImageFile(), entity.getImage());
			System.out.println("uploading image: " + entity.getImage());
		}
		
		vegetableService.save(entity);
		int countCart = shoppingCartService.getCount();
		if(countCart>0) {
			shoppingCartService.updatePrice(entity.getProductID());
		}
		return new ModelAndView("forward:/admin/vegetables/sp/", model);
	}

	@GetMapping("delete/{productID}")
	public ModelAndView delete(ModelMap model, @PathVariable("productID") Long productID) throws IOException {

		Optional<Vegetable> opt = vegetableService.findById(productID);
		if (opt.isPresent()) {
			if (!StringUtils.isEmpty(opt.get().getImage())) {
				storageService.delete(opt.get().getImage());
			}
			vegetableService.delete(opt.get());
			model.addAttribute("message", "product is delete");
		}
		model.addAttribute("message", "product not found");

		return new ModelAndView("forward:/admin/vegetables/sp/", model);
	}

	@RequestMapping(value = "sp", method = { RequestMethod.GET, RequestMethod.POST })
	//@GetMapping("/sp")
	public String list(ModelMap model,
			@RequestParam(name = "pageNumber", defaultValue = "0", required = false) int pageNumber) {
		Page<Vegetable> list = vegetableService.findPage(pageNumber);

		model.addAttribute("products", list);
		return "admin/vegetables/list";
	}

	@GetMapping("search")
	// dùng required để xác định có param hoặc không có đều được
	public String search(ModelMap model, @RequestParam(name = "name", required = false) String name) {

		List<Vegetable> list = null;

		// check xem có giá trị name được truyền vào từ param hay không
		if (StringUtils.hasText(name)) {
			list = vegetableService.findByNameContaining(name);
		} else {
			list = vegetableService.findByNameContaining(name);
		}
		// thêm list cate vào attribute để hiển thị lên form
		model.addAttribute("products", list);

		return "admin/vegetables/list";
	}


	@GetMapping("/images/{filename:.+}")
	// dùng responseBody để không trả về view
	@ResponseBody
	public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
		Resource file = storageService.loadAsResource(filename);

		return ResponseEntity.ok()
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
				.body(file);

	}

}
