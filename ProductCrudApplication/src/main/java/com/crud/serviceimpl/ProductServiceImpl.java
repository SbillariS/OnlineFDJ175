package com.crud.serviceimpl;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.crud.Model.Product;
import com.crud.repository.ProductRepo;
import com.crud.servicei.ProductServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class ProductServiceImpl implements ProductServiceI
{ 
	@Autowired
	ProductRepo pr;
	
	@Override
	public Product savaProduct(String details, MultipartFile productimg) 
	{
		ObjectMapper mapper=new ObjectMapper();
		Product prod=null;
		try {
			prod=mapper.readValue(details, Product.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		if(prod!=null)
		{
			try {
				prod.setImg(productimg.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			return pr.save(prod);
		}
		return null;
	}

}
