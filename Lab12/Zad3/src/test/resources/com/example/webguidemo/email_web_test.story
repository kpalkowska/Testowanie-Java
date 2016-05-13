Scenario: Bad password
 
Given user is on interia page
When user enter bad interia login and password
Then user is not logged in interia

Scenario: Sending email

Given user is on interia page
When user enter interia login and password
Then user is logged in interia
When user try to send without receiver
Then email was not send
When user enter receiver
Then email was send to wp

Scenario: Receive email

Given user is on wp page
When user enter wp login and password
Then user is logged in wp
When user receive email from interia
Then email was received at wp

Scenario: Answer and delete email

Given user is on wp page
When user enter wp login and password
Then user is logged in wp
When user answer email from wp
Then email was send to interia
When user deletes email
Then email is deleted
