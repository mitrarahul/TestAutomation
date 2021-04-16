package AutomationProject.DemoE2ETesting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.HomePageObjects;
import pageObjects.SignInPageObjects;
import resources.PreRequisite;

public class SignInPageValidation extends PreRequisite {
	private static Logger logObject = LogManager.getLogger(PreRequisite.class.getName());
	public WebDriver driver; //best practice to prevent overriding of initializeDriver()
	@BeforeTest
	public void SignInPageCheck() throws IOException {
		driver = initializeDriver();
		driver.get(propertyObject.getProperty("homePageURL"));
		logObject.debug("driver initialized class SignInPageValidation SignInPageCheck()");
	}
	@BeforeClass
	public void signInPageNavigation() {
		HomePageObjects homePageObject = new HomePageObjects(driver);
		homePageObject.getsigninButton().click();
		logObject.debug("getting into signin page");
	}
	
	@Test( dataProvider = "signinCheck")
	public void SignInFieldsCheck(String username, String password) {
		int count =0;
		SignInPageObjects signInPageObject = new SignInPageObjects(driver);
		signInPageObject.getemailID().sendKeys(username);
		signInPageObject.getPassword().sendKeys(password);
		signInPageObject.getLoginButton().submit();
		count++;
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		if (count==0)
			logObject.error("Execution failed at parameterization step");
	}

	@DataProvider
	public Object[][] signinCheck() {
		Object[][] dataProviderObject = new Object[3][2];
		dataProviderObject[0][0] = "";
		dataProviderObject[0][1] = "";

		dataProviderObject[1][0] = "wert";
		dataProviderObject[1][1] = "8498/*/";
		dataProviderObject[2][0] = "sdsd";
		dataProviderObject[2][1] = "asd";
		return dataProviderObject;
	}
	@AfterClass
	public void close() {
		driver.quit();
	}
}
