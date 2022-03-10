package pages;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utilities.CommonMethods;
import net.bytebuddy.matcher.MethodExceptionTypeMatcher;

public class CreateAccountPage extends PageFactory {
	  WebDriver driver;
	  WebDriverWait wait;
	  //CommonMethods method;
	  
	 @FindBy(xpath = "//body/div[1]/div[2]/section[1]/div[1]/div[2]/section[1]/div[1]/div[1]/span[1]/span[2]")
	 WebElement drpdwn;
	 
	 @FindBy(xpath = "//body/div[1]/div[2]/section[1]/div[1]/div[2]/section[1]/div[1]/input[1]") 
	 WebElement search;
	 
	@FindBy(xpath ="//input[@id=\"name\"]")
	
	WebElement fullName;

	@FindBy(xpath = "//input[@id=\"orgName\"]")
	WebElement OrganizationName;
	
	@FindBy(xpath = "//input[@id=\"singUpEmail\"]")
	WebElement email;
	
	@FindBy(xpath = "//span[contains(text(),'I agree to the')]")
	WebElement checkbox;
	
	@FindBy(xpath ="//button[@type=\"submit\"]" )
	WebElement submitBtn;
	
	@FindBy(xpath="//img[@src=\"images/logo.701d2226.png\"]")
	WebElement logo;
	
	
	public CreateAccountPage(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnDrpDwn() throws InterruptedException {
		//click on language dropdown
		
		//drpdwn.click();
		//Thread.sleep(5000);
	}
	public void ValidateDropDownOption(String explanguage) throws InterruptedException {
		
		if(drpdwn.getText().equals(explanguage)) {
			Assert.assertEquals(explanguage+"is present in Dropdown", explanguage,drpdwn.getText());
		}else {
	
			drpdwn.click();
	
	Thread.sleep(5000);
   search.click();
   search.sendKeys(explanguage);
   search.sendKeys(Keys.ARROW_DOWN);
   search.sendKeys(Keys.ENTER); 
   
  
   Thread.sleep(5000);
   System.out.println(drpdwn.getText());
   
		
		
			Assert.assertEquals(explanguage+"is present in Dropdown", explanguage,drpdwn.getText());
		}
	
			
			
				
		}
	
	
		
		
	
	public void enterFullname(String fullname) {
		fullName.sendKeys(fullname);
	}
	
	public void enterOrganisationName(String orgname) {
		OrganizationName.sendKeys(orgname);
	}
	
	public void enterEmailID(String emailid) {
		email.sendKeys(emailid);
		CommonMethods.setEmailID(emailid);
	}
	
	public void validateEmail() {
	 String actEmailSubject=CommonMethods.getEmail();
	 
	 Assert.assertEquals("Email Sucessfully Validated", actEmailSubject, actEmailSubject);
	}
	
	public void clickonIAgreeCheckbox() {
		checkbox.click();
		
	}
	public void waitForLogoDisplay() {
		 //method=new CommonMethods(driver);
		 CommonMethods.waitForElement(logo);
		 
		 if(logo.isDisplayed()) {
			 System.out.println("We sucessfully landed to page");
		 }else{
			System.out.println("Something went wrong"); 
		 }
		 //Assert.assertTrue("Logo is displayed", logo.isDisplayed());
	}
	
	public void clickOnSubmit() throws InterruptedException {
		submitBtn.click();
		
		Thread.sleep(10000);
		
	}
	
	
	
	
	
	
}
