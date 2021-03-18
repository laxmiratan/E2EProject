package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	private By email = By.id("user_email");
	private By password = By.id("user_password");
	private By submit = By.xpath("//input[@value = 'Log In']");
	private By forgetPassword = By.cssSelector("a.link-below-button");
	
	
	public LoginPage(WebDriver driver) {
			// TODO Auto-generated constructor stub
		this.driver= driver;
		}


	public ForgetPassword getForgetPassword() {
		driver.findElement(forgetPassword).click();
		return new ForgetPassword(driver);
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getPassword() {
		return driver.findElement(password);
	}
	
	public WebElement getSubmit() {
		return driver.findElement(submit);
	}

}
