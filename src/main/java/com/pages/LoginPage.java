package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.factory.CRMApp;
import com.util.ElementUtil;

public class LoginPage {

	public WebDriver driver;
	public ElementUtil eleUtil;

	/*
	 * @mdas This is the constructor and invoking it give the driver instance to you
	 * class
	 * 
	 */
	public LoginPage(WebDriver DRIVER) {

		this.driver = DRIVER;
		eleUtil = new ElementUtil(this.driver);
		// System.out.println("---------Page Layer Login called ---------");

	}

	/*
	 * maintian the private by locators to achive encapuslation
	 */
	private By logoLocator = By.cssSelector("img[src *=logo]");
	private By menuLinks = By.cssSelector("ul.nav > li");
	private By userNamelocator = By.cssSelector("input[name *= username]");
	private By passwordlocator = By.cssSelector("input[name ^= pass]");

	/*
	 * To check for page log in application
	 */
	public Boolean validatePageLogo() {
		return eleUtil.elementIsDisplayed(logoLocator);
	}

	/*
	 * To check for available menus in Login Page
	 */
	public List<WebElement> getAvailableMenusinPage() {
		return eleUtil.doGetElements(menuLinks);
	}

	/*
	 * To get the page title
	 */
	public String getTitleinPage() {
		return eleUtil.doGetTitle();
	}

	/*
	 * To enter user name and password in application
	 */
	public void inputUserPassinPage(String username, String password) {
		eleUtil.doSendKeys(userNamelocator, username);
		eleUtil.doSendKeys(passwordlocator, password);

	}

	/*
	 * Logged in, and returns the CRMApp class object
	 * CRMApp class has driver and elementUtil class invoked through parameterized constructor
	 */
	public CRMApp loginInPage() {
		eleUtil.actions_EnterKey();

		return new CRMApp(this.driver);
	}

}
