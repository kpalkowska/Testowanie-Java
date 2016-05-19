package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Books extends WebDriverPage {

	public Books(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("https://books1.herokuapp.com/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}
