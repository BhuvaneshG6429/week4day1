package assignment.week4day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundFrames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//open url
				WebDriverManager.chromedriver().setup();
				ChromeDriver driver = new ChromeDriver();
				driver.get("http://www.leafground.com/pages/frame.html");
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
				
				List<WebElement> allFrames = driver.findElements(By.tagName("iframe"));
				
				int count=0;
				int totalFrames=0;
				for(int i=0;i<allFrames.size();i++) {
					driver.switchTo().frame(i);
					List<WebElement> nestedFrames = driver.findElements(By.tagName("iframe"));
					count+=nestedFrames.size();
					driver.switchTo().defaultContent();
					
				}
				
				totalFrames=allFrames.size()+count;
				System.out.println("total frames in the page : "+totalFrames);
				
	}

}
