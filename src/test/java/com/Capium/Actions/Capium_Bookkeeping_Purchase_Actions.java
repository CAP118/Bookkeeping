package com.Capium.Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.Capium.Locators.Capium_Bookkeeping_Purchase_Locators;
import com.Capium.Utilies.ExcelUtils;
import com.Capium.Utilies.HelperClass;
import com.Capium.Utilies.Log;
import com.Capium.stepDefinations.Hooks;

public class Capium_Bookkeeping_Purchase_Actions {

	Capium_Bookkeeping_Purchase_Locators purchase_L = null;

	public Capium_Bookkeeping_Purchase_Actions() {
		this.purchase_L = new Capium_Bookkeeping_Purchase_Locators();
		PageFactory.initElements(HelperClass.getDriver(), purchase_L);
	}

	private static int supplierCounter = 1;

	WebDriverWait wait = HelperClass.getWait();
	WebDriver driver = HelperClass.getDriver();

	String filepath = "D:\\Core Modules\\Capium_BK_3.0\\src\\test\\resources\\Files\\File uploading in purchase invoice.pdf";
	String Filepath = "D:\\Core Modules\\Capium_BK_3.0\\src\\test\\resources\\Files\\ClientCreationData.xlsx";
	String path = "D:\\Autoit\\FileUpload.exe";

	public static By PurchaseLocator = By.xpath("//span[normalize-space()='Purchase']");
	public static By PurchaseDashboard = By.xpath("//a[@href='/bookkeeping/purchases/default.aspx']");

