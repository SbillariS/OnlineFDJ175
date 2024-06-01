package com.crud.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("/getProduct")
		public ResponseEntity<List<Product>> getpro(){
			
			List<Product> list =psi.Product();
			return new ResponseEntity<List<Product>>(list, HttpStatus.ACCEPTED);
			
		}

	@PostMapping("/savaProduct")
	public ResponseEntity<Product> savaProduct(@RequestPart("text") String details,@RequestPart("img") MultipartFile productimg)
	{
		Product p=psi.savaProduct(details,productimg);
		return new ResponseEntity<Product>(p,HttpStatus.CREATED);
		
	}
	
	@GetMapping("/getSingleProduct/{productid}")
	public ResponseEntity<Product> getSingleProduct(@PathVariable int productid)
	{
		Product p=psi.getSingleProduct(productid);
		return new ResponseEntity<Product>(p,HttpStatus.OK);	
	}
	
	@DeleteMapping("/deleteSingleProduct/{productid}")
	public ResponseEntity<List<Product>> deleteSingleProduct(@PathVariable int productid)
	{
		List<Product> list=psi.deleteSingleProduct(productid);
		return new ResponseEntity<List<Product>>(list,HttpStatus.OK);	
		
	}
}

