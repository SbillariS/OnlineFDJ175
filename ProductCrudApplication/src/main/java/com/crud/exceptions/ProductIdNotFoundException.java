package com.crud.exceptions;

public class ProductIdNotFoundException extends RuntimeException
{
   public ProductIdNotFoundException(String msg)
   {
	   super(msg);
   }
}
