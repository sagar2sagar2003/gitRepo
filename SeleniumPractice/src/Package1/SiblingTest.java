package Package1;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiblingTest {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Aug17_Softwares\\Selenium_June18\\Browsers\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		d.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		d.get("http://demo.guru99.com/test/guru99home/");
		d.manage().window().maximize();
		
		List<WebElement> wl = d.findElements(By.xpath("//h2[contains(text(),'A few of our most popular courses')]/parent::div//div[//a[text()='SELENIUM']]/following-sibling::div[*]"));
				//(By.xpath("//h2[contains(text(),'A few of our most popular courses')]/following-sibling::div"));
		
		for(WebElement w:wl)
		{
			System.out.println(w.getText());
		}
		
		
		
	}

}
