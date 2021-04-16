package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.testng.Assert;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.junit.Cucumber;
import pageObjects.AccountLoginPageObjects;
import pageObjects.HomePageObjects;
import pageObjects.SignInPageObjects;
import resources.PreRequisite;

@RunWith(Cucumber.class)
public class StepDefinitionTesting extends PreRequisite{

	@Given("^Browser initialization with a chosen web browser$")
	public void browser_initialization_with_a_chosen_web_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		driver = initializeDriver();
	}

	@Given("^Navigate to the landing page \"([^\"]*)\" site$")
	public void navigate_to_the_landing_page_site(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	  //  throw new PendingException();
		driver.get(arg1);
	}

	@Given("^User clicks on login link$")
	public void user_clicks_on_login_link_and() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		HomePageObjects homePageObject = new HomePageObjects(driver);
		homePageObject.getsigninButton().click();
	}

	
	  @When("^User tries to login via (.+) and (.+) and clicks on login button$")
	    public void user_tries_to_login_via_and_and_clicks_on_login_button(String username, String password) throws Throwable {
		  SignInPageObjects signInPageObject = new SignInPageObjects(driver);
			signInPageObject.getemailID().sendKeys(username);
			signInPageObject.getPassword().sendKeys(password);
			signInPageObject.getLoginButton().submit();
	    }

	@Then("^Verify user is signed in successfully$")
	public void verify_user_is_signed_in_successfully() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new PendingException();
		AccountLoginPageObjects accountLoginPageObj = new AccountLoginPageObjects(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		System.out.println(accountLoginPageObj.getAccountName().getText());
		Assert.assertTrue(accountLoginPageObj.getAccountName().getText().equalsIgnoreCase("RAHUL MITRA"));	
			
	}
	
	@And("^driver is closed$")
	public void driver_is_closed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   driver.quit();
	}
}