	//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	public void click_purchase_btn() {
	    wait.until(ExpectedConditions.visibilityOf(purchase_L.Purchase_btn));
	    wait.until(ExpectedConditions.elementToBeClickable(purchase_L.Purchase_btn));
	    purchase_L.Purchase_btn.click();
	}

	public void click_purchase_dashboard() {
	    wait.until(ExpectedConditions.visibilityOf(purchase_L.Purchase_dashboard));
	    wait.until(ExpectedConditions.elementToBeClickable(purchase_L.Purchase_dashboard));
	    purchase_L.Purchase_dashboard.click();
	}

	public void openPurchaseDashboard() {
		WebDriverWait wait = HelperClass.getWait();

		try {
			WebElement dashboard = wait.until(ExpectedConditions.elementToBeClickable(PurchaseDashboard));
			System.out.println("Purchase Dashboard is already visible.");
			dashboard.click();
		} catch (TimeoutException e) {
			System.out.println("Purchase Dashboard not visible. Clicking Purchase button...");

			try {
				WebElement purchaseBtn = wait.until(ExpectedConditions.elementToBeClickable(PurchaseLocator));
				purchaseBtn.click();

				WebElement dashboardAfterClick = wait.until(ExpectedConditions.elementToBeClickable(PurchaseDashboard));
				dashboardAfterClick.click();
			} catch (Exception ex) {
				System.out.println("Failed to open Purchase Dashboard after clicking Purchase.");
				ex.printStackTrace();
			}
		}
	}

	public void ClickOnPurchases() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	    wait.until(ExpectedConditions.elementToBeClickable(purchase_L.RedirectToPurchase));

	    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", purchase_L.RedirectToPurchase);

	    try {
	        purchase_L.RedirectToPurchase.click();
	    } catch (ElementClickInterceptedException e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", purchase_L.RedirectToPurchase);
	    }

	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@type='button']"))); 
	}


	public void click_add_purchases_btn() {
		purchase_L.Purchase_Addbtn.click();
	}

	public void ClickSupplierButton() {
		purchase_L.ClickSupplierButton.click();
	}

	public void click_AddSuplier_btn() {
		purchase_L.Suplier_Addbtn.click();
	}

	public void Enter_suplier_name() throws InterruptedException {
		String supplierName = "o_" + supplierCounter++; // e.g., o_1, o_2, ...
		Thread.sleep(3000);
		purchase_L.enter_Suplier_name.sendKeys(supplierName);
		System.out.println("Supplier created: " + supplierName);
	}

	public void click_suplier_savebtn() {
		HelperClass.scrollUntilElementVisible(HelperClass.getDriver(), purchase_L.Save_Suplier);
		purchase_L.Save_Suplier.click();
	}

	public void select_purchase_type() throws InterruptedException {
		HelperClass.ClickDropdown(By.id("cboInvType"));
		Thread.sleep(1000);
	}

	public void click_date() throws InterruptedException {
		HelperClass.ClickandAnyTypeofWebelemnt(By.xpath("//input[@id='txtVDate']"));
		Thread.sleep(1000);
		HelperClass.sendKeys(By.xpath("//input[@id='txtVDate']"), "01/03/2023");
	}

	public void click_due_date() {
		HelperClass.sendKeys(By.id("txtDueDate"), "28/02/2024");
	}

	public void enter_note() {
		HelperClass.sendKeys(By.name("Note"), "Testing");
	}

	public void enter_description() throws InterruptedException {
		WebDriver driver = HelperClass.getDriver();
		Thread.sleep(3000);
		WebDriverWait wait = HelperClass.getWait();
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.Description));
		purchase_L.Description.sendKeys("test");
		Thread.sleep(1000);
		HelperClass.setValueUsingJS(By.xpath("//input[@name='Items[1].Price']"), "1000");
		Thread.sleep(1000);
		HelperClass.sendKeys(By.xpath("//input[@class='form-control input-sm AccSearch ui-autocomplete-input']"),
				"1210");
		Thread.sleep(1000);
		HelperClass.ClickDropdown(By.xpath("//select[@name='Items[1].F_TaxCodeMaster']"));
		Thread.sleep(1000);
		HelperClass.selectOptionByValue(By.name("Items[1].F_TaxCodeMaster"), "7");
		Thread.sleep(1000);
		HelperClass.ClearElement(By.xpath("//input[@name='Items[1].TaxAmount']"));
		Thread.sleep(1000);
		HelperClass.setValueUsingJS(By.xpath("//input[@name='Items[1].TaxAmount']"), "500");

	}

	public void UploadFile() throws InterruptedException, IOException {

		WebDriver driver = HelperClass.getDriver();
		WebElement spanTrigger = driver.findElement(By.xpath("//span[@class='buttonText']"));
		spanTrigger.click();
		Thread.sleep(1000);

		Runtime.getRuntime().exec(path);
		Thread.sleep(3000);
		System.out.println("File upload triggered for: " + path);
	}

	public void SaveandClose() {
		HelperClass.ClickandAnyTypeofWebelemnt(By.xpath("//button[@onclick='Invoice.Save(1)']"));
	}

	public void ClickOn_import() {
		purchase_L.ImportBtn.click();
	}

	public void ClickOn_Download() {
		purchase_L.DownloadLink.click();
	}

	public void UploadFile1() throws InterruptedException, IOException {
		String Path1 = "D:\\Autoit\\UploadCSV.exe";
		WebDriver driver = HelperClass.getDriver();
		WebElement spanTrigger = driver.findElement(By.xpath("//span[@class='buttonText']"));
		spanTrigger.click();
		Thread.sleep(2000);

		Runtime.getRuntime().exec(Path1);
		System.out.println("File upload triggered for: " + Path1);
	}

	public void ClickOnImportAfterUpload() throws InterruptedException {
		Thread.sleep(3000);
		WebDriverWait wait = HelperClass.getWait();
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ImportAfterUpload));
		purchase_L.ImportAfterUpload.click();
	}

	public void ClickOnProcessImport() {
		WebDriverWait wait = HelperClass.getWait();
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ProcessImport));
		purchase_L.ProcessImport.click();

	}

	public void ClickCheckbox() {
		WebDriverWait wait = HelperClass.getWait();
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.CheckBoxlist));
		purchase_L.CheckBoxlist.click();
	}

	public void ClickOnApprovedBtn() {
		WebDriverWait wait = HelperClass.getWait();
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ApprovedBtn));
		purchase_L.ApprovedBtn.click();
	}

	public void ConformationPopup() throws InterruptedException {
		WebDriverWait wait = HelperClass.getWait();
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ConformationPopup));
		purchase_L.ConformationPopup.click();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.SuccessPopup));
		purchase_L.SuccessPopup.click();
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnPurchase));
		purchase_L.ClickOnPurchase.click();

	}

	public void SearchandCaptureScreenshofPurchase() {
		purchase_L=PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		WebDriverWait wait = HelperClass.getWait();
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.EnterFormdate));
		purchase_L.EnterFormdate.clear();
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.SearchAfterEnterDate));
		purchase_L.SearchAfterEnterDate.click();

	}

	public void SelectPurchase() throws InterruptedException {
	    purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);

	    WebDriverWait wait = HelperClass.getWait();

	    By openPurchaseBtnLocator = By.xpath("//tbody[@role='alert']/tr[1]/td[2]/button");
	    wait.until(ExpectedConditions.presenceOfElementLocated(openPurchaseBtnLocator));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(openPurchaseBtnLocator));
	    wait.until(ExpectedConditions.elementToBeClickable(openPurchaseBtnLocator));
	    HelperClass.ClickUsingJS(driver, openPurchaseBtnLocator);
	    Thread.sleep(3000);
	    Hooks.captureScreenshotBase64(HelperClass.getDriver(), Hooks.getScenarioTest(), "purchase invoice");
	    Thread.sleep(2000);
	    By closePopupLocator = By.xpath("//button[text()='×']");
	    wait.until(ExpectedConditions.visibilityOfElementLocated(closePopupLocator));
	    wait.until(ExpectedConditions.elementToBeClickable(closePopupLocator));
	    HelperClass.ClickUsingJS(driver, closePopupLocator);
	    
	}


	public void AddSupplier() throws IOException, InterruptedException {

		WebDriverWait wait = HelperClass.getWait();
		Thread.sleep(3000);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.Purchase_dashboard));
		// HelperClass.ClickUsingJS(HelperClass.getDriver(),
		// purchase_L.Purchase_dashboard);
		purchase_L.Purchase_dashboard.click();
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickAddSupplierBtn));
		HelperClass.ClickUsingJS(HelperClass.getDriver(), purchase_L.ClickAddSupplierBtn);

		FileInputStream file = new FileInputStream(Filepath);
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Supplier");
		int rowcount = sheet.getLastRowNum();
		Log.info("Total row count: " + rowcount);
		DataFormatter formatter = new DataFormatter();

		for (int i = 1; i <= rowcount; i++) {
			Thread.sleep(2000);
			XSSFRow row = sheet.getRow(i);
			wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickAddNewSuplier));
			purchase_L.ClickAddNewSuplier.click();

			String ContactName = getFormattedValue(row.getCell(0), formatter);
			String TradingName = getFormattedValue(row.getCell(1), formatter);
			String Address1 = getFormattedValue(row.getCell(2), formatter);
			String Address2 = getFormattedValue(row.getCell(3), formatter);
			String CityTown = getFormattedValue(row.getCell(4), formatter);
			String Postcode = getFormattedValue(row.getCell(5), formatter);
			String County = getFormattedValue(row.getCell(6), formatter);
			String OpeningBalance = getFormattedValue(row.getCell(7), formatter);
			String Email = getFormattedValue(row.getCell(8), formatter);
			String Phone = getFormattedValue(row.getCell(9), formatter);
			String Notes = getFormattedValue(row.getCell(10), formatter);

			HelperClass.sendKeys(By.id("txtName"), ContactName);
			HelperClass.sendKeys(By.id("txttradingname0"), TradingName);
			HelperClass.sendKeys(By.id("txtAddress1"), Address1);
			HelperClass.sendKeys(By.id("txtAddress2"), Address2);
			HelperClass.sendKeys(By.id("txttown"), CityTown);
			HelperClass.sendKeys(By.id("txtZip"), Postcode);
			HelperClass.sendKeys(By.id("txtState"), County);
			HelperClass.sendKeys(By.id("OpeningBalance"), OpeningBalance);
			HelperClass.sendKeys(By.id("txtEmail"), Email);
			HelperClass.sendKeys(By.id("txtPhone"), Phone);
			HelperClass.sendKeys(By.id("txtNotes"), Notes);

			HelperClass.ClickandAnyTypeofWebelemnt(By.xpath("//button[normalize-space()='Save']"));

		}

		wb.close();
		file.close();
	}

	private String getFormattedValue(Cell cell, DataFormatter formatter) {
		if (cell == null)
			return "";
		return formatter.formatCellValue(cell).trim();
	}

	public void ClickOnCapiScan() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnCapiscan));
		purchase_L.ClickOnCapiscan.click();
		Thread.sleep(2000);
		Hooks.captureScreenshotBase64(HelperClass.getDriver(), Hooks.getScenarioTest(), "capture CapiScan dashboard");
	}

	public void ClickOnRecuringPurchases() throws InterruptedException {
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnRecuringPurchases));
		purchase_L.ClickOnRecuringPurchases.click();
		Thread.sleep(2000);
		Hooks.captureScreenshotBase64(HelperClass.getDriver(), Hooks.getScenarioTest(),
				"capture RecuringPurchases dashboard");
	}

	public void AddPurchaseInvoice() throws InterruptedException, IOException {
		String[][] data = ExcelUtils.getSheetData(Filepath, "Purchases");
		String baseSupplierName = data[0][1];
		String supplierName;
		int supplierCounter = 1;
		do {
			supplierName = baseSupplierName + "_o_" + supplierCounter++;
		} while (isSupplierNameExists(supplierName));

		HelperClass.selectOptionByVisibleText(By.xpath("//select[@id='cboInvType']"), data[0][0]);
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//i[@class='fa fa-plus azure']"));
		Thread.sleep(2000);
		HelperClass.setValueUsingJS(By.xpath("//input[@id='txtCName']"), supplierName);
		Thread.sleep(2000);
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		purchase_L.Save_Suplier.click();
		System.out.println("Supplier created: " + supplierName);
		Thread.sleep(2000);

		for (String[] row : data) {
			purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
			String invoiceType = row[0];

			HelperClass.selectOptionByVisibleText(By.xpath("//select[@id='cboInvType']"), invoiceType);
			Thread.sleep(2000);

			HelperClass.selectOptionByVisibleText(By.xpath("//select[@id='cboCustomer']"), supplierName);
			System.out.println("Existing supplier selected: " + supplierName);
			Thread.sleep(2000);

			HelperClass.selectOptionByValue(By.id("cboDueDay"), "90");
			Thread.sleep(2000);
			HelperClass.sendKeys(By.xpath("//input[@id='txtNote']"), row[2]);

			if (invoiceType.equalsIgnoreCase("Inventory")) {
				System.out.println("Inventory invoice detected. Checking if item exists in dropdown...");

				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

				String itemName = "Manual_Item_ABC";
				String vatCodeValue = "5";

				By itemDropdownLocator = By.xpath("//select[@name='Items[1].F_ItemMaster']");
				WebElement itemDropdown = wait
						.until(ExpectedConditions.visibilityOfElementLocated(itemDropdownLocator));

				HelperClass.ClickUsingJS(driver, By.xpath("//button[normalize-space()='Item']"));

				WebElement itemNameInput = wait
						.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtItemName")));
				itemNameInput.clear();
				itemNameInput.sendKeys(itemName);
				System.out.println("Entered Item Name: " + itemName);

				HelperClass.selectOptionByValue(By.id("F_TaxCodeMaster"), vatCodeValue);

				HelperClass.ClickUsingJS(driver, By.xpath("//button[normalize-space()='Save']"));
				Thread.sleep(2000);
			}

			Thread.sleep(2000);
			if (!invoiceType.equalsIgnoreCase("Inventory")) {
				HelperClass.sendKeys(By.xpath("//textarea[@name='Items[1].Note']"), row[3]);
			}
			Thread.sleep(2000);
			HelperClass.setValueUsingJS(By.xpath("//input[@name='Items[1].Price']"), row[4]);
			Thread.sleep(2000);
			HelperClass.sendKeys(By.xpath("//input[@class='form-control input-sm AccSearch ui-autocomplete-input']"),
					row[5]);
			Thread.sleep(2000);
			HelperClass.ClickDropdown(By.name("Items[1].F_TaxCodeMaster"));
			Thread.sleep(1000);
			HelperClass.selectOptionByValue(By.name("Items[1].F_TaxCodeMaster"), row[6]);
			Thread.sleep(2000);
			HelperClass.setValueUsingJS(By.xpath("//input[@name='Items[1].TaxAmount']"), row[7]);
			Thread.sleep(2000);
			HelperClass.ClickUsingJS(HelperClass.getDriver(),
					By.xpath("//span[normalize-space()='Amount Including VAT']"));
			Thread.sleep(2000);

			WebElement spanTrigger = driver.findElement(By.xpath("//span[@class='buttonText']"));
			spanTrigger.click();
			Thread.sleep(1000);
			Runtime.getRuntime().exec(path);
			Thread.sleep(3000);
			HelperClass.ClickUsingJS(HelperClass.getDriver(),
					By.xpath("//div[@class='clearfix form-footer']//div[@class='clearfix pull-right']//button[1]"));

			if (invoiceType.equalsIgnoreCase("Credit Note")) {
				try {
					WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(5));
					WebElement allocateLaterButton = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Allocate Later']")));
					allocateLaterButton.click();
					System.out.println("Allocate Later button clicked for Credit Note.");
				} catch (TimeoutException e) {
					System.out.println("Allocate Later button not shown. Continuing without allocation.");
				}
			}

			WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(15));
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='DivFilter']")));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='DivFilter']")));

			HelperClass.getDriver().navigate().refresh();
			HelperClass.sendKeys(By.id("txtSearch"), supplierName);
			HelperClass.getDriver().findElement(By.xpath("//a[@onclick='PurchasesList.GetData();']")).click();
			Thread.sleep(2000);

			List<WebElement> results = HelperClass.getDriver()
					.findElements(By.xpath("//table/tbody/tr/td[contains(text(), '" + supplierName + "')]"));
			if (results.isEmpty()) {
				System.out.println("Purchase not found for supplier: " + supplierName);
			} else {
				System.out.println("Purchase successfully created for supplier: " + supplierName);
			}

			HelperClass.ClickUsingJS(HelperClass.getDriver(), By.xpath("//a[@type='button']"));
			Thread.sleep(2000);
		}

	}

	private boolean isSupplierNameExists(String supplierName) {
		try {
			WebElement supplierDropdown = HelperClass.getDriver().findElement(By.id("cboCustomer"));
			return supplierDropdown.getText().contains(supplierName);
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public boolean isItemNameExists(String itemName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ItemName")));

			nameInput.clear();
			nameInput.sendKeys(itemName);
			Thread.sleep(1000);

			List<WebElement> errors = driver
					.findElements(By.xpath("//div[@id='DvErrorItem' and contains(@style,'display: block')]"));

			List<WebElement> closeButtons = driver.findElements(By.xpath("//button[normalize-space()='Close']"));
			if (!closeButtons.isEmpty()) {
				closeButtons.get(0).click();
			}

			return !errors.isEmpty();
		} catch (Exception e) {
			return false;
		}
	}

	public void ClickOnPurchaseTypeDropdown() {
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    
	    try {
	        WebElement dropdown = wait.until(ExpectedConditions.elementToBeClickable(purchase_L.PurchaseDropdown));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", dropdown);
	        Thread.sleep(300); 

	        try {
	            dropdown.click();
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Dropdown click intercepted. Using JS click.");
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdown);
	        }

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[contains(@class, 'dropdown-menu')]//li[1]")));

	    } catch (Exception e) {
	        System.out.println("Failed to click Purchase Type dropdown: " + e.getMessage());
	    }
	}


	public void ValidatePurchaseType_Dropdown() throws InterruptedException {
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnNewPurchase)).click();
		Hooks.captureScreenshotBase64(driver, Hooks.getScenarioTest(), "Purchase invoice Screenshot");
		Thread.sleep(2000);

		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.Purchases)).click();
		Thread.sleep(2000);

		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.PurchaseDropdown)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnNewCreditNote)).click();
		Hooks.captureScreenshotBase64(driver, Hooks.getScenarioTest(), "Credit Note Screenshot");
		Thread.sleep(2000);

		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.Purchases)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.PurchaseDropdown)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnCISInvoice)).click();
		Hooks.captureScreenshotBase64(driver, Hooks.getScenarioTest(), "CIS Invoice Screenshot");
		Thread.sleep(2000);

		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.Purchases)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.PurchaseDropdown)).click();
		Thread.sleep(2000);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnInventory)).click();
		Hooks.captureScreenshotBase64(driver, Hooks.getScenarioTest(), "Inventory Screenshot");
		Thread.sleep(2000);

		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.Purchases)).click();
	}

	public void ActionDropdown() throws InterruptedException {
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ActionDropdown)).click();
		Thread.sleep(1000);
	}

	public void Edit() throws InterruptedException {
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);

		HelperClass.selectOptionByVisibleText(By.xpath("//tbody[@role='alert']/tr[1]/td/select[@id='ddlaction']"),
				"Edit");
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//textarea[@name='Items[0].Note']")));
		HelperClass.sendKeys(By.xpath("//textarea[@name='Items[0].Note']"), "Update");
		Thread.sleep(1000);
		HelperClass.ClickUsingJS(HelperClass.getDriver(),
				By.xpath("//div[@class='clearfix form-footer']//div[@class='clearfix pull-right']//button[1]"));
	}

	public void ClickOnExport() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    
	    try {

	        WebElement exportBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnExport")));

	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", exportBtn);
	        Thread.sleep(300); 

	        try {
	            exportBtn.click();
	        } catch (ElementClickInterceptedException e) {
	            System.out.println("Normal click intercepted. Using JavaScript click.");
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", exportBtn);
	        }

	    } catch (Exception e) {
	        System.out.println("Failed to click Export button: " + e.getMessage());
	    }
	}


	public void ClickOnExportPDF() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pdfBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick=\"PurchasesList.Export('pdf');\"]")));
		pdfBtn.click();

		Thread.sleep(2000);
	}

	public void ClickOnExportExcel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement excelBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick=\"PurchasesList.Export('excel');\"]")));
		excelBtn.click();

		Thread.sleep(2000);
	}

	public void ClickOnAddRecuringPurchaseButton() {
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnAddRecuringPurchase));
		purchase_L.ClickOnAddRecuringPurchase.click();
	}

	public void EnterRecurringPurchaseDetails() throws InterruptedException {
		String[][] data = ExcelUtils.getSheetData(Filepath, "RecuringPurchase");
		String[] row = data[0]; // row[0] = Supplier Name
		String supplierName = row[0];

		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		// Locate the supplier dropdown
		WebElement supplierDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cboCustomer")));
		Select selectSupplier = new Select(supplierDropdown);

		boolean supplierExists = selectSupplier.getOptions().stream()
				.anyMatch(option -> option.getText().trim().equalsIgnoreCase(supplierName));

		if (supplierExists) {

			selectSupplier.selectByVisibleText(supplierName);
		} else {

			wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnAddSupplerbutton)).click();
			wait.until(ExpectedConditions.visibilityOf(purchase_L.InputSuplierName)).clear();
			purchase_L.InputSuplierName.sendKeys(supplierName);
			wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnSaveSuplier)).click();

			wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("loading-indicator")));
			supplierDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cboCustomer")));
			selectSupplier = new Select(supplierDropdown);
			selectSupplier.selectByVisibleText(supplierName);
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtreptimes"))).sendKeys(row[1]);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Note"))).sendKeys(row[2]);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtVDate"))).sendKeys(row[3]);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtDueDays"))).sendKeys(row[4]);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Items[0].Note"))).sendKeys(row[6]);

		HelperClass.setValueUsingJS(By.name("Items[0].Price"), row[7]);

		if (row[5].equalsIgnoreCase("Yes") && !purchase_L.AmountIncludingVAT.isSelected()) {
			purchase_L.AmountIncludingVAT.click();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(
				By.xpath("//input[@class='form-control input-sm AccSearch ui-autocomplete-input']"))).sendKeys(row[8]);

		HelperClass.ClickDropdown(By.name("Items[0].F_TaxCodeMaster"));
		HelperClass.selectOptionByValue(By.name("Items[0].F_TaxCodeMaster"), row[9]);
		HelperClass.setValueUsingJS(By.name("Items[0].TaxAmount"), row[10]);

		Hooks.setScenarioContext("CreatedSupplier", supplierName);
	}

	public void ClickOnSaveAndCloseButton() {
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		HelperClass.ClickUsingJS(driver, purchase_L.ClickOnSaveCloseSuplierbtn);
	}

	public void ClickOnSaveAndNewButton() {
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		HelperClass.ClickUsingJS(driver, purchase_L.ClickOnSaveAndNewButton);
	}

	public void SearchRecurringPurchaseBySupplierFromExcel() {
		String[][] data = ExcelUtils.getSheetData(Filepath, "RecuringPurchase");
		String supplierToSearch = data[0][0];
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement searchBox = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSearch']"))); // Update
																												// locator
		searchBox.clear();
		searchBox.sendKeys(supplierToSearch);

		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='TblRecurringList']/tbody/tr[1]")));
	}

	public void ClickOnSearchButton() {
		WebElement searchBtn = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='btnSearch']"))); // Update
																										// locator
		searchBtn.click();
	}

	public void ClickOnPayments() {
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnPayment));
		purchase_L.ClickOnPayment.click();
	}

	public void ClickOnAddPayment() {
		wait.until(ExpectedConditions.elementToBeClickable(purchase_L.ClickOnAddNewbtn));
		purchase_L.ClickOnAddNewbtn.click();
	}

