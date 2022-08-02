package com.api.payloads;

public class Payloads {
	
	public static String post_singleuser(String name,String job)
	{
		return "{\r\n"
				+ "    \"name\": \""+name+"\",\r\n"
				+ "    \"job\": \""+job+"\"\r\n"
				+ "}";
	}

}
