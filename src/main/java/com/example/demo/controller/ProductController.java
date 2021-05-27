package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Product;
import com.example.demo.service.ProductService;

@RestController
@RequestMapping(value = "/product")
public class ProductController 
{
	@Autowired
	private ProductService pservice;
	/*
	 * http://localhost:8080/product/saveProduct
	 * {
	 *   "pname":"Sony Headphones",
	 *   "price":9800.334
	 * }
	 */
	@PostMapping(value = "/saveProduct")
	public ResponseEntity<String> saveProduct(@RequestBody Product product)
	{
		Product p=pservice.saveProduct(product);
		return new ResponseEntity<String>("Product Saved With ID :"+p.getPid(),HttpStatus.CREATED);
	}
	
	/*
	 * http://localhost:8080/product/allProducts
	 */
	@GetMapping(value = "/allProducts")
	public ResponseEntity<List<Product>> getAllProducts()
	{
		return new ResponseEntity<List<Product>>(pservice.getAllProducts(),HttpStatus.OK);
	}
	
	

}
