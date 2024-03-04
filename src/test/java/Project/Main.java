package Project;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class Main {
public static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("1.chrome\n2.edge");
		int choose = sc.nextInt();
		switch(choose) {
		
		case 1: 
				driver=new ChromeDriver();
				break;
		case 2: 
				driver = new EdgeDriver();
				break;
		}
		
		
		CarLoan ac = new CarLoan();
		ac.setup();

	}

	
}
