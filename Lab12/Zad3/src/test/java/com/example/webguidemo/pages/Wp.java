package com.example.webguidemo.pages;

import java.util.concurrent.TimeUnit;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;

public class Wp extends WebDriverPage {

	public Wp(WebDriverProvider driverProvider) {
		super(driverProvider);
	}

	public void open() {
		get("http://profil.wp.pl/login.html?url=http%3A%2F%2Fpoczta.wp.pl%2Findexgwt.html%3Fflg%3D1&serwis=nowa_poczta_wp");
		manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
}
