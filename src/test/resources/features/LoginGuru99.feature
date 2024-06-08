Feature: Feature to test login functionality
@SmokeTest
Scenario: Check login is successful with valid credentials
Given user is on Login page
When user validates login functionality of "OrangeHRM"
Then user should see the Home page

@RegressionTest
Scenario: Check login is successful with valid credentials2
Given user is on Login page
When user validates login functionality of "Guru99"
Then user should see the Home page

@HealthCheckTest
Scenario: Check login is successful with valid credentials2
Given user is on Login page
When user validates login functionality of "Guru99"
Then user should see the Home page


