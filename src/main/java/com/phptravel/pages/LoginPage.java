package com.phptravel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravel.base.TravelTestBase;

public class LoginPage extends TravelTestBase {

	@FindBy(xpath = "//a[text()='Register']")
	WebElement registerLnk;

	@FindBy(xpath = "")
	WebElement loginLbl;

	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	public boolean isLoginPageDisplayed() {
		return loginLbl.isDisplayed();
	}

	public RegisterPage registerNewUser() {
		registerLnk.click();
		// driver.findElement(By.xpath("//a[text()='Register']")).click();
		return new RegisterPage();
	}
}
