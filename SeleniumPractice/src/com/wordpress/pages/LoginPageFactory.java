package com.wordpress.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPageFactory {
	
	WebDriver driver;
	
	@FindBy(how=How.ID,using ="user_login") WebElement usname;
	@FindBy(how=How.ID,using="user_pass") WebElement Paswd;
	@FindBy(how=How.ID,using="wp-submit") WebElement LoginButton;
	
	public LoginPageFactory(WebDriver driver) {
	
		this.driver=driver;
	}

	
	public void LoginwithPageFact(String usn, String psw)
	{
		usname.sendKeys(usn);
		Paswd.sendKeys(psw);
		LoginButton.click();
	}
	
}
