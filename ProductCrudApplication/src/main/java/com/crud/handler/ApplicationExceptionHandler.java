package com.crud.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.crud.Dto.ApplicationDto;
import com.crud.exceptions.ProductIdNotFoundException;


@RestControllerAdvice
public class ApplicationExceptionHandler 
{
	@ExceptionHandler(ProductIdNotFoundException.class)
    public ResponseEntity<ApplicationDto> handleUsernotfound(ProductIdNotFoundException ue)
    {
		ApplicationDto response=new ApplicationDto(ue.getMessage(), new Date());
		return new  ResponseEntity<ApplicationDto>(response,HttpStatus.NOT_FOUND);
    }
}
