package com.wordpress.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class WordpressLoginPage {

	WebDriver driver;
	By uname = By.id("user_login");
	By pwd = By.id("user_pass");
	By LoginButton = By.id("wp-submit");
	
	By Logout1 = By.xpath("//*[@id='wp-admin-bar-my-account']/a");
	By LogoutText= By.xpath("//li/a[text()='Log Out']");
	
	public WordpressLoginPage(WebDriver driver) {
	
		this.driver = driver;
	}
	
	public void LoginWordpress(String un, String pw)
	{
		driver.findElement(uname).sendKeys(un);
		driver.findElement(pwd).sendKeys(pw);
		driver.findElement(LoginButton).click();
	}
	
	public void LogoutWordpress() throws InterruptedException
	{
		Actions a = new Actions(driver);
		Thread.sleep(2000);
		a.moveToElement(driver.findElement(Logout1)).click(driver.findElement(LogoutText)).build().perform();
	}
}
