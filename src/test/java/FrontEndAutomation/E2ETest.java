package FrontEndAutomation;

import static org.testng.Assert.*;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import GeericLiraries.BaseClass;
import objectRepoClasses.CartPage;
import objectRepoClasses.CoursePage;
import objectRepoClasses.HomePage;
import objectRepoClasses.LoginPage;

public class E2ETest extends BaseClass {
@Test
public void logIn() throws IOException {
	String email = fUtil.readdatafromPropertyfile("email");
	 String password1 = fUtil.readdatafromPropertyfile("password1");
 LoginPage login = new LoginPage(driver);
 HomePage home = new HomePage(driver);
 CoursePage course = new CoursePage(driver);
 CartPage cart = new CartPage(driver);
 login.clickSignIn();

 login.login(email, password1);

 boolean isDisplayed = driver.findElement(By.xpath("//h1[text()='My account']")).isDisplayed();

 Assert.assertTrue(isDisplayed, 
         "Login Failed - My Account page not displayed");

 System.out.println("Login Successful");
 //
 WebElement categories = home.getCategoriesMenu();
 wUtil.waitUntillEleToeclickale(driver, 10, categories);
 categories.click();

 // 🔹 SELECT Hand Tools
 WebElement handTools = home.getHandTools();
 wUtil.waitUntillEleToeclickale(driver, 10, handTools);
 handTools.click();

 // 🔥 ASSERTION (VERY IMPORTANT)
 boolean isCategoryLoaded = driver.getPageSource().contains("Category: Hand Tools");

 Assert.assertTrue(isCategoryLoaded,
         "Failed to load Hand Tools category");

 System.out.println("Course category loaded successfully");
 //
// WebElement product = course.getClawHammer();
// wUtil.waitUntillEleToeclickale(driver, 10, product);
// product.click(); 
 
 WebElement product = course.getClawHammer();

//Scroll
wUtil.scrollToElement(driver, product);

//Wait
wUtil.waitUntillEleToeclickale(driver, 10, product);

try {
  product.click();
} catch (Exception e) {
  // 🔥 fallback (VERY IMPORTANT in real projects)
  wUtil.clickElementUsingJSE(driver, product);
}

 // 🔹 ADD TO CART
 WebElement addBtn = course.getAddToCartBtn();
 wUtil.waitUntillEleToeclickale(driver, 10, addBtn);
 addBtn.click();

 // 🔥 HANDLE BUG (IMPORTANT)
 if (course.isErrorPopupDisplayed()) {
     System.out.println("BUG: Error popup displayed after adding to cart");
 }
 cart.openCart();

//🔹 GET VALUES
int qty = cart.getQuantity();
double price = cart.getProductPrice();
double linePrice = cart.getLinePrice();
double total = cart.getTotalPrice();

//🔹 EXPECTED CALCULATION
double expectedLinePrice = qty * price;

System.out.println("Qty: " + qty);
System.out.println("Price: " + price);
System.out.println("Line Price(UI): " + linePrice);
System.out.println("Expected Line Price: " + expectedLinePrice);
System.out.println("Total: " + total);

//🔥 VALIDATION 1 (THIS WILL FAIL → BUG)
Assert.assertEquals(linePrice, expectedLinePrice,
      "BUG: Line price is incorrect");

//🔥 VALIDATION 2 (SHOULD PASS)
Assert.assertTrue(total > 0,
      "Total price is incorrect");

//🔹 PROCEED TO CHECKOUT
cart.clickCheckout();
driver.findElement(By.xpath("//button[text()='Proceed to checkout ']")).click();

}        

}



