package com.example.webguidemo;

import java.util.Locale;

public class PolStories extends LocalizedStories {
	
	private Pages pages;
    
    @Override
    protected Locale locale() {
        return new Locale("pol");
    }

    @Override
    protected String storyPattern() {
        return "**/*.historia";
    }

    @Override
    protected Object localizedSteps() {
        return new BooksSteps(pages);
    }
 
}
