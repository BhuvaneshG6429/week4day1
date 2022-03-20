package assignment.week4day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AlertLeafground {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("http://www.leafground.com/pages/Alert.html");
		//maximize window
		driver.manage().window().maximize();
		
		//AlertBox
		WebElement element = driver.findElement(By.xpath("//button[text()='Alert Box']"));
		element.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		//ConfirmBox
		WebElement element1 = driver.findElement(By.xpath("//button[text()='Confirm Box']"));
		element1.click();
		alert.accept();
		
		element1.click();
		alert.dismiss();
		
		
		//PromptBox
		WebElement element2 = driver.findElement(By.xpath("//button[text()='Prompt Box']"));
		element2.click();
		alert.sendKeys("Test Leaf");
		System.out.println("Txt in prompt box : "+alert.getText());
		alert.accept();
		
		//Line Breaks?
		WebElement element3 = driver.findElement(By.xpath("//button[text()='Line Breaks?']"));
		element3.click();
		System.out.println("Txt in the line break :"+alert.getText());
		alert.accept();
		
		//Sweet Alert
		WebElement element4 = driver.findElement(By.xpath("//button[text()='Sweet Alert']"));
		element4.click();
		
		System.out.println("Txt in the sweet alert : "+driver.findElement(By.className("swal-text")).getText());
		driver.findElement(By.xpath("//button[text()='OK']")).click();
	}

}
