package AutomationProject.DemoE2ETesting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObjects.HomePageObjects;

import resources.PreRequisite;

public class HomePageValidation extends PreRequisite {
	public WebDriver driver; //best practice to prevent overriding of initializeDriver()
	private static Logger logObject = LogManager.getLogger(PreRequisite.class.getName());
	@BeforeTest
	public void initialRun() throws IOException {
		driver = initializeDriver();
		logObject.debug("running initialRun() and Driver Initialized");
		driver.get(propertyObject.getProperty("homePageURL"));
		logObject.debug("running initialRun() and home page URL Initialized "); 
		logObject.debug(propertyObject.getProperty("browser"));
	}
	
	@Test
	public void homePageNavigation() throws IOException, InterruptedException, NullPointerException {

		HomePageObjects homePageObject = new HomePageObjects(driver);
		// Wait<WebDriver> w = new
		// FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		// WebDriverWait wait= new WebDriverWait(driver, 15);
		// Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class*='sumome-react-wysiwyg-popup-container']")));
		// driver.findElement(By.xpath("//button[text()='NO THANKS']")).click();

		Assert.assertTrue(homePageObject.getUpperNavigationBar().isDisplayed());
		logObject.info("");
		Assert.assertEquals(driver.findElement(By.xpath("//a[contains(text(),'Contact Us')]")).getText(), "Contact Us");

		
	}

	@Test(dependsOnMethods = { "homePageNavigation" })
	public void SIgnInPageCheck() {
		HomePageObjects homePageObject = new HomePageObjects(driver);
		Assert.assertTrue(homePageObject.getsigninButton().getText().equalsIgnoreCase("Login"));
		
//		SignInPageObjects signInPageObject = new SignInPageObjects(driver);
//		signInPageObject.getemailID().sendKeys("rahul");
//		signInPageObject.getPassword().sendKeys("random");
//		signInPageObject.getLoginButton().submit();

		//signInPageObject.getRegisteremailID().sendKeys("sample@mail.com");
		// signInPageObject.createAccount().submit();

	}
	
	
	@AfterClass
	public void Shutdown() {
		driver.close();
	}
}