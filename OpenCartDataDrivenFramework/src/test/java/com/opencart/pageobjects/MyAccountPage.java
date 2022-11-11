package com.opencart.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.tests.BaseClass;

public class MyAccountPage extends BaseClass {
	WebDriver driver;

	public MyAccountPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBox;

	public void searchItem(String itemText) {
		searchBox.clear();
		searchBox.sendKeys(itemText);
	}

	@FindBy(xpath = "//input[@name='search']")
	private WebElement searchBtn;

	public SearchResultPage clickOnSearchBtn() {
		searchBtn.click();
		return new SearchResultPage(driver);
	}

	public SearchResultPage pressSearchBtn(Keys k) {

		searchBox.sendKeys(Keys.ENTER);
		return new SearchResultPage(driver);
	}

	@FindBy(xpath = "//a[text()='HP LP3065']")
	private WebElement hp;

	public boolean validateSearchResult() {
		return hp.isDisplayed();
	}

	public String getTitle() {

		return driver.getTitle();
	}

	@FindBy(xpath = "//a[normalize-space()='View your order history']")
	private WebElement validateYourOrderHistoryLink;

	public boolean validateYourOrderHistory() {
		return validateYourOrderHistoryLink.isDisplayed();
	}

	@FindBy(xpath = "//h2[normalize-space()='My Orders']")
	private WebElement myOrders;

	public boolean validateMyOrders() {
		return myOrders.isDisplayed();
	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropdownMenu;

	public void clickOnMyAccountDropdownMenu() {
		myAccountDropdownMenu.click();
	}

	@FindBy(xpath = "//a[text()='Logout']")
	private WebElement logOutBtn1;

	public LogOutPage SelectLogoutOption() {
		logOutBtn1.click();
		return new LogOutPage(driver);
	}

	@FindBy(xpath = "(//a[text()='My Account'])[2]")
	private WebElement myAccountFromFooter;

	public void clickOnMyAccountFromFooter() {
		myAccountFromFooter.click();
	}

	@FindBy(xpath = "(//a[text()='Logout'])[2]")
	private WebElement logOutBtn2;

	public LogOutPage logout2() {
		logOutBtn2.click();
		return new LogOutPage(driver);
	}

}
