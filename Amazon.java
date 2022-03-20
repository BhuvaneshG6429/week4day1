package assignment.week4day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {

	public static void main(String[] args) {
		
//			1.Load the uRL https://www.amazon.in/
			WebDriverManager.chromedriver().setup();
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://www.amazon.in/");
			driver.manage().window().maximize();
			
			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
//			2.search as oneplus 9 pro 
			String phoneSearch = "OnePlus 9 Pro";
			driver.findElement(By.xpath("(//form[@id='nav-search-bar-form']//child::input)[1]")).sendKeys(phoneSearch);
			driver.findElement(By.xpath("(//form[@id='nav-search-bar-form']//child::input)[2]")).click();
//			3.Get the price of the first product
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='RESULTS']")));
			String priceWholeFirstProduct = driver.findElement(By.xpath("(//div//h2//span[contains(text(),'OnePlus 9 Pro')])[1]//following::span[@class='a-price-whole']")).getText();
			String symbolFirstProduct = driver.findElement(By.xpath("(//div//h2//span[contains(text(),'OnePlus 9 Pro')])[1]//following::span[@class='a-price-symbol']")).getText();
			String firstProductPrice = symbolFirstProduct+priceWholeFirstProduct;
			System.out.println("price of the first listed product is "+firstProductPrice);
//			4. Print the number of customer ratings for the first displayed product
			String ratingFirstProduct = driver.findElement(By.xpath("((//div//h2//span[contains(text(),'"+phoneSearch+"')])[1]//following::span/a/span)[1]")).getText();
			System.out.println("number of ratings for the first listed product is "+ratingFirstProduct);
//			5. click on the stars
			driver.findElement(By.xpath("((//div//h2//span[contains(text(),'"+phoneSearch+"')])[1]//following::a)[1]")).click();
//			6. Get the percentage of ratings for the 5 star.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='a-popover-content']")));
			String fiveStarPercentage = driver.findElement(By.xpath("//table[@id='histogramTable']/tbody/tr[1]/td[3]/span[2]/a")).getText();
			System.out.println("percentage of five stars for the first listed product is "+fiveStarPercentage);
//			7. Click the first text link of the first image
			driver.findElement(By.xpath("(//div//h2//span[contains(text(),'"+phoneSearch+"')])[1]")).click();
//			8. Click 'Add to Cart' button
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> list = new ArrayList<String>(windowHandles);
			driver.switchTo().window(list.get(1));
			driver.findElement(By.id("add-to-cart-button")).click();
//			9. Get the cart subtotal and verify if it is correct.
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@id='attach-accessory-pane']//span[contains(text(),'Added to Cart')])[1]")));
			String cartSubTotal = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
			String finalCartTotal = cartSubTotal.replaceAll("[.0]+$", "");
			Assert.assertEquals(finalCartTotal, firstProductPrice);
	}
	

}
	