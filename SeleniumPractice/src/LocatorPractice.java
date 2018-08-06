import java.util.List;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

public class LocatorPractice extends Test {

public static void main(String[] args) throws InterruptedException
{
	t = new ReusableMethods();
	driver = t.getDriver("Chrome");
	driver.manage().window().maximize();
	
	//Drop Down Examples
	driver.get("https://www.telugumatrimony.com/register/registerform.php");
	
	Select Mpf = new Select(driver.findElement(By.xpath("//div[@class='select-arw'][1]/select")));
	Mpf.selectByValue("9");
	Mpf.selectByVisibleText("Brother");
	List<WebElement> Mli = Mpf.getOptions();
	
	for (WebElement i : Mli)
	{
		System.out.println(i.getText());
	}
	Thread.sleep(3000);
	
	driver.close();
	
	
	
	
	
}

}