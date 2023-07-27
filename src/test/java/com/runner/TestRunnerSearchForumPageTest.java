package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"./src/test/resources/feature/SearchFormPage.feature"},
		glue= {"stepDefinitions","hooks"},
		plugin= {"pretty", "summary","html: target/cucumber-reports","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}, 
		tags = "not @Skip",
		monochrome=true,
		dryRun=false,
		publish = true)

public class TestRunnerSearchForumPageTest {
	
	
	
	

}
