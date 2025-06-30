
Feature: BookkeepingModule-Sales

  Background: User login
  Given Launch the browser
  And User need to enter the Application Url
  When User Enter username and Password
  Then User Click on login button
  And redirect to Bookkeeping module

  @Sales @Regression
  Scenario: Sales Dashboard functionality
    Given Enter into client
    Given Click on Sales drop down
    When Click on Dashboard
    Then Verify All links and buttons in Sales Summary dashboard
    And Click on Sales button it navigate to Create new Invoice page
    And Verify the Create new Invoice page
    And Redirect to Sale dashboard
    And Click on Coustomer button it navigate to Contact list page
    And Verify the Contact list page
    Given Click on Sales drop down
    And Redirect to Sale dashboard
    And Click on Quote button it navigate to Create New Quotation page
    And Verify the Create New Quotation page
    And Redirect to Sale dashboard
    And Click on All Sales link it navigate to Invoices page
    And Verify the Invoices page
    And Redirect to Sale dashboard
    And Click on All Coustomer link it navigate to Contact list page
    And Verify the Contact list page
    Given Click on Sales drop down
    And Redirect to Sale dashboard
    And Click on All Quote link in navigate to Qutations page
    And Verify the Qutations page
    And Redirect to Sale dashboard
    And Verify Sales Chart dashboard
    And Verify Debtors Chart dashboard
    And Verify Links in Current Debtors list dashboard
    And Click on All Debtors link it navigate to Debtors list page
    And Verify the Debtors list page
    Given Click on Sales drop down
    And Redirect to Sale dashboard
    And Verify Links in Recent Sales list dashboard
    And Click on All Sales link in Recent Sales list it navigate to Invoices page
    And Verify the Invoices page
    And Redirect to Sale dashboard

  @Sales @Regression
  Scenario: Sales Invoices
    Given Enter into client
    Given Click on Sales drop down
    And Click on Invoices
    When Click on New Invoice button
    And Enter requried data for invoice
    #Then Click on save and close invoice
 @Sales @Regression
  Scenario: Sales Invoice dropdown
    Given Enter into client
    Given Click on Sales drop down
    And Click on Invoices
    When Click on New Invoice dropdown
    Then Verify Each type of invoice in dropdown

  @Sales @Regression
  Scenario: Invoices Type Satuts and Export
    Given Enter into client
    Given Click on Sales drop down
    And Click on Invoices
    When Click on Type dropdown
    Then Select Sales type and validate
    When Click on Type dropdown
    Then Select Credit Note and validate
    When Click on Type dropdown
    Then Select Draft and validate
    When Click on Type dropdown
    Then Select Recurring and validate
    When Click on Type dropdown
    Then Select All and Validate
    When Click on Status dropdown
    Then Select Paid and validate
    When Click on Status dropdown
    Then Select OutStanding and validate
    When Click on Status dropdown
    Then Select Overdue and validate
    When Click on Status dropdown
    Then Select Status All and validate
    When Click on Export dropdown
    Then Select Export as PDF
    When Click on Export dropdown
    Then Select Export as Excel

  @Sales @Regression
  Scenario: Invoice Select Actions Dropdown
    Given Enter into client
    Given Click on Sales drop down
    And Click on Invoices
    When Click on Invoice Select Action dropdown
    And Select Edit Action and update the data
    When Click on Invoice Select Action dropdown
    And Select Email Action send email
    When Click on Invoice Select Action dropdown
    And Select Download doc Action
    When Click on Invoice Select Action dropdown
    And Select Download PDF Action
    When Click on Invoice Select Action dropdown
    And Select Attachments Action and attach a file
    When Click on Invoice Select Action dropdown
    And Select Delete Action and validate

  @Sales @Regression
  Scenario: Sales Quotations
    Given Enter into client
    Given Click on Sales drop down
    Then Click on Quotations
    And Click on Add New Quotation button and Add Quotation

  @Sales @Regression
  Scenario: Quotation Select Action
    Given Enter into client
    Given Click on Sales drop down
    Then Click on Quotations
    And Click on Quotation Select Action dropdown
    And Click on Edit Quotation and update the data
    And Click on Quotation Select Action dropdown
    And Click on Create invoice and validate
    Then Click on Quotations
    And Click on Quotation Select Action dropdown
    And Click on Download PDF Quotation and validate
    And Click on Quotation Select Action dropdown
    And Click on Email Quotation and validate
    And Click on Quotation Select Action dropdown
    And Click on Delete Quotation and validate

  @Sales @Regression
  Scenario: Sales Recurring Invoices
    Given Enter into client
    Given Click on Sales drop down
    When Click on Recurring invoices
    Then Click on Add New Recuuring Invoice button and Add Recuuring Invoice

  @Sales @Regression
  Scenario: Recurring Select Actions
    Given Enter into client
    Given Click on Sales drop down
    When Click on Recurring invoices
    Then Click on Recurring Invoce select dropdown
    Then Click on Edit Recurring Invoice and update the data
    And Click on Recurring Invoce select dropdown
    And Click on Delete Recurring invoice

  @Sales @Regression
  Scenario: Sales Recepits
    Given Enter into client
    Given Click on Sales drop down
    When Click on Receipts
    Then Click on Add New Receipt and Add Receipt

  @Sales @Regression
  Scenario: Receipts Select Action
    Given Enter into client
    Given Click on Sales drop down
    When Click on Receipts
    Then Click on Receipts Select Action dropdown
    And Click on Edit Receipts
    Then Click on Receipts Select Action dropdown
    And Click on Download PDF Receipts
    Then Click on Receipts Select Action dropdown
    And Click on Delete Receipt
    
    
    
