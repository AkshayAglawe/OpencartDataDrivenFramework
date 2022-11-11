package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {

	WebDriver driver;

	public LogOutPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement continueBtn;

	public void clickOnContinueBtn() {
		continueBtn.click();
	}

}
