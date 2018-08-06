package com.wordpress.testcases;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.wordpress.pages.LoginPageFactory;
import com.wordpress.pages.WordpressLoginPage;

import Configuration_pack.Readconfig;
import ExcelOperations.ExcelExample;
import Utility.ReuseMethods;

public class VerifyWPLogin {
	
	public static WebDriver driver;
	public static String url, chromePath;
	//public static WordpressLoginPage wpPageObj;
	static ReuseMethods ReuseVar =new ReuseMethods();
	
	@BeforeMethod
	public void DriverInit() throws Exception
	{
		Readconfig rconfig = new Readconfig();
		url=rconfig.getURL();
		chromePath = rconfig.getChromepath();
		System.out.println("Execute Before Test");
		driver = ReuseVar.AppLaunchAndMax("Chrome",url, chromePath);
		
	}
	
	
	@Test
	public void wpLogin() throws InterruptedException, IOException
	{
		//driver = new ReuseMethods().AppLaunchAndMax("Chrome","http://demosite.center/wordpress/wp-login.php");
		WordpressLoginPage wpPageObj = new WordpressLoginPage(driver);
		wpPageObj.LoginWordpress("admin", "demo123");
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		ReuseVar.capScreen("Sucess");
		wpPageObj.LogoutWordpress();
		Thread.sleep(2000);
		System.out.println(driver.getTitle());
		
	}
	
	@Test(dataProvider="pagefactData")
	public void loginPageFact(String uname, String pswd) throws InterruptedException, IOException
	{
		LoginPageFactory newObj = PageFactory.initElements(driver, LoginPageFactory.class);		
		newObj.LoginwithPageFact(uname, pswd);
		ReuseVar.capScreen("DataDriven");
		Thread.sleep(3000);
	}
	
	
	
	@AfterMethod
	public void CloseDriver()
	{
		driver.close();	
	}
	
	@DataProvider(name="pagefactData")
	public Object[][] passData() throws Exception
	{
		
		ExcelExample xlobj = new ExcelExample("./src/ExcelOperations/Registration.xlsx");
		int rc = xlobj.getRowcount(0);
		int cc = xlobj.getColcount(0);
		
		Object[][] data = new Object[rc][cc];
		for (int i=0; i<rc;i++)
		{
			for(int j=0; j<cc; j++)
			{
				data[i][j] = xlobj.getXldata(0, i, j);
			}
		}
		return data;
	}
	
}