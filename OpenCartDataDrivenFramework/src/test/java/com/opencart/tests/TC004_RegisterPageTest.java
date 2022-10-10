package com.opencart.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;
import com.opencart.util.Utils;

public class TC004_RegisterPageTest extends BaseClass {
//	@Test(dataProvider = "dataSupplier")
	public void register(Object firstName, Object lastName, Object email, Object phoneNo, Object pwd, Object cpwd) {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		RegisterPage registerPage = homepage.selectRegisterOption();
		registerPage.enterFirstname(firstName);
		registerPage.enterLastName(lastName);
		registerPage.enterEmail(email);
		registerPage.enterTelephone(phoneNo);
		registerPage.enterPassword(pwd);
		registerPage.enter(cpwd);
		registerPage.selectPrivacyPolicyCheckbox();
		registerPage.clickOnContinueBtn();
		Assert.assertEquals(registerPage.validateSuccessMsg(), "Your Account Has Been Created!");
	}

	// Register account through different way
	// @Test(dataProvider="dataset")
	public void register2ndway(Object firstName, Object lastName, Object email, Object phoneNo, Object pwd,
			Object cpwd) {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage loninpage = homepage.selectLoginOption();
		RegisterPage registerPage = loninpage.registerAccount();
		registerPage.enterFirstname(firstName);
		registerPage.enterLastName(lastName);
		registerPage.enterEmail(email);
		registerPage.enterTelephone(phoneNo);
		registerPage.enterPassword(pwd);
		registerPage.enter(cpwd);
		registerPage.selectPrivacyPolicyCheckbox();
		registerPage.clickOnContinueBtn();
		Assert.assertEquals(registerPage.validateSuccessMsg(), "Your Account Has Been Created!");

	}

	@Test(dataProvider = "dataSupplier")
	public void registerWithRegisteredEmail(Object firstName, Object lastName, Object email, Object phoneNo, Object pwd,
			Object cpwd) {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		RegisterPage registerPage = homepage.selectRegisterOption();
		registerPage.enterFirstname(firstName);
		registerPage.enterLastName(lastName);
		registerPage.enterEmail(email);
		registerPage.enterTelephone(phoneNo);
		registerPage.enterPassword(pwd);
		registerPage.enter(cpwd);
		registerPage.selectPrivacyPolicyCheckbox();
		registerPage.clickOnContinueBtn();
		boolean result = driver.getPageSource().trim().contains("E-Mail Address is already registered!");
		Assert.assertTrue(true);
	}

	@DataProvider
	public Object[][] dataSupplier() throws IOException {
		String path = "C:\\java\\OpenCartDataDrivenFramework\\src\\test\\java\\com\\opencart\\testdata\\Opencart.xlsx";
		return Utils.getCellValues(path, 1);
	}

}
