package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SignInPageObjects {

	public WebDriver driver;

	public SignInPageObjects(WebDriver driver) {
		this.driver = driver;
		 PageFactory.initElements(driver, this);
	}

	By registeremailId = By.cssSelector("#email_create");

//	@FindBy(css = "[value='Create an account']")
//	WebElement createAccount;

	By emailSignin = By.cssSelector("#user_email");
	By passwordSignin = By.cssSelector("#user_password");
	
	@FindBy(css = "input[name='commit']")
	WebElement loginButton;
	
//	By loginButton = By.cssSelector("input[name='commit']");

	public WebElement getRegisteremailID() {
		return driver.findElement(registeremailId);
	}
//	public WebElement createAccount()
//	{
//		return createAccount;
//	}

	public WebElement getemailID() {
		return driver.findElement(emailSignin);
	}

	public WebElement getPassword() {
		return driver.findElement(passwordSignin);
	}

	public WebElement getLoginButton() {
		return (loginButton);
	}

}
