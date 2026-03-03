package GeericLiraries;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class webDriverUtility {
	
/**
 *  this method is used to maximize the window
 * @param driver
 */
	public void maximizWidow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 *  this method is used to wait for to load the page
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	}
	/**
	 *  this method is used to wait until element is available on webpage
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	/**
	 * waitUntillEleToeVisile
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitUntillEleToeVisile(WebDriver driver, int seconds, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	/**
	 *  this method is used to wait until element is available on webpage to click
	 * @param driver
	 * @param seconds
	 * @param element
	 */
	public void waitUntillEleToeclickale(WebDriver driver, int seconds, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	//1 Way//SELECT
//	public void dropDownUsingValue(WebElement element, String value)
//	{
//		Select sel = new Select(element);
//		sel.selectByValue(value);
//	}
	
	//public void dropDownUsingIndex(WebElement element, int index )
//	{
//	Select sel = new Select(element);
//		sel.selectByIndex(index);
//	}
	
	/**
	 * this method is used to create an object for select class to call select class
	 * @param element
	 * @return
	 */
	/**
	 * select class methods
	 * @param element
	 * @return
	 */
	public Select dropDown(WebElement element)
	{
	Select sel = new Select(element);
	return sel;
	}
	
	
	
	/**
	 * this method is used to select the value from dropdown
	 * @param element
	 * @param value
	 */
	public void dropDownUsingValue(WebElement element, String value)
	{
		dropDown(element).selectByValue(value);
	}
	/**
	 * this method is used to select the int index vaue from dropdown
	 * @param element
	 * @param index
	 */
	/**
	 *  this method is used to select the droupdow by ContainsVisibleText
	 * @param element
	 * @param VisibleText
	 */
	
	public void dropDownUsingContainsVisibleText(WebElement element, String VisibleText )
	{
		dropDown(element).selectByValue(VisibleText);
	}
	
	
	public void dropDownUsingIndex(WebElement element, int index)
	{
		dropDown(element).selectByIndex(index);
	}
	/**
	 * this method is used to select the text from dropdown
	 * @param element
	 * @param text
	 */
	public void dropDownUsingElemet(WebElement element, String text)
	{
		dropDown(element).selectByVisibleText(text);
	}
	/**
	 * this method is used to create an object for actions class
	 * @param driver
	 * @return
	 */
	//Actions
	public Actions actions(WebDriver driver)
	{
		Actions act = new Actions(driver);
		return act;
	}
	/**
	 *  this method is used to move mouse to element
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element)
	{
		actions(driver).moveToElement(element).perform();
	}
	/**
	 * this method is used to  move mouse to element and click on the element
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAndClickOnEle(WebDriver driver, WebElement element)
	{
		actions(driver).moveToElement(element).click(element).perform();
	}
	
	/**
	 * this method is used to right click o webelement
	 * @param driver
	 * @param element
	 */
	public void rightClickOnEle(WebDriver driver, WebElement element)
	{
	    actions(driver).contextClick(element).perform();
	}
/**
 * this method is used to move mouse to element and click on the element
 * @param driver
 * @param element
 */
	public void clickAndHold(WebDriver driver, WebElement element)
	{
	    actions(driver).clickAndHold(element).perform();
	}

	//clickHoldAndRelease
	/**
	 * 
	 * @param driver
	 * @param element
	 */
	public void clickHoldAndRelease(WebDriver driver, WebElement element)
	{
	    actions(driver).clickAndHold(element).release().perform();
	}

	
	/**
	 * this method is used to drag and drop the webelement
	 * 
	 * @param driver
	 * @param src
	 * @param dst
	 */
	public void dragAndDrop(WebDriver driver, WebElement src, WebElement dst) {
		actions(driver).dragAndDrop(src, dst).perform();
	}

	/**
	 * this method is used to scroll web page
	 * @author Srinivas V
	 * @param driver
	 * @param x
	 * @param y
	 */
	public void scrollWebPage(WebDriver driver, int x, int y) {
		actions(driver).scrollByAmount(x, y).perform();
	}

	/**
	 * this method is used to scroll to the element
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void scrollToElement(WebDriver driver, WebElement element) {
		actions(driver).scrollToElement(element).perform();
	}

	/**
	 * this method is used to double click on the webpage
	 * @author Srinivas V
	 * @param driver
	 */
	public void doubleclick(WebDriver driver) {
		actions(driver).doubleClick().perform();
	}

	/**
	 * this method is used to  double Click On Element
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void doubleClickOnElement(WebDriver driver, WebElement element) {
		actions(driver).doubleClick(element).perform();
	}

	/**
	 * this method is used to right Click On Web Page
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void rightClickOnWebPage(WebDriver driver, WebElement element) {
		actions(driver).contextClick(element).perform();
	}

	/**
	 * this method is used to right Click On Element
	 * @author Srinivas V
	 * @param driver
	 * @param element
	 */
	public void rightClickOnElement(WebDriver driver, WebElement element) {
		actions(driver).contextClick().perform();

	}

	
	/**
	 * this method is used to switch child frame by using inex value
	 * @param driver
	 * @param index
	 */
	//frames
	public void switchToChildFrame(WebDriver driver, int index)
	{
	    driver.switchTo().frame(index);
	}

	/**
	 * this method is used to switch child frame by using name
	 * @param driver
	 * @param name
	 */
	public void switchToChildFrame(WebDriver driver, String name)
	{
	    driver.switchTo().frame(name);
	}
/**
 * this method is used to switch child frame by using webelement
 * @param driver
 * @param element
 */
	public void switchToChildFrame(WebDriver driver, WebElement element)
	{
	    driver.switchTo().frame(element);
	}

	/**
	 * this method is used to switch parent frame
	 * @param driver
	 */
	public void switchToParentFrame(WebDriver driver)
	{
	    driver.switchTo().parentFrame();
	}
	/**
	 * this method is used to switch main frame
	 * @param driver
	 */
	public void switchToMainPage(WebDriver driver)
	{
	    driver.switchTo().defaultContent();
	}
	
	/**
	 * this method is used to accept the alert popup
	 * @param driver
	 */
	//alert popups
	public void acceptAlertPopup(WebDriver driver)
	{
	    driver.switchTo().alert().accept();
	}
/**
 * this method is used to cancel the alert popup
 */
	public void cancelAlertPopup(WebDriver driver)
	{
	    driver.switchTo().alert().dismiss();
	}
/** 
 * this method is used to get text from alter popup
 * @param driver
 */
	public void getTextFromAlertPopup(WebDriver driver)
	{
	    driver.switchTo().alert().getText();
	}
/**
 *  this method is used to enter the value into alert text field
 * @param driver
 * @param value
 */
	public void enterValueIntoAlertTextField(WebDriver driver, String value)
	{
	    driver.switchTo().alert().sendKeys(value);
	}
	
	/** 
	 * this method is used to get the all windows
	 * @param driver
	 * @param expTitle
	 */
	//WindowHandle
	public void switchToWindow(WebDriver driver, String expTitle)
	{
		//String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();
		while(it.hasNext())
		{
			String currentWin = it.next();
			@Nullable
			String actualTitle = driver.switchTo().window(currentWin).getTitle();
			if(actualTitle.contains(expTitle))
			{
				break;
			}
		}
		/**
		 *  this method is used to switch the parent window
		 */
	}
	public void switchToPareatWidow(WebDriver driver, String ParetID)
	{
		driver.switchTo().window(ParetID);
	}
	/** 
	 * typecasting to the javascript method
	 * @param driver
	 * @return
	 */
	//JavaScript
	// Return JS executor
	public JavascriptExecutor javascriptExecutor(WebDriver driver) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    return js;
	}
