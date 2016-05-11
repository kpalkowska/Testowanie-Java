Scenario: User try to calculate
 
Given user is on calculator page
When user enter tangent 180
Then result is 0

Scenario: Parameters

When user enter tangent <value>
Then result is <result>

Examples:
|value|result|
|180|0|
|45|1|
|90|infinity|