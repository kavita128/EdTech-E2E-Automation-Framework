package GeericLiraries;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;



public class BaseClass {
	
	public FileUtility fUtil = new FileUtility();
	public ExcelUtils excUtil = new ExcelUtils();
	public JavaUtils javUtils = new JavaUtils();
	public webDriverUtility wUtil = new webDriverUtility();
  
	public WebDriver driver;
	//public static WebDriver sdriver;
	public static ThreadLocal<WebDriver> wdriver = new ThreadLocal<WebDriver>();
	@BeforeSuite(groups = "smoke")
	public void connectToDB()
	{
		System.out.println("--connect To DB ");
	}
	
	@Parameters("BROWSER")
	
	@BeforeClass(groups = "smoke")
	public void launchBrowser() throws IOException
	{
		String BROWSER = fUtil.readdatafromPropertyfile("browser");
		 String URL = fUtil.readdatafromPropertyfile("url");
		 
		 if(BROWSER.equalsIgnoreCase("chrome"))
		 {
	       driver = new ChromeDriver();
		 }
 else if(BROWSER.equalsIgnoreCase("firefox"))
	 {
	 driver = new FirefoxDriver();
	 }
 else if(BROWSER.equalsIgnoreCase("edge"))
 {   
	 driver = new EdgeDriver(); 
 }
		//sdriver = driver;
		 wdriver.set(driver);
		 
 wUtil.maximizWidow(driver);
 //driver.manage().window().maximize();
 driver.get(URL);
	wUtil.waitForPageLoad(driver);
	System.out.println("---Browse lauched successfully ");
		 }
	
//	@BeforeMethod(groups = "smoke")
//	public void LoginToApp() throws IOException
//	{
//	 String USERNAME = fUtil.readdatafromPropertyfile("username");
//	 String PASSWORD = fUtil.readdatafromPropertyfile("password");
//	LoginPage Lp =  new LoginPage(driver);
//	Lp.loginToApp(USERNAME, PASSWORD);
//	
//	System.out.println("logged in To App");
//	}
//	
//	@AfterMethod(groups = "smoke")
//	public void LoggedOutFromApp()
//	{  HomePage Hp  = new HomePage(driver);
//		Hp.SiOuBt(driver);
//		//driver.quit();
//		System.out.println("logged out of appli");
//	}
//	
	@AfterClass(groups = "smoke")
	public void closeBrowser()
	{
	//driver.quit();
	System.out.println("closed Browser");
	}
	
	@AfterSuite(groups = "smoke")
	public void DisConnectDB()
	{
		System.out.println("DisConnec to DB");
	}


	
	
}
