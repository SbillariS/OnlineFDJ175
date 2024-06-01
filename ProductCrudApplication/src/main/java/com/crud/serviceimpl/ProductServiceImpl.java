package com.crud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.repository.ProductRepo;
import com.crud.servicei.ProductServiceI;
@Service
public class ProductServiceImpl implements ProductServiceI{
@Autowired
ProductRepo pr;

@Override
public List<com.crud.Model.Product> Product() {
	
	return pr.findAll();
}
	

	}


