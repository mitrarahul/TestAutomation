Feature: Signin into application

Scenario Outline: Positive Test Case Validaiton

Given Browser initialization with a chosen web browser
And Navigate to the landing page "https://rahulshettyacademy.com/#/index" site
And User clicks on login link
When User tries to login via <username> and <password> and clicks on login button
Then Verify user is signed in successfully
And driver is closed

Examples: 
|username					|password|
|talk.to.rahul.247@gmail.com|pass	 |
|talk.to.rahul.247@gmail.com|P@ssw0rd|
|rahul.247@gmail.co			|P@ssw0rd|