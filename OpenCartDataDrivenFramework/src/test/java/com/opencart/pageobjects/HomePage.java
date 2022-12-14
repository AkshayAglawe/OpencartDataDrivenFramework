package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.opencart.tests.BaseClass;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Your Store']")

	private WebElement logo;

	public boolean validateLogo() {
		return logo.isDisplayed();
	}

	public String getTitle() {
		return driver.getTitle();
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	@CacheLookup
	private WebElement myAccount;

	public void clickOnMyAccountDropMenu() {

		myAccount.click();

	}

	@FindBy(linkText = "Login")
	@CacheLookup
	private WebElement loginOption;

	public LoginPage selectLoginOption() {

		loginOption.click();

		return new LoginPage(driver);

	}

	@FindBy(linkText = "Register")
	private WebElement registerOption;

	public RegisterPage selectRegisterOption() {

		registerOption.click();

		return new RegisterPage(driver);

	}

	public String validateLogoutOption() {
		String text = loginOption.getText();
		String text2 = registerOption.getText();
		return text.concat(text2);

	}

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logoutBtn;

}
