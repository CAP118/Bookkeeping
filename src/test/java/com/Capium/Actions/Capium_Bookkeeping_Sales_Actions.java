package com.Capium.Actions;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.Capium.Locators.Capium_Bookkeeping_Purchase_Locators;
import com.Capium.Locators.Capium_Bookkeeping_Sales_Locators;
import com.Capium.Utilies.ExcelUtils;
import com.Capium.Utilies.HelperClass;
import com.Capium.Utilies.Log;

public class Capium_Bookkeeping_Sales_Actions {

	Capium_Bookkeeping_Sales_Locators SalesLocators = null;

	public Capium_Bookkeeping_Sales_Actions() {
		this.SalesLocators = new Capium_Bookkeeping_Sales_Locators();
		PageFactory.initElements(HelperClass.getDriver(), SalesLocators);
	}

	WebDriver driver = HelperClass.getDriver();
	WebDriverWait wait = HelperClass.getWait();
	public static final By ClickOnSalesDashboard = By.xpath("//a[normalize-space()='Dashboard'][@id='mnuSalesLeft']");

	String SalesPath = "D:\\Core Modules\\Capium_BK_3.0\\src\\test\\resources\\Files\\ClientCreationData.xlsx";

	public void ClickOnSales() {
		WebDriver driver = HelperClass.getDriver();
		SalesLocators = PageFactory.initElements(driver, Capium_Bookkeeping_Sales_Locators.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		WebElement salesButton = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[normalize-space()='Sales']")));
		wait.until(ExpectedConditions.elementToBeClickable(salesButton));

		((JavascriptExecutor) driver).executeScript("arguments[0].click();", salesButton);
	}

	public void ClickOnSales_dashboard() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement dashboardButton = wait.until(ExpectedConditions.elementToBeClickable(ClickOnSalesDashboard));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", dashboardButton);
	}

