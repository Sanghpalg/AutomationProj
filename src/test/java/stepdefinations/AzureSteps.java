package stepdefinations;

import java.io.IOException;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import Utilities.CommonMethods;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CreateAccountPage;


public class AzureSteps  {
	

	WebDriver driver;
	CreateAccountPage accountpageobj;
	

    @Given("^user is on Azure website$")
    public void user_is_on_azure_website() throws InterruptedException, IOException {
       
    	driver=CommonMethods.SetUp();
    	accountpageobj=new CreateAccountPage(driver);
    	//accountpageobj.waitForLogoDisplay();
    	
    	Thread.sleep(10000);
    	
    	
    	
    	
    }

    @When("^user click on dropdown$")
    public void user_click_on_dropdown() throws InterruptedException {
    	 
    	accountpageobj.clickOnDrpDwn();
       
    }

    @Then("^\"([^\"]*)\" language should be display$")
    public void something_language_should_be_display(String explanguage) throws InterruptedException {
       
    	accountpageobj.ValidateDropDownOption(explanguage);
    }
    

    @When("^user Enter \"([^\"]*)\" , \"([^\"]*)\" , \"([^\"]*)\" on create account field$")
    public void user_enter_something_something_something_on_create_account_field(String fullname, String orgname, String email) throws Throwable {
        
    	accountpageobj.enterFullname(fullname);
    	accountpageobj.enterOrganisationName(orgname);
    	accountpageobj.enterEmailID(email);
    }
    @And("^Accept Tearms and condition$")
    public void accept_tearms_and_condition() throws Throwable {
    	
    	accountpageobj.clickonIAgreeCheckbox();
    	
    }

    @And("^Submit the application$")
    public void submit_the_application() throws Throwable {
    	System.out.println("click on submit");
    	accountpageobj.clickOnSubmit();
       
    }
    @Then("^User should Recieved an Email on his email account$")
    public void user_should_recieved_an_email_on_his_email_account() throws Throwable {
    	accountpageobj.validateEmail();
    	
       
    }
    @And("^close the browser$")
    public void close_the_browser()  {
    	
    	CommonMethods.tearDown();
       
    }

  

}