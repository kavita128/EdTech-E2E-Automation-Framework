package objectRepoClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

	public class CartPage {
		 WebDriver driver;

		    public CartPage(WebDriver driver) {
		        this.driver = driver;
		    }

		    By cartIcon = By.xpath("//a[@class='nav-link' and @aria-label='cart']");
		    By quantity = By.cssSelector("[data-test='product-quantity']");
		    By productPrice = By.cssSelector("[data-test='product-price']");
		    By linePrice = By.cssSelector("[data-test='line-price']");
		    By totalPrice = By.cssSelector("[data-test='cart-total']");
		    By checkoutBtn = By.xpath("//button[contains(text(),'Proceed to checkout')]");

		    public void openCart() {
		        driver.findElement(cartIcon).click();
		    }

//		    public int getQuantity() {
//		        String qty = driver.findElement(quantity).getText();
//		        return Integer.parseInt(qty);
//		    }
		    public int getQuantity() {
		        String qty = driver.findElement(quantity).getText().trim();

		        if (qty.isEmpty()) {
		            System.out.println("BUG: Quantity is empty");
		            return 0; // avoid crash
		        }

		        return Integer.parseInt(qty);
		    }

//		    public double getProductPrice() {
//		        String price = driver.findElement(productPrice).getText().replace("$", "");
//		        return Double.parseDouble(price);
//		    }
		    public double getProductPrice() {
		        String price = driver.findElement(productPrice).getText().replace("$", "").trim();

		        if (price.isEmpty()) {
		            System.out.println("BUG: Product price empty");
		            return 0;
		        }

		        return Double.parseDouble(price);
		    }

		    public double getLinePrice() {
		        String price = driver.findElement(linePrice).getText().replace("$", "");
		        return Double.parseDouble(price);
		    }

		    public double getTotalPrice() {
		        String price = driver.findElement(totalPrice).getText().replace("$", "");
		        return Double.parseDouble(price);
		    }

		    public void clickCheckout() {
		        driver.findElement(checkoutBtn).click();
		    }
	}

