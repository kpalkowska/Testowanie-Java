GivenStories: zad1/scenario2.story,
			  zad1/scenario3.story

Scenario:  Test MyStack
Given the empty stack
Then isEmpty should be true
Given a new value by 2
When a new value pushed
Then isEmpty should be false
Given a new value by 4
When a new value pushed
Then arrayTop should 4
When pop from the stack
Then arrayTop should 2
Given a new value by 6
When a new value pushed
Then arrayTop should 6