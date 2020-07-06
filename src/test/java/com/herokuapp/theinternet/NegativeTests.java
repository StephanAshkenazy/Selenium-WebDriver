package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTests {

	@Test
	public void incorrectUsernameTest() {
		System.out.println("\n**** Starting the incorrect username test ****");

//	SetUp: Create Drive for Chrome browser
//		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		
		// maximize the browser window
		driver.manage().window().maximize();

//	Test steps:

//	Step 1: Open the test page URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("\n**** Step 1: Open the test page URL ****");

//	Step 2: Enter the incorrect user-name
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("incorrect");
		System.out.println("\n**** Step 2: Enter the incorrect user-name ****");

//	Step 3: Enter the correct password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");
		System.out.println("\n**** Step 3: Enter the correct password ****");

//	Step 4: Click on Login button 
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();
		System.out.println("\n**** Step 4: Click on Login button ****");

//	Verifications:

//	Step4a: Failure login message
		WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "Your username is invalid!";
		String actualMessage = errorMessage.getText();

		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"\nThe actual message does not contain the expected message.\nActual message: " + actualMessage
						+ "\nExpected message: " + expectedMessage);
		System.out.println(
				"\n**** Step 4c: Successful login message\nThe actual message does contain the expected message.\nActual message: "
						+ actualMessage + "\nExpected message: " + expectedMessage);

//	Close the browser	
		driver.quit();
		System.out.println("\n**** The page is closed ****");

	}

	
	
	@Test
	public void incorrectPaasswordTest() {
		System.out.println("\n**** Starting the incorrect password test ****");

//	SetUp: Create Drive for Chrome browser
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// maximize the browser window
		driver.manage().window().maximize();

//	Test steps:

//	Step 1: Open the test page URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("\n**** Step 1: Open the test page URL ****");

//	Step 2: Enter the correct user-name
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");
		System.out.println("\n**** Step 2: Enter the correct user-name ****");

//	Step 3: Enter the incorrect password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("IncorrectPassword!");
		System.out.println("\n**** Step 3: Enter the incorrect password ****");

//	Step 4: Click on Login button 
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();
		System.out.println("\n**** Step 4: Click on Login button ****");

//	Verifications:

//	Step4a: Failure login message
		WebElement errorMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "Your password is invalid!";
		String actualMessage = errorMessage.getText();

		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"\nThe actual message does not contain the expected message.\nActual message: " + actualMessage
						+ "\nExpected message: " + expectedMessage);
		System.out.println(
				"\n**** Step 4c: Successful login message\nThe actual message does contain the expected message.\nActual message: "
						+ actualMessage + "\nExpected message: " + expectedMessage);

//	Close the browser	
		driver.quit();
		System.out.println("\n**** The page is closed ****");

	}

//	private void sleep(long time_ms) {
//		try {
//			Thread.sleep(time_ms);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

}
