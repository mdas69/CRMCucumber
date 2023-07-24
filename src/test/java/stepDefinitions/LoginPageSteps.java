package stepDefinitions;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.factory.CRMApp;
import com.factory.DriverFactory;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {
	
	LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
	public static CRMApp crmapp ;
	
	
	@Given("the application is loaded and launched")
	public void validateLogo() {
	Assert.assertTrue(loginPage.validatePageLogo(), "The page is Not Loaded Properly, logo not visible");	
	}
	

	@Then("The title of the application should be {string}")
	public void the_title_of_the_application_is_verified(String expectedTitle) {
		// Title of the page, use assertion

		String actualTitle = loginPage.getTitleinPage();

		Assert.assertEquals(actualTitle.contains(expectedTitle),true);
		;

	}

	@Then("The available menus on the page")
	public void the_available_menus_on_the_page(DataTable dataTable) {
		List<String> expectedMenus = dataTable.asList();

		// findElements in List<WebElements>.toString and assert
		List<WebElement> actualMenus = loginPage.getAvailableMenusinPage();

		for (WebElement elements : actualMenus) {
			String menu = elements.getText().trim();
			boolean bool = expectedMenus.contains(menu);

			Assert.assertEquals(bool, true);

		}

	}

	@When("User enter the userName and password from configuration")
	public void inputUserPassStep() {
		// doSendKeys
		
		String user = DriverFactory.prop.getProperty("username");
		String pass = DriverFactory.prop.getProperty("password");
		
		loginPage.inputUserPassinPage(user, pass);
		
	}

	@And("user clicks on Login_button")
	public void user_clicks_on_login_button() {
		 
		crmapp = loginPage.loginInPage();
	}
	
	
	@Then("lands on Accounts page has title {string}")
	
	public void verifyAccountsPage(String title) {
		loginPage.getTitleinPage();
		
		Assert.assertTrue(loginPage.getTitleinPage().contains(title));
		
		
		
	}


	
	
	/*
	 * public CRMApp getCrmapp() { return crmapp; }
	 */
	
	
}
