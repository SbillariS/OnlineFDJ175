package com.crud.Dto;

import java.util.Date;


public class ApplicationDto 
{
	private String message;
    private Date timeStamp;
    
    public ApplicationDto()
    {
    	
    }
    public ApplicationDto(String message,Date timeStamp)
    {
    	this.message=message;
    	this.timeStamp=timeStamp;
    }
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
    
} 
