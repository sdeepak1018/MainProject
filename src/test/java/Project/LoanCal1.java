package Project;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class LoanCal1 {
	
	WebDriver driver;
	static String EMI;
	static String a;
	ExcelScript Ex = new ExcelScript();
 
// Constructor
	public LoanCal1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
//Locators
	
	
	
	@FindBy(xpath="//*[@id=\"menu-item-dropdown-2696\"]")
	WebElement CalClick;
	
	@FindBy(xpath="//*[@id=\"menu-item-2423\"]")
	WebElement LoanCalClick;
	
	@FindBy(id="loanamount")
	static WebElement LoanAmt;
	
	@FindBy(xpath="//*[@id=\"loanamountslider\"]/span")
	static WebElement LoanAmtSlide;
	
	@FindBy(id="loaninterest")
	static WebElement loanIntrst;
	
	@FindBy(xpath="//*[@id=\"loaninterestslider\"]/span")
	static WebElement loanIntrstSlide;
	
	@FindBy	(id="loanterm")
	static WebElement loanTerm;
	
	@FindBy(xpath="//*[@id=\"loantermslider\"]/span")
	static WebElement loanTermSlide;
	
	@FindBy(xpath ="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[1]")
	static WebElement termMnth;
	
	@FindBy(id="loanfees")
	static WebElement Fee;
	
	@FindBy(xpath="//*[@id=\"loanfeesslider\"]/span")
	static WebElement FeeSlide;
	
	@FindBy(xpath="//*[@id=\"loansummary-emi\"]/p/span")
	WebElement emi;
	
	@FindBy(xpath="//*[@id=\"leschemewrapper\"]/div/div/div/div/label[1]")
	static WebElement adv;
	
	@FindBy(className = "highcharts-point")
	static List<WebElement> hover;
	
	@FindBy(id="startmonthyear")
	static WebElement date;
	
	@FindBy(xpath="//tr//td//span[@class='month'][4]")
	static WebElement month;
	
	@FindBy(id="yearformat")
	static WebElement dropdown; //financialyear
	
	@FindBy(xpath="//*[@id=\"ecalprintandshare\"]/a[1]")
	static WebElement print;
	
	@FindBy(xpath="//*[@id=\"sidebar\"]//print-preview-button-strip//div/cr-button[2]")
	static WebElement close;
	
	@FindBy(xpath="//*[@id='ecalprintandshare']/a[2]")
	static WebElement share;
	
	@FindBy(xpath="/html/head/title")
	static WebElement title;
	
	@FindBy(xpath="//*[@id=\"ltermwrapper\"]/div[1]/div/div/div/div/div/label[2]")
	static WebElement monthChange;
	
//Action method
	
	public void LoanCalClick() {
		CalClick.click();
		LoanCalClick.click();
	}
	public void LoanAMT() throws InterruptedException, IOException {
		
		Thread.sleep(3000);
		LoanAmt.sendKeys(Keys.CONTROL + "a");
		LoanAmt.sendKeys(Ex.Loancal(0));
		//To move the slider
		Thread.sleep(3000);
		Actions move1 = new Actions(driver);
		Action action1 = (Action) move1.dragAndDropBy(LoanAmtSlide, 50, 0).build();
	    action1.perform();
	}
	public void LoanINt() throws InterruptedException, IOException {
		
		loanIntrst.sendKeys(Keys.CONTROL + "a");
		loanIntrst.sendKeys(Ex.Loancal(1));
		//To move the slider
		Thread.sleep(3000);
		Actions move2 = new Actions(driver);
		Action action2 = (Action) move2.dragAndDropBy(loanIntrstSlide, 50, 0).build();
	    action2.perform();
	}
	public void Tenure() throws InterruptedException, IOException {
		
		loanTerm.sendKeys(Keys.CONTROL + "a");
		loanTerm.sendKeys(Ex.Loancal(2));
		
		//To move the slider
		Thread.sleep(3000);
		Actions move3 = new Actions(driver);
		Action action3 = (Action) move3.dragAndDropBy(loanTermSlide, 60, 0).build();
	    action3.perform();
	}
	public void feeCharges() throws InterruptedException, IOException {
		
		Fee.sendKeys(Keys.CONTROL + "a");
		Fee.sendKeys(Ex.Loancal(3));
		//To move the slider
		Thread.sleep(3000);
		Actions move4 = new Actions(driver);
		Action action4 = (Action) move4.dragAndDropBy(FeeSlide, 60, 0).build();
	    action4.perform();
	}
	public void emi() {
		
		EMI=emi.getText();
	}
	public void adv() {
		adv.click();
	}
	public void date() {
		date.click();
	}
	public void month() {
		month.click();
	}
	public void Dropdn() {
		Select s=new Select(dropdown);
	    s.selectByIndex(1);
	}
	public void hover() {
		Actions Hover = new Actions(driver);
	    for(WebElement i:hover) {
	    	Hover.moveToElement(i).perform();
	    }
	}
	public void yearTomonth() throws InterruptedException {
		String b=loanTerm.getAttribute("value");
		monthChange.click();
		Thread.sleep(5000);
		String c =loanTerm.getAttribute("value");
        System.out.println("The change is "+b+" to "+c);
//        int val1 = Integer.parseInt(b);
//        int val2 = Integer.parseInt(c);
//        return val2;
	}

}
