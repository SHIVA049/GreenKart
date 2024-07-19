package HTC.GreenKart.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HTC.GreenKart.AbstractComponents.AbstractComponent;

public class ProdSelectionPage extends AbstractComponent {
	
	WebDriver driver;
	
	public ProdSelectionPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css=".product")
	List<WebElement> cartItems;
	
	@FindBy(css=".cart-icon")
	WebElement cartIcon;
	
	@FindBy(css="button[type='button']")
	WebElement proceedToCheckOut;
	
	By products=By.cssSelector(".product-name");
	By increment = By.cssSelector(".increment");
	By addToCart= By.cssSelector("button[type='button']");
	
	 public void getProductByName(String i) {
		 
		 WebElement item=cartItems.stream().filter(p->
		 p.findElement(products).getText().contains(i)).findFirst().orElse(null);
		 item.findElement(increment).click();
		 item.findElement(addToCart).click();
	 }
	 
	 public OrdersPage proceedToCheckOutP() {
		 
		 cartIcon.click();
		 proceedToCheckOut.click();
		 OrdersPage op=new OrdersPage(driver);
		 return op;
		 
	 }
	 
	 
	 public void goTo() {
	    	
	    	driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	  }
	    
	

}
