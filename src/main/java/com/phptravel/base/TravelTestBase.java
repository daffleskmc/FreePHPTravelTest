package com.phptravel.base;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TravelTestBase {

	public static Properties prop;

	public static WebDriver driver;

	public TravelTestBase() {
		prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\main\\java\\com\\phptravel\\config\\config.properties");
			prop.load(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void initialization() {
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			// Step 1 :
			// Create a map to store preferences
			Map<String, Object> prefs = new HashMap<String, Object>();
			// Step 2 :

			// add key and value to map as follow to switch off browser notification
			prefs.put("profile.default_content_setting_values.notifications", 2);
			// Step 3 :

			// Create an instance of ChromeOptions
			ChromeOptions options = new ChromeOptions();
			// Step 4 :

			// set ExperimentalOption - prefs
			options.setExperimentalOption("prefs", prefs);
			// Step 5 :

			// Now Pass ChromeOptions instance to ChromeDriver Constructor to initialize
			// chrome driver which will switch off this browser notification on the chrome
			// browser
			// WebDriver driver = new ChromeDriver(options);
			WebDriverManager.chromedriver().setup();

			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));

	}
}
