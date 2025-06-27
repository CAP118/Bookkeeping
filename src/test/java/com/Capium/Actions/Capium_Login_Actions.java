package com.Capium.Actions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Locators.Capium_Login_Locators;
import com.Capium.Utilies.HelperClass;
import com.Capium.Utilies.Log;

public class Capium_Login_Actions {

	Capium_Login_Locators loginLocators = null;

	public Capium_Login_Actions() {
		this.loginLocators = new Capium_Login_Locators();
		PageFactory.initElements(HelperClass.getDriver(), loginLocators);
	}

	public void EnterUsername(String username) {
		loginLocators.inputUsername.clear();
		loginLocators.inputUsername.sendKeys(username);

	}

	public void EnterPassword(String password) {
		loginLocators.inputPassword.clear();
		loginLocators.inputPassword.sendKeys(password);
	}

	public void ClickLoginbtn() throws Exception {
		loginLocators.btnLogin.click();
		Thread.sleep(5000);
	}

	public boolean isHomePage() {
		try {
			return loginLocators.Homepage_Element.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}

	public void Navigate_to_bookkeeping_module() {

		try {
			boolean clicked = false;

			try {
				if (loginLocators.Homepage_BK_module != null && loginLocators.Homepage_BK_module.isDisplayed()) {
					loginLocators.Homepage_BK_module.click();
					System.out.println("Navigated to Bookkeeping module from Homepage.");
					clicked = true;
				}
			} catch (Exception e) {
				System.out.println("Homepage bookkeeping module not available or not visible.");
			}

			if (!clicked) {
				try {
					if (loginLocators.C_icon_inside_modules != null
							&& loginLocators.C_icon_inside_modules.isDisplayed()) {
						loginLocators.C_icon_inside_modules.click();
						Thread.sleep(500); 

						if (loginLocators.Bookkeeping_Module != null
								&& loginLocators.Bookkeeping_Module.isDisplayed()) {
							loginLocators.Bookkeeping_Module.click();
							System.out.println("Navigated to Bookkeeping module from inside module.");
							clicked = true;
						}
					}
				} catch (Exception e) {
					System.out.println("Could not click C icon or bookkeeping inside module.");
				}
			}

			if (!clicked) {
				System.err.println("Bookkeeping module not found in either location.");
			}

		} catch (Exception e) {
			System.err.println("Error navigating to Bookkeeping module: " + e.getMessage());
			e.printStackTrace();
		}

	}

//	public void navigateToCapium365Module() {
//	    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(3));
//
//	    try {
//	        if (isElementVisible(loginLocators.Capiuum365_Module, wait)) {
//	            loginLocators.Capiuum365_Module.click();
//	            System.out.println("Navigated to Capium365 module from Homepage.");
//	            return;
//	        }
//
//	        if (isElementVisible(loginLocators.CiconFivepoint_o, wait)) {
//	            loginLocators.CiconFivepoint_o.click();
//	            Thread.sleep(2000);
//	            wait.until(ExpectedConditions.visibilityOf(loginLocators.InsideCicon5_0_365Module));
//
//	            if (isElementVisible(loginLocators.InsideCicon5_0_365Module, wait)) {
//	                loginLocators.InsideCicon5_0_365Module.click();
//	                System.out.println("Navigated to Capium365 module from inside 5.0 module.");
//	                return;
//	            }
//	        }
//
//	        if (isElementVisible(loginLocators.C_icon_inside_modules, wait)) {
//	            loginLocators.C_icon_inside_modules.click();
//	            Thread.sleep(2000);
//	            wait.until(ExpectedConditions.visibilityOf(loginLocators.insideCicon3_0_365Module));
//
//	            if (isElementVisible(loginLocators.insideCicon3_0_365Module, wait)) {
//	                loginLocators.insideCicon3_0_365Module.click();
//	                System.out.println("Navigated to Capium365 module from inside 3.0 module.");
//	                return;
//	            }
//	        }
//
//	        System.out.println("Capium365 module could not be found in any known location.");
//
//	    } catch (Exception e) {
//	        System.out.println("Error while navigating to Capium365 module.");
//	        e.printStackTrace();
//	    }
//	}


//	public void Logout() {
//	    WebDriver driver = HelperClass.getDriver();
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30)); // More time for slow modules
//
//	    try {
//	        if (loginLocators.Logout_element != null && loginLocators.Logout_element.isDisplayed()) {
//	            loginLocators.Logout_element.click();
//	            Log.info("Clicked logout element directly.");
//	        }
//
//	        else if (loginLocators.Logo_in_homepage != null && loginLocators.Logo_in_homepage.isDisplayed()) {
//	            loginLocators.Logo_in_homepage.click();
//	            Log.info("Clicked homepage logo.");
//	            wait.until(ExpectedConditions.elementToBeClickable(loginLocators.Logout_inside_logo)).click();
//	            Log.info("Clicked logout inside homepage logo.");
//	        }
//
//	        else if (loginLocators.FivePointProfileIcon != null && loginLocators.FivePointProfileIcon.isDisplayed()) {
//	            wait.until(ExpectedConditions.elementToBeClickable(loginLocators.FivePointProfileIcon)).click();
//	            Log.info("Clicked 5.0 profile icon.");
//	            wait.until(ExpectedConditions.elementToBeClickable(loginLocators.SignoutFivePointZero)).click();
//	            Log.info("Clicked Sign Out in 5.0 module.");
//	        }
//
//	        wait.until(ExpectedConditions.or(
//	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Sign In']")),  
//	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Accountant Login']"))  
//	        ));
//
//	        Log.info("Logout successful. Redirected to login page (3.0 or 5.0).");
//
//	    } catch (Exception e) {
//	        Log.error("Logout failed: " + e.getMessage());
//	        System.out.println("Logout failed: " + e.getMessage());
//	    }
//	}
//

	public void Logout() {
	    WebDriver driver = HelperClass.getDriver();
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40)); // extended wait for slow modules

	    try {
	        // CASE 1: 5.0 Module Logout
	        if (loginLocators.FivePointProfileIcon != null && loginLocators.FivePointProfileIcon.isDisplayed()) {
	            wait.until(ExpectedConditions.elementToBeClickable(loginLocators.FivePointProfileIcon)).click();
	            Log.info("Clicked 5.0 Profile Icon.");

	            if (loginLocators.SignoutFivePointZero != null && loginLocators.SignoutFivePointZero.isDisplayed()) {
	                wait.until(ExpectedConditions.elementToBeClickable(loginLocators.SignoutFivePointZero)).click();
	                Log.info("Clicked 5.0 Sign Out.");
	            }
	        }

	        //CASE 2: Homepage → Logo → Logout
	        else if (loginLocators.Logo_in_homepage != null && loginLocators.Logo_in_homepage.isDisplayed()) {
	            loginLocators.Logo_in_homepage.click();
	            Log.info("Clicked homepage logo.");

	            if (loginLocators.Logout_inside_logo != null && loginLocators.Logout_inside_logo.isDisplayed()) {
	                wait.until(ExpectedConditions.elementToBeClickable(loginLocators.Logout_inside_logo)).click();
	                Log.info("Clicked logout inside logo.");
	            }
	        }

	        //CASE 3: Direct Logout Element (e.g., power icon)
	        else if (loginLocators.Logout_element != null && loginLocators.Logout_element.isDisplayed()) {
	            wait.until(ExpectedConditions.elementToBeClickable(loginLocators.Logout_element)).click();
	            Log.info("Clicked direct logout element.");
	        }

	        //Wait for either login page to appear (3.0 or 5.0)
	        wait.until(ExpectedConditions.or(
	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[normalize-space()='Sign In']")), // 3.0 login
	            ExpectedConditions.visibilityOfElementLocated(By.xpath("//h6[normalize-space()='Accountant Login']")) // 5.0 login
	        ));
	        Log.info("Successfully redirected to login page after logout.");

	    } catch (Exception e) {
	        Log.error("Logout failed: " + e.getMessage());
	        System.out.println("Logout failed: " + e.getMessage());
	    }
	}

	
	public boolean isElementVisible(WebElement element, WebDriverWait wait) {
	    try {
	        wait.until(ExpectedConditions.visibilityOf(element));
	        return element.isDisplayed();
	    } catch (Exception e) {
	        return false;
	    }
	}

}