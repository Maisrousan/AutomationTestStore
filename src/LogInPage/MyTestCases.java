package LogInPage;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	
	
	private static final String Threed = null;
	WebDriver driver = new ChromeDriver();
	String theURL = "https://automationteststore.com/" ;
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create" ; 
	Random rand = new Random();
	
	
	@BeforeTest 
	public void MySetUp () {
		
		driver.get(theURL);
		driver.manage().window().maximize();
		
		
	}
	
	@Test (priority= 1)
	
	public void Signup () throws InterruptedException {
		
		driver.navigate().to(SignupPage);
		
		
		
	
		
		//Elements 
		WebElement FirstNamesInput=driver.findElement(By.xpath("//input[@id='AccountFrm_firstname']"));
		WebElement LastNameInput = driver.findElement(By.xpath("//input[@id='AccountFrm_lastname']"));
		WebElement EmailInput = driver.findElement(By.id("AccountFrm_email"));
		WebElement TelephoneInput = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement FaxInput = driver.findElement(By.id("AccountFrm_fax"));
		WebElement CompanyInput = driver.findElement(By.id("AccountFrm_company"));
		WebElement Address1Input = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement Address2Input = driver.findElement(By.id("AccountFrm_address_2"));
		WebElement CityInput = driver.findElement(By.id("AccountFrm_city"));
		WebElement StateInput = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement ZIPCodeInput = driver.findElement(By.id("AccountFrm_postcode"));
		WebElement CountryInput = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement LoginNameInput = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement PasswordInput = driver.findElement(By.id("AccountFrm_password"));
		WebElement PasswordConfirmInput = driver.findElement(By.id("AccountFrm_confirm"));
		WebElement Agreebox = driver.findElement(By.id("AccountFrm_agree"));
		WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-orange.pull-right.lock-on-click"));


		//Data
		
		String[] FirstNames = {"Mais" , "Noor" , "Yaqout" , "Tuqa" ,"Wafaa" ,"Haifa"};
		int randomIndexForFirstName = rand.nextInt(FirstNames.length);
		String randomFirstName = FirstNames[randomIndexForFirstName];
		
		
		
	    String [] LastNames = {"Saif" , "Basel"};
	    int randomIndexForLastName = rand.nextInt(LastNames.length);
	    String randomLastName = LastNames[randomIndexForLastName];
	    
	    int randomNumberForEmail = rand.nextInt(8000);
	    
	    
	    String Email = randomFirstName + randomLastName + randomNumberForEmail + "@gmail.com";
	    String Telephone = "87987638";
	    String Fax = "mm99";
	    String Company = "freema";
	    String Address1 = "Irbid" ;
	    String Address2 = "Irbid"; 
	    String City ="Irbid";
	    String State = "";
	    String ZIPCode="0000";
	    String Country ="Irbid";
	    String LoginName= randomFirstName+randomLastName+ randomNumberForEmail ;
	    String Password ="Nn0000//";
	  
	    
	    
		
		
		//Actions
		FirstNamesInput.sendKeys(randomFirstName);
		LastNameInput.sendKeys(randomLastName);
		EmailInput.sendKeys(Email);
		TelephoneInput.sendKeys(Telephone);
		FaxInput.sendKeys(Fax);
		CompanyInput.sendKeys(Country);
		Address1Input.sendKeys(Address1);
		Address2Input.sendKeys(Address2);
		CityInput.sendKeys(City);
		
	
		Select myselectforcountry = new Select(CountryInput);
		myselectforcountry.selectByContainsVisibleText("Jordan");
		
		Thread.sleep(1000);
		
		
		
		
		int sizeofoptions = StateInput.findElements(By.tagName("option")).size();

		
		
		
		
		Select myselectforstate = new Select(StateInput);
	 	int randomstateindex = rand.nextInt(1 ,sizeofoptions);
	myselectforstate.selectByValue("1705");		
		
// 	Select myselectforstate = new Select(StateInput);
// 	int randomstateindex = rand.nextInt(1 ,sizeofoptions);
//	myselectforstate.selectByIndex(randomstateindex);		
		
		
		
		ZIPCodeInput.sendKeys(ZIPCode);
		LoginNameInput.sendKeys(LoginName);
		PasswordInput.sendKeys(Password);
		PasswordConfirmInput.sendKeys(Password);
		Agreebox.click();
		ContinueButton.click();
	}

}
	

	
	
	
	