/**
 * this method is used to scroll height
 * @param driver
 */
	// Scroll to bottom of the page
	public void scrollHeight(WebDriver driver) {
	    javascriptExecutor(driver).executeScript("window.scrollBy(0, document.body.scrollHeight);");
	}

	/**
	 * this mehtod is used to scroll unit element is visible
	 * @param driver
	 * @param element
	 */
	// Scroll till element is visible
	public void scrollUntilEleIsVisibleUsingJSE(WebDriver driver, WebElement element) {
	    javascriptExecutor(driver).executeScript("arguments[0].scrollIntoView();", element);
	}
/**
 * this method is used to click on element
 * @param driver
 * @param element
 */
	// Click on element using JS
	public void clickElementUsingJSE(WebDriver driver, WebElement element) {
	    javascriptExecutor(driver).executeScript("arguments[0].click();", element);
	}
/**
 *  this method is used to enter the value into text field
 * @param driver
 * @param element
 * @param value
 */
	// Enter text using JS (sendKeys alternative)
	public void enterValueIntoTextFieldUsingJSE(WebDriver driver, WebElement element, String value) {
	    javascriptExecutor(driver).executeScript("arguments[0].value = arguments[1];", element, value);
	}
/**
 * this method is used to scroll to element x y location
 * @param driver
 * @param element
 */
	// Scroll to element using XY coordinates
	public void scrollToEleUsingXYCoordinate(WebDriver driver, WebElement element) {
	    Point loc = element.getLocation();
	    int x = loc.getX();
	    int y = loc.getY();
	    javascriptExecutor(driver).executeScript("window.scrollBy(" + x + "," + y + ");");
	}
	
}
  
    
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


