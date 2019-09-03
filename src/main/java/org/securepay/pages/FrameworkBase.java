package org.securepay.pages;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.securepay.utilclass.UtilClass;

public class FrameworkBase {
	
	public WebDriver driver;
	public UtilClass util;
	
public void setBrowser() throws MalformedURLException {
	 util= new UtilClass();
		
		String browserType = util.getAppPropValue("browser");

		// to facilitate multi browser settings

		if (browserType.equalsIgnoreCase("chrome")) {
			/*
			 * to open chrome browser in incognito mode 
			 */

			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "/resources/drivers/chromedriver_3.exe");
			driver = new ChromeDriver(options);
		}
		/*
		 *  add firefox or ie browser
		 *   we can start remote webdriver also. From there we can integrate it with Dockers(selenoid)
		 */
		//
	}

}
