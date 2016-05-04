package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Projekt {
	
	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "/html/body/header/div/nav/ul/li[3]/a")
	private WebElement login;
	
	@FindBy(id = "session_email")
	private WebElement email;
	
	@FindBy(id = "session_password")
	private WebElement password;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/input[5]")
	private WebElement loginBtn;
	
	@FindBy(id = "logo")
	private WebElement logo;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/a")
	private WebElement add;
	
	@FindBy(id = "book_name")
	private WebElement name;
	
	@FindBy(id = "book_description")
	private WebElement desc;
	
	@FindBy(id = "book_price")
	private WebElement price;
	
	@FindBy(id = "book_author_id")
	private WebElement author;
	
	@FindBy(id = "book_img_url")
	private WebElement img;
	
	@FindBy(how = How.XPATH, using = "id('new_book')/div[6]/input")
	private WebElement createBtn;

	@FindBy(how = How.XPATH, using = "/html/body/div/a[2]")
	private WebElement backBtn;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/ul/li[13]/a")
	private WebElement lastPage;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr[1]/td[5]/a")
	private WebElement show;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/p[2]")
	private WebElement title;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr[9]/td[1]")
	public WebElement addedName;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr[9]/td[7]/a")
	private WebElement delete;

	@FindBy(how = How.XPATH, using = "/html/body/div/div[1]")
	private WebElement info;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div[1]")
	public WebElement notLogged;
	
	@FindBy(how = How.XPATH, using = "/html/body/header/div/nav/ul/li[4]/ul/li[4]/a")
	private WebElement logout;

	@FindBy(how = How.XPATH, using = "/html/body/header/div/nav/ul/li[4]/a")
	private WebElement account;
	
	@FindBy(how = How.XPATH, using = "id('error_explanation')/div")
	public WebElement emptyError;
	
	private static String PAGE_URL = "https://books1.herokuapp.com/";

	public Projekt(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver, this);
	}
	
	public void login(){
		login.click();
		email.sendKeys("kp.elblag@wp.pl");
		password.sendKeys("123456");
		loginBtn.click();
	}
	
	public void badLogin(){
		login.click();
		email.sendKeys("kp.elblag@wp.pl");
		password.sendKeys("123456x");
		loginBtn.click();
	}
	
}
