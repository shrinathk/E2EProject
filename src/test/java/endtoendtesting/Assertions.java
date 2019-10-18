package endtoendtesting;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Assertions extends Webbrowser {

private static Logger log =LogManager.getLogger(Assertions.class.getName());
	
	@BeforeTest
	public void initializeTesting() throws IOException{
		
		initializedriver();
		log.info("WebDdriver initialized");
		
	}
	
	@Parameters({"URL"})
	@Test
	public void TitleAssertions(String URL) throws IOException, InterruptedException {

		// When a child class inherits parent class, then we need not create an object
		// of the parent class in order to access its methods and non-private variables,
		// we can directly call method like this:
		// methodname;
		driver.get(URL);
		
		log.info("URL opened");
		
		LandingPage pf = new LandingPage(driver);
		String coursefeatures = pf.checkCoursesText().getText();
		System.out.println(coursefeatures);
		Assert.assertTrue(coursefeatures.equals("FEATURED COURSES"));
		
		log.info("Title matches with requirement");
		
		
}

	@AfterTest
	public void closeBrowser() {
		
		driver.close();
	}
	
	
	
}
