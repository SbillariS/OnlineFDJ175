package com.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.crud.Model.Product;
import com.crud.servicei.ProductServiceI;

@RestController
public class ProductController 
{
	@Autowired
	ProductServiceI psi;
	
	@PostMapping("/savaProduct")
	public ResponseEntity<Product> savaProduct(@RequestPart("text") String details,@RequestPart("img") MultipartFile productimg)
	{
		Product p=psi.savaProduct(details,productimg);
		return new ResponseEntity<Product>(p,HttpStatus.CREATED);
		
	}
}
