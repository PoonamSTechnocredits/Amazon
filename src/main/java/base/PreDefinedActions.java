package base;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import constant.ConstantPath;

public class PreDefinedActions {

	static protected WebDriver driver;

	static public void start(String url) {
		System.setProperty("webdriver.chrome.driver", ConstantPath.chromeDriverExePath);
		driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.get(url);
	}

	protected WebElement getElement(String locator) {
		String locatorType = locator.split("]:-")[0].trim().substring(1).toUpperCase();
		String locatorValue = locator.split("]:-")[1].trim();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement element = null;
		switch (locatorType) {
		case "ID":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locatorValue)));
			break;
		case "XPATH":
			element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locatorValue)));
			break;
		default:
			System.out.println("User didn't follow locator conventions");
		}
		return element;
	}

	protected void setText(String locator, String value) {
		
		WebElement element = getElement(locator);
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);
	}

	protected void clickOnElement(String locator) {
		WebElement element = getElement(locator);
		element.click();
	}

	public void scrollToElement(String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", locator);

	}

	public void switchWindowHandle() {
		String mainWindow = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		for (String currentWindow : s) {
			if (!currentWindow.equals(mainWindow)) {
				driver.switchTo().window(currentWindow);
				break;
			}
		}
	}

	public String getTitle() {
		String currentTitle = driver.getTitle();
		return currentTitle;
	}
	
	static public void closeBrowser() {
		driver.close();
	}
	
	
}
