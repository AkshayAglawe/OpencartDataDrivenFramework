package com.opencart.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.MyAccountPage;
import com.opencart.util.Utils;

public class TC002_LoginPageTest extends BaseClass {
	@Test(dataProvider="dataSupplier")
	public void login(Object email,Object password) {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(String.valueOf(email));
		login.enterPassword(String.valueOf(password));
		MyAccountPage myaccount = login.clickOnLoginButton();
		Assert.assertTrue(myaccount.validateYourOrderHistory() );
		
	}
	@DataProvider
	public Object[][] dataSupplier() throws IOException {
	String path = "C:\\java\\OpenCartDataDrivenFramework\\src\\test\\java\\com\\opencart\\testdata\\Opencart.xlsx";
	return Utils.getCellValues(path,0);
		
	}	
	
	
	@DataProvider
	public Object[][] dataset() throws IOException {
		String path = "C:\\java\\OpenCartDataDrivenFramework\\src\\test\\java\\com\\opencart\\testdata\\Opencart.xlsx";
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rows = Utils.getRows(path, 0);
		int cols = Utils.getCols(path, 0);
		Object[][] loginDataset = new Object[3][2];
		for (int i = 0; i < rows - 1; i++) {
			XSSFRow row = sheet.getRow(i + 1);

			for (int j = 0; j < cols; j++) {
				XSSFCell cell = row.getCell(j);

				switch (cell.getCellType()) {
				case STRING:
					cell.getStringCellValue();
					loginDataset[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					loginDataset[i][j] = cell.getNumericCellValue();
					break;
				default:
					break;
				}

			}

		}
		return loginDataset;
	}
	
	
	

}
