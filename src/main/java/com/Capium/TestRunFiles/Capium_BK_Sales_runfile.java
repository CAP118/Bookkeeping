package com.Capium.TestRunFiles;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "D:\\Core Modules\\Capium_BK_3.0\\src\\test\\resources\\Feature_CapiumPurchase\\BK_Sales.feature",

		glue = { "com.Capium.stepDefinations" }, tags="@Regression", plugin = { "pretty",
				"html:target/cucumber-html-report", "json:target/cucumber-reports/CucumberReport.json",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }, monochrome = true)
public class Capium_BK_Sales_runfile extends AbstractTestNGCucumberTests{

}
 