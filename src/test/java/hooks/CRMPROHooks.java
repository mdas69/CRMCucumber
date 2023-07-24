package hooks;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CRMPROHooks {

	public DriverFactory driverFactory;
	public Properties property;
	public WebDriver driver;

	@Before(order = 0)
	public void launchBrowser() {
		driverFactory = new DriverFactory();
		property = driverFactory.init_Properties();
		driver = driverFactory.init_Driver(property);

		// url is launched
		driver.get(property.getProperty("url"));

	}

	/*
	 * Screenshot for failed Scenario
	 */
	@After(order = 1)
	public void takeScreenShotForFailedScenario(Scenario scenario) {
		if (scenario.isFailed()) {

			String screenShotName = scenario.getName();
			byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
			scenario.attach(sourcePath, "image/png", screenShotName);
			
			
			String path = scenario.getName()+"_"+".png";
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			
			File dest = new File(path);
			try {
				FileUtils.copyFile(src, dest);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

			

		}
	}

	@After(order = 0)
	public void closeBrowser() {
		driver.quit();
	}

}
