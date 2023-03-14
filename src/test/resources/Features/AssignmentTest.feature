@CreateUserAccount
Feature: Create an Account

  Background: 
    Given Open the browser and Launch the application

#1. Visit the URL. https://magento.softwaretestingboard.com/
#2. Navigate to Create an Account
#3. Manually Create an account using fake emails (no authentication needed) and Signout
#4. Navigate to Sign In
#5. Verify Account details in home page

 Scenario: Verify the account details in the home page by creating an account, Signout and SignIN
    Given User clicks on Create An Account link
    Given User clicks on Create An Account link
    And User provides all personal information
    When User clicks on Create An Account button
    Then Account is successfully created
    When User logs out and signIn
    And Verify the account details in the home page
    
    

  Scenario Outline: Verify the error message when mandatory details is missed while doing registration
    Given User clicks on Create An Account link
    And User provides personal information by missing "<missingInfo>"
    When User clicks on Create An Account button
    Then User verifies the error message for missing field

    Examples: 
      | missingInfo     |
      | firstName       |
      | lastName        |
      | Email           |
      | Password        |
      | ConfirmPassword |

  Scenario: Verify the error message when all fields are missed while doing registration
    Given User clicks on Create An Account link
    When User clicks on Create An Account button
    Then User verifies the error message for missing all fields
 
