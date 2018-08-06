import org.openqa.selenium.By;

import java.util.List;

import org.apache.commons.lang3.math.IEEE754rUtils;
import org.apache.http.util.Asserts;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class Test {
	static WebDriver driver;
	static String titleName;
	static ReusableMethods t;
	public static void main(String[] args) throws InterruptedException {
		t = new ReusableMethods();
		try {
			
		driver = t.getDriver("Chrome");//Provide Input IE or Chrome //FF v. 54.0 is not Compatible
		driver.get("http://www.spicejet.com");
		driver.manage().window().maximize();
		
		t.verifyTitle("SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
		if(driver.findElement(By.id("ctl00_mainContent_view_date2")).isEnabled())
		{
			System.out.println("Round Trip Date Window Enabled");
		}else {System.out.println("Still Disabled");}
		
		
		//Bootstrap Drop Down
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		List<WebElement> Depar_dd = driver.findElements(By.xpath("//div[@id='dropdownGroup1']//ul/li/a"));
		for(WebElement e:Depar_dd)
		{
			String Depar_CityName=e.getAttribute("innerHTML");
			//System.out.println(Depar_CityName);
			
			if(Depar_CityName.contains("SXR"))
			{
				e.click();
				
			}
		} 

		//Traditional Drop Down
		
		Select Currency = new Select(driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency")));
		List<WebElement> CurrencyList = Currency.getOptions();
		for(int i=0;i<CurrencyList.size();i++)
		{
			WebElement c = CurrencyList.get(i);
			if(c.getText().equals("USD"))
			{
				c.click();
				Thread.sleep(1000);
			}
		}
		
		
		/*
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@class='dropdownDiv']/ul[3]/li[6]")).click();
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//div[@class='dropdownDiv']/ul[4]/li[4])[2]")).click();
		
		
		t.SelectDate("//table[@class='ui-datepicker-calendar']//td", "15");
		driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		t.SelectDate("//table[@class='ui-datepicker-calendar']//td", "18");
		driver.findElement(By.xpath("//div[@class='row1 adult-infant-child']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='divAdult']/div/span[3]")).click();
		driver.findElement(By.xpath("//div[@id='divChild']/div/span[3]")).click();
		driver.findElement(By.id("btnclosepaxoption")).click();
		
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().dismiss();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_friendsandfamily']")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_StudentDiscount']")).click();
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")).click();
		
		Thread.sleep(5000);
		t.verifyTitle("Cheap Air Tickets Online, International Flights to India, Cheap International Flight Deals | SpiceJet Airlines");
			*/	
		}
		
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		finally
		{
			driver.quit();
		}
	}
}