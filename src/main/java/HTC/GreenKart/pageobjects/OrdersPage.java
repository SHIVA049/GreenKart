package HTC.GreenKart.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import HTC.GreenKart.AbstractComponents.AbstractComponent;


public class OrdersPage extends AbstractComponent {
	
	WebDriver driver;
	
	public OrdersPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="//table/tbody/tr/td[2]")
	List<WebElement> cartList;
	
	@FindBy(css=".promoCode")
	WebElement promoCode;
	
	@FindBy(css=".promoBtn")
	WebElement promoApplyButton;
	
	@FindBy(css=".promoInfo")
	WebElement promoApplyMessage;
	
	@FindBy(xpath="//button[normalize-space()='Place Order']")
	WebElement placeOrder;
	
	By products=By.cssSelector(".product-name");
	By increment = By.cssSelector(".increment");
	By addToCart= By.cssSelector("button[type='button']");
	
	 public Boolean cartVerification(String s) {
		 
		 Boolean match =cartList.stream().anyMatch(p->
			p.getText().equalsIgnoreCase(s));
			return match;
	 }
	 
	 public WebElement promoApplyVerification(String promocode) {
		 
		promoCode.sendKeys(promocode);
		promoApplyButton.click();
		waitForWebElementToAppear(promoApplyMessage);
		return promoApplyMessage;
		
	 }
	 
	 public ChooseCountryPage placeOrderClick() {
		 
		 placeOrder.click();
		 ChooseCountryPage ccp=new ChooseCountryPage(driver);
		 return ccp;
	 }
	

}
