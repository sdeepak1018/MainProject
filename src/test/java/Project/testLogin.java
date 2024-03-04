package Project;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class testLogin {
	
public WebDriver driver;

ExcelScript Ex = new ExcelScript();
	
	//Constructor
	public testLogin(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//	WebElement Locators+identification
	
	@FindBy(tagName="h1")
	WebElement 	Heading_check;
	
	@FindBy(id="car-loan")
	WebElement car_menu;
	
	@FindBy(id="loanamount")
	WebElement LoanAmount;
	
	@FindBy(id="loaninterest")
	WebElement LoanInterest;
	
	@FindBy(id="loanterm")
	WebElement LoanTenure;
	
	@FindBy(xpath="//*[@id=\"emicalculatorinnerform\"]/div[7]/div/div/div/div")
	WebElement LoanTermyear;
	
	@FindBy(xpath="//*[@id=\"emiamount\"]/p/span")
	WebElement LoanEMI;
	
	@FindBy(xpath="/html/body")
	WebElement CarScr;
	
	@FindBy(xpath="//*[@id=\"emiamount\"]/h4")
	WebElement ScrollDown;
	
	
// Action Methods
	
	public String checkHeading() throws IOException, AWTException, InterruptedException
	{
		String heading=Heading_check.getText();
		return heading;
		
	}
	
	public void CarClick() throws IOException, AWTException, InterruptedException
	{
		car_menu.click();
	}
	
	public void Loan_Amount() throws IOException, AWTException, InterruptedException
	{
		
		LoanAmount.sendKeys(Keys.CONTROL + "a");
		LoanAmount.sendKeys(Ex.CarLone(0));
	}
	public void Loan_Interest() throws IOException, AWTException, InterruptedException
	{
		
		LoanInterest.sendKeys(Keys.CONTROL + "a");
		LoanInterest.sendKeys(Ex.CarLone(1));
	}
	
	public void Loan_Tenure() throws IOException, AWTException, InterruptedException
	{
		
		LoanTenure.sendKeys(Keys.CONTROL + "a");
		LoanTenure.sendKeys(Ex.CarLone(2));
		LoanTermyear.click();
	}
	
	public int Loan_EMI() throws IOException, AWTException, InterruptedException
	{
		
		String EMI = LoanEMI.getText();
		System.out.println(EMI);
		// Remove commas from the string
		EMI = EMI.replace(",", "");

		// Convert the modified string into an integer
		int intValue = Integer.parseInt(EMI);

		System.out.println("The Loan EMI "+intValue);
		
		return intValue;
		
	}
	public int Loan_EMI_Check()
	{
		
		// Calculation for finding the monthly Principle amount and Interest amount
		
		
		double e, principle_amount;
		double rate_of_interest;
		int tenture_in_month;
		
		principle_amount = 1500000;
		
		rate_of_interest = (9.5/12)/100;
		
		tenture_in_month = 12;
		
		e = principle_amount * rate_of_interest;
		
		
		Math.pow(2, 3);
		
		e = e * Math.pow(1+rate_of_interest, tenture_in_month);
		
		e = e/(Math.pow(1+rate_of_interest, tenture_in_month)-1);
		
		int test = (int)e;
		
		System.out.println("Monthly EMI to be paid "+test);
		
		double Month_Interest =  e*(rate_of_interest);
		
		System.out.println("Monthly interest to be paid "+Month_Interest);
		
		double Month_principle = e - Month_Interest ;
		
		System.out.println("Monthly interest to be paid "+Month_principle);
		
		return test;
	}
	
	public void Scroll_Down()
	{
		 boolean stat=ScrollDown.isDisplayed();
		    if(stat==true) {
		    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    	js.executeScript("arguments[0].scrollIntoView();", ScrollDown);
		    }
		
		
	}

}
