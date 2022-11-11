package com.opencart.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.tests.BaseClass;

public class LoginPage extends BaseClass {
	WebDriver driver;

	public LoginPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-email")
	private WebElement emailField;

	public void enterEmailAddress(String emailText) {

		emailField.sendKeys(emailText);

	}

	@FindBy(id = "input-password")
	private WebElement passwordField;

	public void enterPassword(String passwordText) {

		passwordField.sendKeys(passwordText);

	}

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	public MyAccountPage clickOnLoginButton() {

		loginButton.click();
		return new MyAccountPage(driver); // IMP

	}

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement registerAC;

	public RegisterPage registerAccount() {
		registerAC.click();
		return new RegisterPage(driver);
	}

	@FindBy(xpath = "//h2[text()='Returning Customer']")
	private WebElement varificationText;

	public String varifyText() {
		return varificationText.getText();
	}

}
