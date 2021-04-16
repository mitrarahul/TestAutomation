package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class HomePageObjects {

	public WebDriver driver;
	
	By signinButtonQA = By.cssSelector("[href*='sign_in']");
//	By popupWindowCross = By.xpath("//button[text()='NO THANKS']");
	
	By signinButton = By.cssSelector("a[class='theme-btn register-btn']");
	
	By upperNavigationBar = By.cssSelector(".navigation.clearfix");
	
//	@FindBy(xpath ="//button[text()='NO THANKS']")
//	WebElement closePopUp;

	public HomePageObjects(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}
 public WebElement getUpperNavigationBar() {
	 return driver.findElement(upperNavigationBar);
 }

	public WebElement getsigninButton() {
		
		return driver.findElement(signinButtonQA);
	}

}
