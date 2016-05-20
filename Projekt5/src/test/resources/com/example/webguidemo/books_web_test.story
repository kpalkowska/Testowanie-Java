Scenario: Login
Given user is on home page
When user enter login and password
Then user is logged in

Scenario: Add book
Given user is on home page
When user add new book
Then book was added