package com.api.stepdefinition;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;

import com.api.base.BaseClass;
import com.api.pojo.GetUserDetails;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;

public class GET_ListOfUsers {
	
	private BaseClass obj;
	private GetUserDetails sc;
	
	public GET_ListOfUsers(BaseClass obj)
	{
		this.obj=obj;
	}
	
	@Given("the valid endpoint for GET API")
	public void the_valid_endpoint_for_get_api() {
		RestAssured.baseURI="https://reqres.in/";
		obj.request=new JSONObject();
	}
	@When("the GET request is sent to the URI")
	public void the_get_request_is_sent_to_the_uri() {
	   //obj.response=given().log().all().when().get("/api/users?page=2").then().log().all().extract().response();
		//obj.js=new JsonPath(obj.response.getBody().asString());
		 sc=given().expect().defaultParser(Parser.JSON).when().get("api/users?page=2").as(GetUserDetails.class);
}
	@Then("the response status should bee {int}")
	public void the_response_status_should_bee(int status) {
		//System.out.println("Status Code is " + obj.response.getStatusCode());
		//Assert.assertEquals(obj.response.getStatusCode(), status);
	}
	@Then("print all response details like id,email,first_name,last_name,avatar")
	public void print_all_response_details_like_id_email_first_name_last_name_avatar() {
		System.out.println(sc.getPage());
		System.out.println(sc.getPer_page());
		System.out.println(sc.getTotal());
		System.out.println(sc.getTotal_pages());
		System.out.println("id in the response " + sc.getData().get(1).getId());
		System.out.println("email in the response " + sc.getData().get(1).getEmail());
		System.out.println("fname in the response " + sc.getData().get(1).getFirst_name());
		System.out.println("lname in the response " + sc.getData().get(1).getLast_name());
		System.out.println("avatar in the response " + sc.getData().get(1).getAvatar());
		
		System.out.println(sc.getSupport().getUrl());
		System.out.println(sc.getSupport().getText());
		
	}



}
