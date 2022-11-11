package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.opencart.tests.BaseClass;

public class CheckoutPage extends BaseClass {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[text()='Checkout']")
	private WebElement checkoutLink;

	public boolean checkoutLinkIsDisplyed() {
		return checkoutLink.isDisplayed();
	}

	@FindBy(xpath = "//input[@id='input-payment-firstname']")
	private WebElement firstNameField;

	public void enterName(String name) {
		firstNameField.sendKeys(name);
	}

	public boolean isFirstNameFieldDisplyed() {
		return firstNameField.isDisplayed();
	}

	@FindBy(xpath = "//input[@id='input-payment-lastname']")
	private WebElement lastNameField;

	public void enterLastName(String lastName) {
		lastNameField.sendKeys(lastName);

	}

	@FindBy(xpath = "//input[@id='input-payment-address-1']")
	WebElement addressField;

	public void enterAddress(String address) {
		addressField.sendKeys(address);
	}

	@FindBy(xpath = "//input[@id='input-payment-city']")
	private WebElement cityField;

	public void enterCity(String city) {
		cityField.sendKeys(city);
	}

	@FindBy(xpath = "	//input[@id='input-payment-postcode']")
	private WebElement postcodeField;

	public void enterPostcodeField(String postcode) {
		postcodeField.sendKeys(postcode);
	}

	@FindBy(xpath = "//select[@id='input-payment-country']")
	WebElement countryDropdown;

	public void selectCountry(String text) {
		Select sel = new Select(countryDropdown);
		sel.selectByVisibleText(text);
		;
	}

	@FindBy(xpath = "//select[@id='input-payment-zone']")
	private WebElement stateDropdown;

	public void selectState(String text) {
		Select sel = new Select(stateDropdown);
		sel.selectByVisibleText(text);
	}

	@FindBy(id = "button-payment-address")
	private WebElement contBtn;

	public void continue1() {
		contBtn.click();
	}

	@FindBy(id = "button-shipping-address")
	private WebElement contBtn1;

	public void continue2() {
		contBtn1.click();
	}

	@FindBy(id = "button-shipping-method")
	private WebElement contBtn2;

	public void continue3() {
		contBtn2.click();
	}

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement tANDcheckbox;

	public void checkCheckbox() {
		tANDcheckbox.click();
	}

	@FindBy(id = "button-payment-method")
	private WebElement contBtn3;

	public void continue4() {
		contBtn3.click();
	}

	@FindBy(xpath = "//input[@id='button-confirm']")
	private WebElement confirmBtn;

	public void clickConfirmBtn() {
		confirmBtn.click();
	}

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement continueBtnAfterPlacingOrder;

	public HomePage clickOnContinueBtnAfterPlacingOrder() {
		continueBtnAfterPlacingOrder.click();
		return new HomePage(driver);
	}

}
