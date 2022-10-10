package com.opencart.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.pageobjects.HomePage;
import com.opencart.pageobjects.LoginPage;
import com.opencart.pageobjects.MyAccountPage;
import com.opencart.pageobjects.SearchResultPage;

public class TC003_MyAccountPageTest extends BaseClass {

	@Test(priority = 1)
	public void searchForExistingProduct() throws InterruptedException {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage resultPage = myaccount.pressSearchBtn(Keys.ENTER);
	    Assert.assertEquals(resultPage.validateSearchResult(),"HP LP3065");
		//Assert.assertTrue(true);
		System.out.println("check2");
	}
	@Test(priority = 2)
	public void searchForNonExistingProduct() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("notebook");
		SearchResultPage resultPage = myaccount.pressSearchBtn(Keys.ENTER);
		Assert.assertEquals(resultPage. validateErrorMessage(),"There is no product that matches the search criteria.");
	
	}
	@Test(priority = 3)
	public void searchWithEnterBtn(){
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		myaccount.searchItem("hp");
		SearchResultPage resultPage = myaccount.pressSearchBtn(Keys.ENTER);
		//SearchResultPage resultPage= new SearchResultPage(driver);
		Assert.assertEquals(resultPage.validateSearchResult(),"HP LP3065");
	}
	
	@Test(priority = 4)
	public void validateTitle() {
		HomePage homepage = new HomePage(driver);
		homepage.clickOnMyAccountDropMenu();
		LoginPage login = homepage.selectLoginOption();
		login.enterEmailAddress(userID);
		login.enterPassword(password);
		MyAccountPage myaccount = login.clickOnLoginButton();
		Assert.assertEquals(myaccount.getTitle(),"My Account");
	}


}
