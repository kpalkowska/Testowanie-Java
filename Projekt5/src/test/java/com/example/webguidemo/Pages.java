package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;
import com.example.webguidemo.pages.Books;

public class Pages {

	private WebDriverProvider driverProvider;
	
	private Books books;

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Books books() {
		if (books == null) {
			books = new Books(driverProvider);
		}
		return books;
	}
}
