package test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Formularz {

	private WebDriver driver;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[1]/div[2]")
	private WebElement sex;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[1]/div[2]/div[3]/div[3]")
	private WebElement woman;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[3]/div/div/div/content/span")
	private WebElement sendButton;

	@FindBy(id = "i.err.1845308767")
	private WebElement errorFirst;

	@FindBy(id = "i.err.1493362538")
	private WebElement errorSecond;

	@FindBy(id = "i.err.1218214957")
	private WebElement errorThird;
	
	@FindBy(id = "i.err.1218214957")
	private WebElement errorFourth;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[2]/div[2]/div/content/label[1]/div[2]/div/span")
	private WebElement radioButton1;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[2]/div[2]/div/content/label[2]/div[2]/div/span")
	private WebElement radioButton2;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[2]/div[2]/div/content/label[3]/div[2]/div/span")
	private WebElement radioButton3;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[2]/div[2]/div/content/label[4]/div[2]/div/span")
	private WebElement radioButton4;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[2]/div[2]/div/content/label[5]/div[2]/div/span")
	private WebElement radioButton5;
	
	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[3]/div[2]/div[1]/label/div[1]/div[2]")
	private WebElement checkbox1;

	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[3]/div[2]/div[2]/label/div[1]/div[2]")
	private WebElement checkbox2;
	
	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[3]/div[2]/div[3]/label/div[1]/div[2]")
	private WebElement checkbox3;
	
	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[3]/div[2]/div[4]/label/div[1]/div[2]")
	private WebElement checkbox4;
	
	@FindBy(how = How.XPATH, using = "id('mG61Hd')/div/div[2]/div[2]/div[3]/div[2]/div[5]/label/div[1]/div[2]")
	private WebElement checkbox5;
	
	private List<WebElement> checkboxList = new ArrayList<WebElement>();
	private List<WebElement> checkboxList2 = new ArrayList<WebElement>();
	
	private static String PAGE_URL = "http://goo.gl/forms/IHKps8Yp24";

	public Formularz(WebDriver driver) {
		this.driver = driver;
		driver.get(PAGE_URL);
		PageFactory.initElements(driver, this);
	}

	public void selectSex() {
		sex.click();
		Actions actions = new Actions(driver);
		actions.moveToElement(woman);
		actions.perform();
		woman.click();
	}

	public void selectAnswer() {
		radioButton3.click();
	}
	
	public void selectDuties() {
		checkbox1.click();
		checkbox2.click();
		checkbox3.click();
		
		checkboxList.add(checkbox1);
		checkboxList.add(checkbox2);
		checkboxList.add(checkbox3);
	}
	
	public void selectTooMuchDuties() {
		checkbox1.click();
		checkbox2.click();
		checkbox3.click();
		checkbox4.click();
		
		checkboxList2.add(checkbox1);
		checkboxList2.add(checkbox2);
		checkboxList2.add(checkbox3);
		checkboxList2.add(checkbox4);
	}
	
	public String getFourthError(){
		return errorFourth.getText();
	}
	
	public int answer3(){
		return checkboxList.size();
	}

	public String answer2() {
		return radioButton3.getText();
	}

	public String isWoman() {
		return woman.getText();
	}

	public void sendForm() {
		sendButton.click();
	}

	public String getFirstError() {
		return errorFirst.getText();
	}

	public String getSecondError() {
		return errorSecond.getText();
	}

	public String getThirdError() {
		return errorThird.getText();
	}
}
