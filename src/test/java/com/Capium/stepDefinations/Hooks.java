package com.Capium.stepDefinations;

import com.Capium.Actions.Capium_Login_Actions;
import com.Capium.Utilies.HelperClass;
import com.Capium.Utilies.Log;
import com.Capium.Utilies.StepTracker;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.service.ExtentService;
import io.cucumber.java.*;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Hooks {

	private static ExtentReports extent = ExtentService.getInstance();
	private static ExtentTest scenarioTest;
	
	@BeforeAll
	public static void setup() {
		HelperClass.setUpDriver();
		Log.info("Driver setup successfully");
		System.out.println("Starting the Test Execution...");

	}

	@Before
	public void beforeScenario(Scenario scenario) {
		scenarioTest = extent.createTest("Scenario: " + scenario.getName());
		System.out.println("Starting Scenario: " + scenario.getName());
		Log.info("Scenario:" + scenario.getName());
	}


	@AfterStep
	public void afterStep(Scenario scenario) {
		WebDriver driver = HelperClass.getDriver();
		String stepName = StepTracker.getCurrentStep();

		if (stepName == null || stepName.isEmpty()) {
			stepName = "Unnamed Step";
		}

		String base64Screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

		if (scenario.isFailed()) {
			scenario.attach(Base64.getDecoder().decode(base64Screenshot), "image/png", stepName);
			Hooks.scenarioTest.log(Status.FAIL, stepName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
		} else {
			Hooks.scenarioTest.log(Status.PASS, stepName,
					MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
		}
	}

	@After
	public void afterScenario(Scenario scenario) {
		WebDriver driver = HelperClass.getDriver();
		WebDriverWait wait = HelperClass.getWait();

		try {
			if (scenario.isFailed()) {
				scenarioTest.log(Status.FAIL, "Scenario Failed.");
				Log.info("Scenario Failed.");
			} else {
				scenarioTest.log(Status.PASS, "Scenario Passed.");
				Log.info("Scenario Passed.");
			}

//			By powerOffIcon = By.xpath("//i[@class='icon fa fa-power-off']");
//			By profileIcon = By.xpath("//div[@class='profile-logo']//label");
//			By logoutLink = By.xpath("//a[normalize-space()='Logout']");
//			By loginPageIdentifier = By.xpath("//div[normalize-space()='Sign In']");
//			By fivePointProfileIcon = By.xpath("(//a[@aria-haspopup='menu'])[3]");
//			By fivePointSignOut = By.xpath("//a[normalize-space()='Sign Out']");
//            // 3.0 logout
//			if (HelperClass.isElementPresent(powerOffIcon)) {
//				WebElement powerOff = wait.until(ExpectedConditions.elementToBeClickable(powerOffIcon));
//				HelperClass.scrollIntoView(powerOff);
//				try {
//					powerOff.click();
//				} catch (ElementClickInterceptedException e) {
//					((JavascriptExecutor) driver).executeScript("arguments[0].click();", powerOff);
//				}
//				Log.info("Clicked power-off icon for logout.");
//			}
//             // home page logout
//			else if (HelperClass.isElementPresent(profileIcon)) {
//				WebElement profile = wait.until(ExpectedConditions.elementToBeClickable(profileIcon));
//				HelperClass.scrollIntoView(profile);
//				try {
//					profile.click();
//				} catch (ElementClickInterceptedException e) {
//					((JavascriptExecutor) driver).executeScript("arguments[0].click();", profile);
//				}
//				Log.info("Clicked profile icon.");
//
//				if (HelperClass.isElementPresent(logoutLink)) {
//					WebElement logout = wait.until(ExpectedConditions.elementToBeClickable(logoutLink));
//					HelperClass.scrollIntoView(logout);
//					try {
//						logout.click();
//					} catch (ElementClickInterceptedException e) {
//						((JavascriptExecutor) driver).executeScript("arguments[0].click();", logout);
//					}
//					Log.info("Clicked logout link.");
//				}
//			}
//			// 5.0 Logout
//			else if (HelperClass.isElementPresent(fivePointProfileIcon)) {
//				WebElement fivePointIcon = wait.until(ExpectedConditions.elementToBeClickable(fivePointProfileIcon));
//				HelperClass.scrollIntoView(fivePointIcon);
//				try {
//					fivePointIcon.click();
//				} catch (ElementClickInterceptedException e) {
//					((JavascriptExecutor) driver).executeScript("arguments[0].click();", fivePointIcon);
//				}
//				Log.info("Clicked 5.0 Profile Icon.");
//
//				if (HelperClass.isElementPresent(fivePointSignOut)) {
//					WebElement fiveSignOut = wait.until(ExpectedConditions.elementToBeClickable(fivePointSignOut));
//					HelperClass.scrollIntoView(fiveSignOut);
//					try {
//						fiveSignOut.click();
//					} catch (ElementClickInterceptedException e) {
//						((JavascriptExecutor) driver).executeScript("arguments[0].click();", fiveSignOut);
//					}
//					Log.info("Clicked 5.0 Sign Out.");
//				}
//			}
//
//			wait.until(ExpectedConditions.visibilityOfElementLocated(loginPageIdentifier));
//			Log.info("Logout successful. Redirected to login page.");
//
//		} 
			Capium_Login_Actions loginPage = PageFactory.initElements(driver, Capium_Login_Actions.class);
	        loginPage.Logout(); 

	        wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.xpath("//div[normalize-space()='Sign In']")));
	        Log.info("Successfully logged out and redirected to login page.");
		}
			catch (Exception e) {
			Log.error("Logout failed: " + e.getMessage());
			System.out.println("Logout failed: " + e.getMessage());
		}
	}

	@AfterAll
	public static void tearDown() {
		System.out.println("Ending Test Execution...");
		try {
			HelperClass.tearDown(); // close browser
			Log.info("Browser closed.");
		} catch (Exception e) {
			Log.error("Error during browser teardown: " + e.getMessage());
		}

		try {
			extent.flush(); // flush report
			System.out.println("Extent report flushed.");
		} catch (Exception e) {
			System.out.println("Error flushing extent report: " + e.getMessage());
		}
	}

	private static String timestamp() {
		return new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
	}

	public static ExtentTest getScenarioTest() {
		return scenarioTest;
	}

	public static void captureScreenshotBase64(WebDriver driver, ExtentTest scenarioTest, String message) {
		try {
			TakesScreenshot ts = (TakesScreenshot) driver;
			String base64Screenshot = ts.getScreenshotAs(OutputType.BASE64);

			scenarioTest.log(Status.INFO, "Screenshot: " + message,
					MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());

			Log.info("Successfully captured screenshot: " + message);

		} catch (Exception e) {
			Log.error("Failed to capture screenshot: " + message + " | Error: " + e.getMessage());
		}
	}

	private String getStepNameFromStackTrace() {
		for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
			String methodName = element.getMethodName();

			// Find your step definition package
			if (element.getClassName().contains("com.Capium.stepDefinations")) {
				return methodName.replace("_", " ");
			}
		}
		return null;
	}

	private String getCurrentStepName(Scenario scenario) {
		try {
			for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
				if (element.getClassName().contains("StepDefinitions")) {
					return element.getMethodName(); 
				}
			}
		} catch (Exception e) {
		
		}
		return null;
	}

	private static Map<String, Object> scenarioContext = new HashMap<>();

	public static void setScenarioContext(String key, Object value) {
		scenarioContext.put(key, value);
	}

	public static Object getScenarioContext(String key) {
		return scenarioContext.get(key);
	}

	public static void clearScenarioContext() {
		scenarioContext.clear();
	}

}
