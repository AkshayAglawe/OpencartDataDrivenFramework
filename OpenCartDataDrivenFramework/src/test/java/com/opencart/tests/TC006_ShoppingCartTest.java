package com.opencart.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.MyAccountPage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.pageobjects.SearchResultPage;
import com.opencart.pageobjects.ShoppingCart;

public class TC006_ShoppingCartTest extends BaseClass {

	// checkout
	// delivery date and reward poin
	HomePage homepage;

	// @Test
	public void validateProductPageLink() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage searchResultPage = myaccount.pressSearchBtn(Keys.ENTER);
		ProductPage productPage = searchResultPage.clickOnProductImage();
		productPage.addToCart();
		ShoppingCart shoppingCartPage = productPage.navigateToshoppingCart();
		shoppingCartPage.navigateToProductPageFromShoppingCart();
		Assert.assertEquals(productPage.validatePrice(), "$100.00");
		Assert.assertTrue(productPage.validateOtherInfo());

	}

	// @Test
	public void removeProductFromCart() throws InterruptedException {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage searchResultPage = myaccount.pressSearchBtn(Keys.ENTER);
		ProductPage productPage = searchResultPage.clickOnProductImage();
		productPage.addToCart();
		ShoppingCart shoppingCartPage = productPage.navigateToshoppingCart();
		shoppingCartPage.removeProduct();
		// Thread.sleep(10000);
		boolean result = driver.getPageSource().contains("Your shopping cart is empty!");
		Assert.assertTrue(result);

	}

	// @Test
	public void updateCart() {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage searchResultPage = myaccount.pressSearchBtn(Keys.ENTER);
		ProductPage productPage = searchResultPage.clickOnProductImage();
		productPage.addToCart();
		ShoppingCart shoppingCartPage = productPage.navigateToshoppingCart();
		shoppingCartPage.enterQty("2");
		shoppingCartPage.update();
		boolean result = driver.getPageSource().contains("You have modified your shopping cart!");
		Assert.assertTrue(result);
	}

	//@Test
	public void proceedToCheckout() {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage searchResultPage = myaccount.pressSearchBtn(Keys.ENTER);
		ProductPage productPage = searchResultPage.clickOnProductImage();
		productPage.addToCart();
		ShoppingCart shoppingCartPage = productPage.navigateToshoppingCart();
		shoppingCartPage.enterQty("2");
		shoppingCartPage.update();
		shoppingCartPage.checkout();

	}

	@Test
	public void validateProductInfoIsDisplyed() {
		homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage searchResultPage = myaccount.pressSearchBtn(Keys.ENTER);
		ProductPage productPage = searchResultPage.clickOnProductImage();
		productPage.addToCart();
		ShoppingCart shoppingCartPage = productPage.navigateToshoppingCart();
		Assert.assertTrue(shoppingCartPage.validateTable());
	}
}