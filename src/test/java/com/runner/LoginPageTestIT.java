package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"./src/test/resources/feature/LoginPage.feature"},
		glue= {"stepDefinitions","hooks"},
		plugin= {"pretty"},
		publish = true)

public class LoginPageTestIT {
	
	
	
	

}
