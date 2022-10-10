package com.opencart.tests;

import java.io.IOException;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobjects.CheckoutPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LogOutPage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.MyAccountPage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.pageobjects.SearchResultPage;
import com.opencart.pageobjects.ShoppingCart;
import com.opencart.util.Utils;

public class TC009_EndToEndTest extends BaseClass {

	HomePage homepage;

	@Test(dataProvider = "dataSupplier")
//Login>>Search Item>> Add to cart>> Navigate to Cart>> checkout>> Logout
	public void endToEndFlowTest(Object firstName, Object lastName, Object address1, Object city, Object postcode,
			Object country, Object state) {
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
		CheckoutPage checkoutPage = shoppingCartPage.checkout();

		if (checkoutPage.isFirstNameFieldDisplyed()) {
			checkoutPage.enterName(String.valueOf(firstName));
			checkoutPage.enterLastName(String.valueOf(lastName));
			checkoutPage.enterAddress(String.valueOf(address1));
			checkoutPage.enterCity(String.valueOf(city));
			checkoutPage.enterPostcodeField(String.valueOf(postcode));
			checkoutPage.selectCountry(String.valueOf(country));
			checkoutPage.selectState(String.valueOf(state));
		}
		checkoutPage.continue1();
		checkoutPage.continue2();
		checkoutPage.continue3();
		checkoutPage.checkCheckbox();
		checkoutPage.continue4();
		checkoutPage.clickConfirmBtn();
		HomePage Homepage = checkoutPage.clickOnContinueBtnAfterPlacingOrder();
		myaccount.clickOnMyAccountDropdownMenu();
		LogOutPage logoutpage = myaccount.SelectLogoutOption();
		logoutpage.clickOnContinueBtn();
	}

	@DataProvider
	public Object[][] dataSupplier() throws IOException {
		String path = "C:\\java\\OpenCartDataDrivenFramework\\src\\test\\java\\com\\opencart\\testdata\\Opencart.xlsx";
		return Utils.getCellValues(path, 2);
	}

}
