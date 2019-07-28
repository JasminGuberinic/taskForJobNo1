package com.boot.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.boot.models.Product;
import com.boot.repository.ProductsRepository;

@Service
public class ProductService {
	@Autowired
	private ProductsRepository productsRepository;
	
	public Product create(@RequestBody Product product) {
		product.setId(UUID.randomUUID().toString());
		return productsRepository.saveAndFlush(product);
	}
	
	public Product get(@PathVariable String id) {
		return productsRepository.findOne(id);
	}
	
	public List<Product> getAll() {
		return productsRepository.findAll();
	}
	
	public Product update(@PathVariable String id, @RequestBody Product product) {
		Product oldProductInfo =productsRepository.findOne(id);
		BeanUtils.copyProperties(product, oldProductInfo);
		return productsRepository.saveAndFlush(product);
	}
	
	public Product delete(@PathVariable String id) {
		Product product =productsRepository.findOne(id);
		productsRepository.delete(product);
		return product;
	}
}
