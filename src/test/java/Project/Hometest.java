package Project;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class Hometest {
	
public WebDriver driver;
ExcelScript Ex = new ExcelScript();
	
	//Constructor
	public Hometest(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
//	WebElement Locators+identification
	
	@FindBy(xpath="//*[@id=\"menu-item-dropdown-2696\"]")
	WebElement menu_dropDown;
	
	@FindBy(className="dropdown-item")
	WebElement Home_menu;
	
	@FindBy(tagName="h1")
	WebElement Home_Comfirm;
	
	@FindBy(id="homeprice")
	WebElement LoanAmount;
	
	@FindBy(id="downpayment")
	WebElement downpayment;
	
	@FindBy(id="homeloaninsuranceamount")
	WebElement homeloaninsuranceamount;
	
	@FindBy(id="homeloanamount")
	WebElement homeloanamount;
	
	@FindBy(id="homeloaninterest")
	WebElement homeloaninterest;
	
	@FindBy(id="homeloanterm")
	WebElement homeloanterm;
	
	@FindBy(id="loanfees")
	WebElement loanfees;
	
	@FindBy(id="onetimeexpenses")
	WebElement onetimeexpenses;
	
	@FindBy(id="propertytaxes")
	WebElement propertytaxes;
	
	@FindBy(id="homeinsurance")
	WebElement homeinsurance;
	
	@FindBy(id="maintenanceexpenses")
	WebElement maintenanceexpenses;
	
	@FindBy(xpath="//*[@id=\"paymentschedule\"]/table/tbody")
	WebElement LoanTable;
	
	
//	@FindBy(xpath="//*[@id=\"monthyear2024\"]/td/div/table/tbody")
//	WebElement LoanTableYear;
	
	
	
	
// Action Methods
	
	public String HomeClick()
	{
		menu_dropDown.click();
		Home_menu.click();
		String home = Home_Comfirm.getText();
		return home;
		
	}
	
	public void HomeLoan_Details() throws IOException
	{
		LoanAmount.sendKeys(Keys.CONTROL + "a");
		LoanAmount.sendKeys(Ex.HomeLone(0));
		
		downpayment.sendKeys(Keys.CONTROL + "a");
		downpayment.sendKeys(Ex.HomeLone(1));
		
		homeloaninsuranceamount.sendKeys(Keys.CONTROL + "a");
		homeloaninsuranceamount.sendKeys(Ex.HomeLone(2));
		
		homeloaninterest.sendKeys(Keys.CONTROL + "a");
		homeloaninterest.sendKeys(Ex.HomeLone(4));
		
		homeloanterm.sendKeys(Keys.CONTROL + "a");
		homeloanterm.sendKeys(Ex.HomeLone(5));
		
		loanfees.sendKeys(Keys.CONTROL + "a");
		loanfees.sendKeys(Ex.HomeLone(6));
		
		
		
	}
	public void HomeOwner_Expenses() throws IOException
	{
		onetimeexpenses.sendKeys(Keys.CONTROL + "a");
		onetimeexpenses.sendKeys(Ex.HomeLone(7));
		
		propertytaxes.sendKeys(Keys.CONTROL + "a");
		propertytaxes.sendKeys(Ex.HomeLone(8));
		
		homeinsurance.sendKeys(Keys.CONTROL + "a");
		homeinsurance.sendKeys(Ex.HomeLone(9));
		
		maintenanceexpenses.sendKeys(Keys.CONTROL + "a");
		maintenanceexpenses.sendKeys(Ex.HomeLone(10));
		
	}
	public boolean ScrollDown() throws IOException
	{
			
		boolean status = LoanTable.isDisplayed();
		if(status==true) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
    	js.executeScript("arguments[0].scrollIntoView();", LoanTable);
		}
		
		return status;
		
	}
	public void WriteYearTable() throws IOException
	{
			
		Ex.HomeLone_write(LoanTable);
		
	}
	
	
	
	
	

}
