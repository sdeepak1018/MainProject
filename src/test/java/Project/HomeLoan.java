package Project;

import java.io.IOException;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class HomeLoan extends Main {
	
//	WebDriver driver;
//	public HomeLoan() {
//		super.driver=driver;
//	}
	Hometest ht;
//	Scanner sc = new Scanner(System.in);
	
	@BeforeClass
	void setup() throws InterruptedException
	{
//		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://emicalculator.net/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
	}
	
	@Test(priority=1)
	void Home_Loan()
	{
		ht = new Hometest(driver);
		String home = ht.HomeClick();
		Assert.assertEquals(home,"Home Loan EMI Calculator with Prepayments, Taxes & Insurance");
	}
	@Test(priority=2)
	void HomeLoan_Data() throws IOException
	{
		ht.HomeLoan_Details();
		ht.HomeOwner_Expenses();
	}
	
	@Test(priority=3)
	void HomeLoan_Write() throws IOException, InterruptedException
	{
		Thread.sleep(5000);
		boolean status = ht.ScrollDown();
		ht.WriteYearTable();
		Assert.assertEquals(status,true);
		
	}

	
}
