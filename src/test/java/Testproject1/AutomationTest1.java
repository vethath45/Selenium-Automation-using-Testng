package Testproject1;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumBase.BaseClass;

/*
1.Verify the title as Swag Labs
2.Verify the login button text is capitalized
3.Login with standard_user & secret_sauce
4.Verify default filter dropDown is A-Z
5.Add the first product to the cart
6.Verify the cart badge has 1 product
7.Add the last product to the cart
8.Verify the cart badge value is increased
9.Remove the first product from the cart
10.Verify the cart badge has 1 product
11.Click on the cart 
12.Verify the added product is available
13.Click on the continue shopping
14.Change the price filter from low to high
15.Screenshot the page
16.close all window.

*/

public class AutomationTest1 extends BaseClass {

	@Test(priority = 1)
	void setup() {
		// Verify the title as Swag Labs
		setup("chrome", "https://www.saucedemo.com/");
	}
	
	
	

	@Test(priority = 2)
	public void VerifyTitle() {
		String expectedTitle = "Swag Labs";
		String actualTitle = getTitle();

		if (actualTitle.equals(expectedTitle)) {
			System.out.println("Title verification passed!");
		} else {
			System.out.println("Title verification failed! Expected: " + expectedTitle + " but found: " + actualTitle);
		}
	}
	
	

	@Test(priority = 3)
	public void input() {
		type(element("name", "user-name"), "standard_user");
		type(element("name", "password"), "secret_sauce");
		WebElement loginButton = element("id", "login-button");
		String loginButtonText = loginButton.getText();
		System.out.println("Text of login button: " + loginButtonText);
		click(element("name", "login-button"));
	}
	
	

	@Test(priority = 4)
	public void VerifyDropdown() {
		WebElement option = element("className", "product_sort_container");

		// Get the current selected value of the filter dropdown
		Select select = new Select(option);
		WebElement selectedOption = select.getFirstSelectedOption();

		// Check if the text of the selected option is "A-Z"
		Assert.assertEquals(selectedOption.getText(), "Name (A to Z)", "Default filter is not set to A-Z");
	}

	
	
	@Test(priority = 5)
	public void SelectProduct() {
		WebElement product = element("id", "add-to-cart-sauce-labs-backpack");

		product.click();
	}

	
	
	@Test(priority = 6)
	public void CheckCart() {

		WebElement cartBadge = element("className", "shopping_cart_badge");
		String cartBadgeText = cartBadge.getText();

		Assert.assertEquals(cartBadgeText, "1", "Cart badge does not show 1 product");
	}
	
	

	@Test(priority = 7)
	public void Addcart2() {
		WebElement product2 = element("id", "add-to-cart-test.allthethings()-t-shirt-(red)");

		product2.click();
	}
	
	

	@Test(priority = 8)
	public void cart2() {

		WebElement cartBadge2 = element("className", "shopping_cart_badge");
		String cartBadgeText2 = cartBadge2.getText();
		Assert.assertEquals(cartBadgeText2, "2", "Cart badge does not show 2 product");
	}
	
	

	@Test(priority = 9)
	public void RemoveProduct() {
		WebElement RemoveProduct = element("id", "remove-sauce-labs-backpack");
		RemoveProduct.click();

	}
	
	

	@Test(priority = 10)
	public void VerifyProduct() {

		WebElement cartBadge1 = element("className", "shopping_cart_badge");
		String Badge = cartBadge1.getText();
		Assert.assertEquals(Badge, "1", "cart badge does not show 1 product");

	}
	
	

	@Test(priority = 11)
	public void cart() {
		element("className", "shopping_cart_link").click();
	}
	
	

	@Test(priority = 12)

	public void displauproduct() {
		WebElement display = element("className", "inventory_item_name");

		if (display.isDisplayed()) {
			System.out.println("displaying");
		} else {
			System.out.println("not displaying");
		}
	}

	
	
	@Test(priority = 13)
	public void ContinueShooping() {
		element("id", "continue-shopping").click();
	}
	
	

	@Test(priority = 14)
	public void selectDropdown() {

		WebElement sel = element("className", "product_sort_container");

		SelectByvalue(sel, "lohi");

		screenshot("./snaps/img.png");
	}
	
	

	@Test(priority = 15)
	public void tearDown() {
		Quit();

	}

}
