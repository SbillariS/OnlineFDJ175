package com.crud.servicei;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.crud.Model.Product;

public interface ProductServiceI {

	List<Product> Product();

	public Product savaProduct(String details, MultipartFile productimg);

	public Product getSingleProduct(int productid);

	public List<Product> deleteSingleProduct(int productid);

	

}
