package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
	this.driver= driver;
	}
	
	private By signIn = By.xpath("//*[@id=\"homepage\"]/header/div[1]/div/nav/ul/li[4]/a/span");
	private By title = By.xpath("//div[@class = 'text-center']/h2");
	private By navBar = By.cssSelector("ul.nav.navbar-nav.navbar-right");
	private By header = By.cssSelector("div.video-banner h3");
	
	public LoginPage getLogin() {
		driver.findElement(signIn).click();
		LoginPage login = new LoginPage(driver);
		return login;
	}
	
	public WebElement getTitle() {
		return driver.findElement(title);
	}
	
	public WebElement getNavBar() {
		return driver.findElement(navBar);
	}
	
	public WebElement getHeader() {
		return driver.findElement(header);
	}

}
