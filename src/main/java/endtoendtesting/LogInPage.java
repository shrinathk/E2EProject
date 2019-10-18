package endtoendtesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LogInPage extends Webbrowser {

	public LogInPage(WebDriver driver) {
		
		this.driver=driver;
	}
	
	By username = By.id("user_email");
	
	By password = By.cssSelector("input[name*='password']");
	
	By logIn = By.xpath("//input[contains(@type,'submit')]");
	
	By errorMessage = By.xpath("//div[contains(@class,'alert-danger')]");
	
	By forgotPassword = By.xpath("//a[text()='Forgot Password?']");
	
	public WebElement getUsername() {
		
		return driver.findElement(username);
	}
	
public WebElement getPassword() {
		
		return driver.findElement(password);
	}

public WebElement clickLogIn() {
	
	return driver.findElement(logIn);
}

public List<WebElement> checkErrorMessage() {
	
	return driver.findElements(errorMessage);
}

public WebElement clickForgotPassword() {
	
	return driver.findElement(forgotPassword);
}

}
