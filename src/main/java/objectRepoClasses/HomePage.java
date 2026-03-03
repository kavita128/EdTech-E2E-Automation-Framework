package objectRepoClasses;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

	public class HomePage {

		WebDriver driver;

	    public HomePage(WebDriver driver) {
	        this.driver = driver;
	    }

	    // Categories menu (using contains + tag a as you said)
	    By categoriesMenu = By.xpath("//a[contains(text(),'Categories')]");

	    // Hand Tools option inside dropdown
	    By handTools = By.xpath("//a[contains(text(),'Hand Tools')]");

	    public WebElement getCategoriesMenu() {
	        return driver.findElement(categoriesMenu);
	    }

	    public WebElement getHandTools() {
	        return driver.findElement(handTools);
	    }

	    // Action method
	    public void selectHandToolsCategory() {
	        driver.findElement(categoriesMenu).click();
	        driver.findElement(handTools).click();
	    }
	}
	

