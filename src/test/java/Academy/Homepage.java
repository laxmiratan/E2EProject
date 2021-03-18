package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgetPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

public class Homepage extends Base {
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest
	public void intialize() throws IOException {
		driver = initializeDriver();
	}
	
	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password, String text) throws IOException {
		
		driver.get(prop.getProperty("url"));
		
		LandingPage lp = new LandingPage(driver);
		
		
		LoginPage loginPage = lp.getLogin();
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		log.info(text);
		loginPage.getSubmit().click();
		
		
		ForgetPassword fp = loginPage.getForgetPassword();
		fp.getFpEmail().sendKeys(username);
		fp.getFpSubmit().click();
		
	}
	
	
	@DataProvider
	public Object[][] getData() {
		
		//Row stand for how many different data type test should run
		//column stand for how many value for each test
		Object[][] data = new Object[2][3];
		
		//0th row
		data[0][0] = "nonrestricteduser@qw.com";
		data[0][1] = "1234567";
		data[0][2] = "restricted User";
		
		//1st row
		data[1][0] = "restricteduser@gmail.com";
		data[1][1] = "76543221";
		data[1][2] = "NonRestricted User";
		
		return data;
		
		
		
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}


}
