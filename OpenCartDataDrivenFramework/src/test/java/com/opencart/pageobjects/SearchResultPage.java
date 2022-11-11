package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.tests.BaseClass;

public class SearchResultPage extends BaseClass {
	WebDriver driver;

	public SearchResultPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='HP LP3065']")
	private WebElement searchReasult;

	public String validateSearchResult() {
		return searchReasult.getText();
	}

	@FindBy(xpath = "//img[@class='img-responsive']")
	private WebElement productImage;

	public ProductPage clickOnProductImage() {
		productImage.click();
		return new ProductPage(driver);
	}

	@FindBy(xpath = "//p[text()='There is no product that matches the search criteria.']")
	private WebElement message;

	public String validateErrorMessage() {
		return message.getText();
	}
}
