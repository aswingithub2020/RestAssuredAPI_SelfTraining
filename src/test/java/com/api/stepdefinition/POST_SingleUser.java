package com.api.stepdefinition;

import static io.restassured.RestAssured.given;

import org.json.JSONObject;
import org.testng.Assert;

import com.api.base.BaseClass;
import com.api.payloads.Payloads;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class POST_SingleUser {
	
	public BaseClass hooks;
	public POST_SingleUser(BaseClass hooks)
	{
		this.hooks=hooks;
	}

	@Given("the valid endpoint for POST API")
	public void the_valid_endpoint_for_post_api() {
		RestAssured.baseURI = "https://reqres.in/";
		hooks.request = new JSONObject();

	}

	@When("the POST request is sent to the URI by sending {string},{string}")
	public void the_post_request_is_sent_to_the_uri_by_sending(String Name, String Job) {
		
			hooks.response = given().log().all().header("Content-Type", "application/json")
					.body(Payloads.post_singleuser(Name, Job)).when()
					.post("/api/users").then().extract().response();
			hooks.js = new JsonPath(hooks.response.getBody().asString());
		
	}

	@Then("validate the response should contain name,job,creation date")
	public void validate_the_response_should_contain_name_job_creation_date() {
		System.out.println("name in the response " + hooks.js.getString("name"));
		System.out.println("job in the response " + hooks.js.getString("job"));
		System.out.println("id in the response " + hooks.js.getString("id"));
		System.out.println("Creation date " + hooks.js.getString("createdAt"));
	}

	@Then("the response status should be {int}")
	public void the_response_status_should_be(int status) {
		System.out.println("Status Code is " + hooks.response.getStatusCode());
		Assert.assertEquals(hooks.response.getStatusCode(), status);

	}

	@Then("validate the response should contain name ,job,cretation date")
	public void validate_the_response_should_contain_name_job_cretation_date() {
		System.out.println("name in the response " + hooks.js.getString("name"));
		System.out.println("job in the response " + hooks.js.getString("job"));
		System.out.println("id in the response " + hooks.js.getString("id"));
		System.out.println("Creation date " + hooks.js.getString("createdAt"));
	}

}
