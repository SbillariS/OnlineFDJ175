package com.crud.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

import org.springframework.web.multipart.MultipartFile;

import com.crud.Model.Product;
import com.crud.exceptions.ProductIdNotFoundException;
import com.crud.repository.ProductRepo;
import com.crud.servicei.ProductServiceI;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service

public class ProductServiceImpl implements ProductServiceI{
 
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
   @Override
   public List<com.crud.Model.Product> Product() {
	
	return pr.findAll();
    }
     @Override
    public Product getSingleProduct(int productid)
   {
    	 Optional<Product> op= pr.findById(productid);
    	 if(op.isPresent())
    	 {
    		 Product p= op.get();
    		 return p;
    	 }
    	 else {
    		 throw new ProductIdNotFoundException("product id does not exist");
    	 }
   }
	@Override
	public List<Product> deleteSingleProduct(int productid) 
	{
	
		 pr.deleteById(productid);
		 return pr.findAll();
	}
	

	}


