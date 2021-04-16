package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountLoginPageObjects {

		public WebDriver driver;
		
		
		By accountName =By.linkText("RAHUL MITRA");
		
		public AccountLoginPageObjects(WebDriver driver) {
			// TODO Auto-generated constructor stub
			this.driver=driver;
		}

public WebElement getAccountName() {
	
	return driver.findElement(accountName);
}
}