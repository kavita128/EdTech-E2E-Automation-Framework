package GeericLiraries;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListerImplemetatioClass implements ITestListener , ISuiteListener {
	ExtentReports report;
	ExtentTest test;
	public static ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();
	@Override
	public void onTestStart(ITestResult result)
	{
		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		extent.set(test);
		//test.log(Status.INFO, methodName+"execution starts");
		extent.get().log(Status.INFO, "<b>methodName+execution starts</b>");
	}


	@Override
	public void onTestSuccess(ITestResult result)
	{
		
		String methodName = result.getMethod().getMethodName();
		//test.log(Status.PASS, methodName+"-->passed");
		extent.get().log(Status.PASS,"<b> "+ methodName +"execution starts</b>");

	}

	//	@Override
	//	public void onTestFailure(ITestResult result) {
	//		
	//		String methodName = result.getMethod().getMethodName();
	//		String fileName = methodName+new JavaUtils().sysDate() ;
	//		try {
	//		//String filepath = ".\\screenshort\\"+methodName+new JavaUtils().systemDate()+".png";
	//		String filepath = ".\\screenshort\\"+fileName+".png";
	//		TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
	//		File src = ts.getScreenshotAs(OutputType.FILE);
	//		File dst = new File(filepath);
	//		
	//			FileUtils.copyFile(src, dst);
	//			String path = dst.getAbsolutePath();
	//			test.addScreenCaptureFromPath(path);
	//			test.log(Status.FAIL, result.getThrowable());
	//			test.log(Status.FAIL, methodName+" ---> failed");
	//		} catch (IOException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}

	//	@Override
	//	public void onTestFailure(ITestResult result) {
	//
	//	    String methodName = result.getMethod().getMethodName();
	//	    test.log(Status.FAIL, methodName + " ---> FAILED");
	//	    test.log(Status.FAIL, result.getThrowable());
	//
	//	    try {
	//	        if (BaseClass.sdriver != null) {
	//	            String fileName = methodName + new JavaUtils().sysDate();
	//	            String filepath = ".\\screenshort\\" + fileName + ".png";
	//
	//	            TakesScreenshot ts = (TakesScreenshot) BaseClass.sdriver;
	//	            File src = ts.getScreenshotAs(OutputType.FILE);
	//	            File dst = new File(filepath);
	//
	//	            FileUtils.copyFile(src, dst);
	//	            test.addScreenCaptureFromPath(dst.getAbsolutePath());
	//	        }
	//	    } catch (Exception e) {
	//	        test.log(Status.WARNING, "Screenshot capture failed: " + e.getMessage());
	//	    }
	//	}	

	@Override
	public void onTestFailure(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		test.log(Status.FAIL,"<i>"+ methodName +"---> FAILED</i>");
		test.log(Status.FAIL, result.getThrowable());

		try {
			if (BaseClass.wdriver != null) {

				File folder = new File("./screenshots");
				if (!folder.exists()) {
					folder.mkdirs();
				}

				String fileName = methodName + "_" + new JavaUtils().sysDateSimple() + ".png";
				File dst = new File(folder, fileName);

				TakesScreenshot ts = (TakesScreenshot) BaseClass.wdriver.get();
				File src = ts.getScreenshotAs(OutputType.FILE);

				FileUtils.copyFile(src, dst);

				test.addScreenCaptureFromPath(dst.getAbsolutePath());
			}
		} catch (Exception e) {
			test.log(Status.WARNING, "Screenshot failed: " + e.getMessage());
			e.printStackTrace();
		}
	}



	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		test.log(Status.SKIP, methodName+"-->skipped");	
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter(".\\ExtentReport\\report"+new JavaUtils().sysDateSimple()+".html");
		htmlreport.config().setDocumentTitle("TP-30");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("VTiger");

		report = new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base_browser", "chrome");
		report.setSystemInfo("base_platform", "windows");
		report.setSystemInfo("base_url", "http://localhost:8888");
		report.setSystemInfo("Reportername", "Kavita");

	}

	@Override
	public void onFinish(ITestContext context) {
		report.flush();	
	}

}
