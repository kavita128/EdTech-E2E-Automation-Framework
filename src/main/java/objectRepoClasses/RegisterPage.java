package objectRepoClasses;


	

	import java.time.Duration;

	import org.openqa.selenium.*;
	import org.openqa.selenium.support.ui.*;

	public class RegisterPage {

	    WebDriver driver;
	    WebDriverWait wait;

	    // Constructor
	    public RegisterPage(WebDriver driver) {
	        this.driver = driver;
	        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    }

	    // Locators
	    By signInLink = By.linkText("Sign in");
	    By registerLink = By.linkText("Register your account");

	    By firstName = By.id("first_name");
	    By lastName = By.id("last_name");
	    By dob = By.id("dob");
	    By address = By.id("address");
	    By postcode = By.id("postcode");
	    By city = By.id("city");
	    By state = By.id("state");
	    By country = By.id("country");
	    By phone = By.id("phone");
	    By email = By.id("email");

	    By password = By.cssSelector("app-password-input input");
	    By registerBtn = By.cssSelector("button[data-test='register-submit']");

	    // Actions

	    public void navigateToRegisterPage() {
	        driver.findElement(signInLink).click();
	        driver.findElement(registerLink).click();
	    }

	    public void enterPersonalDetails(String fName, String lName) {
	        driver.findElement(firstName).sendKeys(fName);
	        driver.findElement(lastName).sendKeys(lName);
	    }

	    public void enterAddressDetails() {
	        driver.findElement(dob).sendKeys("2000-03-06");
	        driver.findElement(address).sendKeys("Chikkabidarkal");
	        driver.findElement(postcode).sendKeys("561000");
	        driver.findElement(city).sendKeys("Bangalore");
	        driver.findElement(state).sendKeys("Karnataka");

	        Select dropdown = new Select(driver.findElement(country));
	        dropdown.selectByVisibleText("India");
	    }

	    public void enterContactDetails(String emailId) {
	        driver.findElement(phone).sendKeys("9999999999");
	        driver.findElement(email).sendKeys(emailId);
	    }

	    public void enterPassword(String pwd) {
	        WebElement passwordField = wait.until(
	                ExpectedConditions.visibilityOfElementLocated(password));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].scrollIntoView(true);", passwordField);

	        passwordField.sendKeys(pwd);
	    }

	    public void clickRegister() {
	        WebElement registerButton = wait.until(
	                ExpectedConditions.elementToBeClickable(registerBtn));

	        ((JavascriptExecutor) driver)
	                .executeScript("arguments[0].click();", registerButton);
	    }

	    // 🔥 FULL FLOW METHOD (VERY IMPORTANT)
	    public void registerUser(String emailId, String password) {

	        navigateToRegisterPage();
	        enterPersonalDetails("Test", "User");
	        enterAddressDetails();
	        enterContactDetails(emailId);
	        enterPassword(password);
	        clickRegister();
	    }
	}

