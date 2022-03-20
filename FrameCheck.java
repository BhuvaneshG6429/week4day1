package assignment.week4day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FrameCheck {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		//open url
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		//maximize window
		driver.manage().window().maximize();
		
		WebElement frame = driver.findElement(By.id("iframeResult"));
		
		driver.switchTo().frame(frame);
		
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		
		Alert alert = driver.switchTo().alert();
		alert.accept();
		//alert.dismiss();
		
		WebElement text = driver.findElement(By.xpath("//p[@id='demo']"));
		String text2 = text.getText();
		if(text2.contains("OK")) {
			System.out.println("alert was accepted");
		}
		
		else {
			System.out.println("alert was dismissed");
		}		

	}

}
