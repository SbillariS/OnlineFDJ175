package com.crud.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
@Data
@Entity
public class Product 
{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private int productid;
   private String pname;
   private int price;
   private int qua;
   private String col;
   @Lob
   @Column(length=999999999)
   private byte[] img;
}
