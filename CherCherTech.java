package assignment.week4day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CherCherTech {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://chercher.tech/practice/frames-example-selenium-webdriver");
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//b[@id='topic']//following::input")).sendKeys("check frame");
		System.out.println("sent text into first frame");
		
		WebElement frame3 = driver.findElement(By.id("frame3"));
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//input[@id='a']")).click();
		System.out.println("clicked checkbox inside second frame");
		
		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		
		WebElement selectAnimals = driver.findElement(By.id("animals"));
		Select select = new Select(selectAnimals);
		select.selectByIndex(2);
		System.out.println("selected from dropdown present inside third frame");
		
		driver.switchTo().defaultContent();
	}

}
