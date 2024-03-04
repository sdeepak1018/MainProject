package testng_hackathon;

import java.awt.AWTException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Project.DriverSetUp;
import Project.Hometest;
import Project.LoanCal1;
import Project.LoanCal2;
import Project.LoanCal3;
import Project.testLogin;

public class SmokeTest {

	public static WebDriver driver;
	testLogin lp;
	Hometest ht;
	LoanCal1 lc1;
	LoanCal2 lc2;
	LoanCal3 lc3;
	static DriverSetUp d;

	@BeforeClass
	public void setup() throws InterruptedException, MalformedURLException {

		d = new DriverSetUp();
		driver = d.SelectDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://emicalculator.net/");
		Thread.sleep(5000);
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	public void car_Loan() throws IOException, AWTException, InterruptedException {
		lp = new testLogin(driver);
		lp.CarClick();
		System.out.println("Smoke testing for car loan funtionality is passed");
		System.out.println();
	}

	@Test(priority = 2)
	public void home_Loan() {
		ht = new Hometest(driver);
		ht.HomeClick();
		System.out.println("Smoke testing for loan loan funtionality is passed");
		System.out.println();
	}

	@Test(priority = 3)
	public void Loan_cal1() {
		lc1 = new LoanCal1(driver);
		lc1.LoanCalClick();
		System.out.println("Smoke testing for EMI calculator page funtionality is passed");
		System.out.println();
	}

	@Test(priority = 4)
	public void Loan_cal2() {
		lc2 = new LoanCal2(driver);
		lc2.LoanCal2Click();
		System.out.println("Smoke testing for Loan Amount calculator page funtionality is passed");
		System.out.println();
	}

	@Test(priority = 5)
	public void Loan_cal3() {
		lc3 = new LoanCal3(driver);
		lc3.LoanCal3Click();
		System.out.println("Smoke testing for Loan Tenure calculator page funtionality is passed");
	}

	@AfterClass
	public void close() {
		driver.quit();
	}

}
