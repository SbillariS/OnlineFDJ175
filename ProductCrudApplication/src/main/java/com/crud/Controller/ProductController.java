package com.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.crud.Model.Product;
import com.crud.servicei.ProductServiceI;

@RestController
public class ProductController 
{
	@Autowired
	ProductServiceI psi;
	
	@GetMapping("/getProduct")
		public ResponseEntity<List<Product>> getpro(){
			
			List<Product> list =psi.Product();
			return new ResponseEntity<List<Product>>(list, HttpStatus.ACCEPTED);
			
		}
	}
	


