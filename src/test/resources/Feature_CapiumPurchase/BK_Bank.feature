Feature: BankPage
 
Background: User login
  Given Launch the browser
  And User need to enter the Application Url
  When User Enter username and Password
  Then User Click on login button
  And redirect to Bookkeeping module
 @Bank @Regression   
Scenario: Validate Bank dashboard
Given Enter into client
Given Verify bank dashboard
  @Bank @Regression 
Scenario: Validate add bank page
Given Enter into client
Given Verify bank dashboard
Then Click on bank and verify bank page
  @Bank @Regression 
Scenario: Verify add bank functionality
Given Enter into client
Given Verify bank dashboard
Then Click on bank and verify bank page
And Enter valide credtentials and save bank
  @Bank @Regression 
Scenario: Verify bank which we created
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
  @Bank @Regression 
Scenario: Verify manual import functionality with saveandclose
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on manual import and enter mandatory details and saveandclose
  @Bank @Regression 
Scenario: Verify manual import functionality with save and new
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on manual import and enter mandatory details and saveandnew
  @Bank @Regression 
Scenario: Verify manual import functionality with add row
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on manual import and enter mandatory details and add row
  @Bank @Regression 
Scenario: Verify Bank import functionality
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on bank import and import banks using excelfile
  @Bank @Regression 
Scenario: Verify add quickentry functionality
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on quickentry and ennter all mandatory details and save
  @Bank @Regression 
Scenario: Verify add journals functionality
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on journals and ennter all mandatory details and save
  @Bank @Regression 
Scenario: Verify direct payment in action dropdown
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on actiondropdown and ennter all mandatory details in directpayment and save
  @Bank @Regression 
Scenario: Verify supplier account in action dropdown
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on actiondropdown and ennter all mandatory details in supplieraccount and save
  @Bank @Regression 
Scenario: Verify Transfer in action dropdown
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on actiondropdown and ennter all mandatory details in transfer and save
  @Bank @Regression 
Scenario: Verify new purchase in action dropdown
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on actiondropdown and ennter all mandatory details in new purchase and save
  @Bank @Regression 
Scenario: Verify customer account in action dropdown
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on actiondropdown and ennter all mandatory details in customer account and save
  @Bank @Regression 
Scenario: Verify direct reciept in action dropdown
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Click on actiondropdown and ennter all mandatory details in direct recipet and save
  @Bank @Regression 
Scenario: Verify refund in action dropdown
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Validate refund functionality in action dropdown
  @Bank @Regression 
Scenario: Verify exports email and excel
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Validate exports pdf or excel
  @Bank @Regression 
Scenario: Verify delete from action dropdown
Given Enter into client
Given Verify bank dashboard
Then Click and verify the bank which we created
And Validate delete from aaction dropdown
  @Bank @Regression 
Scenario: verify bank transfer page
Given Enter into client
Given Verify bank dashboard
Then Click on bank transfer and verify page
  @Bank @Regression 
Scenario: verify bank transfer adding
Given Enter into client
Given Verify bank dashboard
Then Click on bank transfer enter mandatory details
  @Bank @Regression 
Scenario: Verify exports in banktransfer page
Given Enter into client
Given Verify bank dashboard
Then Click on bank transfer and verify page
