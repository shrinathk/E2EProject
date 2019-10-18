package endtoendtesting;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePage extends Webbrowser {
	
	
	private static Logger log =LogManager.getLogger(HomePage.class.getName());
	
	@BeforeTest
	public void initializeTesting() throws IOException{
		
		initializedriver();
		log.info("WebDdriver initialized");
		
	}
	
	
	@Test(dataProvider="loginDetails")
	public void basePageNavigation(String username, String password, String typeOfUser) throws IOException, InterruptedException {

		// When a child class inherits parent class, then we need not create an object
		// of the parent class in order to access its methods and non-private variables,
		// we can directly call method like this:
		// methodname;
		driver.get(prop.getProperty("URL"));
		
		log.info("URL opened");
		
		// Thread.sleep(20000);
		LandingPage pf = new LandingPage(driver);

		// System.out.println(pf.getNewsletter().size());
		if (pf.getNewsletter().size() > 0) {

			pf.noThanks().click();
			log.info("Popup clicked");
		}
		
		log.debug("Checking if title of features matches with required name");
			
			
			
			log.debug("Checking if navigation bar is displayed on landing page");
			
			Assert.assertTrue(pf.checkNavigationBar().isDisplayed());
			
			log.info("Navigation bar is displayed on landing page");
			
		
		pf.loggingIn().click();
//		Properties prop = new Properties();
//		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\browserdata.properties");
//		prop.load(fis);
		
		log.debug("Entering log in page");
		LogInPage lp = new LogInPage(driver);
		log.info("In the logging page");
		lp.getUsername().sendKeys(username);
		lp.getPassword().sendKeys(password);
		System.out.println(typeOfUser);
		//lp.getUsername().sendKeys(prop.getProperty("username"));
		//lp.getPassword().sendKeys(prop.getProperty("password"));
		lp.clickLogIn().click();
		if(lp.checkErrorMessage().size()>0) {
			lp.clickForgotPassword().click();
			log.info("In forgot password page");
		}

	}
	
	@AfterTest
	public void closeBrowser() {
		
		driver.close();
		driver = null;
	}
	
	@DataProvider
	public Object[][] loginDetails(){
		
		Object[][] loginCredentials = new Object[2][3];
		loginCredentials[0][0] = "restricteduser@abc.com";
		loginCredentials[0][1] = "123456";
		loginCredentials[0][2] = "This is a restricted user";
		loginCredentials[1][0] = "adminuser@abc.com";
		loginCredentials[1][1] = "987654";
		loginCredentials[1][2] = "This is an admin user";
		return loginCredentials;
		
		
	}
}
