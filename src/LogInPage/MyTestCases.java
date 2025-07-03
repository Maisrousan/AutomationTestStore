package LogInPage;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	
	
	WebDriver driver = new ChromeDriver();
	String theURL = "https://automationteststore.com/" ;
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create" ; 
	
	
	
	@BeforeTest 
	public void MySetUp () {
		
		driver.get(theURL);
		driver.manage().window().maximize();
		
		
	}
	
	@Test (priority= 1)
	
	public void Signup () {
		
		driver.navigate().to(SignupPage);
		
		WebElement FirstName = driver.findElement(By.xpath("//input[@id='AccountFrm_firstname']"));
		WebElement LastName = driver.findElement(By.xpath("//input[@id='AccountFrm_lastname']"));
		WebElement Email = driver.findElement(By.id("AccountFrm_email"));
		WebElement Telephone = driver.findElement(By.id("AccountFrm_telephone"));
		WebElement Fax = driver.findElement(By.id("AccountFrm_fax"));
		WebElement Company = driver.findElement(By.id("AccountFrm_company"));
		WebElement Address1 = driver.findElement(By.id("AccountFrm_address_1"));
		WebElement Address2 = driver.findElement(By.id("AccountFrm_address_2"));
		WebElement City = driver.findElement(By.id("AccountFrm_city"));
		//WebElement Region = driver.findElement(By.id("AccountFrm_zone_id"));
		WebElement ZIPCode = driver.findElement(By.id("AccountFrm_postcode"));
		//WebElement Country = driver.findElement(By.id("AccountFrm_country_id"));
		WebElement LoginName = driver.findElement(By.id("AccountFrm_loginname"));
		WebElement Password = driver.findElement(By.id("AccountFrm_password"));
		WebElement PasswordConfirm = driver.findElement(By.id("AccountFrm_confirm"));


		FirstName.sendKeys("Mais");
		LastName.sendKeys("Alrousan");
		Email.sendKeys("maisrousan@gmail.com");
		Telephone.sendKeys("87987638");
		Fax.sendKeys("mm99");
		Company.sendKeys("freema");
		Address1.sendKeys("Irbid");
		Address2.sendKeys("Irbid");
		City.sendKeys("Irbid");
		//Region.sendKeys("Irbid");
		ZIPCode.sendKeys("0000");
		//Country.sendKeys("Irbid");
		LoginName.sendKeys("MaisRousan");
		Password.sendKeys("Nn0000//");
		PasswordConfirm.sendKeys("Nn0000//");
		
		
	}

	

	
	
	
	
	
}
