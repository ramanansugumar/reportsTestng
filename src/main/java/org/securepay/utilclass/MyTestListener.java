package org.securepay.utilclass;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.TestListenerAdapter;

public class MyTestListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult arg0){
        System.out.println("Failure detected...");
        String fileName = String.format("Screenshot-%s.jpg", Calendar.getInstance().getTimeInMillis());
        WebDriver driver = (WebDriver)arg0.getTestContext().getAttribute("webDriver");
        TakesScreenshot ts = (TakesScreenshot)driver;
        File srcFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File(System.getProperty("user.dir")+"./screenshots/" + fileName);
        try{
            FileUtils.copyFile(srcFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Reporter.log("<a href='"+ destFile.getAbsolutePath() + "'> <img src='"+ destFile.getAbsolutePath() + "' height='100' width='100'/> </a>");
        System.out.println("Screenshot taken");
    }
}
