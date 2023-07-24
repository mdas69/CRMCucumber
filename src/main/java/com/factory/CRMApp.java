package com.factory;

import org.openqa.selenium.WebDriver;

import com.util.ElementUtil;

public class CRMApp {
	
	public WebDriver driver;
	public ElementUtil eleUtil;
	
	public CRMApp (WebDriver DRIVER) {
		this.driver = DRIVER;
		this.eleUtil = new ElementUtil(this.driver);
	}

}
