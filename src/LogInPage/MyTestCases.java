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
		
		WebElement FirstName = driver.findElement(By.xpath("//*[@id=\"AccountFrm_firstname\"]"));
		
		FirstName.sendKeys("Mais");
	}

	//Hi

	
	
	
	
	
}
