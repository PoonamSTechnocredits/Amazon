package amazon;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.PreDefinedActions;
import constant.ConstantPath;
import pages.AmazonHomePage;
import util.ExcelOperations;

public class SeachProduct extends TestBase {

	
	@Test(dataProvider = "SearchDataProvider")
	public void searchProduct(String productName) {
		getAmazonHome();
		amazonHomePage.clickOnSearchBox();
		amazonHomePage.enterProductName(productName);
		amazonHomePage.clickOnSearchResult(productName);
		amazonHomePage.switchAmazonWindow();
		amazonHomePage.clickOnBuyNow();
		String pageTitle = amazonHomePage.getPageTitle();
		Assert.assertEquals(pageTitle, "Amazon Sign In");
	}

	@DataProvider(name = "SearchDataProvider")
	public String[][] searchData() throws IOException {
		String[][] productName = ExcelOperations.readExcelData(ConstantPath.amazonProductDataSheetPath, "Data");
		return productName;
	}
}
