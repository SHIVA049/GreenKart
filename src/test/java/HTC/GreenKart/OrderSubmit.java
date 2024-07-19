package HTC.GreenKart;

import java.io.IOException;
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
import org.testng.annotations.Test;

import HTC.GreenKart.TestComponents.BaseTest;
import HTC.GreenKart.pageobjects.ChooseCountryPage;
import HTC.GreenKart.pageobjects.OrdersPage;
import HTC.GreenKart.pageobjects.ProdSelectionPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class OrderSubmit extends BaseTest {

	
		// TODO Auto-generated method stub
	@Test	 
	public void OrderSubmitTest() {
		
	String[] productName = {"Carrot","Tomato","Beans","Brocolli"};
		
		ProdSelectionPage psp = new ProdSelectionPage(driver);	    
		for(String i : productName) {
	    psp.getProductByName(i);
		}
	    OrdersPage op=psp.proceedToCheckOutP();
		for(String s : productName) {
		Boolean match=op.cartVerification(s);
		Assert.assertTrue(true);
		}
		WebElement promoCode=op.promoApplyVerification("rahulshettyacademy");	    
	    Assert.assertEquals(promoCode.getText(),"Code applied ..!");	    
	    ChooseCountryPage ccp=op.placeOrderClick();	    
	    ccp.CountrySelection("Algeria");
	    ccp.clickCheckBox();
	    ccp.proceedToFinalPage();
	    
	}

}
