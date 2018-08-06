package TestNGTutorial;

import org.testng.annotations.Test;

public class TestNGTest1 {
	
	@Test(priority=2)
	void method1()
	{
		System.out.println("My First Test in TestNG");
	}
	
	@Test(priority=1)
	void method2()
	{
		System.out.println("Method 2");
	}

	@Test(priority=3)
	void method3()
	{
		System.out.println("Method 3");
	}
	@Test(priority=3)
	void method4()
	{
		System.out.println("Method 4");
	}
}
