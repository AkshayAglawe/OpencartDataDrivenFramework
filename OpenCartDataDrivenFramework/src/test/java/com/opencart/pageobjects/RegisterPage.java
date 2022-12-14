package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.tests.BaseClass;

public class RegisterPage extends BaseClass {
	WebDriver driver;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[text()='Register Account']")
	private WebElement heading;

	public String validateHeading() {
		return heading.getText();
	}

	@FindBy(xpath = "//a[text()='login page']")
	private WebElement loginLink;

	public boolean validateLoginLink() {
		return loginLink.isDisplayed();
	}

	@FindBy(xpath = "//input[@id='input-firstname']")
	private WebElement firstNameField;

	public void enterFirstname(Object firstName) {
		firstNameField.sendKeys(String.valueOf(firstName));

	}

	@FindBy(xpath = "//input[@id='input-lastname']")
	private WebElement lastNameField;

	public void enterLastName(Object lastName) {
		lastNameField.sendKeys(String.valueOf(lastName));
	}

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElement emailField;

	public void enterEmail(Object email) {
		emailField.sendKeys(String.valueOf(email));
	}

	@FindBy(xpath = "//input[@id='input-telephone']")
	private WebElement telephoneField;

	public void enterTelephone(Object telephone) {
		telephoneField.sendKeys(String.valueOf(telephone));
	}

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElement passwordField;

	public void enterPassword(Object pwd) {
		passwordField.sendKeys(String.valueOf(pwd));
	}

	@FindBy(xpath = "//input[@id='input-confirm']")
	private WebElement confirmPasswordField;

	public void enter(Object confirmPwd) {
		confirmPasswordField.sendKeys(String.valueOf(confirmPwd));
	}

	@FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
	private WebElement newsLetterRadioButton;

	public void selectYesRadioBtn() {
		newsLetterRadioButton.click();

	}

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyCheckbox;

	public void selectPrivacyPolicyCheckbox() {
		privacyPolicyCheckbox.click();

	}

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueBtn;

	public void clickOnContinueBtn() {
		continueBtn.click();
	}

	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	private WebElement successMsg;

	public String validateSuccessMsg() {
		return successMsg.getText();
	}

	@FindBy(xpath = "//a[@class='btn btn-primary']")
	private WebElement continueBtnAfterRegister;

	public LoginPage clickOnContinueBtnAfterRegister() {
		continueBtnAfterRegister.click();
		return new LoginPage(driver);
	}

}
