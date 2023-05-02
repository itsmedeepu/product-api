package com.jsp.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.productservice.entity.ProductEntity;
import com.jsp.productservice.serviceimpl.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	private ProductServiceImpl productServiceImpl;

	@PostMapping("/saveproduct")
	public @ResponseBody ProductEntity saveProduct(@RequestBody ProductEntity productentity) {

		return productServiceImpl.saveProduct(productentity);

	}

	@GetMapping("/getproduct/{id}")
	public @ResponseBody ProductEntity findProductById(@PathVariable("id") Long id) {

		return productServiceImpl.findProductById(id);

	}

	@GetMapping("/getallproducts")
	public @ResponseBody List<ProductEntity> findAllProduct() {
		return productServiceImpl.findAllProduct();

	}

	@GetMapping("/getQuantity/{id}")
	public @ResponseBody Integer findProductQuantityById(@PathVariable("id") Long id) {

		return productServiceImpl.findProductQuantityById(id);

	}

	@DeleteMapping("/deleteproduct/{id}")
	public @ResponseBody ProductEntity deleteProductbyId(@PathVariable("id") Long id) {
		return productServiceImpl.deleteProductbyId(id);

	}

	public ProductEntity product(ProductEntity productEntity) {
		return null;
	}

}
