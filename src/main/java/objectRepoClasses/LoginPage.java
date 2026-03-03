package objectRepoClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    By signIn = By.linkText("Sign in");
    By email = By.id("email");
    By password = By.cssSelector("app-password-input input");
    By loginBtn = By.cssSelector("[data-test='login-submit']");

    public void clickSignIn() {
        driver.findElement(signIn).click();
    }

    public void login(String userEmail, String userPass) {
        driver.findElement(email).sendKeys(userEmail);
        driver.findElement(password).sendKeys(userPass);
        driver.findElement(loginBtn).click();
    }
}
