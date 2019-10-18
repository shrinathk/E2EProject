package endtoendtesting;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage extends Webbrowser {

	
	//WebDriver driver;
	
	//List<WebElement> newsLetter;
	
public LandingPage(WebDriver driver) {
	
	this.driver=driver;
}
//		
//		@FindBy(xpath="//button[contains(text(),'NO THANKS')]")
//		WebElement newsLetter;


		By courses = By.xpath("//div[contains(@class,'text-center')]/h2");
		
//By courses = By.xpath("//h2[contains(text(),'Featured Courses')]");
		
		By navigationBar = By.cssSelector("ul[class*='navbar']");
		
		
		By noThanks = By.xpath("//button[contains(text(),'NO THANKS')]");
		
		By logIn = By.cssSelector("a[href*='sign_in']");
		
		public List<WebElement> getNewsletter() {
			
			return driver.findElements(noThanks);
//try {
//	
//	 newsLetter =  driver.findElements(By.xpath("//button[contains(text(),'NO THANKS')]"));
//}
//		catch(Exception e) {
//			System.out.println("This element is not present on the webpage");
//			newsLetter = new ArrayList<WebElement>();
//		}
//			return  newsLetter;
	}

public WebElement noThanks() {
			
			return driver.findElement(noThanks);
		}

public WebElement loggingIn() {
	
	return driver.findElement(logIn);
}

public WebElement checkCoursesText() {
	
	return driver.findElement(courses);
}

public WebElement checkNavigationBar() {
	
	return driver.findElement(navigationBar);
}
}
