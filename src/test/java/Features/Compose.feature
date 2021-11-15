Feature: Compose functionality

  Scenario: Verify that user is able to succesfully send new email
    Given User opens Chrome and launch the application
    And User logs in with "vaibhavsender@gmail.com" and "V@!bhavTest"
    When Send email with subject "Incubyte" and body "Automation QA test for Incubyte" to "vaibhavsender@gmail.com"
    And Refreshes the mail list
    Then Verify that last received email is from "Vaibhav Vora" and has subject "Incubyte" and body "Automation QA test for Incubyte"
    And Delete the opened mail
