package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Base {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		
		String browserName = System.getProperty("browser");
		//String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		
		if(browserName.contains("chrome")) {
			
			//execute in chrome browser
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\main\\java\\resources\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			
			if(browserName.contains("headless")) {
				
				options.addArguments("headless");
				
			}
			
			driver = new ChromeDriver(options);
			
		}
//		else if(browserName == "firefox") {
//			//execute in firefox
//		}else if(browserName == "IE"){
//			
//		}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public String getScreenShotPath( String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot ts = (TakesScreenshot) driver;
		File sourse = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+ testCaseName+ ".png";
		FileUtils.copyFile(sourse, new File(destinationFile));
		return destinationFile;
	}
	
}
