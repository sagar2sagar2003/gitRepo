//This example click on Frame, it open a new window and then close new window

package Package1;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.*;

public class FramesExample {

	public static void main(String[] args)
	{
		
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Aug17_Softwares\\Selenium_June18\\Browsers\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.get("http://demo.guru99.com/test/guru99home/");
		d.manage().window().maximize();
		
		/*String parentWin = d.getWindowHandle();
		System.out.println(parentWin);
		
		int fi =d.findElements(By.tagName("iFrame")).size();
		System.out.println(fi);
		
		d.switchTo().frame("a077aa5e");
		d.findElement(By.xpath("//img[contains(@src,'Jmeter720')]")).click();
		Set<String> wl = d.getWindowHandles();
		for(String e:wl)
		{
			if(!e.equals(parentWin))
			{
				System.out.println(e);
				d.switchTo().window(e);
				System.out.println("New Window Closed");
				d.close();
			}
		}
		d.switchTo().window(parentWin);
		System.out.println("Back to Parent");*/
		
		
		d.close();
	 }
}