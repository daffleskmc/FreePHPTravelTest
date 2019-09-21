package com.phptravel.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravel.base.TravelTestBase;

public class DemoHomePage extends TravelTestBase {

	@FindBy(xpath = "//text()[contains(.,'Login')]/ancestor::a[1]")
	WebElement loginBtn;

	public DemoHomePage() {
		PageFactory.initElements(driver, this);
	}

	public LoginPage clickLoginBtn() {
		loginBtn.click();
		return new LoginPage();
	}
}
