package testng_hackathon;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.SimpleDateFormat;
import java.time.Duration;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Project.DriverSetUp;
import Project.Hometest;
import Project.LoanCal1;
import Project.LoanCal2;
import Project.LoanCal3;
import Project.testLogin;

@Listeners(testng_hackathon.ExtentedReportManager.class)
public class LoanCalculator {

	public static WebDriver driver;
	testLogin lp;
	Hometest ht;
	LoanCal1 lc;
	LoanCal2 lc2;
	LoanCal3 lc3;
	ExtentedReportManager Ex;
	static DriverSetUp d;

	@BeforeClass
	void setup() throws InterruptedException, MalformedURLException {
//		d = new DriverSetUp();
//		driver = d.SelectDriver();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://emicalculator.net/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Test(priority = 1,groups = "RegressionTest")
	void testLogo() throws IOException, AWTException, InterruptedException // Check the page loaded to correct or not
	{
		lp = new testLogin(driver);
		String title = lp.checkHeading();
		Assert.assertEquals(title, "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");
	}

	@Test(priority = 2,groups = {"SmokeTest", "RegressionTest"})
	void Car_Loan() throws IOException, AWTException, InterruptedException // Enter values into the CarLoan Field
	{
		Thread.sleep(5000);
		lp.CarClick();
		lp.Loan_Amount();
		lp.Loan_Interest();
		lp.Loan_Tenure();

	}

	@Test(priority = 3,groups = "RegressionTest")
	void EMI_Calculation() throws IOException, AWTException, InterruptedException // Calculate The Monthly EMI
	{
		int EMI = lp.Loan_EMI();

		int test = lp.Loan_EMI_Check();

		Assert.assertEquals(EMI, test); // Compare the EMI in website and The Calculated EMI
	}

	@Test(priority = 4,groups = {"SmokeTest", "RegressionTest"})
	void Home_Loan() // Check the page loaded to correct or not
	{
		ht = new Hometest(driver);
		String home = ht.HomeClick();
		Assert.assertEquals(home, "Home Loan EMI Calculator with Prepayments, Taxes & Insurance");
	}

	@Test(priority = 5,groups = "RegressionTest")
	void HomeLoan_Data() throws IOException {
		ht.HomeLoan_Details();
		ht.HomeOwner_Expenses();

	}

	@Test(priority = 6,groups = "RegressionTest")
	void HomeLoan_Write() throws IOException, InterruptedException {
		boolean status = ht.ScrollDown();
		Thread.sleep(5000);
		ht.WriteYearTable();
		Assert.assertEquals(status, true);
	}

	@Test(priority = 7,groups = {"SmokeTest", "RegressionTest"})
	public void Test1() throws InterruptedException, AWTException, IOException {
		lc = new LoanCal1(driver);
		lc.LoanCalClick();
		lc.LoanAMT();
		lc.LoanINt();
		lc.Tenure();
		lc.yearTomonth();
//		if(value != 3 )
//		{
//		Assert.assertEquals(true, true);
//		}
	}
	
	@Test(priority = 8,groups = "RegressionTest")
	public void Test12() throws InterruptedException, AWTException {
		lc.emi();
		lc.adv();
		lc.date();
		lc.month();
		lc.Dropdn();
		lc.hover();

	}

	@Test(priority = 8,groups = {"SmokeTest", "RegressionTest"})
	public void Test2() throws InterruptedException, IOException {
		lc2 = new LoanCal2(driver);
		lc2.LoanCal2Click();
		lc2.emi();
		lc2.UI_Check2();
	}

	@Test(priority = 9,groups = {"SmokeTest", "RegressionTest"})
	public void Test3() throws InterruptedException, IOException {
		lc3 = new LoanCal3(driver);
		lc3.LoanCal3Click();
		lc3.UI_Check3();
	}

	@AfterClass
	public void close() {
		Ex = new ExtentedReportManager();
		Ex.openreport();
		driver.quit();
	}

}
