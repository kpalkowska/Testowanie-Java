Scenario:  1
Given a new numbers <a> and <b>
Then titit should <n>

Examples:
|a|b|n|
|15|-5|true|
|16|-5|false|
|0|12|true|

Scenario: 2
When argument is null
Then titit throw an NullPointerException

Scenario: 3
When second argument is 0
Then titit throw an IllegalArgumentException

Examples:
|a|b|
|12|0|