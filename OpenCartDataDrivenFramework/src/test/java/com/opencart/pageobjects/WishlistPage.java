package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.opencart.tests.BaseClass;

public class WishlistPage extends BaseClass {
	WebDriver driver;
	public WishlistPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

}
