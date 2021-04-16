package resources;

import java.io.File;
//import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
//import java.io.*;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PreRequisite {
	 public WebDriver driver;
	 public Properties propertyObject;

	public WebDriver initializeDriver() throws IOException   {

		 propertyObject = new Properties();
		FileInputStream fis = new FileInputStream(
//				"F:\\Users\\RAHUL\\eclipse-workspace\\DemoE2ETesting\\src\\main\\java\\resources"
//				+ "\\dataPreRequisite.properties");
		//we can intoroduce user.dir to softcode location for usability
				System.getProperty("user.dir")+"\\src\\\\main\\\\java\\\\resources\\dataPreRequisite.properties");
		propertyObject.load(fis);
		/* In order to make the browser value imported from the system(maven or jenkins), then use System.getProperty 
		  instead of propertyObject.getProperty
		  maven command is:> mvn test -Dbrowser=firefox */
//		String browserType = System.getProperty("browser");
		String browserType = propertyObject.getProperty("browser");
		
		System.out.println(browserType);
		
		if (browserType.contains("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\SW\\Webdrivers\\chromedriver_win32\\chromedriver.exe");
			ChromeOptions chromeOptionObject = new ChromeOptions();
			if (browserType.contains("headless")) {
			chromeOptionObject.addArguments("headless");}
			driver = new ChromeDriver(chromeOptionObject);
		}

		else if (browserType.equalsIgnoreCase( "firefox") ){
			System.setProperty("webdriver.gecko.driver",
					"E:\\SW\\Webdrivers\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}

		else if (browserType.equalsIgnoreCase( "edge")){
			System.setProperty("webdriver.edge.driver", "E:\\SW\\Webdrivers\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		
		return driver;
		 
	}
	public String getScreenshotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshotSource = ts.getScreenshotAs(OutputType.FILE);
		String ScreenshotDestinationPathFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".jpg";
		FileUtils.copyFile(screenshotSource, new File(ScreenshotDestinationPathFile));
		return ScreenshotDestinationPathFile;
	}
	  
	//getScreenshotAs(OutputType.File);
}
