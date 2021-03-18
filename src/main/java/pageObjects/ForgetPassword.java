package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgetPassword {
	
	public WebDriver driver;
	
	
	public ForgetPassword(WebDriver driver) {
		this.driver = driver;
	}
	
	private By email = By.id("user_email");
	private By submit = By.name("commit");
	
	public WebElement getFpEmail() {
		return driver.findElement(email);
	}
	
	public WebElement getFpSubmit() {
		return driver.findElement(submit);
	}
	

}
