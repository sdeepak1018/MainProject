package Project;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverSetUp {

	public WebDriver SelectDriver() throws MalformedURLException {
		WebDriver d = null;
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the browser to execute \n1.Chrome\n2.Edge");
		int a=sc.nextInt();
		switch(a){
			case 1: d=new ChromeDriver();
			        break;
			case 2: d=new EdgeDriver();
	                break;
	        default: System.out.println("Wrong choice\n");         
		}
//		DesiredCapabilities capability = new DesiredCapabilities();
//		capability.setBrowserName("MicrosoftEdge");
//		WebDriver d = new RemoteWebDriver(new URL("http://10.229.14.141:4444"),capability);
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		d.get("https://emicalculator.net/");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		return d;
}
}

//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.Scanner;
// 
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
// 
//public class DriverSetUp {
// 
////	String huburl = "http://192.168.138.131:4444/";
// 
//	public WebDriver SelectDriver() throws MalformedURLException {
//		WebDriver d = new ChromeDriver();
////		Scanner sc = new Scanner(System.in);
////		System.out.println("Enter \n1 for remote webdriver\n2 for local webdriver");
////		int x = sc.nextInt();
////		if (x == 1) {
////			DesiredCapabilities ds = new DesiredCapabilities();
//			//ds.setCapability("browserName", "chrome");
////			ds.setBrowserName("chrome");
////			ds.setBrowserName("MicrosoftEdge");
//// 
////			d = new RemoteWebDriver(new URL(huburl), ds);
////		} else if (x == 2) {
////			System.out.println("Enter the browser to execute \n1.Chrome\n2.Edge");
////			int a = sc.nextInt();
////			switch (a) {
////			case 1:
////				d = new ChromeDriver();
////				break;
////			case 2:
////				d = new EdgeDriver();
////				break;
////			default:
////				System.out.println("Wrong choice\n");
////			}
////		}
//		return d;
//	}
 
//}
