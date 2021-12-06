package com.altmetrik.assignment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.altmetrik.assignment.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	@GetMapping(path = "/product/{index}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Integer getProductValueByIndex(@PathVariable int index) {
		return productService.getProductValueByIndex(index);
	}

}
