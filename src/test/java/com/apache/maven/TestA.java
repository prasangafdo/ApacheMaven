package com.apache.maven;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestA {

	static{
		System.setProperty("webdriver.chrome.driver", "C:/Users/Prasanga Fernando/Documents/Eclipse/TestNG_PageTitle/chromedriver/chromedriver.exe");
	}

	WebDriver driver = new ChromeDriver();

	@BeforeClass
	public void navigateToLogion() {

		driver.get("https://opensource-demo.orangehrmlive.com/");

	}

	@Test(priority=1)
	public void verifyLoginwithInvalidCredentials() {

		String username = "aaa";
		String password = "vdsgf";

		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);	
		driver.findElement(By.name("Submit")).click();

		String status = "Verify login error message: ";
		String errorMessage = driver.findElement(By.id("spanMessage")).getText();
		//System.out.println(errorMessage);

		if(errorMessage.equals("Invalid credentials")) {
			status = status.concat("Pass");
		}
		Assert.assertEquals(errorMessage, "Invalid credentials");

		System.out.println(status);

	}

	@Test(priority =2)
	public void verifyLoginwithValidCredentials() {

		String username = "Admin";
		String password = "admin123";

		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);	
		driver.findElement(By.name("Submit")).click();

		String expectedUrl = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";
		String actualUrl = driver.getCurrentUrl();
		
		Assert.assertEquals(actualUrl, expectedUrl);

	}

	@Test
	public void verifyHelloWorld() {
		Assert.assertEquals("Aaa", "Aaa");

		System.out.println("This is Hello World");
	}

	@Test
	public void method2() {
		Assert.assertEquals("Aaa", "Aaa");
		//System.out.println("This is Hello World");
	}
	
	@AfterClass
	public void closeBrowser(){
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.close();
	}
	

}
