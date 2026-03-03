package objectRepoClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class CoursePage {

		WebDriver driver;

	    public CoursePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Product (course)
	    By clawHammer = By.xpath("//h5[contains(text(),'Claw Hammer')]");

	    // Add to cart
	    By addToCartBtn = By.id("btn-add-to-cart");

	    // Error popup
	    By errorPopup = By.xpath("//*[contains(text(),'Oops')]");

	    public WebElement getClawHammer() {
	        return driver.findElement(clawHammer);
	    }

	    public WebElement getAddToCartBtn() {
	        return driver.findElement(addToCartBtn);
	    }

	    public boolean isErrorPopupDisplayed() {
	        try {
	            return driver.findElement(errorPopup).isDisplayed();
	        } catch (Exception e) {
	            return false;
	        }
	    }
	}

