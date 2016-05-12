package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Interia extends WebDriverPage {

	public Interia(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("https://poczta.interia.pl/");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}
