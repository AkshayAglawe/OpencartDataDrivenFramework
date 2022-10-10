package com.opencart.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.MyAccountPage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.pageobjects.SearchResultPage;

public class TC005_ProductPageTest extends BaseClass {
	HomePage homepage;

	@Test
	public void addToCart() {
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
		Assert.assertTrue(productPage.validateAddToCartConfirmation());

	}

	@Test
	public void addToWishlist() {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage searchResultPage = myaccount.pressSearchBtn(Keys.ENTER);
		ProductPage productPage = searchResultPage.clickOnProductImage();
		productPage.addToWishList();
		Assert.assertTrue(productPage.validateAddToWishlistConfirmation());

	}

	@Test
	public void validateQuantity() {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage searchResultPage = myaccount.pressSearchBtn(Keys.ENTER);
		ProductPage productPage = searchResultPage.clickOnProductImage();
		Assert.assertEquals(productPage.valiadteBydefaultQuantityEntered(), "1");

	}

	@Test
	public void validatePriceAndOtherInfo() {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage searchResultPage = myaccount.pressSearchBtn(Keys.ENTER);
		ProductPage productPage = searchResultPage.clickOnProductImage();
		Assert.assertEquals(productPage.validatePrice(), "$100.00");
		Assert.assertTrue(productPage.validateOtherInfo());

	}

	@Test
	public void validateWritingReview() {

		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage searchResultPage = myaccount.pressSearchBtn(Keys.ENTER);
		ProductPage productPage = searchResultPage.clickOnProductImage();
		productPage.clickOnReviewTab();
		productPage.enterYourName("Akshay");
		productPage.writeReview(
				"This product is extremely good i have been using it for last 2 years still i have not faced a single issue");
		productPage.giveRating();
		productPage.submitReview();
		Assert.assertTrue(productPage.valiadateReviewAlert());

	}

}
