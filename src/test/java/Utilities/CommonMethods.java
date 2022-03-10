package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Network.UserAgent;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonMethods {

	static WebDriver driver;
	static WebDriverWait wait;
	static Properties props;
	
	@SuppressWarnings("deprecation")
	public static WebDriver SetUp() throws IOException {
		String baseUrl="https://jt-dev.azurewebsites.net/#/SignUp";
		//creating properties file
		
		 InputStream input = new FileInputStream("D:\\Programing\\javaProjects\\AzureWebsite\\Resources\\config.properties");
		 props=new Properties();
		 props.load(input);
		
		//setting property for driver
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		//initiating browser
		driver=new ChromeDriver();
		System.out.println("Browser Initiated");
		// navigating to ur;
		driver.get(baseUrl);
		
		//maximizing browser window
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static  String getEmail() {
		
		
		
		return GetEmail.checkMail(props.getProperty("host"),
				props.getProperty("mailStoreType"),
				props.getProperty("username") ,
				props.getProperty("password"));
		
		
	}
	 public static void setEmailID(String email) {
		 props.setProperty("username",email);
	 }
	
	public  CommonMethods(WebDriver driver) {
		 this.driver=driver;
	}
	
	public static void waitForElement(WebElement element) {
		
		wait=new WebDriverWait(driver, 15);
		
		wait.until(ExpectedConditions.presenceOfElementLocated((By) element));
	}
	public static  void tearDown() {
		
		//closing the browser
		driver.close();
		
	}
	
	
}
