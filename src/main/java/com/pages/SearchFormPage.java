package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.factory.CRMApp;

public class SearchFormPage {

	/*
	 * public WebDriver driver; public ElementUtil eleUtil;
	 * 
	 * public SearchFormPage(WebDriver DRIVER) {
	 * 
	 * this.driver = DRIVER; eleUtil = new ElementUtil(this.driver);
	 * System.out.println("---------Page Layer Search called ---------");
	 * 
	 * }
	 */

	CRMApp CRM;

	public SearchFormPage(CRMApp crmapp) {
		this.CRM = crmapp;
	}

	private By frameLocator = By.cssSelector("frame[name*=mainpanel]");
	private By contactsLocator = By.cssSelector("a[title *=Contacts]");
	private By searchFormLocator = By.xpath("//a[text()='Contacts']/..//a[text()='Full Search Form']");
	private By firstNameLocator = By.cssSelector("input[name *= cs_first_name]");
	private By lastNameLocator = By.cssSelector("input[name *= cs_surname]");
	private By searchContactButton = By.xpath("(//input[@value='Search Contacts'])[1]");
	private By checkBoxLocator = By.xpath("//a[text()='Eder Militao']/../../td/input[@type='checkbox']");
	private By phoneLocator = By.xpath("//a[text()='Eder Militao']/../../td/span[@context='phone']");

	public void selectFullSearchForm() {
		CRM.eleUtil.frameSwitch(frameLocator);
		CRM.eleUtil.actions_MouseHover(contactsLocator);
		CRM.eleUtil.doClickButton(searchFormLocator);

	}

	public void searchUsingFirstlastName(String firstName, String lastName) {
		CRM.eleUtil.doSendKeys(firstNameLocator, firstName);
		CRM.eleUtil.doSendKeys(lastNameLocator, lastName);
		CRM.eleUtil.doClickButton(searchContactButton);
	}

	public List<Object> clickCheckBoxAndCaptureMobile() {
		List<Object> valueCaptured = new ArrayList<>();
		boolean flag = CRM.eleUtil.doClickCheckBox(checkBoxLocator);
		String mobileNumber = CRM.eleUtil.doGetText(phoneLocator);

		valueCaptured.add(flag);
		valueCaptured.add(mobileNumber);
		return valueCaptured;

	}

	public void clickContactsMenu() {
		CRM.eleUtil.frameSwitch(frameLocator);
		CRM.eleUtil.doClickButton(contactsLocator);
	}

	private By contactsOnTable = By.cssSelector("tbody tr > td > a[context *='contact']");
	private By pagination = By.xpath("(//div[@class='pagination'])[1]//strong/../a");

	public void dosearchinContactTable(String nameExpected) {
		By checkBoxNameExpecetd = By.xpath("//a[text()='" + nameExpected + "']/../../td/input[@type='checkbox']");

		// click on page 1

		List<WebElement> pages = CRM.eleUtil.doGetElements(pagination);
		List<WebElement> contacts = CRM.eleUtil.doGetElements(contactsOnTable);
		boolean flag = true;
		while (flag) {

			for (WebElement e : contacts) {
				String nameActual = e.getText();
				if (nameActual.equalsIgnoreCase(nameExpected)) {
					CRM.eleUtil.doClickCheckBox(checkBoxNameExpecetd);
					flag = false;
					break;
				}

			}

			// click on page 2,3,4,,5,onwards
			if (flag) {
				int totalpage = pages.size();
				for (int i = 0; i < totalpage; i++) {
					pages.get(i).click();
					contacts = CRM.eleUtil.doGetElements(contactsOnTable);
					pages = CRM.eleUtil.doGetElements(pagination);

					for (WebElement e : contacts) {
						String nameActual = e.getText();
						if (nameActual.equalsIgnoreCase(nameExpected)) {
							CRM.eleUtil.doClickCheckBox(checkBoxNameExpecetd);
							flag = false;

							/*
							 * To prevent once name found to stop and not traverese the whole pagination
							 */
							i = totalpage + 1;

							/*
							 * break acts on the innermost loop it encounters within the scope
							 */
							break;

						}

					}
				}

			}

			/*
			 * for the while loop, else it would be an infinite
			 */
			flag = false;

		}

	}

	public String dogetCompanyName(String name) {
		By checkBoxSelectionStateLocator = By.xpath("//a[text()='" + name + "']/../../td/input[@type='checkbox']");
		boolean flag = CRM.eleUtil.docheckStatusOfCheckBox(checkBoxSelectionStateLocator);
		if (flag) {
			By companyNameLocator = By.xpath("//a[text()='" + name + "']/../../td/a[@context='company']");
			return CRM.eleUtil.doGetText(companyNameLocator);
		}
		return null;

	}
}
