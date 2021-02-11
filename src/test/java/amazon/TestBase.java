package amazon;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import base.PreDefinedActions;
import pages.AmazonHomePage;

public class TestBase {

	@BeforeTest
	public void launchAmazon() {
		PreDefinedActions.start("https://www.amazon.in");
	}
	
	AmazonHomePage amazonHomePage;
	AmazonHomePage getAmazonHome() {
		amazonHomePage = AmazonHomePage.getInstance();
		return amazonHomePage;
			}
	
	@AfterTest
	public void closeAmazon() {
		PreDefinedActions.closeBrowser();
	}
}
