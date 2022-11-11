package com.opencart.tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.IOException;

import org.testng.annotations.Test;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.RegisterPage;

public class TC001_HomePageTest extends BaseClass {
	HomePage homepage;

	@Test(priority = 1)
	public void varifyLogo() {
		homepage = new HomePage(driver);
		assertTrue(homepage.validateLogo());

	}

	@Test(priority = 2)
	public void varifyTitle() {
		homepage = new HomePage(driver);
		assertEquals(homepage.getTitle(), "Your Store");
	}

	@Test(priority = 3)
	public void validateLoginOptionInMyAccountDropMenu() throws IOException {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage text = homepage.selectLoginOption();
		assertEquals(text.varifyText(), "Returning Customer");

	}

	@Test(priority = 4)
	public void validateRegisterOptionInMyAccountDropMenu() throws IOException {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		RegisterPage text = homepage.selectRegisterOption();
		assertEquals(text.validateHeading(), "Register Account");

	}

}
