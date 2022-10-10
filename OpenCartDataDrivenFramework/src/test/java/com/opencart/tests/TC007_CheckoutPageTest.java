package com.opencart.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobjects.CheckoutPage;
import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.MyAccountPage;
import com.opencart.pageobjects.ProductPage;
import com.opencart.pageobjects.RegisterPage;
import com.opencart.pageobjects.SearchResultPage;
import com.opencart.pageobjects.ShoppingCart;
import com.opencart.util.Utils;

public class TC007_CheckoutPageTest extends BaseClass {
	HomePage homepage;

	@Test(dataProvider = "dataSupplier")

	public void enterBillingDetails(Object firstName, Object lastName, Object address1, Object city, Object postcode,
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
		boolean result = driver.getPageSource().contains("Your order has been placed!");
		// Assert.assertTrue(result);
	}
	
	
	@DataProvider
	public Object[][] dataSupplier() throws IOException {
		String path = "C:\\java\\OpenCartDataDrivenFramework\\src\\test\\java\\com\\opencart\\testdata\\Opencart.xlsx";
		return Utils.getCellValues(path, 2);
	}

//	@DataProvider
//	public Object[][] dataset() throws IOException {
//		String path = "C:\\java\\OpenCartDataDrivenFramework\\src\\test\\java\\com\\opencart\\testdata\\Opencart.xlsx";
//		FileInputStream fis = new FileInputStream(path);
//		XSSFWorkbook wb = new XSSFWorkbook(fis);
//		XSSFSheet sheet = wb.getSheetAt(2);
//		int rows = Utils.getRows(path, 2);
//		int cols = Utils.getCols(path, 1);
//		Object[][] loginDataset = new Object[1][7];
//		for (int i = 0; i < rows - 1; i++) {
//			XSSFRow row = sheet.getRow(i + 1);
//
//			for (int j = 0; j <= cols; j++) {
//				XSSFCell cell = row.getCell(j);
//
//				switch (cell.getCellType()) {
//				case STRING:
//
//					loginDataset[0][j] = cell.getStringCellValue();
//					break;
//				case NUMERIC:
//					loginDataset[0][j] = cell.getNumericCellValue();
//					break;
//				default:
//					break;
//				}
//
//			}
//
//		}
//		return loginDataset;
//	}
}
