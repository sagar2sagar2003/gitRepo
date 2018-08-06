package Utility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import com.wordpress.testcases.VerifyWPLogin;

public class ReuseMethods {
	WebDriver driver = VerifyWPLogin.driver;
	
	public WebDriver AppLaunchAndMax(String DriverString, String eurl, String DriverPath)
	{
		
		switch (DriverString)
		{
		case "IE":
			System.setProperty("webdriver.ie.driver", "D:\\Selenium_Aug17_Softwares\\Selenium_June18\\Browsers\\IEDriverServer.exe");		
			driver = new InternetExplorerDriver();
			driver.get(eurl);
			driver.manage().window().maximize();
			break;
		case "FF":
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Aug17_Softwares\\Selenium_June18\\Browsers\\geckodriver.exe");
			driver = new FirefoxDriver();
			driver.get(eurl);
			driver.manage().window().maximize();
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", DriverPath);
			driver = new ChromeDriver();
			driver.get(eurl);
			driver.manage().window().maximize();
			break;
		default: System.out.println("Provide Input as FF or IE or Chrome");
		break;
		}
		return driver;
		
	}
	
	public void capScreen(String TestScreen) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("./Screenshots/"+TestScreen+".png"));
	}
	
}
