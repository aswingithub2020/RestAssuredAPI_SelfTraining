package com.api.base;

import java.io.IOException;

import com.api.commonutils.ExcelReader;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

public class getdata {

	public static void main(String[] args) throws InvalidFormatException, IOException {
		ExcelReader obj=new ExcelReader();
		System.out.println(obj.getData("./TestData\\TestData.xlsx", "TestData").get(0).get("UserName"));
		System.out.println(obj);
		
		

	}

}