//	public void AddSupplierfromDropdown() throws InterruptedException {
//	    String[][] data = ExcelUtils.getSheetData(Filepath, "RecuringPurchase");
//	    String[] row = data[0];
//	    String supplierName = row[0];
//
//	    WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));
//	    
//	    WebElement customerDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cboCustomer")));
//	    Select customerSelect = new Select(customerDropdown);
//
//	    boolean supplierExists = customerSelect.getOptions().stream()
//	        .anyMatch(option -> option.getText().trim().equalsIgnoreCase(supplierName));
//
//	    if (supplierExists) {
//	        customerSelect.selectByVisibleText(supplierName);
//	        System.out.println("Selected existing supplier: " + supplierName);
//	    } else {
//	        System.out.println("Supplier not found. Creating: " + supplierName);
//
//	        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@onclick,'AddSupplier')]")));
//	        addButton.click();
//
//	        WebElement supplierInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCustomerName")));
//	        supplierInput.sendKeys(supplierName);
//
//	        WebElement saveSupplier = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveCustomer")));
//	        saveSupplier.click();
//
//	        Thread.sleep(2000);
//
//	        customerDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cboCustomer")));
//	        customerSelect = new Select(customerDropdown);
//	        customerSelect.selectByVisibleText(supplierName);
//
//	        System.out.println("Supplier created and selected: " + supplierName);
//	    }
//
//	    Thread.sleep(1000); 
//	}

	public void AddSupplierfromDropdown() throws InterruptedException {
		String[][] data = ExcelUtils.getSheetData(Filepath, "RecuringPurchase");
		String[] row = data[0];
		String supplierName = row[0];

		WebDriverWait wait = new WebDriverWait(HelperClass.getDriver(), Duration.ofSeconds(10));

		WebElement customerDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cboCustomer")));
		Select customerSelect = new Select(customerDropdown);

		boolean supplierExists = customerSelect.getOptions().stream()
				.anyMatch(option -> option.getText().trim().equalsIgnoreCase(supplierName));

		if (supplierExists) {
			customerSelect.selectByVisibleText(supplierName);
			System.out.println("Selected existing supplier: " + supplierName);

			Thread.sleep(1000); // Wait for the table to load

			List<WebElement> tableElements = HelperClass.getDriver().findElements(
					By.xpath("//table[@id='TblPayment']/tbody/tr/td[contains(text(),'No payments to display')]"));

			if (!tableElements.isEmpty()) {
				System.out.println("No payments for this supplier. Selecting next available supplier.");

				List<WebElement> options = customerSelect.getOptions();
				boolean foundNext = false;

				for (int i = 0; i < options.size(); i++) {
					String text = options.get(i).getText().trim();
					if (text.equalsIgnoreCase(supplierName) && i + 1 < options.size()) {
						String nextSupplier = options.get(i + 1).getText().trim();
						customerSelect.selectByVisibleText(nextSupplier);
						System.out.println("Selected next supplier: " + nextSupplier);
						foundNext = true;
						break;
					}
				}

				if (!foundNext) {
					System.out.println("No other suppliers available. Staying with the original supplier.");
				}
			}

		} else {
			System.out.println("Supplier not found. Creating: " + supplierName);

			WebElement addButton = wait.until(
					ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@onclick,'AddSupplier')]")));
			addButton.click();

			WebElement supplierInput = wait
					.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCustomerName")));
			supplierInput.sendKeys(supplierName);

			WebElement saveSupplier = wait.until(ExpectedConditions.elementToBeClickable(By.id("btnSaveCustomer")));
			saveSupplier.click();

			Thread.sleep(2000); // Wait for dropdown to reload

			customerDropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cboCustomer")));
			customerSelect = new Select(customerDropdown);
			customerSelect.selectByVisibleText(supplierName);

			System.out.println("Supplier created and selected: " + supplierName);
		}

		Thread.sleep(1000); // Optional wait if required after selecting supplier
	}

	public void EnterAmount() {
		purchase_L = PageFactory.initElements(driver, Capium_Bookkeeping_Purchase_Locators.class);
		WebDriver driver = HelperClass.getDriver();
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='TblPayment']/tbody/tr"));

		for (int i = 1; i <= rows.size(); i++) {
			WebElement dueAmountCell = driver
					.findElement(By.xpath("//table[@id='TblPayment']/tbody/tr[" + i + "]/td[5]"));
			String dueAmountText = dueAmountCell.getText().replaceAll("[^0-9.]", "");

			if (!dueAmountText.isEmpty()) {
				WebElement amountInput = driver
						.findElement(By.xpath("//table[@id='TblPayment']/tbody/tr[" + i + "]/td[7]//input"));

				amountInput.clear();
				amountInput.click();
				// amountInput.sendKeys(dueAmountText);
				HelperClass.setValueUsingJS(amountInput, dueAmountText);

				System.out.println("Entered amount " + dueAmountText + " in row " + i);
			}
		}
	}

	public void ClickOnPaymentsSaveandClose() {
		purchase_L.PaymentSaveandCloseButton.click();
	}

	public void ClickAdvancePaymentCheckbox() {
		purchase_L.ClickAdvanceCheckbox.click();
	}

	public void ClickOnSaveandNewButton() {
		purchase_L.PaymentSaveAndNewButton.click();
	}

}
