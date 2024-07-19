package HTC.GreenKart.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import HTC.GreenKart.AbstractComponents.AbstractComponent;

public class ChooseCountryPage extends AbstractComponent {
	
WebDriver driver;
	
	public ChooseCountryPage(WebDriver driver){
		
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(xpath="(//select)[1]")
	WebElement countrySelectBox;
	
	@FindBy(css="input[type='checkbox']")
	WebElement checkBox;
	
	@FindBy(xpath="//button[normalize-space()='Proceed']")
	WebElement proceedButton;
	
	@FindBy(css="span[class='errorAlert'] b")
	WebElement errorMessage;
	
	
	public void CountrySelection(String countryName) {
		
		 Actions a = new Actions(driver);
		 countrySelectBox.click();
		 Select s = new Select(countrySelectBox);
		 s.selectByValue(countryName);
		 //checkBox.click();
		 //proceedButton.click();
		 
	}
	
	public void clickCheckBox() {
		
		checkBox.click();
	}
	
	public void proceedToFinalPage() {
		
		proceedButton.click();
	}
	
	public String getErrorMessage() {
		
		String errorMessage1=errorMessage.getText();
		return errorMessage1;
	}

}
