package com.util;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtil {
	WebDriver driver;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		// System.out.println("-----Element Utility called--------");

	}

	public WebElement doGetElement(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, 250);
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

	}

	public boolean doClickCheckBox(By locator) {

		WebDriverWait wait = new WebDriverWait(this.driver, 10);
		doGetElement(locator).click();
		return wait.until(ExpectedConditions.elementToBeSelected(locator));
	}

	public void doSendKeys(By locator, String text) {
		doGetElement(locator).clear();
		doGetElement(locator).sendKeys(text);
	}

	public String doGetText(By locator) {
		return doGetElement(locator).getText();

	}

	public void doClickButton(By locator) {
		doGetElement(locator).click();
	}

	public String doGetTitle() {
		return driver.getTitle();
	}

	public List<WebElement> waitForElement(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, 250);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}

	public List<WebElement> doGetElements(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, 50);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		// return driver.findElements(locator);
	}

	public boolean elementIsDisplayed(By locator) {
		return (!waitForElement(locator).isEmpty()) ? true : false;
	}
	
	
	public boolean docheckStatusOfCheckBox(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver,50) ;
			return wait.until(ExpectedConditions.elementSelectionStateToBe(locator, true));
		
	}

	/*
	 * Actions Util
	 */
	public void actions_MouseHover(By locator) {
		Actions actions = new Actions(driver);
		actions.moveToElement(doGetElement(locator)).perform();

	}

	public void actions_EnterKey() {
		Actions actions = new Actions(driver);
		actions.sendKeys(Keys.ENTER).perform();

	}

	/*
	 * Frame Utils
	 */

	public void frameSwitch(By locator) {
		WebDriverWait wait = new WebDriverWait(this.driver, 250);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
	}

}
