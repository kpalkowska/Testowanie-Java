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
	public WebElement backBtn;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/div/ul/li[13]/a")
	public WebElement lastPage;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr[1]/td[5]/a")
	private WebElement show;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/p[2]")
	private WebElement title;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr[9]/td[1]")
	public WebElement addedName;
	
	@FindBy(how = How.XPATH, using = "/html/body/div/table/tbody/tr[9]/td[7]/a")
	public WebElement delete;

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
	
	public void createBook(){
		logo.click();
		add.click();
		name.sendKeys("Test");
		desc.sendKeys("Test");
		price.sendKeys("10.99");
		author.sendKeys("12");
		img.sendKeys("http://blog.zooplus.pl/wp-content/uploads/sites/8/2014/03/maly_kotek.jpg");
		createBtn.click();
	}
	
	public void clickBack(){
		backBtn.click();
	}
	
	public void lastPage(){
		logo.click();
		lastPage.click();
	}
	
	public void createEmptyBook(){
		logo.click();
		add.click();
		createBtn.click();
	}
	
	public String addedBook(){
		return addedName.getText();
	}
	
	public void deleteBook(){
		logo.click();
		lastPage.click();
		delete.click();
	}
	
	public String infoBook(){
		return info.getText();
	}
	
	public String titleBook(){
		return title.getText();
	}
	
	public String notLogged(){
		return notLogged.getText();
	}
	
	public void showBook(){
		logo.click();
		show.click();
	}
	
	public void logout(){
		account.click();
		logout.click();
	}
	
	public String emptyError(){
		return emptyError.getText();
	}
}
