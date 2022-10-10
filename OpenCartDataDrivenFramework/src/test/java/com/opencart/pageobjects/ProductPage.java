package com.opencart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.opencart.tests.BaseClass;

public class ProductPage extends BaseClass {
	WebDriver driver;

	public ProductPage(WebDriver driver) {

		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "input-quantity")
	WebElement qty;

	public void enterQuantity(int quantity) {
		qty.sendKeys(String.valueOf(quantity));
	}

	public String valiadteBydefaultQuantityEntered() {
		return qty.getAttribute("value");
	}

	@FindBy(id = "button-cart")
	WebElement addToCart;

	public void addToCart() {
		addToCart.click();

	}

	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa-heart']")
	WebElement addToWishList;

	public void addToWishList() {
		addToWishList.click();
	}

	public boolean validateAddToWishlistConfirmation() {
		return addToWishList.isDisplayed();
	}
// shopping cart alert
	// add to wishlist alert

//	@FindBy (xpath="//div[@class='alert alert-success alert-dismissible']")
//	WebElement adcConfirmationMsg;
//	
//	public String validateAddToCartConfirmationMsg() {
//		return adcConfirmationMsg.getText();
//	}

//	@FindBy (xpath="//div[@class='alert alert-success alert-dismissible']")
//	WebElement adwConfirmationMsg;
//	
//	public String validateAddToWishlistConfirmationMsg() {
//		return adwConfirmationMsg.getText();
//	}

	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	WebElement shoppingCart;

	public ShoppingCart navigateToshoppingCart() {
		shoppingCart.click();
		return new ShoppingCart(driver);
	}

	public boolean validateAddToCartConfirmation() {
		return shoppingCart.isDisplayed();
	}

	@FindBy(xpath = "//h2[normalize-space()='$100.00']")
	WebElement price;

	public String validatePrice() {
		return price.getText();
	}

	@FindBy(xpath = "//a[normalize-space()='Hewlett-Packard']")
	WebElement brand;
	@FindBy(xpath = "//li[normalize-space()='Product Code: Product 21']")
	WebElement productCode;
	@FindBy(xpath = "//li[normalize-space()='Availability: In Stock']")
	WebElement availability;

	public boolean validateOtherInfo() {
		return (brand.isDisplayed() && productCode.isDisplayed() && availability.isDisplayed());
	}
	
@FindBy(xpath="//a[normalize-space()='Reviews (0)']")
WebElement reviews;
 public void clickOnReviewTab() {
	 reviews.click();
 }

@FindBy(xpath="//input[@id='input-name']")
WebElement yourNameField;

public void enterYourName(String name) {
	yourNameField.sendKeys(name);
	
}

@FindBy(xpath="//textarea[@id='input-review']")
WebElement inputReview;

public void writeReview(String review) {
	inputReview.sendKeys(review);
	
}


@FindBy(xpath="//input[@value='3']")
WebElement ratingRadioBtn;

public void giveRating() {
	ratingRadioBtn.click();
	
}

@FindBy(xpath="//button[@id='button-review']")
WebElement continueBtn;

public void submitReview() {
	continueBtn.click();
	
}

@FindBy(xpath="//div[text()=' Thank you for your review. It has been submitted to the webmaster for approval.']")
WebElement reviewSubmissionConfirmationAlert;

public boolean valiadateReviewAlert() {
	return reviewSubmissionConfirmationAlert.isDisplayed();
}
}
