package assignment.week4day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Irctc {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
//			1. Load https://www.irctc.co.in/
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.get("https://www.irctc.co.in/");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
//			2. Click on OK button in the dialog
				driver.findElement(By.xpath("//span[text()='Alert']/following::button[text()='OK']")).click();
				
//			3. Click on FLIGHTS link   
				driver.findElement(By.xpath("//a[contains(text(),'FLIGHTS')]")).click();
//			4. Go to the Flights tab
				Set<String> windowHandles = driver.getWindowHandles();
				List<String> list = new ArrayList<String>(windowHandles);
				driver.switchTo().window(list.get(1));
				
				driver.findElement(By.xpath("//button[text()='Later']")).click();
				
//			5. Print the customer care email id
				driver.findElement(By.xpath("//a[text()='Contact Us']")).click();
				String custEmail = driver.findElement(By.xpath("//a[text()='Contact Us']//following::a[3]")).getText();
				System.out.println("Customer Care mail address : "+custEmail);
//			6. Close the First tab(Train ticket booking) alone
				
				driver.switchTo().window(list.get(0));
				driver.close();
		
		
		
	}

}
