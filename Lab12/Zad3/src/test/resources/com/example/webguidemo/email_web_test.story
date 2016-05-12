Scenario: User try to send email
 
Given user is on interia page
When user enter interia login and password
Then user is logged in interia
When user send email from interia
Then email was send to wp

Scenario: User try to receive email

Given user is on wp page
When user enter wp login and password
Then user is logged in wp
When user receive email from interia
Then email was received at wp
When user answer email from wp
Then email was send to interia
