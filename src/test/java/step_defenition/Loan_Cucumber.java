package step_defenition;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Project.testLogin;
import Project.Hometest;
import Project.LoanCal1;
import Project.LoanCal2;
import Project.LoanCal3;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Loan_Cucumber {
	static WebDriver driver;
	static testLogin lp;
	Hometest Hl;
	LoanCal1 lc1;
	LoanCal2 lc2;
	LoanCal3 lc3;
	int intValue;

	@Given("User selects car loan in the application")
	public void user_selects_car_loan_in_the_application() throws IOException, AWTException, InterruptedException {
		driver = hooks.driver;
		lp = new testLogin(driver);
		lp.CarClick();
		Assert.assertEquals(lp.checkHeading(), "EMI Calculator for Home Loan, Car Loan & Personal Loan in India");

	}

	@When("Users enters the values to compute the emi")
	public void users_enters_the_values_to_compute_the_emi() throws IOException, AWTException, InterruptedException {
		lp.Loan_Amount();
		lp.Loan_Interest();
		lp.Loan_Tenure();
	}

	@Then("The Emi is displayed is compared with the computed one")
	public void the_emi_is_displayed_is_compared_with_the_computed_one()
			throws IOException, AWTException, InterruptedException {
		int EMI = lp.Loan_EMI();

		int test = lp.Loan_EMI_Check();

		Assert.assertEquals(EMI, test);

	}

	@Given("The user navigates to the Home Loan page")
	public void the_user_navigates_to_the_home_loan_page() throws InterruptedException {
		Hl = new Hometest(driver);
		String home = Hl.HomeClick();
		Assert.assertEquals(home, "Home Loan EMI Calculator with Prepayments, Taxes & Insurance");
	}

	@When("The user enters the values")
	public void the_user_enters_the_values() throws IOException {

		Hl.HomeLoan_Details();
		Hl.HomeOwner_Expenses();

	}

	@When("Emi is calculated")
	public void emi_is_calculated() {
		WebElement EMI = driver.findElement(By.id("monthlyprincipalandinterestterm"));
		boolean stat = EMI.isDisplayed();
		if (stat == true) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView();", EMI);
			Assert.assertEquals(stat, true);
		}
	}

	@When("Year on year table is displayed is saved in an excel")
	public void year_on_year_table_is_displayed_is_saved_in_an_excel() throws IOException, InterruptedException {
		boolean status = Hl.ScrollDown();
		Thread.sleep(5000);
		Hl.WriteYearTable();
		Assert.assertEquals(status, true);
	}

	@Given("The user navigates to Loan page")
	public void the_user_navigates_to_loan_page() {
		lc1 = new LoanCal1(driver);
		lc1.LoanCalClick();
	}

	@Then("User do all the neccessary UI Functionality")
	public void user_do_all_the_neccessary_ui_functionality() throws InterruptedException, IOException {
		lc1.LoanAMT();
		lc1.LoanINt();
		lc1.Tenure();
		lc1.feeCharges();
		lc1.emi();
		lc1.adv();
		lc1.date();
		lc1.month();
		lc1.Dropdn();
		lc1.hover();
	}

	@Then("User selects Loan amount calculator to do all the neccessary UI Functionality")
	public void user_selects_loan_amount_calculator_to_do_all_the_neccessary_ui_functionality()
			throws InterruptedException, IOException {
		lc2 = new LoanCal2(driver);
		lc2.LoanCal2Click();
		lc2.emi();
		lc2.UI_Check2();
	}

	@Then("User selects Loan Tenure Calculator to do all the neccessary UI Functionality")
	public void user_selects_loan_tenure_calculator_to_do_all_the_neccessary_ui_functionality()
			throws InterruptedException, IOException {
		lc3 = new LoanCal3(driver);
		lc3.LoanCal3Click();
		lc3.UI_Check3();
		// driver.quit();
	}

	@Given("Car loan page is clicked")
	public void car_loan_page_is_clicked() throws IOException, AWTException, InterruptedException {
		driver = hooks.driver;
		lp = new testLogin(driver);
		lp.CarClick();
		System.out.println("Smoke testing for car loan funtionality is passed");
		System.out.println();
	}

	@Given("Home Loan page is clicked")
	public void home_loan_page_is_clicked() {
		Hl = new Hometest(driver);
		Hl.HomeClick();
		System.out.println("Smoke testing for loan loan funtionality is passed");
		System.out.println();
	}

	@Given("Emi calaculator page is clicked")
	public void emi_calaculator_page_is_clicked() {
		lc1 = new LoanCal1(driver);
		lc1.LoanCalClick();
		System.out.println("Smoke testing for EMI calculator page funtionality is passed");
		System.out.println();
	}

	@Given("Loan Amount calculator page is clicked")
	public void loan_amount_calculator_page_is_clicked() {
		lc2 = new LoanCal2(driver);
		lc2.LoanCal2Click();
		System.out.println("Smoke testing for Loan Amount calculator page funtionality is passed");
		System.out.println();
	}

	@Then("Loan Tenure calculator page is clicked")
	public void loan_tenure_calculator_page_is_clicked() {
		lc3 = new LoanCal3(driver);
		lc3.LoanCal3Click();
		System.out.println("Smoke testing for Loan Tenure calculator page funtionality is passed");
	}

}