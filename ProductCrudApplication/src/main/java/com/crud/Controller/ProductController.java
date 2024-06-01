package com.crud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.crud.servicei.ProductServiceI;

@RestController
public class ProductController 
{
	@Autowired
	ProductServiceI psi;
}
