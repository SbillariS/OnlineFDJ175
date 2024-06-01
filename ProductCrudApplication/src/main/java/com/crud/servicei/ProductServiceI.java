package com.crud.servicei;

import org.springframework.web.multipart.MultipartFile;

import com.crud.Model.Product;

public interface ProductServiceI {

	public Product savaProduct(String details, MultipartFile productimg);

}
