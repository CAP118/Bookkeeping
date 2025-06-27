package com.Capium.Utilies;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

public class HelperClass {

	private static HelperClass helperClass;

	private static WebDriver driver;
	private static WebDriverWait wait;
	public final static int TIMEOUT = 10;
	private static String screenshotDirectory = "screenshots/";

	private HelperClass() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");
		driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
	}

	public static void openPage(String url) {
		if (driver == null) {
			setUpDriver(); 
		}
		driver.get(url);
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			setUpDriver();
		}
		return driver;
	}

	public static void setUpDriver() {

		if (helperClass == null) {
			java.util.logging.Logger.getLogger("org.openqa.selenium").setLevel(java.util.logging.Level.OFF);
			System.setProperty("webdriver.chrome.silentOutput", "true");
			helperClass = new HelperClass();
		}
	}

	public static void tearDown() {

		if (driver != null) {
			setUpDriver();
			driver.close();
			driver.quit();
		}

		helperClass = null;
	}

	public static WebDriverWait getWait() {
		return new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(TIMEOUT));

	}

	public static String GetUserName() {
		return "Capium Username";
	}

	public static String GetPassword() {
		return "Capium password";
	}

	public static String getTitile(By locator) {
		return driver.getTitle();
	}

	public static String getCuurentUrl() {
		return driver.getCurrentUrl();
	}

	// sendKeys methods
	public static void sendKeys(By locator, String text) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		WebElement element = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));

		element.clear();
		element.sendKeys(text);
	}

	public static List<WebElement> Listoptions(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElements(locator);
	}

	public static void ClickandAnyTypeofWebelemnt(By locator) {
		WebDriverWait wait = HelperClass.getWait();
		WebElement element = driver.findElement(locator);
		wait.until(ExpectedConditions.visibilityOf(element));
		element.click();

	}
	
	public static void clickWhenVisibleAndClickable(WebElement element) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(element));
	    wait.until(ExpectedConditions.elementToBeClickable(element));
	    element.click();
	}

	
	public static boolean isElementPresentAndClickable(WebElement element) {
	    try {
	        return element != null && element.isDisplayed() && element.isEnabled();
	    } catch (NoSuchElementException | StaleElementReferenceException e) {
	        return false;
	    }
	}

	public static void setValueUsingJSWithEvent(By locator, String value) {
		WebElement element = getDriver().findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('change'));", element,
				value);
	}

	public static void setValueUsingJS(By locator, String value) {
		WebDriver driver = getDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));

		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);

		((JavascriptExecutor) driver)
				.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }))", element);

		System.out.println("Value set using JS for element: " + locator.toString());
	}

	public static void setValueUsingJS(WebElement element, String value) {
		WebDriver driver = getDriver();
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", element);

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		((JavascriptExecutor) driver).executeScript("arguments[0].value='" + value + "';", element);

		((JavascriptExecutor) driver)
				.executeScript("arguments[0].dispatchEvent(new Event('change', { bubbles: true }))", element);

		System.out.println("Value set using JS for element: " + element.toString());
	}

	public static boolean isButtonEnabled(By locator) {
		WebDriverWait wait = HelperClass.getWait();
		try {
			WebElement button = driver.findElement(locator);
			wait.until(ExpectedConditions.visibilityOf(button));
			return button.isEnabled();
		} catch (Exception e) {
			System.out.println("Error occurred while checking button: " + e.getMessage());
			return false;
		}
	}

	public static boolean isElementPresent(By locator) {
		try {
			WebElement element = getDriver().findElement(locator);
			return element.isDisplayed();
		} catch (NoSuchElementException | StaleElementReferenceException e) {
			return false;
		}
	}

	public static void sendKeysAndPressEnter(By locator, String text) {
		WebElement element = driver.findElement(locator);
		element.clear();
		element.sendKeys(text);
	}

	public static void ClearElement(By locator) throws InterruptedException {
		WebElement element = driver.findElement(locator);
		element.click();
		Thread.sleep(2000);
		element.clear();
	}

	// Select class methods dropdowns
	public static void selectOptionByVisibleText(By dropdownLocator, String visibleText) {
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}

	public static void selectOptionByValue(By dropdownLocator, String value) {
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		select.selectByValue(value);
	}

	public static void selectOptionByValue(WebElement dropdownElement, String value) {
		Select select = new Select(dropdownElement);
		select.selectByValue(value);
	}

	public static void ClickDropdown(By dplocator) {
		WebElement dropdown = driver.findElement(dplocator);
		Select select = new Select(dropdown);
	}

	public static void selectFromDropdownAndObserveResults(By dropdownLocator) throws IOException {

		WebDriverWait wait = HelperClass.getWait();
		WebElement dropdownElement = driver.findElement(dropdownLocator); // Change the locator as per your dropdown
		wait.until(ExpectedConditions.visibilityOf(dropdownElement));
		Select dropdown = new Select(dropdownElement);
		List<WebElement> options = dropdown.getOptions();
		for (WebElement option : options) {
			dropdown.selectByVisibleText(option.getText());
			wait.until(ExpectedConditions.visibilityOf(option));
			System.out.println("Selected option: " + option.getText());
			HelperClass.captureScreenshot(option.getText());
		}
	}

	public static void selectOptionByIndex(By dropdownLocator, int index) {
		WebElement dropdown = driver.findElement(dropdownLocator);
		Select select = new Select(dropdown);
		select.selectByIndex(index);
	}

	// capture scrrenshot method
	public static String captureScreenshot(String screenshotName) throws IOException {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		String screenshotPath = screenshotDirectory + screenshotName + ".png";
		File destinationFile = new File(screenshotPath);
		FileUtils.copyFile(sourceFile, destinationFile);

		return screenshotPath;
	}

	public static File getScreenshot() {
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File screenshotFile = screenshot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("path/to/save/screenshot.png"); // Or use a unique file name
		try {
			FileUtils.copyFile(screenshotFile, destFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destFile;
	}
	// Window handlemethods

	public static String getCurrentWindowHandle(WebDriver driver) {
		return driver.getWindowHandle();
	}

	public static Set<String> getAllWindowHandles(WebDriver driver) {
		return driver.getWindowHandles();
	}

	public static void switchToWindow(WebDriver driver, String windowHandle) {
		driver.switchTo().window(windowHandle);
	}

	public static void switchToParentWindow(WebDriver driver, String parentWindowHandle) {
		driver.switchTo().window(parentWindowHandle);
	}

	public static void closeCurrentWindow(WebDriver driver) {
		driver.close();
	}

	public static void closeAllWindows(WebDriver driver) {
		driver.quit();
	}

	public static void verify(By locator) {
		WebElement element = driver.findElement(locator);

		String cicon = element.getText();

		Assert.assertTrue(element.getText().contains(cicon));

	}
//Js methods

	public static JavascriptExecutor getJSExecutor() {
		return (JavascriptExecutor) getDriver();
	}

	public static void scrolling1() {

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,2000)");

	}

	public static void scrollUntilElementVisible(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	public static void scrolling3() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-3000)");

	}

	public static void ClickUsingJS(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public static void ClickUsingJS(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
		js.executeScript("arguments[0].click();", element);
	}
	
	public static void scrollIntoView(WebElement element) {
	    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
	}


	public static void pagenumberdropdown() {

		WebElement dropdown = driver.findElement(By.xpath("//select[@name='TblClientList_VAT_length']"));
		Select select = new Select(dropdown);
		select.selectByValue("25");

	}

	public static void SearchAndSelectClient(By searchFieldLocator, String searchText, By suggestionLocator) {

		WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(searchFieldLocator));
		searchField.clear();
		searchField.sendKeys(searchText);
		wait.until(ExpectedConditions.visibilityOfElementLocated(suggestionLocator));
		WebElement firstSuggestion = driver.findElement(suggestionLocator);
		firstSuggestion.click();
	}

	public static void refresh() {
		driver.navigate().refresh();

	}

	public static void SelectDropdownvaluesOneByOne(By dropdownLocator) {
		WebDriver driver = getDriver();
		WebElement dropdownElement = driver.findElement(dropdownLocator);
		Select dropdown = new Select(dropdownElement);
		List<WebElement> options = dropdown.getOptions();

		for (WebElement option : options) {
			String optionText = option.getText().trim();
			if (optionText.isEmpty())
				continue;

			dropdown.selectByVisibleText(optionText);
			System.out.println("Selected filter: " + optionText);

			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			List<WebElement> tableRows = driver.findElements(By.xpath("//table//tbody/tr"));
			if (tableRows.isEmpty()) {
				System.out.println("No data found for filter: " + optionText);
			} else {
				System.out.println("Found " + tableRows.size() + " rows for filter: " + optionText);
			}

			try {
				WebElement firstRowText = tableRows.get(0).findElement(By.xpath("./td[1]"));
				System.out.println("Sample result: " + firstRowText.getText());
			} catch (Exception e) {
				System.out.println("Could not read row data for filter: " + optionText);
			}
		}
	}

	public static void Searchclient(String Clientname, By Locator1) throws InterruptedException {

		WebElement searchBox = driver.findElement(By.id("txtSearch"));
		searchBox.sendKeys(Clientname);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement firstSuggestion = driver.findElement(Locator1);
		js.executeScript("arguments[0].click();", firstSuggestion);
	}

	public static WebElement waitUntilClickable(WebDriverWait wait, By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static WebElement waitUntilClickable(WebDriverWait wait, WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitUntilVisible(WebDriverWait wait, WebElement element) {
		return wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static WebElement waitUntilVisible(WebDriverWait wait, By locator) {
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}

	public static void handleAddressPopup(WebDriver driver, String choice) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		try {
			By saveBtn = By.xpath("//button[contains(text(),'Save')]");
			By noThanksBtn = By.xpath("//button[contains(text(),'No Thanks')]");

			if (choice.equalsIgnoreCase("save")) {
				WebElement save = wait.until(ExpectedConditions.elementToBeClickable(saveBtn));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", save);
				System.out.println("Clicked on 'Save' in address popup.");
			} else if (choice.equalsIgnoreCase("no")) {
				WebElement noThanks = wait.until(ExpectedConditions.elementToBeClickable(noThanksBtn));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", noThanks);
				System.out.println("Clicked on 'No Thanks' in address popup.");
			} else {
				System.out.println("Invalid option for address popup: " + choice);
			}
		} catch (Exception e) {
			System.out.println("Address popup did not appear or elements not found: " + e.getMessage());
		}
	}

	public static String getText(By locator) {
		try {
			WebElement element = getDriver().findElement(locator);
			return element.getText().trim();
		} catch (Exception e) {
			System.err.println("Unable to get text from: " + locator + " - " + e.getMessage());
			return "";
		}
	}
	
	//Safe Click 
	
	public static boolean safeClick(By locator, int timeoutInSeconds) {
	    WebDriver driver = getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

	    int attempts = 0;
	    while (attempts < 5) {
	        try {
	           
	            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	            wait.until(ExpectedConditions.visibilityOf(element));
	            wait.until(ExpectedConditions.elementToBeClickable(element));

	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	            try {
	                element.click();
	            } catch (ElementClickInterceptedException e) {
	                ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
	            }

	            return true; 
	        } catch (StaleElementReferenceException | NoSuchElementException e) {
	            System.out.println("Retry due to stale or not found: " + e.getMessage());
	        } catch (TimeoutException e) {
	            System.out.println("Timeout waiting for element: " + locator);
	            return false;
	        } catch (Exception e) {
	            System.out.println("Unexpected error while clicking: " + e.getMessage());
	        }

	        attempts++;
	        try {
	            Thread.sleep(1000); 
	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    return false;
	}
	
	// send keys
	
	public static boolean safeSendKeys(By locator, String text, int timeoutInSeconds) {
	    WebDriver driver = getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    int attempts = 0;

	    while (attempts < 5) {
	        try {
	            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	            wait.until(ExpectedConditions.visibilityOf(element));
	            wait.until(ExpectedConditions.elementToBeClickable(element));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

	            element.clear();
	            element.sendKeys(text);
	            return true;
	        } catch (StaleElementReferenceException | NoSuchElementException e) {
	            System.out.println("Retrying sendKeys due to stale/no element: " + e.getMessage());
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Intercepted, retrying sendKeys: " + e.getMessage());
	        } catch (TimeoutException e) {
	            System.out.println("Timeout waiting for input field: " + locator);
	            return false;
	        } catch (Exception e) {
	            System.out.println("Unexpected sendKeys error: " + e.getMessage());
	        }

	        attempts++;
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException ie) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    return false;
	}

	//DropDown
	
	public static boolean safeSelectByVisibleText(By locator, String visibleText, int timeoutInSeconds) {
	    WebDriver driver = getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    int attempts = 0;

	    while (attempts < 5) {
	        try {
	            WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	            wait.until(ExpectedConditions.elementToBeClickable(dropdown));
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);

	            Select select = new Select(dropdown);
	            select.selectByVisibleText(visibleText);
	            return true;
	        } catch (StaleElementReferenceException | NoSuchElementException e) {
	            System.out.println("Retry dropdown select: " + e.getMessage());
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Dropdown intercepted, retrying...");
	        } catch (TimeoutException e) {
	            System.out.println("Timeout selecting dropdown option: " + visibleText);
	            return false;
	        } catch (Exception e) {
	            System.out.println("Unexpected dropdown issue: " + e.getMessage());
	        }

	        attempts++;
	        try {
	            Thread.sleep(1000);
	        } catch (InterruptedException ie) {
	            Thread.currentThread().interrupt();
	        }
	    }

	    return false;
	}
//Verifying text
	
	public static boolean waitForTextPresent(By locator, String expectedText, int timeoutInSeconds) {
	    WebDriver driver = getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));

	    try {
	        return wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, expectedText));
	    } catch (TimeoutException e) {
	        System.out.println("Text not found in time: " + expectedText);
	        return false;
	    }
	}

	
	public static void waitForLoaderToDisappear(By loaderLocator) {
	    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(loaderLocator));
	}

//	safeClick(By.id("submitBtn"), 10);
//	safeSendKeys(By.id("username"), "admin", 10);
//	safeSelectByVisibleText(By.id("countryDropdown"), "India", 10);
//	waitForTextPresent(By.xpath("//div[@class='toast']"), "Saved successfully", 5);
//	waitForLoaderToDisappear(By.id("loadingOverlay"));



}
