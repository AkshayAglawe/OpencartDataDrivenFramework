package com.opencart.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LogOutPage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.MyAccountPage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.pageobjects.SearchResultPage;

public class TC008_LogOutTest extends BaseClass {

	HomePage homepage;

	// @Test
	public void validateLoggingOutFromMyAccountDropdownMenuOption() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.clickOnMyAccountDropdownMenu();
		LogOutPage logoutpage = myaccount.SelectLogoutOption();
		String text = "You have been logged off your account. It is now safe to leave the computer.";
		String text2 = driver.getTitle();
		boolean result = driver.getPageSource().contains(text);
		boolean result2 = text2.equals("Account Logout");
		Assert.assertTrue(result);
		Assert.assertTrue(result2);
		logoutpage.clickOnContinueBtn();

	}

	// @Test
	public void validateLoggingOutFromRightColumnOption() {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage searchResultPage = myaccount.pressSearchBtn(Keys.ENTER);
		ProductPage productPage = searchResultPage.clickOnProductImage();
		productPage.enterQuantity(2);
		productPage.addToCart();
		myaccount.clickOnMyAccountFromFooter();
		LogOutPage logoutpage = myaccount.logout2();
		String text = "You have been logged off your account. It is now safe to leave the computer.";
		String text2 = driver.getTitle();
		boolean result = driver.getPageSource().contains(text);
		boolean result2 = text2.equals("Account Logout");
		Assert.assertTrue(result);
		Assert.assertTrue(result2);
		logoutpage.clickOnContinueBtn();
	}

	// @Test
	public void clickOnBrowseBackBtnAfterLoggingOut() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.clickOnMyAccountDropdownMenu();
		LogOutPage logoutpage = myaccount.SelectLogoutOption();
		logoutpage.clickOnContinueBtn();
		driver.navigate().back();
		driver.navigate().back();
		String title = driver.getTitle();
		if (title.equals("My Account")) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}

	@Test
	public void ValidateLogoutOptionUnderMyAccountMenuBeforeLoggingIn() {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		String result = homepage.validateLogoutOption();
		if (result.contains("Logout")) {
			Assert.assertTrue(false);
		} else {
			Assert.assertTrue(true);
		}
	}

}
