package com.api.runnerclass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "Feature" }, 
				dryRun = false, 
				monochrome = true,
				glue = {"com.wellsfargo.flexloan.stepdefinition" }, plugin = { "html:target/cucumber-reports/cucumber-pretty.html",
				"pretty" }, tags = "@apitest"

)
public class Runnerclass {

}
