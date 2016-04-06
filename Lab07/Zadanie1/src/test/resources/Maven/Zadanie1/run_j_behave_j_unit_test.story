Scenario:  Test MyStack
Given a new value by 2
When a new value added
Then arrayTop should 2
Given a new value by 4
When a new value added
Then arrayTop should 4
When pop from the stack
Then arrayTop should 2
					 
Scenario: Test MyStack2
When the stack is empty
Then arrayTop should throw an exception

Scenario: Test MyStack3
When the stack is empty
Then pop should throw an exception