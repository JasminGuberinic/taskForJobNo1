package com.boot.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.boot.models.Product;
import com.boot.service.ProductService;

import org.springframework.web.bind.annotation.RequestMethod;
@RestController
@RequestMapping("api/v1/")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value = "product", method = RequestMethod.POST)
	public Product create(@RequestBody Product product) {
		return productService.create(product);
	}
	
	@RequestMapping(value = "product/{id}", method = RequestMethod.GET)
	public Product get(@PathVariable String id) {
		return productService.get(id);
	}
	
	@RequestMapping(value = "products", method = RequestMethod.GET)
	public List<Product> getAll() {
		return productService.getAll();
	}
	
	@RequestMapping(value = "product/{id}", method = RequestMethod.PUT)
	public Product update(@PathVariable String id, @RequestBody Product product) {
		return productService.update(id, product);
	}
	
	@RequestMapping(value = "product/{id}", method = RequestMethod.DELETE)
	public Product delete(@PathVariable String id) {
		return productService.delete(id);
	}
	
}
