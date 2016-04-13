Scenario:  Test MyStack4
Given the empty stack
Then isEmpty should be true
Given a new item by 2
When a new item is pushed
Then isEmpty should be false
Given a new item by 4
When a new item is pushed
Then arrayTop should 4
When pop from the stack
Then arrayTop should 2
Given a new item by 6
When a new item is pushed
Then arrayTop should 6
					 
Scenario: Test MyStack5
Given the empty stack
Then arrayTop should throw an exception

Scenario: Test MyStack6
Given the empty stack
Then pop should throw an exception