import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReusableMethods {
	
	WebDriver getDriver(String DriverString)
	{
		
		switch (DriverString)
		{
		case "IE":
		System.setProperty("webdriver.ie.driver", "D:\\Selenium_Aug17_Softwares\\Selenium_June18\\Browsers\\IEDriverServer.exe");		
		Test.driver = new InternetExplorerDriver();
		break;
		case "FF":
			System.setProperty("webdriver.gecko.driver", "D:\\Selenium_Aug17_Softwares\\Selenium_June18\\Browsers\\geckodriver.exe");
			Test.driver = new FirefoxDriver();
			break;
		case "Chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Aug17_Softwares\\Selenium_June18\\Browsers\\chromedriver.exe");
			Test.driver = new ChromeDriver();
			break;
		default: System.out.println("Provide Input as FF or IE or Chrome");
		break;
		}
		return Test.driver;
		
	}
	void verifyTitle(String title)
	{
		Test.titleName = Test.driver.getTitle();
		
		if(Test.titleName.equals(title))
		{
			System.out.println("Title Matched");
		}
		else
		{System.out.println("Title Mismatched");}

	}
	
	void SelectDate(String xpathVar, String DateVar)
	{
		List<WebElement> dates = Test.driver.findElements(By.xpath(xpathVar));
		int totalDates = dates.size();
		for (int i=0;i<totalDates; i++)
		{
			String sd = dates.get(i).getText();
			if(sd.equalsIgnoreCase(DateVar))
			{
				dates.get(i).click();
				break;
			}
		}
	}
}
