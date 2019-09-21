package com.phptravel.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.phptravel.base.TravelTestBase;

public class RegisterPage extends TravelTestBase {

	@FindBy(xpath = "//input[@type='text'][@name='firstname']")
	WebElement firstName;

	@FindBy(xpath = "//input[@type='text'][@name='lastname']")
	WebElement lastName;

	@FindBy(xpath = "//input[@type='email'][@name='email']")
	WebElement email;

	// @FindBy(xpath = "//div[contains(@class, 'selected-dial-code') and
	// text()='Model saved']")
	// WebElement dialCd;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void createNewUser(String fName, String lName, String eml, String dialCd) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(eml);

		driver.findElement(By.xpath("//div[contains(@class, 'selected-dial-code') and text()='" + dialCd + "']"));
	}

}
