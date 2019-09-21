package com.phptravel.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravel.base.TravelTestBase;
import com.phptravel.pages.DemoHomePage;
import com.phptravel.pages.LoginPage;
import com.phptravel.pages.RegisterPage;

public class LoginPageTest extends TravelTestBase {

	RegisterPage registerPage;

	LoginPage loginPage;

	DemoHomePage demo;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();
		demo = new DemoHomePage();
		loginPage = demo.clickLoginBtn();

		// registerPage = new RegisterPage();
	}

	public void isLoginLblDisplayedTest() {
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
	}

	@Test(priority = 2)
	public void clickToRegisterPage() {
		registerPage = loginPage.registerNewUser();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
