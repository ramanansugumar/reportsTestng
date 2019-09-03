package org.securepay;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.securepay.pages.FrameworkBase;
import org.securepay.pages.SecurepayPage;
import org.securepay.utilclass.MyTestListener;
import org.securepay.utilclass.UtilClass;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

@Listeners({MyTestListener.class})
public class TestRunner2 {
	
	WebDriver driver;
	

	// to intialize the reports
	
	@Test(priority = 0)
	public void anothertest(ITestContext context) throws FileNotFoundException, IOException, InterruptedException {
		FrameworkBase base = new FrameworkBase();
		base.setBrowser();
		driver=base.driver;
	
	
			driver.get(base.util.getAppPropValue("googleurl"));
			SecurepayPage page = new SecurepayPage(driver);
			context.setAttribute("webDriver", driver);
			page.clickSecurePay();
			
			page.gotoSupport();
			page.gotoContact();
			page.contactPageVerification();
		
			page.enterInformation();
			page.enterPh();
			page.enterUrl();
			page.selectEnquiry();
			
		
		
	}

	@AfterTest
	public void getResult() throws IOException {
		
		driver.quit();
		
	}


	

}
