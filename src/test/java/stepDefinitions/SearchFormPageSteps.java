package stepDefinitions;

import java.util.List;

import org.testng.Assert;

import com.pages.SearchFormPage;

import io.cucumber.java.en.Given;

public class SearchFormPageSteps {

	SearchFormPage searchFormPage = new SearchFormPage(LoginPageSteps.crmapp);

	@Given("user clicks on Full Search Form in Contacts")
	public void full_Search_form_Contacts() {

		searchFormPage.selectFullSearchForm();

	}

	@Given("user enter the {string} and {string} to search")
	public void searchingNameinForm(String firstName, String lastName) {
		searchFormPage.searchUsingFirstlastName(firstName, lastName);
	}

	@Given("user checks the checkbox and cpature the mobile number")
	public void checkCheboxAndGetMobile() {
		List<Object> captured = searchFormPage.clickCheckBoxAndCaptureMobile();

		// Assert the List<Object> as it has stored flag and number

	}

	@Given("user clicks in Contacts")
	public void clickContacts() {
		searchFormPage.clickContactsMenu();
	
	}

	@Given("user search for {string} in the table and checks the checkBox")
	public void searchInContactTable(String Name) {
		searchFormPage.dosearchinContactTable(Name);
	}

	@Given("confirm that Company is {string} and {string} is checked")
	public void checkCompanyname(String ompanyNameExpeceted, String Name) {
		String CompanyNameActual = searchFormPage.dogetCompanyName(Name);
		
	Assert.assertEquals(CompanyNameActual, ompanyNameExpeceted);
		
	}

}
