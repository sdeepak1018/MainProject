package Project;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ExcelScript {
	
	
	
	public String HomeLone(int a) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\2303965\\eclipse-workspace\\Hackathon_Project\\dataset\\HoneLoan_Data.xlsx") ;
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		
		XSSFRow currentRow = sheet.getRow(1);
		String Amount = currentRow.getCell(a).toString();
		workbook.close();
		file.close();
		return Amount;
		
	}
	
	public void HomeLone_write(WebElement LoanTable) throws IOException {
		
		FileOutputStream file = new FileOutputStream("C:\\Users\\2303965\\eclipse-workspace\\Hackathon_Project\\dataset\\HomeLoanwrite_Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("sheet2");
		XSSFRow rowHead = sheet.createRow(0);
		
		// Table Heading
		rowHead.createCell(0).setCellValue("year");
		rowHead.createCell(1).setCellValue("principle");
		rowHead.createCell(2).setCellValue("Interest");
		rowHead.createCell(3).setCellValue("Taxes");
		rowHead.createCell(4).setCellValue("Total_Payment");
		rowHead.createCell(5).setCellValue("Balance");
		rowHead.createCell(6).setCellValue("Loan_Paid");
		
		
		int table_row = LoanTable.findElements(By.xpath("tr")).size();
		for(int r=2;r<=table_row;r+=2)
		{
			String year = LoanTable.findElement(By.xpath("tr["+r+"]/td[1]")).getText();
			String principle = LoanTable.findElement(By.xpath("tr["+r+"]/td[2]")).getText();
			String Interest = LoanTable.findElement(By.xpath("tr["+r+"]/td[3]")).getText();
			String Taxes = LoanTable.findElement(By.xpath("tr["+r+"]/td[4]")).getText();
			String Total_Payment = LoanTable.findElement(By.xpath("tr["+r+"]/td[5]")).getText();
			String Balance = LoanTable.findElement(By.xpath("tr["+r+"]/td[6]")).getText();
			String Loan_Paid = LoanTable.findElement(By.xpath("tr["+r+"]/td[7]")).getText();
			
			
			XSSFRow row = sheet.createRow(r);
			row.createCell(0).setCellValue(year);
			row.createCell(1).setCellValue(principle);
			row.createCell(2).setCellValue(Interest);
			row.createCell(3).setCellValue(Taxes);
			row.createCell(4).setCellValue(Total_Payment);
			row.createCell(5).setCellValue(Balance);
			row.createCell(6).setCellValue(Loan_Paid);
		}
		workbook.write(file);
		workbook.close();
		file.close();
	}
	

	public String CarLone(int a) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\2303965\\eclipse-workspace\\Hackathon_Project\\dataset\\carLone.xlsx") ;
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet1");
		
		XSSFRow currentRow = sheet.getRow(1);
		String Amount = currentRow.getCell(a).toString();
		workbook.close();
		file.close();
		return Amount;
		
	}
	public String Loancal(int a) throws IOException
	{
		FileInputStream file = new FileInputStream("C:\\Users\\2303965\\eclipse-workspace\\Hackathon_Project\\dataset\\HoneLoan_Data.xlsx") ;
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("sheet2");
		
		XSSFRow currentRow = sheet.getRow(1);
		String Amount = currentRow.getCell(a).toString();
		workbook.close();
		file.close();
		return Amount;
		
	}
	
}
