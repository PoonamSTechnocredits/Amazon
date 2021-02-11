package pages;

import java.io.IOException;

import base.PreDefinedActions;
import constant.ConstantPath;
import util.PropertyFileOperation;

public class AmazonHomePage extends PreDefinedActions {

	PropertyFileOperation pfo;
	private static AmazonHomePage amazonHomePage = null;

	private AmazonHomePage() {
		try {
			pfo = new PropertyFileOperation(ConstantPath.amazonHomePagePropertyFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static AmazonHomePage getInstance() {
		if (amazonHomePage == null)
			amazonHomePage = new AmazonHomePage();
		return amazonHomePage;
	}

	public void clickOnSearchBox() {
		clickOnElement(pfo.readProperty("productSearchBox"));
	}

	public void enterProductName(String productName) {
		setText(pfo.readProperty("productSearchBox"), productName);
		
	}

	public void clickOnBuyNow() {
		clickOnElement(pfo.readProperty("buyNowButton"));
	}

	public void scrollToElementOnHomePage(String key) {
		scrollToElement(pfo.readProperty(key));
	}
	
	public void clickOnSearchResult(String key) {
		clickOnElement(pfo.readProperty(key));
	}
	
	public void switchAmazonWindow() {
		switchWindowHandle();
	}
	
	public String getPageTitle() {
		String titleName = getTitle();
		return titleName;
	}
	
}
