package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.tests.BaseClass;

public class ShoppingCart extends BaseClass {
	WebDriver driver;

	public ShoppingCart(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[normalize-space()='Image']")
	WebElement col1;

	@FindBy(xpath = "//td[normalize-space()='Product Name']")
	WebElement col2;

	@FindBy(xpath = "//td[normalize-space()='Model']")
	WebElement col3;

	@FindBy(xpath = "//td[normalize-space()='Quantity']")
	WebElement col4;

	@FindBy(xpath = "//td[normalize-space()='Unit Price']")
	WebElement col5;

	@FindBy(xpath = "//td[contains(text(),'Total')]")
	WebElement col6;

	public boolean validateTable() {
		if (col1.isDisplayed() && col2.isDisplayed() && col3.isDisplayed() && col4.isDisplayed() && col5.isDisplayed()
				&& col6.isDisplayed()) {
			return true;
		}
			
		return false;
		

	}

	@FindBy(xpath = "//i[@class='fa fa-times-circle']")
	WebElement removeProduct;

	public void removeProduct() {
		removeProduct.click();
	}

	@FindBy(xpath = "/html[1]/body[1]/div[2]/div[1]/div[1]/form[1]/div[1]/table[1]/tbody[1]/tr[1]/td[5]")
	WebElement unitPrice;

	public String getUnitPrice() {
		return unitPrice.getText().replace("$", "");

	}

//	public void getTotalPrice() {
//		getUnitPrice()*qty
//	}

	@FindBy(xpath = "(//a[text()='HP LP3065'])[2]")
	WebElement backToProductPage;

	public ProductPage navigateToProductPageFromShoppingCart() {
		backToProductPage.click();
		return new ProductPage(driver);
	}

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement removeBtn;

	public void clickOnRemoveBtn() {
		removeBtn.click();

	}

	@FindBy(xpath = "(//div[@id='content']//child::*)[2]")
	WebElement messageAfterRemovingAllProduct;

	public String validateMsg() {
		return messageAfterRemovingAllProduct.getText();
	}

	@FindBy(xpath = "//div[@class='input-group btn-block']//child::input")
	WebElement updateQtyField;
	String qty;

	public void enterQty(String qty) {
		updateQtyField.clear();
		updateQtyField.sendKeys(qty);
	}

	@FindBy(xpath = "//i[@class='fa fa-refresh']")
	WebElement updateBtn;

	public void update() {
		updateBtn.click();
	}

	@FindBy(xpath = "//a[text()='Checkout']")
	WebElement checkoutBtn;

	public CheckoutPage checkout() {
		checkoutBtn.click();
		return new CheckoutPage(driver);
	}
}
