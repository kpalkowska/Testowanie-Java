import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	private WebDriver driver;
	
	@FindBy(how = How.CLASS_NAME, using = "c2")
	private WebElement ogloszenia;
	
	@FindBy(id = "slw_in")
	private WebElement searchTxt;
	
	@FindBy(id = "wynikiDiv")
	private WebElement wyniki;

   private static String PAGE_URL="http://www.portel.pl";

   public HomePage(WebDriver driver){
       this.driver=driver;
       driver.get(PAGE_URL);
       PageFactory.initElements(driver, this);
   }
   
   public void clickOnAddsLink(){
	   ogloszenia.click();
   }
   
   public void setKeysToSearch(){
	   searchTxt.clear();
	   searchTxt.sendKeys("selenium");
   }
   
   public String isInformation(){
	   return wyniki.getText();
   }
}
