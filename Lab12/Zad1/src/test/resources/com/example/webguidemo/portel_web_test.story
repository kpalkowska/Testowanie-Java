Scenario: User try to login
 
Given user is on login page
When user enter login and password
When user click login button
Then user is logged in

Scenario: User enter bad pass

When user enter bad password
When user click login button
Then user is not logged in