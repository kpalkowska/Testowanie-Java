package com.example.webguidemo;

import org.jbehave.web.selenium.WebDriverProvider;
import com.example.webguidemo.pages.Interia;
import com.example.webguidemo.pages.Wp;

public class Pages {

	private WebDriverProvider driverProvider;
	
	private Interia interia;
	private Wp wp;

	public Pages(WebDriverProvider driverProvider) {
		super();
		this.driverProvider = driverProvider;
	}

	public Interia interia() {
		if (interia == null) {
			interia = new Interia(driverProvider);
		}
		return interia;
	}
	
	public Wp wp() {
		if (wp == null) {
			wp = new Wp(driverProvider);
		}
		return wp;
	}
}
