package HTC.GreenKart.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import HTC.GreenKart.pageobjects.ProdSelectionPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public WebDriver driver;
	public ProdSelectionPage psp;
	
	public WebDriver initializeTest() throws IOException {
		
		Properties prop=new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\HTC\\GreenKart\\resources\\GlobalData.properties");
		prop.load(fis);
		String browserName=System.getProperty("browser") != null ? System.getProperty("browser") : prop.getProperty("browser");
		if(browserName.contains("chrome")) {
			ChromeOptions options=new ChromeOptions();	
			WebDriverManager.chromedriver().setup();
			if(browserName.contains("headless")) {
				options.addArguments("headless");
				
			}
			
			driver=new ChromeDriver(options);
			//driver.manage().window().setSize(new Dimension(1440, 900));
			
			//WebDriver driver=new EdgeDriver();
			 
			
			
			}
			else if(browserName.equalsIgnoreCase("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver=new FirefoxDriver();
				
			}else if(browserName.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				
			}
			
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			//driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
			driver.manage().window().maximize();
			return driver;
		}
	
	 
	  public String getScreenShot(String testcaseName, WebDriver driver) throws IOException {
		  
		  TakesScreenshot ts=(TakesScreenshot)driver;
		  File source=ts.getScreenshotAs(OutputType.FILE);
		  File file=new File(System.getProperty("user.dir") + "//reports//"+ testcaseName + ".png");
		  FileUtils.copyFile(source, file);
		  return (System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
	  }
	  
	  @BeforeMethod(alwaysRun=true)
	  public ProdSelectionPage launchApplication() throws IOException {
		  
		  driver=initializeTest();
		  psp=new ProdSelectionPage(driver);
		  psp.goTo();
		  return psp;
	  }
	  
	  @AfterMethod(alwaysRun=true)
		public void tearDown() {
			
			driver.close();
		}
		
	}


