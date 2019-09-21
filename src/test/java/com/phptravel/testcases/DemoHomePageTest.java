package com.phptravel.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravel.base.TravelTestBase;
import com.phptravel.pages.DemoHomePage;
import com.phptravel.pages.LoginPage;

public class DemoHomePageTest extends TravelTestBase {

	LoginPage loginPage;

	DemoHomePage demoHomePage;

	public DemoHomePageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		demoHomePage = new DemoHomePage();
	}

	@Test(priority = 1)
	public void clickLogin() {
		demoHomePage.clickLoginBtn();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
