package com.Capium.Actions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Locators.Capium_Bookkeeping_FixedAssets_Locators;
import com.Capium.Utilies.HelperClass;


public class Capium_Bookkeeping_FixedAssets_Actions {

Capium_Bookkeeping_FixedAssets_Locators FixedAssestLocators = null;
	
	public Capium_Bookkeeping_FixedAssets_Actions() {
		this.FixedAssestLocators = new Capium_Bookkeeping_FixedAssets_Locators();
		PageFactory.initElements(HelperClass.getDriver(), FixedAssestLocators);
	}
	
     WebDriverWait wait=HelperClass.getWait();
	public void Clickonfixedassestsvalidatefixedassestspage() throws InterruptedException {
	
	
		FixedAssestLocators.clickFixedAsset.click();
 
		String actualtext = HelperClass.getText(By.xpath("//h1[text()='Fixed Assets']"));
 
		String expected = "Fixed Assets";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickonaddfixedassestsandverifypurchasepage() throws InterruptedException {
		Thread.sleep(2000);
		FixedAssestLocators.addFixedAsset.click();
		Thread.sleep(2000);
 
		String actualtext = HelperClass.getText(By.xpath("//h1[text()='Create New Purchase']"));
		String expected = "Create New Purchase";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickaddfixedassestsandaddtangbleassestinpurchase() throws InterruptedException {
 
		FixedAssestLocators.addFixedAsset.click();
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-plus azure']"));
		HelperClass.sendKeys(By.xpath("//input[@id='txtCName']"), "Supplierfortangble");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//i[@class='fa fa-save'])[3]"));
		Thread.sleep(2000);
		FixedAssestLocators.enterDescription.sendKeys("des1");
		HelperClass.setValueUsingJS(By.xpath("(//input[@type='text'])[5]"), "1000");
		HelperClass.sendKeys(By.xpath("(//input[@type='text'])[7]"), "4100");
		HelperClass.selectOptionByValue(By.xpath("//select[@name='Items[1].F_TaxCodeMaster']"), "5");
		FixedAssestLocators.clickSaveandClose.click();
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//span[@class='menu-text'])[6]"));
 
		String actualtext = HelperClass.getTitile(By.xpath("//div[@title='Fixtures & Fittings - Cost b/fwd']"));
		String expected = "Other Intangible - Additions Cost";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickaddfixedassestsandaddintangbleassestinpurchase() throws InterruptedException {
 
		FixedAssestLocators.addFixedAsset.click();
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-plus azure']"));
		HelperClass.sendKeys(By.xpath("//input[@id='txtCName']"), "Supplierforintangble");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//i[@class='fa fa-save'])[3]"));
		Thread.sleep(2000);
		FixedAssestLocators.enterDescription.sendKeys("des2");
		HelperClass.setValueUsingJS(By.xpath("(//input[@type='text'])[5]"), "1000");
		HelperClass.sendKeys(By.xpath("(//input[@type='text'])[7]"), "4031");
		HelperClass.selectOptionByValue(By.xpath("//select[@name='Items[1].F_TaxCodeMaster']"), "5");
		FixedAssestLocators.clickSaveandClose.click();
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//span[@class='menu-text'])[6]"));
 
		String actualtext = HelperClass.getText(By.xpath("//div[@class='hideoverflow danger']"));
		String expected = "Other Intangible - Additions Cost";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickaddfixedassestsandaddleasedassestinpurchase() throws InterruptedException {
 
		FixedAssestLocators.addFixedAsset.click();
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-plus azure']"));
		HelperClass.sendKeys(By.xpath("//input[@id='txtCName']"), "Supplierforleased");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//i[@class='fa fa-save'])[3]"));
		Thread.sleep(2000);
		FixedAssestLocators.enterDescription.sendKeys("des3");
		HelperClass.setValueUsingJS(By.xpath("(//input[@type='text'])[5]"), "1000");
		HelperClass.sendKeys(By.xpath("(//input[@type='text'])[7]"), "4130");
		HelperClass.selectOptionByValue(By.xpath("//select[@name='Items[1].F_TaxCodeMaster']"), "5");
		FixedAssestLocators.clickSaveandClose.click();
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//span[@class='menu-text'])[6]"));
 
		String actualtext = HelperClass.getText(By.xpath("//div[@class='hideoverflow danger']"));
		String expected = "Land & Buildings Leased - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickoneditandexplaininactiondropdownfortangible() throws InterruptedException {
 
		HelperClass.selectOptionByValue(By.xpath("(//select[@class='fa-action input-xs text-center'])[1]"), "edit");
		HelperClass.sendKeys(By.xpath("//input[@id='fa-edit-rate']"), "10");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-save']"));
		Thread.sleep(2000);
 
		String actualtext = HelperClass.getText(By.xpath("//div[@class='hideoverflow ']"));
		String expected = "Land & Buildings Leased - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickonsellinactiondropdownfortangible() throws InterruptedException {
 
		HelperClass.selectOptionByValue(By.xpath("(//select[@class='fa-action input-xs text-center'])[1]"), "sell");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//li[@class='active'])[4]"));
 
		HelperClass.setValueUsingJS(By.xpath("//input[@name='Price']"), "1000");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//button[@type='button'])[4]"));
		Thread.sleep(2000);
		FixedAssestLocators.clickDisposed.click();
		String actualtext = HelperClass.getTitile(By.xpath("//div[@title='Fixtures & Fittings - Cost b/fwd']"));
		String expected = "Fixtures & Fittings - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickonactivatesellaseestinactiondropdownfortangible() {
 
		FixedAssestLocators.clickDisposed.click();
		HelperClass.selectOptionByValue(By.xpath("(//select[@class='fa-action-disposed input-xs text-center'])[1]"),
				"activate");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-check']"));
		String actualtext = HelperClass.getTitile(By.xpath("//div[@title='Fixtures & Fittings - Cost b/fwd']"));
		String expected = "Fixtures & Fittings - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickondisposedinactiondropdownfortangible() throws InterruptedException {
 
		HelperClass.selectOptionByValue(By.xpath("(//select[@class='fa-action input-xs text-center'])[1]"), "dispose");
		Thread.sleep(2000);
		FixedAssestLocators.clickDisposedsave.click();
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-save']"));
		Thread.sleep(2000);
 
		String actualtext = HelperClass.getText(By.xpath("//div[@class='hideoverflow ']"));
		String expected = "Land & Buildings Leased - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickonactivatedisposedactiondropdownfortangible() {
 
		FixedAssestLocators.clickDisposed.click();
		HelperClass.selectOptionByValue(By.xpath("(//select[@class='fa-action-disposed input-xs text-center'])[1]"),
				"activate");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-check']"));
		String actualtext = HelperClass.getTitile(By.xpath("//div[@title='Fixtures & Fittings - Cost b/fwd']"));
		String expected = "Fixtures & Fittings - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickondepreciationandverifydepreciatefortangible() throws InterruptedException {
 
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//a[text()='Depreciation']"));
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//input[@id='chkfixed']"));
 
	}
 
	public void Clickoneditandexplaininationropdownforintangible() throws InterruptedException {
 
	wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Select2']")));
		HelperClass.selectOptionByValue(By.xpath("//select[@id='Select2']"), "edit");
		HelperClass.sendKeys(By.xpath("//input[@id='fa-edit-rate']"), "10");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//button[normalize-space()='Save']"));
		Thread.sleep(2000);
 
		String actualtext = HelperClass.getText(By.xpath("(//div[@class='hideoverflow '])[2]"));
		String expected = "Other Intangible - Additions Cost";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
 
	}
 
	public void Clickondisposedinactiondropdownforintangble() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Select2']")));
		HelperClass.selectOptionByValue(By.xpath("//select[@id='Select2']"), "dispose");
		Thread.sleep(2000);
		FixedAssestLocators.clickDisposedsave.click();
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-save']"));
		Thread.sleep(2000);
 
		String actualtext = HelperClass.getText(By.xpath("(//div[@class='hideoverflow '])[2]"));
		String expected = "Other Intangible - Additions Cost";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickonactivatedisposedactiondropdownforintangble() {
 
		FixedAssestLocators.clickDisposed.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@class='fa-action-disposed input-xs text-center'])[1]")));
		HelperClass.selectOptionByValue(By.xpath("(//select[@class='fa-action-disposed input-xs text-center'])[1]"),
				"activate");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//button[normalize-space()='Ok']"));
//		String actualtext = HelperClass.getTitile(By.xpath("//div[@title='Other Intangible - Additions Cost']"));
//		String expected = "Other Intangible - Additions Cost";
//
//		if (actualtext == expected) {
//
//			System.out.println("Verified");
//		} else {
//			System.out.println("Not Matched");
//		}
	}
 
	public void Clickoneditandexplaininactiondropdownforleased() throws InterruptedException {
		String supplierName = "Supplierforleased";
 
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Asset']")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Asset']")));
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//a[normalize-space()='Asset']"));
		Thread.sleep(2000);
 
 
		Select supplierDropdown = new Select(HelperClass.getDriver().findElement(By.id("cboCustomer")));
 
		boolean supplierExists = false;
		for (WebElement option : supplierDropdown.getOptions()) {
		    if (option.getText().trim().equalsIgnoreCase(supplierName)) {
		        supplierExists = true;
		        break;
		    }
		}
 
		if (supplierExists) {
		   
		    supplierDropdown.selectByVisibleText(supplierName);
		    System.out.println("Existing supplier selected: " + supplierName);
		} else {
		    // Create new supplier
		    HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//button[@class='btn btn-default']"));
		    Thread.sleep(1000); // Wait for modal/input to appear
 
		    HelperClass.sendKeys(By.xpath("//input[@id='txtCName']"), supplierName);
		    HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//i[@class='fa fa-save'])[3]"));
		    Thread.sleep(2000); // Wait for save to complete and dropdown to refresh
 
		    // Re-check the dropdown to select newly created supplier
		    supplierDropdown = new Select(HelperClass.getDriver().findElement(By.id("cboCustomer")));
		    supplierDropdown.selectByVisibleText(supplierName);
		    System.out.println("New supplier created and selected: " + supplierName);
		}
 
		FixedAssestLocators.enterDescription.sendKeys("des3");
		HelperClass.setValueUsingJS(By.xpath("(//input[@type='text'])[5]"), "1000");
		HelperClass.sendKeys(By.xpath("(//input[@type='text'])[7]"), "4130");
		HelperClass.selectOptionByValue(By.xpath("//select[@name='Items[1].F_TaxCodeMaster']"), "5");
		FixedAssestLocators.clickSaveandClose.click();
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//span[@class='menu-text'])[6]"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@class='fa-action input-xs text-center'])[2]")));
		HelperClass.selectOptionByValue(By.xpath("(//select[@class='fa-action input-xs text-center'])[2]"), "edit");
		HelperClass.sendKeys(By.xpath("//input[@id='fa-edit-rate']"), "10");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-save']"));
		Thread.sleep(2000);
 
		String actualtext = HelperClass.getText(By.xpath("//div[@class='hideoverflow ']"));
		String expected = "Land & Buildings Leased - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickonsellinactiondropdownforleased() throws InterruptedException {
		
		HelperClass.selectOptionByValue(By.xpath("(//select[@class='fa-action input-xs text-center'])[2]"), "sell");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//li[@class='active'])[4]"));
 
		HelperClass.setValueUsingJS(By.xpath("//input[@name='Price']"), "1000");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//button[@type='button'])[4]"));
		Thread.sleep(2000);
		FixedAssestLocators.clickDisposed.click();
		String actualtext = HelperClass.getTitile(By.xpath("//div[@title='Land & Buildings Leased - Cost b/fwd']"));
		String expected = "Land & Buildings Leased - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickonactivatesellaseestinactiondropdownforleased() {
 
		FixedAssestLocators.clickDisposed.click();
		HelperClass.selectOptionByValue(By.xpath("(//select[@class='fa-action-disposed input-xs text-center'])[1]"),
				"activate");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-check']"));
		String actualtext = HelperClass.getTitile(By.xpath("//div[@title='Land & Buildings Leased - Cost b/fwd']"));
		String expected = "Land & Buildings Leased - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickondisposedinactiondropdownforleased() throws InterruptedException {
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='Select1']")));
		HelperClass.selectOptionByValue(By.xpath("//select[@id='Select1']"), "dispose");
		Thread.sleep(2000);
		FixedAssestLocators.clickDisposedsave.click();
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-save']"));
		Thread.sleep(2000);
 
		String actualtext = HelperClass.getText(By.xpath("//div[@class='hideoverflow ']"));
		String expected = "Land & Buildings Leased - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
 
	public void Clickonactivatedisposedactiondropdownforleased() {
 
		FixedAssestLocators.clickDisposed.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@class='fa-action-disposed input-xs text-center']")));
		HelperClass.selectOptionByValue(By.xpath("//select[@class='fa-action-disposed input-xs text-center']"),
				"activate");
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-check']"));
 
		String actualtext = HelperClass.getTitile(By.xpath("//div[@title='Land & Buildings Leased - Cost b/fwd"));
		String expected = "Land & Buildings Leased - Cost b/fwd";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
 
	}
 
	public void Clickondepreciationandverifydepreciate() throws InterruptedException {
 
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//a[text()='Depreciation']"));
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//input[@id='chkfixed']"));
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("(//button[@type='button'])[4]"));
 
		String actualtext = HelperClass.getTitile(By.xpath("//a[text()='Rollback']"));
		String expected = "Rollback";
 
		if (actualtext == expected) {
 
			System.out.println("Verified");
		} else {
			System.out.println("Not Matched");
		}
	}
}
