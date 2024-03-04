package Project;

import java.awt.AWTException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class CarLoan {
	
	WebDriver driver;
	testLogin lp;
	
	@BeforeClass
	void setup() throws InterruptedException
	{
//		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://emicalculator.net/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
		
	}
	@Test(priority=1)
	void testLogo() throws IOException, AWTException, InterruptedException
	{
		lp=new testLogin(driver);
		Assert.assertEquals(lp.checkHeading(), "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");
	}
	
	@Test(priority=2)
	void Car_Loan() throws IOException, AWTException, InterruptedException
	{
		lp.CarClick();
		lp.Loan_Amount();
		lp.Loan_Interest();
		lp.Loan_Tenure();
		lp.Scroll_Down();
	}
	@Test(priority=3)
	void EMI_Calculation() throws IOException, AWTException, InterruptedException
	{
		int EMI=lp.Loan_EMI();
		
		int test =lp.Loan_EMI_Check();
		
		Assert.assertEquals(EMI,test);
		
		
		
	}
	
	

}
