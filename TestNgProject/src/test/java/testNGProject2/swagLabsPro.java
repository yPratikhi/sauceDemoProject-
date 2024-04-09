package testNGProject2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
//import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class swagLabsPro {

	   WebDriver driver;
	   ExtentTest test;
	   ExtentReports er;
	
	   @BeforeClass
		public void reportConfig() {
			er=new ExtentReports(System.getProperty("user.dir")+"/TestNgSelenium/swagLabs2.html");
			test=er.startTest("Swag Labs");
		}
		
		@BeforeTest
		public void setup() {
			driver = new FirefoxDriver();
			
//			test.log(LogStatus.PASS, "Browser opened successfully");
			
			driver.manage().window().maximize();
			driver.get("https://www.saucedemo.com/");
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
//			test.log(LogStatus.PASS, "URL entered is correct");
		}
	@Test(priority = 1,alwaysRun=true)
	public void oneTest() throws InterruptedException {
	//Login into Web page
		
		test.log(LogStatus.PASS,"Login by entering necessary credentials");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		Thread.sleep(1000);
		driver.findElement(By.id("login-button")).click();
		test.log(LogStatus.PASS,">Login Successful");
	}

	@Test(priority = 2,alwaysRun=true)
	public void twoTest() throws InterruptedException {
		//After login select specific item.
	
		test.log(LogStatus.PASS,"Click on Add to cart");
		Thread.sleep(1000);
		
		driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
		
		
		
		test.log(LogStatus.PASS,">Add to Cart Successful");
	}

	@Test(priority = 3 ,alwaysRun=true)
	public void threeTest() throws InterruptedException {
		//Clicking on the add to cart icon
		test.log(LogStatus.PASS,"Click and ensure added item is there in the cart");
		Thread.sleep(1000);
		driver.findElement(By.className("shopping_cart_link")).click();
		
		test.log(LogStatus.PASS,">Click to Cart icon Successful");
	}

	@Test(priority = 4,alwaysRun=true)
	public void fourTest() throws InterruptedException {
		//checkout option selection
		test.log(LogStatus.PASS,"Proceed with checkout");
		Thread.sleep(1000);

		driver.findElement(By.id("checkout")).click();
		
		test.log(LogStatus.PASS,">Checkout Successful");
	}

	@Test(priority = 5,alwaysRun=true)
	public void fiveTest() throws InterruptedException {
		
		test.log(LogStatus.PASS,"Enter necessary details and continue");
		
		//Checkout Details
		driver.findElement(By.id("first-name")).sendKeys("pratik");
		driver.findElement(By.id("last-name")).sendKeys("yadav");
		driver.findElement(By.id("postal-code")).sendKeys("400083");
		Thread.sleep(1000);
		driver.findElement(By.id("continue")).click();
		
		test.log(LogStatus.PASS,">Necessary details Successful");
	}

	@Test(priority=6,alwaysRun=true)
	public void sixTest() throws InterruptedException {
	
		test.log(LogStatus.PASS,"Click on Finish");
		Thread.sleep(1000);
		//Click on fines
		driver.findElement(By.id("finish")).click();
		test.log(LogStatus.PASS,">Finish Successful");
	
	}
	@Test(priority=7,alwaysRun=true)
	public void sevenTest() {
		test.log(LogStatus.PASS,"Display the “Thank you for your order” in console");
		System.out.println("*********Thank you for your order*********");
		test.log(LogStatus.PASS,">Display the “Thank you for your order” in console Successful");
	}
	
	@Test(priority=8,alwaysRun=true)
	public void eightTest() throws IOException {
         test.log(LogStatus.PASS,"Taking screenshort");
		
		//Taking screen short
		TakesScreenshot tc = (TakesScreenshot)driver;
		//Method to create file
		File src = tc.getScreenshotAs(OutputType.FILE);
		//Creating file storing screen short
		File destFile = new File("C:\\Users\\yprat\\Pictures\\Screenshots\\swagLabs2.png");
		
		//Copy the file at location
		 FileUtils.copyFile(src, destFile);
		
		test.log(LogStatus.PASS,">Taking screenshort  Successful");
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}

	@AfterClass
	public void reportflush() {
			
		er.endTest(test);
		
		er.flush();
		
		
	}
	
}
