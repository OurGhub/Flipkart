
Feature: Search for a product 

@Regression
Scenario: Verify the page title and URL

Given user url in browser
When user validate title and URL from application

@Regression
Scenario Outline: Verify user enter special character in search Box filed

Given user launch url
When user search for a product in search bar by entering "<DifferentCharacter>" 
Then user will not get any dropdown option

Examples:
|DifferentCharacter|
|#@#$$$%%%|
|124536565|
|12453 #$$%%|
|M|
|   |

@functional
Scenario: Verify User search for a product in a Home page

Given user launch url
When user search for specific product in search bar
And search dropdown list will disply
Then user selects first item from dropdown
