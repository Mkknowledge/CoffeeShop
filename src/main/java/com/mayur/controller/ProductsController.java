package com.mayur.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mayur.model.Product;
import com.mayur.repository.ProductRepository;

@Controller
public class ProductsController {

	@Autowired
	ProductRepository productRepository;
	
	@RequestMapping("product/{id}")
	public String product(@PathVariable Long id, Model model) {
		model.addAttribute("product", productRepository.findById(id));	
		return "product";
	}
	
	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public String productList(Model model) {
		model.addAttribute("products", productRepository.findAll());
		return "products";
	}
	
	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	@ResponseBody
	public String saveProduct(@RequestBody Product product) {
		productRepository.save(product);
		return product.getProductId().toString();
	}
		
}
