package Package1;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MultipleWindow {
	static boolean res;
	static Set<String> allw;
	public static void main(String[] args) throws InterruptedException {
		
		MultipleWindow m = new MultipleWindow();
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Aug17_Softwares\\Selenium_June18\\Browsers\\chromedriver.exe");
		
		WebDriver d = new ChromeDriver();
		
		d.get("https://www.naukri.com/");
		d.manage().window().maximize();
		String Parent=d.getWindowHandle();
		System.out.println(Parent);
		
		d.findElement(By.xpath("//button[text()='Search Walk-in Jobs']")).click();
		allw = d.getWindowHandles();
		try {
		for(String s:allw)
		{
			if(!s.equals(Parent))
			{
				d.switchTo().window(s);
				System.out.println(d.getTitle());
				d.close();
				
				/*d.findElement(By.xpath("//input[@class='sugInp']")).sendKeys("Software Testing");
				d.findElement(By.id("//button[@id='qsbFormBtn']")).click();
				res=m.isAPresent(d);
				if(res==true)
				{
					System.out.println(d.switchTo().alert().getText());
					d.switchTo().alert().dismiss();
				}*/
			}
		}
		}
		finally
		{
			//d.close();
			d.switchTo().window(Parent);
			d.findElement(By.xpath("//ul[@class='midSec menu']/li[4]")).click();
			allw=d.getWindowHandles();
			
			ArrayList <String> al = new ArrayList<>(allw);
			d.switchTo().window(al.get(1));
			System.out.println(d.getTitle());
			/*allw = d.getWindowHandles();
			for(String s:allw)
			{
				if(!s.equals(Parent))
				{
					d.switchTo().window(s);
					System.out.println(d.getTitle());
				}
			}*/
			d.close();
		}
		d.quit();
	}
	boolean isAPresent(WebDriver d)
	{
		//boolean foundelement =false;
		WebDriverWait wait = new WebDriverWait(d, 10);
		try {
		wait.until(ExpectedConditions.alertIsPresent());
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return true;
	}

}