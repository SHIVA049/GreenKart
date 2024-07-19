package HTC.GreenKart;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GKStandAlone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] productName = {"Carrot","Tomato","Beans","Brocolli"};
		WebDriverManager.chromedriver().setup();
		
		ChromeDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();
		
		List<WebElement> cartItems = driver.findElements(By.cssSelector(".product"));
		
		for(String i : productName) {
		/*WebElement item=cartItems.stream().filter(p->
		p.findElement(By.cssSelector(".product-name")).getText().contains(productName)).findFirst().orElse(null);*/
			
	    WebElement item=cartItems.stream().filter(p->
	    p.findElement(By.cssSelector(".product-name")).getText().contains(i)).findFirst().orElse(null);
		
		//item.findElement(By.xpath("//div[@class='products']//div[1]//div[3]//button[1]")).click();
		item.findElement(By.cssSelector(".increment")).click();
		item.findElement(By.cssSelector("button[type='button']")).click();
		}
		
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.cssSelector("button[type='button']")).click();
			
		List<WebElement> cartList=driver.findElements(By.xpath("//table/tbody/tr/td[2]"));
		
		for(String i : productName) {
		Boolean match =cartList.stream().anyMatch(p->
		p.getText().equalsIgnoreCase(i));
		Assert.assertTrue(true);
		}
		
		driver.findElement(By.cssSelector(".promoCode")).sendKeys("rahulshettyacademy");
		
	    driver.findElement(By.cssSelector(".promoBtn")).click();
	    
	   WebElement promoCode=driver.findElement(By.cssSelector(".promoInfo"));
		
	    WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(".promoInfo"))));
	    
	    Assert.assertEquals(promoCode.getText(),"Code applied ..!");
	    
	    driver.findElement(By.xpath("//button[normalize-space()='Place Order']")).click();
	    
	    Actions a = new Actions(driver);
	    
	    driver.findElement(By.xpath("(//select)[1]")).click();
	    Select s = new Select(driver.findElement(By.xpath("(//select)[1]")));
	    s.selectByValue("Algeria");
	    
	    driver.findElement(By.cssSelector("input[type='checkbox']")).click();
	    
	    driver.findElement(By.xpath("//button[normalize-space()='Proceed']")).click();
	    
	   // a.sendKeys(promoCode, productName)
		
	
	}

}
