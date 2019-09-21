package com.phptravel.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.phptravel.base.TravelTestBase;
import com.phptravel.pages.DemoHomePage;
import com.phptravel.pages.LoginPage;
import com.phptravel.pages.RegisterPage;

public class RegisterPageTest extends TravelTestBase {

	RegisterPage registerPage;

	LoginPage loginPage;

	DemoHomePage demo;

	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	public void setup() {
		initialization();

		demo = new DemoHomePage();
		demo.clickLoginBtn();

		loginPage = new LoginPage();
		loginPage.registerNewUser();

		registerPage = new RegisterPage();
	}

	@Test(priority = 1)
	public void createNewUser() {
		registerPage.createNewUser("Daphne", "Cruz", "daphne@gmail.com", "+61");
	}

	public void tearDown() {
		driver.quit();
	}
}
