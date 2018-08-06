package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousehover  {

	static WebElement ele1, ele2, ele3;
	static By uname = By.id("user_login");
	static By pwd = By.id("user_pass");
	static By LoginButton = By.id("wp-submit");
	
	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "D:\\Selenium_Aug17_Softwares\\Selenium_June18\\Browsers\\chromedriver.exe");
		WebDriver d=new ChromeDriver();
		
		//d.get("http://www.shop.thetestingworld.com/"); //Keyboard actions
		//d.get("http://www.spicejet.com/"); //Mouse action
		
		d.get("http://demosite.center/wordpress/wp-login.php");
		
		d.manage().window().maximize();
		
		d.findElement(uname).sendKeys("admin");
		d.findElement(pwd).sendKeys("demo123");
		d.findElement(LoginButton).click();
		
		Actions ac=new Actions(d);
		
		ac.moveToElement(d.findElement(By.xpath("//*[@id='wp-admin-bar-my-account']/a"))).pause(500).click(d.findElement(By.xpath("//li/a[text()='Log Out']"))).build().perform();
		
		//Mouse Actions
		/*
		ele1 = d.findElement(By.xpath("//li[@class='li-login float-right']"));
		ele2 = d.findElement(By.xpath("//li[2]/a[contains(text(),'SpiceCash/SpiceClub Members')]"));
		ele3 = d.findElement(By.xpath("//li/a[contains(text(),'Sign up')]"));
		ac.moveToElement(ele1).pause(1000).moveToElement(ele2).pause(1000).click(ele3).build().perform();
		
		Thread.sleep(3000);
		d.close();*/
		
		//ac.moveToElement(d.findElement(By.xpath("//*[@id='header-addons']/a[text()='Add-Ons']"))).perform();
				
		/*List<WebElement> AddOnLinks = d.findElements(By.xpath("//*[@id='header-addons']//li/a"));
		
		for(WebElement w:AddOnLinks)
		{
			String AddOnText = w.getAttribute("innerHTML");
			if(AddOnText.equalsIgnoreCase("Friends and family"))
			{
				w.click();
			}
		}*/
		
		//Keyboard actions
		/*ele1 = d.findElement(By.name("search"));
		ele1.sendKeys("Iphone");
		ac.sendKeys(Keys.ENTER).perform();
		*/
		

	}

}
