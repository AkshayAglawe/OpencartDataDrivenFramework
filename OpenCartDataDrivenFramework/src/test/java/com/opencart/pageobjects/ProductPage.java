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
	private WebElement qty;

	public void enterQuantity(int quantity) {
		qty.sendKeys(String.valueOf(quantity));
	}

	public String valiadteBydefaultQuantityEntered() {
		return qty.getAttribute("value");
	}

	@FindBy(id = "button-cart")
	private WebElement addToCart;

	public void addToCart() {
		addToCart.click();

	}

	@FindBy(xpath = "//button[@type='button']//i[@class='fa fa-heart']")
	private WebElement addToWishList;

	public void addToWishList() {
		addToWishList.click();
	}

	public boolean validateAddToWishlistConfirmation() {
		return addToWishList.isDisplayed();
	}

	@FindBy(xpath = "//a[normalize-space()='shopping cart']")
	private WebElement shoppingCart;

	public ShoppingCart navigateToshoppingCart() {
		shoppingCart.click();
		return new ShoppingCart(driver);
	}

	public boolean validateAddToCartConfirmation() {
		return shoppingCart.isDisplayed();
	}

	@FindBy(xpath = "//h2[normalize-space()='$100.00']")
	private WebElement price;

	public String validatePrice() {
		return price.getText();
	}

	@FindBy(xpath = "//a[normalize-space()='Hewlett-Packard']")
	private WebElement brand;
	@FindBy(xpath = "//li[normalize-space()='Product Code: Product 21']")
	private WebElement productCode;
	@FindBy(xpath = "//li[normalize-space()='Availability: In Stock']")
	private WebElement availability;

	public boolean validateOtherInfo() {
		return (brand.isDisplayed() && productCode.isDisplayed() && availability.isDisplayed());
	}

	@FindBy(xpath = "//a[normalize-space()='Reviews (0)']")
	private WebElement reviews;

	public void clickOnReviewTab() {
		reviews.click();
	}

	@FindBy(xpath = "//input[@id='input-name']")
	private WebElement yourNameField;

	public void enterYourName(String name) {
		yourNameField.sendKeys(name);

	}

	@FindBy(xpath = "//textarea[@id='input-review']")
	private WebElement inputReview;

	public void writeReview(String review) {
		inputReview.sendKeys(review);

	}

	@FindBy(xpath = "//input[@value='3']")
	private WebElement ratingRadioBtn;

	public void giveRating() {
		ratingRadioBtn.click();

	}

	@FindBy(xpath = "//button[@id='button-review']")
	private WebElement continueBtn;

	public void submitReview() {
		continueBtn.click();

	}

	@FindBy(xpath = "//div[text()=' Thank you for your review. It has been submitted to the webmaster for approval.']")
	private WebElement reviewSubmissionConfirmationAlert;

	public boolean valiadateReviewAlert() {
		return reviewSubmissionConfirmationAlert.isDisplayed();
	}
}
