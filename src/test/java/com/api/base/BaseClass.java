package com.api.base;

import org.json.JSONObject;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class BaseClass {
	public JSONObject request;
	public Response response;
	public JsonPath js;
	public DataTable dt;
	public Scenario scenario;
	
	@Before
	public void startScenario(Scenario scenario)
	{
		this.scenario=scenario;
	}
	
	@After
	public void endScenario(Scenario scenario)
	{
		scenario.log(scenario.getName()+" got failed");
	}

}
