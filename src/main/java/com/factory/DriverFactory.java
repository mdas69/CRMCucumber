package com.factory;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {

	public static Properties prop=null;
	public FileInputStream file=null;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public Properties init_Properties() {
		try {
			file = new FileInputStream("./src/test/resources/config/config.properties");
			
			prop = new Properties();
			prop.load(file);
			System.out.println(prop);
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return prop;

	}

	// to Initialize the driver - Open a webBrowser
	public WebDriver init_Driver(Properties property) {

		String browserName = property.getProperty("browser").trim();
		String browserVersion = property.getProperty("browserVersion");

		if (browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("Google Chrome")) {
			WebDriverManager.chromedriver().setup();
			// WebDriver driver = new ChromeDriver();
			ChromeOptions co = new ChromeOptions();
			co.setBrowserVersion(browserVersion);
			tlDriver.set(new ChromeDriver(co));
			
		} else {
			WebDriverManager.firefoxdriver().setup();
			// WebDriver driver = new ChromeDriver();
			tlDriver.set(new FirefoxDriver());
		}
		
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		return getDriver();

	}

	/**
	 * @mdas - Returns the value in the current thread's copy of this thread-local variable.
	 * If the variable has no value for the current thread, it is first initialized
	 * to the value returned by an invocation of the initialValue method.
	 * 
	 * @return WebDriver 
	 */
	public static WebDriver getDriver() {

		return tlDriver.get();
	}

}