	public void SalesSummaryMinimize() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		HelperClass.ClickUsingJS(driver, By.xpath("//div[normalize-space()='Sales Summary']/div"));
	}

	public void click_on_add_sales_in_sales_summary() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		SalesLocators.AddSalesbtn.click();
	}

	public void VerifySalesPageTitile() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		WebDriverWait wait = HelperClass.getWait();

		WebElement heading = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Create New Invoice')]")));

		Assert.assertTrue(heading.isDisplayed(), "Create New Invoice page is not displayed.");

		System.out.println("Create New Invoice page successfully displayed.");
	}

	public void VerifyContactListPageTitle() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		WebDriverWait wait = HelperClass.getWait();

		WebElement heading = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Contact List')]")));

		Assert.assertTrue(heading.isDisplayed(), "Contact List page is not displayed.");

		System.out.println("Contact List page successfully displayed.");
	}

	public void VerifyQuotationPageTitle() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		WebDriverWait wait = HelperClass.getWait();

		WebElement heading = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Create New Quotation')]")));

		Assert.assertTrue(heading.isDisplayed(), "Create New Quotation page is not displayed.");

		System.out.println("Create New Quotation page successfully displayed.");
	}

	public void VerifyAllSalesLinkPageTitle() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		WebDriverWait wait = HelperClass.getWait();

		WebElement heading = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Invoices')]")));

		Assert.assertTrue(heading.isDisplayed(), "Invoices page is not displayed.");

		System.out.println("Invoices page successfully displayed.");
	}

	public void VerifyAllCustomersLinkPagetitle() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		WebDriverWait wait = HelperClass.getWait();

		WebElement heading = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Contact List')]")));

		Assert.assertTrue(heading.isDisplayed(), "Contact List page is not displayed.");

		System.out.println("Contact List page successfully displayed.");
	}

	public void VerifyAllQuotesLinkPageTitle() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		WebDriverWait wait = HelperClass.getWait();

		WebElement heading = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Quotations')]")));

		Assert.assertTrue(heading.isDisplayed(), "Quotations page is not displayed.");

		System.out.println("Quotations page successfully displayed.");
	}

	public void VerifyAllDebtorsPageTitle() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		WebDriverWait wait = HelperClass.getWait();

		WebElement heading = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Debtors List')]")));

		Assert.assertTrue(heading.isDisplayed(), "Quotations page is not displayed.");

		System.out.println("Quotations page successfully displayed.");
	}

	public void click_on_add_customer_in_sales_summary() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), SalesLocators.ClickAddCoustomeronDashboard);
	}

	public void click_on_add_quote_in_sales_summary() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), SalesLocators.ClickAddQuoteOnSalesDashboard);
	}

	public void ClickonSalesChartMinimize() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), SalesLocators.SalesChartMinimize);
	}

	public void ClickOnDebtorsChartMinimize() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		HelperClass.ClickUsingJS(HelperClass.getDriver(), SalesLocators.DebtorsChatMinimize);
	}

	public void ClickOnCurrentDebtorsListMinimize() {
		WebDriver driver = HelperClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		SalesLocators = PageFactory.initElements(driver, Capium_Bookkeeping_Sales_Locators.class);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[normalize-space()='Current Debtors List']/div/a[@href='#']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//div[normalize-space()='Current Debtors List']/div/a[@href='#']"));
	}

	public void ClickonRecentSalesListMinimize() {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		SalesLocators = PageFactory.initElements(driver, Capium_Bookkeeping_Sales_Locators.class);
		wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//div[normalize-space()='Recent Sales List']/div/a[@href='#']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//div[normalize-space()='Recent Sales List']/div/a[@href='#']"));
	}

	public void ClickOnAllSalesLinkInRecentSalesList() {
		wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//td[@class='text-right bottom_link']//a[normalize-space()='All Sales']")));
		HelperClass.ClickUsingJS(driver,
				By.xpath("//td[@class='text-right bottom_link']//a[normalize-space()='All Sales']"));

	}

	public void ClickOnInvoices() {
		SalesLocators = PageFactory.initElements(driver, Capium_Bookkeeping_Sales_Locators.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Invoices']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[normalize-space()='Invoices']"));

	}

	public void ClickAddNewInvoicebutton() {
		SalesLocators = PageFactory.initElements(driver, Capium_Bookkeeping_Sales_Locators.class);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@type='button']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[@type='button']"));
	}

	public void ClickonAddSalesbtn() throws IOException, InterruptedException {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		String[][] data = ExcelUtils.getSheetData(SalesPath, "SalesInvoice");

		for (String[] row : data) {
			String invoiceType = row[0].trim();
			String customerName = row[1].trim();
			String note = row[2];
			String itemName = row[3].trim();
			String vatCode = row[4].trim();
			String price = row[5];
			String quantity = row[6];

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			HelperClass.ClickUsingJS(driver, By.xpath("//a[@type='button']"));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("cboInvType")));

			Select invoiceTypeDropdown = new Select(driver.findElement(By.id("cboInvType")));
			invoiceTypeDropdown.selectByVisibleText(invoiceType);

			handleCustomer(customerName, wait);
			Thread.sleep(3000);

			HelperClass.ClickUsingJS(driver, By.xpath("//select[@name='cboDueDay']"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='cboDueDay']")));
			Thread.sleep(1000);
			HelperClass.selectOptionByVisibleText(By.xpath("//select[@name='cboDueDay']"), "90 Days");

			HelperClass.setValueUsingJS(By.id("txtNote"), note);
			fillItemDetails(itemName, vatCode, price, quantity, wait);

			SalesLocators.ClickOnSaveClose.click();
			Thread.sleep(3000);

			Log.info("Invoice created for customer: " + customerName);

			if (invoiceType.equalsIgnoreCase("Credit Note")) {
				try {
					WebElement allocateLaterButton = wait.until(ExpectedConditions
							.visibilityOfElementLocated(By.xpath("//button[normalize-space()='Allocate Later']")));
					allocateLaterButton.click();
					System.out.println("Allocate Later button clicked for Credit Note.");
				} catch (TimeoutException e) {
					System.out.println("Allocate Later button not shown. Continuing without allocation.");
				}
			}

			searchInvoiceByCustomer(customerName, wait);
		}
	}

	private void handleCustomer(String customerName, WebDriverWait wait) throws InterruptedException {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		WebElement dropdown = driver.findElement(By.xpath("//select[@id='cboCustomer']/following-sibling::span"));
		dropdown.click();

		WebElement searchInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class='select2-search__field']")));
		searchInput.sendKeys(customerName);
		Thread.sleep(1000);

		List<WebElement> options = driver.findElements(By.xpath("//ul[@id='select2-cboCustomer-results']/li"));
		boolean customerExists = false;
		for (WebElement option : options) {
			if (option.getText().trim().equalsIgnoreCase(customerName)) {
				option.click();
				customerExists = true;
				break;
			}
		}

		if (!customerExists) {
			driver.findElement(By.xpath("//button[@onclick='Invoice.OpenContactDialog(this)']")).click();

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtCName")));
			WebElement input = driver.findElement(By.id("txtCName"));
			input.clear();
			input.sendKeys(customerName);

			HelperClass.ClickUsingJS(driver, By.xpath("//button[normalize-space()='Save']"));
			Thread.sleep(2000);
		}
	}

	private void fillItemDetails(String itemName, String vatCode, String price, String quantity, WebDriverWait wait)
			throws InterruptedException {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		// SalesLocators.ClickAddItem.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='Items[0].F_ItemMaster']")));

		WebElement dropdown = driver.findElement(By.xpath("//select[@name='Items[0].F_ItemMaster']"));
		dropdown.click();

		WebElement searchInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@name='Items[0].F_ItemMaster']")));
		searchInput.sendKeys(itemName);
		Thread.sleep(1000);

		List<WebElement> options = driver.findElements(By.xpath("//select[@name='Items[0].F_ItemMaster']/option"));
		boolean itemExists = false;
		for (WebElement option : options) {
			if (option.getText().trim().equalsIgnoreCase(itemName)) {
				option.click();
				itemExists = true;
				break;
			}
		}

		if (!itemExists) {
			HelperClass.ClickUsingJS(driver, By.xpath("//button[normalize-space()='Item']"));
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("txtItemName")));

			driver.findElement(By.id("txtItemName")).sendKeys(itemName);
			HelperClass.selectOptionByValue(By.id("F_TaxCodeMaster"), vatCode);
			HelperClass.setValueUsingJS(By.id("txtPrice"), price);
			HelperClass.setValueUsingJS(By.id("txtOpQuantity"), quantity);
			By saveButton = By.xpath("//button[normalize-space()='Save']");
			wait.until(ExpectedConditions.elementToBeClickable(saveButton));
			HelperClass.ClickUsingJS(driver, saveButton);
			Thread.sleep(2000);
		}

	}

	private void searchInvoiceByCustomer(String customerName, WebDriverWait wait) {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		WebElement searchInput = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSearch']")));
		searchInput.clear();
		searchInput.sendKeys(customerName);
		WebElement searchButton = driver.findElement(By.xpath("//i[@class='fa fa-search']"));
		searchButton.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@id='TblInvoiceList']/tbody/tr")));

		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='TblInvoiceList']/tbody/tr"));
		boolean invoiceFound = rows.stream().anyMatch(row -> row.getText().contains(customerName));

		if (invoiceFound) {
			Log.info("Invoice found for customer: " + customerName);
		} else {
			Log.warn("No invoice found for customer: " + customerName);
		}
	}

	public void ClickOnSaveandCloseInvoice() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		SalesLocators.SaveItem.click();
	}

	public void ClickSaveAndClose() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		SalesLocators.ClickOnSaveClose.click();
	}

	public void ClickOnNewInvoiceDropdown() {
		HelperClass.ClickUsingJS(driver,
				By.xpath("//a[@class='btn btn-azure dropdown-toggle input-sm']//i[@class='fa fa-angle-down']"));
	}

	public void VerifyInvoiceDropdown() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@href='Invoice.aspx?id=-1&iType=3'])[2]")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Invoices']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[normalize-space()='Invoices']"));

		HelperClass.ClickUsingJS(driver,
				By.xpath("//a[@class='btn btn-azure dropdown-toggle input-sm']//i[@class='fa fa-angle-down']"));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='Invoice.aspx?id=-1&iType=4']")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Invoices']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[normalize-space()='Invoices']"));

		HelperClass.ClickUsingJS(driver,
				By.xpath("//a[@class='btn btn-azure dropdown-toggle input-sm']//i[@class='fa fa-angle-down']"));

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='Invoice.aspx?id=-1&iType=5']")))
				.click();

		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[normalize-space()='Invoices']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[normalize-space()='Invoices']"));

	}

	public void ClickOnExport() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
	    
	    try {

	        WebElement exportBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("btnExport")));
	        wait.until(ExpectedConditions.elementToBeClickable(exportBtn));
	        
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", exportBtn);
	        
	        try {
	            exportBtn.click();
	        } catch (ElementClickInterceptedException e) {
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", exportBtn);
	        }
	    } catch (Exception e) {
	        System.out.println("Export button click failed: " + e.getMessage());
	    }
	}


	public void ClickOnExportPDF() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement pdfBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick=\"InvoiceList.Export('pdf');\"]")));
		pdfBtn.click();

		Thread.sleep(2000);
	}

	public void ClickOnExportExcel() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement excelBtn = wait.until(
				ExpectedConditions.elementToBeClickable(By.xpath("//a[@onclick=\"InvoiceList.Export('excel');\"]")));
		excelBtn.click();

		Thread.sleep(2000);
	}

	public void InvoiceActionDropdown() throws InterruptedException {
		SalesLocators = PageFactory.initElements(driver, Capium_Bookkeeping_Sales_Locators.class);
//		wait.until(ExpectedConditions.elementToBeClickable(SalesLocators.SelectActionDropdpwn));
//		Thread.sleep(2000);
//		wait.until(ExpectedConditions.elementToBeClickable(SalesLocators.SelectActionDropdpwn)).click();
//		Thread.sleep(2000);
		
		By actionDropdown = By.xpath("//tbody[@role='alert']/tr[1]/td/select[@id='ddlaction']");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.presenceOfElementLocated(actionDropdown));
		wait.until(ExpectedConditions.visibilityOfElementLocated(actionDropdown));

		WebElement dropdownElement = driver.findElement(actionDropdown);
		boolean isClickable = (Boolean) ((JavascriptExecutor) driver).executeScript(
		    "var elem = arguments[0], box = elem.getBoundingClientRect();" +
		    "return (box.top >= 0 && box.left >= 0 && box.bottom <= (window.innerHeight || document.documentElement.clientHeight) &&" +
		    "box.right <= (window.innerWidth || document.documentElement.clientWidth));", 
		    dropdownElement);

		if (isClickable && dropdownElement.isDisplayed() && dropdownElement.isEnabled()) {
		  
		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", dropdownElement);
		} else {
		    System.out.println("Dropdown is not safely clickable due to UI overlay or animation.");
		}
       Thread.sleep(2000);
	}

	public void InvoiceEditOnlyAddItemRow() throws InterruptedException, IOException {
		SalesLocators = PageFactory.initElements(driver, Capium_Bookkeeping_Sales_Locators.class);
		String[][] data = ExcelUtils.getSheetData(SalesPath, "SalesInvoice");
		String[] row = data[0];

		String invoiceType = row[0].trim().toLowerCase();
		String itemName = row[3].trim();

		System.out.println("Invoice Type read from Excel: " + invoiceType);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		By actionDropdown = By.xpath("(//select[@id='ddlaction'])[1]");
		wait.until(ExpectedConditions.elementToBeClickable(actionDropdown));
		HelperClass.selectOptionByVisibleText(actionDropdown, "Edit");
		Thread.sleep(1000);

		List<WebElement> itemRows = driver
				.findElements(By.xpath("//select[starts-with(@name, 'Items') and contains(@name, 'F_ItemMaster')]"));
		int newRowIndex = itemRows.size();

		By addRowBtn = By.xpath("//button[@class='btn btn-azure btn-sm'][normalize-space()='Row']");
		wait.until(ExpectedConditions.elementToBeClickable(addRowBtn));
		HelperClass.ClickUsingJS(driver, driver.findElement(addRowBtn));
		Thread.sleep(1000);

		String dropdownXPath = "//select[@name='Items[" + newRowIndex + "].F_ItemMaster']";
		By itemDropdown = By.xpath(dropdownXPath);
		wait.until(ExpectedConditions.elementToBeClickable(itemDropdown));

		WebElement dropdownElement = driver.findElement(itemDropdown);
		Select select = new Select(dropdownElement);

		boolean itemExists = select.getOptions().stream()
				.anyMatch(option -> option.getText().trim().equalsIgnoreCase(itemName));

		if (itemExists) {
			select.selectByVisibleText(itemName);
		} else {
			throw new RuntimeException("Item '" + itemName + "' not found in dropdown at row index " + newRowIndex);
		}

		Thread.sleep(2000);

		wait.until(ExpectedConditions.elementToBeClickable(SalesLocators.ClickOnSaveClose));
		HelperClass.ClickUsingJS(driver, SalesLocators.ClickOnSaveClose);
		System.out.println("Clicked Save and Close.");

		if (invoiceType.contains("credit")) {
			try {
				By allocateLaterBtnBy = By.xpath("//button[normalize-space()='Allocate Later']");
				WebElement allocateLaterButton = wait
						.until(ExpectedConditions.elementToBeClickable(allocateLaterBtnBy));
				HelperClass.ClickUsingJS(driver, allocateLaterButton);
				System.out.println("Allocate Later button clicked for Credit Note.");
			} catch (TimeoutException e) {
				System.out.println("Allocate Later button not found after Save and Close.");
			}
		} else {
			System.out.println("Normal Invoice: No Allocate Later button expected.");
		}
	}

	public void InvoiceDelete() throws InterruptedException {
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='ddlaction'])[1]")));
		SalesLocators = PageFactory.initElements(driver, Capium_Bookkeeping_Sales_Locators.class);
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Delete");
		Thread.sleep(1000);
		WebElement confirmationTextElement = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Record will be permanently deleted')]")));

		String actualMessage = confirmationTextElement.getText();
		System.out.println(actualMessage);
		String expectedMessage = "Record will be permanently deleted and cannot be recovered.";

		if (actualMessage.equals(expectedMessage)) {
			Log.info("Delete confirmation message is verified: " + actualMessage);
		} else {
			Log.error("Delete confirmation message mismatch. Found: " + actualMessage);
			throw new AssertionError("Expected: '" + expectedMessage + "' but found: '" + actualMessage + "'");
		}
		WebElement okButton = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='OK']")));
		okButton.click();

		Log.info("Clicked OK on delete confirmation.");

	}

	public void InvoiceDownloadDoc() throws InterruptedException {
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='ddlaction'])[1]")));
		Thread.sleep(2000);
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Download Doc");
	}

	public void InvoiceDownload_PDF() throws InterruptedException {
		// wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='ddlaction'])[1]")));
		Thread.sleep(2000);
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Download Pdf");
	}

	public void InvoiceAttachments() throws InterruptedException, IOException {
		String path = "D:\\Autoit\\FileUpload.exe";
		Thread.sleep(2000);
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Attachments");
		WebDriver driver = HelperClass.getDriver();
		WebElement spanTrigger = driver.findElement(By.xpath("//span[@class='buttonText']"));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='buttonText']")));
		spanTrigger.click();
		Thread.sleep(1000);
		Runtime.getRuntime().exec(path);
		Thread.sleep(3000);
		HelperClass.ClickUsingJS(driver, By.xpath("//button[@id='BtnAttachmentUpload']"));
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(driver, By.xpath("//i[@class='fa fa-arrow-left']//parent::button"));

	}

	public void InvoiceEmail() throws InterruptedException {

		Thread.sleep(1000);
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Email");
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@id='txtepto']")));
		HelperClass.sendKeys(By.xpath("//input[@id='txtepto']"), "anwar.capium118@gmail.com");
		Thread.sleep(1000);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Send']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//button[normalize-space()='Send']"));
		Thread.sleep(1000);
	}

	public void ClickQuotation() {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);
		wait.until(ExpectedConditions.visibilityOf(SalesLocators.ClickOnQuotations));
		HelperClass.waitUntilClickable(wait, SalesLocators.ClickOnQuotations);
		HelperClass.ClickUsingJS(driver, SalesLocators.ClickOnQuotations);
	}

	public void ClickOnAddQuotation() throws InterruptedException {
		SalesLocators = PageFactory.initElements(HelperClass.getDriver(), Capium_Bookkeeping_Sales_Locators.class);

		String[][] data = ExcelUtils.getSheetData(SalesPath, "Quotation");
		String[] row = data[0];

		WebDriver driver = HelperClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(driver, SalesLocators.AddQuotation);
		String baseCustomerName = row[0];
		HelperClass.waitUntilVisible(wait, By.xpath("//select[@id='cboCustomer']"));

		Select customerDropdown = new Select(driver.findElement(By.xpath("//select[@id='cboCustomer']")));

		List<WebElement> customerOptions = customerDropdown.getOptions();

		List<String> matchingCustomers = customerOptions.stream().map(option -> option.getText().trim())
				.filter(name -> name.toLowerCase().startsWith(baseCustomerName.toLowerCase()))
				.collect(Collectors.toList());

		String uniqueCustomerName = baseCustomerName + (matchingCustomers.size() + 1);

		boolean customerExists = matchingCustomers.stream().anyMatch(name -> name.equalsIgnoreCase(uniqueCustomerName));

		if (!customerExists) {
			HelperClass.ClickUsingJS(driver, By.xpath("//button[@onclick='Quote.OpenContactDialog(this)']"));
			HelperClass.waitUntilVisible(wait, By.xpath("//input[@id='txtCName']"));
			WebElement customerInput = driver.findElement(By.xpath("//input[@id='txtCName']"));
			customerInput.clear();
			customerInput.sendKeys(uniqueCustomerName);

			HelperClass.ClickUsingJS(driver, By.xpath("//button[normalize-space()='Save']"));
			HelperClass.waitUntilVisible(wait, By.xpath("//select[@id='cboCustomer']"));
		}

		customerDropdown = new Select(driver.findElement(By.xpath("//select[@id='cboCustomer']")));
		customerDropdown.selectByVisibleText(uniqueCustomerName);

		HelperClass.setValueUsingJS(By.xpath("//input[@id='txtNote']"), row[1]);

		Select itemDropdown = new Select(driver.findElement(By.xpath("//select[@name='Items[0].F_ItemMaster']")));
		boolean itemExists = itemDropdown.getOptions().stream()
				.anyMatch(option -> option.getText().trim().equalsIgnoreCase(row[2].trim()));

		if (!itemExists) {
			HelperClass.waitUntilClickable(wait, By.xpath("//button[normalize-space()='Item']"));
			HelperClass.ClickUsingJS(driver, By.xpath("//button[normalize-space()='Item']"));

			HelperClass.setValueUsingJS(By.xpath("//input[@id='txtItemName']"), row[2]);
			HelperClass.setValueUsingJS(By.xpath("//input[@id='Code']"), row[3]);
			HelperClass.selectOptionByValue(By.xpath("//select[@id='F_TaxCodeMaster']"), row[4]);
			HelperClass.setValueUsingJS(By.xpath("//textarea[@id='txtDescription']"), row[5]);
			HelperClass.setValueUsingJSWithEvent(By.xpath("//input[@id='txtPrice']"), row[6]);
			HelperClass.setValueUsingJS(By.xpath("//input[@id='txtOpQuantity']"), row[7]);
			HelperClass.setValueUsingJS(By.xpath("//input[@id='txtOpPrice']"), row[8]);

			HelperClass.waitUntilClickable(wait, By.xpath("//button[normalize-space()='Save']"));
			HelperClass.ClickUsingJS(driver, By.xpath("//button[normalize-space()='Save']"));
			HelperClass.waitUntilVisible(wait, By.xpath("//select[@name='Items[0].F_ItemMaster']"));
		}

		HelperClass.waitUntilClickable(wait, By.xpath("//select[@name='Items[0].F_ItemMaster']"));
		HelperClass.selectOptionByVisibleText(By.xpath("//select[@name='Items[0].F_ItemMaster']"), row[2]);

		Thread.sleep(3000);
		HelperClass.waitUntilClickable(wait, By.xpath("//div[@class='clearfix pull-right']//button[1]"));
		HelperClass.ClickUsingJS(driver, By.xpath("//div[@class='clearfix pull-right']//button[1]"));

		HelperClass.waitUntilVisible(wait, By.xpath("//input[@id='txtSearch']"));
		WebElement searchBox = driver.findElement(By.xpath("//input[@id='txtSearch']"));
		searchBox.clear();
		searchBox.sendKeys(uniqueCustomerName);
		Thread.sleep(2000);
		HelperClass.ClickUsingJS(driver, By.xpath("//i[@class='fa fa-search']"));
		wait.until(ExpectedConditions.presenceOfElementLocated(By
				.xpath("//table[@id='TblQuotation']/tbody/tr/td[2]/a[contains(text(),'" + uniqueCustomerName + "')]")));

		Thread.sleep(2000);

	}

	public void editQuotationAndAddItemRow() throws InterruptedException {
		WebDriver driver = HelperClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String[][] data = ExcelUtils.getSheetData(SalesPath, "Quotation");
		String[] row = data[0];

//	    WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='searchQuotation']")));
//	    searchBox.clear();
//	    searchBox.sendKeys(row[0]); 
//	    searchBox.sendKeys(Keys.ENTER);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='ddlaction'])[1]")));
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Edit");

		List<WebElement> existingItemRows = driver
				.findElements(By.xpath("//select[contains(@name, 'Items') and contains(@name, 'F_ItemMaster')]"));
		int newRowIndex = existingItemRows.size();

		HelperClass.waitUntilClickable(wait, By.xpath("//a[@onclick=\"Quote.AddNewRow('TblQuote');\"]"));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[@onclick=\"Quote.AddNewRow('TblQuote');\"]"));

		String dynamicItemDropdownXpath = "//select[@name='Items[" + newRowIndex + "].F_ItemMaster']";

		WebElement dropdownElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicItemDropdownXpath)));
		Select itemDropdown = new Select(dropdownElement);
		itemDropdown.selectByVisibleText(row[2]);

		HelperClass.waitUntilClickable(wait, By.xpath("//div[@class='clearfix pull-right']//button[1]"));
		HelperClass.ClickUsingJS(driver, By.xpath("//div[@class='clearfix pull-right']//button[1]"));

		System.out.println("Quotation edited and new item row added successfully.");
	}

	public void ClickOnQuotationPDF_download() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='ddlaction'])[1]")));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select[@id='ddlaction'])[1]")));
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Download PDF");
	}

	public void CreateInvoiceQuotation() {

		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Create Invoice");

		HelperClass.waitUntilClickable(wait, By.xpath("//button[contains(text(),'Edit Invoice')]"));
		HelperClass.ClickUsingJS(driver, By.xpath("//button[contains(text(),'Edit Invoice')]"));
		wait.until(ExpectedConditions.elementToBeClickable(SalesLocators.ClickOnSaveClose));
		SalesLocators.ClickOnSaveClose.click();

		HelperClass.waitUntilVisible(wait, By.xpath("//input[@id='txtSearch']"));

		String[][] data = ExcelUtils.getSheetData(SalesPath, "Quotation");
		String[] row = data[0];
		String customerName = row[0];

		WebElement searchInput = driver.findElement(By.xpath("//input[@id='txtSearch']"));
		searchInput.clear();
		searchInput.sendKeys(customerName);

		HelperClass.ClickUsingJS(driver, By.xpath("//i[@class='fa fa-search']"));
	}

	public void ClickOnRecuringInvoices() {
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Recurring Invoices']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[normalize-space()='Recurring Invoices']"));
	}

	public void ClickOnAddNewRecringInvoice() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='btnAddNew']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[@id='btnAddNew']"));

		WebElement dropdown = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//select[@id='cboCustomer'])//following-sibling::span[1]")));
		dropdown.click();

		WebElement firstCustomer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//ul[@id='select2-cboCustomer-results']/li[not(contains(@class,'select2-results__option--loading'))])[1]")));
		String customerName = firstCustomer.getText();
		firstCustomer.click();

		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//select[contains(@name,'Items[0].F_ItemMaster')]")));

		Select itemDropdown = new Select(
				driver.findElement(By.xpath("//select[contains(@name,'Items[0].F_ItemMaster')]")));
		List<WebElement> itemOptions = itemDropdown.getOptions();
		if (itemOptions.size() > 1) {
			itemDropdown.selectByIndex(1);

			HelperClass.waitUntilClickable(wait, By.xpath("//div[@class='clearfix pull-right']//button[1]"));
			HelperClass.ClickUsingJS(driver, By.xpath("//div[@class='clearfix pull-right']//button[1]"));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSearch']")));
			HelperClass.sendKeys(By.xpath("//input[@id='txtSearch']"), customerName);
			Thread.sleep(1000);

		}
	}

	public void EditRecurringInvoiceAndUpdatedata() {

		WebDriver driver = HelperClass.getDriver();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String[][] data = ExcelUtils.getSheetData(SalesPath, "Quotation");
		String[] row = data[0];

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='ddlaction'])[1]")));
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Edit");

		List<WebElement> existingItemRows = driver
				.findElements(By.xpath("//select[contains(@name, 'Items') and contains(@name, 'F_ItemMaster')]"));
		int newRowIndex = existingItemRows.size();

		HelperClass.waitUntilClickable(wait, By.xpath("//a[@class='btn btn-azure btn-sm']"));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[@class='btn btn-azure btn-sm']"));

		String dynamicItemDropdownXpath = "//select[@name='Items[" + newRowIndex + "].F_ItemMaster']";

		WebElement dropdownElement = wait
				.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dynamicItemDropdownXpath)));
		Select itemDropdown = new Select(dropdownElement);
		itemDropdown.selectByVisibleText(row[2]);

		HelperClass.waitUntilClickable(wait, By.xpath("//div[@class='clearfix pull-right']//button[1]"));
		HelperClass.ClickUsingJS(driver, By.xpath("//div[@class='clearfix pull-right']//button[1]"));

		System.out.println("Quotation edited and new item row added successfully.");

	}

	public void ClickOnReceipt() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Receipts']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[normalize-space()='Receipts']"));
	}

	public void ClickAddNewReceipt() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='btnAddNew']")));
		HelperClass.ClickUsingJS(driver, By.xpath("//a[@id='btnAddNew']"));

		WebElement dropdown = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("(//select[@id='cboCustomer'])//following-sibling::span[1]")));
		dropdown.click();

		WebElement firstCustomer = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"(//ul[@id='select2-cboCustomer-results']/li[not(contains(@class,'select2-results__option--loading'))])[1]")));
		String customerName = firstCustomer.getText();
		firstCustomer.click();
		Thread.sleep(2000);
		List<WebElement> rows = driver.findElements(By.xpath("//table[@id='TblReceipt']/tbody/tr"));

		for (int i = 1; i <= rows.size(); i++) {
			WebElement dueAmountCell = driver
					.findElement(By.xpath("//table[@id='TblReceipt']/tbody/tr[" + i + "]/td[5]"));
			String dueAmountText = dueAmountCell.getText().replaceAll("[^0-9.]", "");

			if (!dueAmountText.isEmpty()) {
				WebElement amountInput = driver
						.findElement(By.xpath("//table[@id='TblReceipt']/tbody/tr[" + i + "]/td[7]//input"));

				amountInput.clear();
				amountInput.click();
				// amountInput.sendKeys(dueAmountText);
				HelperClass.setValueUsingJS(amountInput, dueAmountText);

				System.out.println("Entered amount " + dueAmountText + " in row " + i);

			}
		}
		Thread.sleep(2000);
		HelperClass.waitUntilClickable(wait, By.xpath("//div[@class='clearfix pull-right']//button[1]"));
		HelperClass.ClickUsingJS(driver, By.xpath("//div[@class='clearfix pull-right']//button[1]"));
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='txtSearch']")));
		HelperClass.sendKeys(By.xpath("//input[@id='txtSearch']"), customerName);
		Thread.sleep(1000);
	}

	public void ReceiptEditing() throws InterruptedException {
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Edit");
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@id='txtDesc'])[2]")));
		Thread.sleep(2000);
		HelperClass.sendKeys(By.xpath("(//input[@id='txtDesc'])[2]"), "Testing");
		Thread.sleep(1000);
		HelperClass.ClickUsingJS(driver, By.xpath("//button[@class='btn btn  btn-save btn-azure']"));
	}

	public void ReceiptDelete() {
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Delete");
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='bootbox-body']")));
		try {
			WebElement popup = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Delete Confirmation')]")));

			WebElement okButton = driver
					.findElement(By.xpath("//button[contains(text(),'OK') and contains(@class,'btn')]"));
			okButton.click();

			System.out.println("Delete confirmation handled.");
		} catch (TimeoutException e) {
			System.out.println("Delete popup not displayed.");
		}
	}

	public void DownloadReceipts() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@id='ddlaction'])[1]")));
		HelperClass.selectOptionByVisibleText(By.xpath("(//select[@id='ddlaction'])[1]"), "Download Pdf");

	}

}
