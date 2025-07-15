package LogInPage;

import static org.testng.Assert.assertEquals;

import java.awt.print.PrinterIOException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTestCases {

	WebDriver driver = new ChromeDriver();
	String theURL = "https://automationteststore.com/";
	String SignupPage = "https://automationteststore.com/index.php?rt=account/create";
	Random rand = new Random();

	String TheUserName;
	String FirstName ; 

	String ThePassword = "Nn0000//";

	@BeforeTest
	public void MySetUp() {

		driver.get(theURL);
		driver.manage().window().maximize();

	}

	@Test(priority = 1, enabled = true)

	public void Signup() throws InterruptedException {

		driver.navigate().to(SignupPage);

		String ConfirmationMessage = "Your Account Has Been Created!";

		// Elements
		WebElement FirstNamesInput = driver.findElement(By.xpath("//input[@id='AccountFrm_firstname']"));
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

		// Data

		String[] FirstNames = { "Mais", "Noor", "Yaqout", "Tuqa", "Wafaa", "Haifa" };
		int randomIndexForFirstName = rand.nextInt(FirstNames.length);
		String randomFirstName = FirstNames[randomIndexForFirstName];
		FirstName = randomFirstName;

		String[] LastNames = { "Saif", "Basel" };
		int randomIndexForLastName = rand.nextInt(LastNames.length);
		String randomLastName = LastNames[randomIndexForLastName];

		int randomNumberForEmail = rand.nextInt(8000);

		String Email = randomFirstName + randomLastName + randomNumberForEmail + "@gmail.com";
		String Telephone = "87987638";
		String Fax = "mm99";
		String Company = "freema";
		String Address1 = "Irbid";
		String Address2 = "Irbid";
		String City = "Irbid";
		String ZIPCode = "0000";
		String Country = "Irbid";
		String LoginName = TheUserName;

		// Actions
		TheUserName = randomFirstName + randomLastName + randomNumberForEmail;

		FirstNamesInput.sendKeys(randomFirstName);
		LastNameInput.sendKeys(randomLastName);
		EmailInput.sendKeys(Email);
		TelephoneInput.sendKeys(Telephone);
		FaxInput.sendKeys(Fax);
		CompanyInput.sendKeys(Company);
		Address1Input.sendKeys(Address1);
		Address2Input.sendKeys(Address2);
		CityInput.sendKeys(City);

//		Select myselectforcountry = new Select(CountryInput);
//		myselectforcountry.selectByContainsVisibleText("Jordan");

		int sizeofcountryoptions = CountryInput.findElements(By.tagName("option")).size();

		Select myselectforcountry = new Select(CountryInput);
		int randomcountryindex = rand.nextInt(1, sizeofcountryoptions);
		myselectforcountry.selectByIndex(randomcountryindex);

		Thread.sleep(1000);

		int sizeofstateoptions = StateInput.findElements(By.tagName("option")).size();

//		Select myselectforstate = new Select(StateInput);
//	 	int randomstateindex = rand.nextInt(1 ,sizeofstateoptions);
//	myselectforstate.selectByValue("1705");		

		Select myselectforstate = new Select(StateInput);
		int randomstateindex = rand.nextInt(1, sizeofstateoptions);
		myselectforstate.selectByIndex(randomstateindex);

		ZIPCodeInput.sendKeys(ZIPCode);
		LoginNameInput.sendKeys(TheUserName);
		PasswordInput.sendKeys(ThePassword);
		PasswordConfirmInput.sendKeys(ThePassword);
		Agreebox.click();
		ContinueButton.click();

		Thread.sleep(3000);

		boolean ActualResult = driver.getPageSource().contains(ConfirmationMessage);

		Assert.assertEquals(ActualResult, true, "this is to test that account has been created");
	}

	// https://automationteststore.com/index.php?rt=account/logout

	@Test(priority = 2, enabled = true)

	public void Logout() {

		String ConfirmationMessage = "You have been logged off your account";

		WebElement LogoutButton = driver.findElement(By.linkText("Logoff"));

		LogoutButton.click();

		WebElement ContinueButton = driver.findElement(By.cssSelector(".btn.btn-default.mr10"));
	
		boolean ActualResult1 = driver.getPageSource().contains(ConfirmationMessage);
		Assert.assertEquals(ActualResult1, true , "this is to test that account has been logged");
		
		
		//optional
		boolean ActualResult2 = driver.getCurrentUrl().contains("https://automationteststore.com/index.php?rt=account/logout");
		boolean ExpectedResult2 = true ;
		Assert.assertEquals(ActualResult2 , ExpectedResult2 , "this is to test that account has been logged");

		ContinueButton.click();

	}

	@Test(priority = 3, enabled = true)

	public void Login() throws InterruptedException {

		WebElement loginButton = driver.findElement(By.partialLinkText("Login or "));
		loginButton.click();

		WebElement LoginInput = driver.findElement(By.id("loginFrm_loginname"));
		LoginInput.sendKeys(TheUserName);

		WebElement PasswordInput = driver.findElement(By.id("loginFrm_password"));
		PasswordInput.sendKeys(ThePassword);

		WebElement LoginPress = driver.findElement(By.xpath("//button[normalize-space()='Login']"));
		LoginPress.click();
		
		Thread.sleep(1000);

		boolean ActualResult = driver.findElement(By.id("customernav")).getText().contains(FirstName);
		Assert.assertEquals(ActualResult, true , "this is to test that account login ");
		
		//optional 

		String ActualResult2 = driver.findElement(By.id("customernav")).getText();
		
		Assert.assertEquals(ActualResult2, "Welcome back "+ FirstName , "this is to test that account login ");
		
	}

//	 
	@Test(priority = 4, invocationCount = 1, enabled = true)

	public void AddToCart1() throws InterruptedException {

		driver.navigate().to(theURL);

		Thread.sleep(3000);

//		 WebElement theIteamContainer = driver.findElement(By.cssSelector("section[id='latest'] div[class='container-fluid']"));
//		 int NumberOfItems = driver.findElement(By.cssSelector(".thumbnails.list-inline")).findElements(By.tagName("div")).size();
//		
//		 
//		 System.out.println(NumberOfItems);
//		 
		List<WebElement> TheListOfItemsize = driver.findElements(By.className("prdocutname"));

		int TotalNumberOfItems = TheListOfItemsize.size();
		System.out.println(TotalNumberOfItems);
		int RandomItemIndex = rand.nextInt(TotalNumberOfItems);
		TheListOfItemsize.get(RandomItemIndex).click();

		WebElement AddCartButton = driver.findElement(By.className("productpagecart"));

		if (AddCartButton.getText().equals("Out of Stock")) {
			driver.navigate().back();

			System.out.println("Sorry the item out of the stock");

		} else {

			// System.out.println("The item is available");
			if (driver.getCurrentUrl().contains("product_id=116")) {

				driver.findElement(By.xpath("//input[@id='option344747']")).click();
			}

			AddCartButton.click();

			WebElement CheckOutButton = driver.findElement(By.linkText("Checkout"));
			
			boolean ActualResult = driver.getPageSource().contains("Shopping Cart");
			Assert.assertEquals(ActualResult, true ,"this is to test add to cart");
			
			
			//CheckOutButton.click();

		}

	}

//	 

	@Test(priority = 4, enabled = false)

	public void Availability() throws InterruptedException {

		driver.navigate().to(theURL);

		Thread.sleep(3000);

//		 WebElement theIteamContainer = driver.findElement(By.cssSelector("section[id='latest'] div[class='container-fluid']"));
//		 int NumberOfItems = driver.findElement(By.cssSelector(".thumbnails.list-inline")).findElements(By.tagName("div")).size();
//		
//		 
//		 System.out.println(NumberOfItems);
//		 
		List<WebElement> TheListOfItemsize = driver.findElements(By.className("prdocutname"));

		int TotalNumberOfItems = TheListOfItemsize.size();
		// System.out.println(TotalNumberOfItems);
		int RandomItemIndex = rand.nextInt(4);
		TheListOfItemsize.get(RandomItemIndex).click();
		if (driver.getPageSource().contains("Out of Stock")) {
			driver.navigate().back();

			System.out.println("Sorry the item out of the stock");

		}

	}

	@Test(priority = 5, enabled = false)

	public void AddToCart() {

		WebElement QtyInput = driver.findElement(By.id("product_quantity"));

		WebElement AddToCart = driver.findElement(By.xpath("//a[normalize-space()='Add to Cart']"));

		WebElement UnitPrice = driver.findElement(By.xpath("//div[@class='productfilneprice']"));

		QtyInput.clear();

		int RandomQtynumber = rand.nextInt(2, 10);

		QtyInput.sendKeys(String.valueOf(RandomQtynumber));

		String Unitpricetext = UnitPrice.getText();
		String CleanUnitprice = Unitpricetext.replace("$", "");

		Double Unitpricedo = Double.parseDouble(CleanUnitprice);
		Double TotalPrice2 = Unitpricedo * RandomQtynumber;

		AddToCart.click();

		WebElement TotalPrice = driver.findElement(By.cssSelector("span[class='bold totalamout']"));

		String TotalPricetext = TotalPrice.getText();
		String TotalPriceSt = TotalPricetext.replace("$", "");

		Double Totaldo = Double.parseDouble(TotalPriceSt);

		Double TotalPricewithShipping = 2.00 + TotalPrice2;
		if (Math.abs(Totaldo - TotalPricewithShipping) < 0.01) {

			System.out.println("The test is pass");

		}

	}

}
