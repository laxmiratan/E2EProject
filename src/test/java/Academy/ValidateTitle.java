package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.Base;

public class ValidateTitle extends Base {
	public WebDriver driver;
	LandingPage lp ;
	
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
		log.info("driver is intialized");
		driver.get(prop.getProperty("url"));
		log.info("navigeted to home page");
	}
	
	@Test
	public void basePageNavigation() throws IOException {
		
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.getTitle().getText(), "FEATURED COURSES" );
		log.info("successfully validated text message");
		
	}
	
	@Test
	public void validateHeader() {
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}

}
