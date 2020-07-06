package com.herokuapp.theinternet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTests {

	@Test
	public void loginTest() {
		System.out.println("\n**** Starting positive login test ****");

//	SetUp: Create Drive for Chrome browser
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Sleep for 3 seconds
		// sleep(3000);

//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'kur')]")));
		
		

		// maximize the browser window
		driver.manage().window().maximize();

//	Test steps:

//	Step 1: Open the test page URL
		String url = "https://the-internet.herokuapp.com/login";
		driver.get(url);
		System.out.println("\n**** The page is opened ****");

		// sleep(2000);

//	Step 2: Enter the user-name
		WebElement username = driver.findElement(By.id("username"));
		username.sendKeys("tomsmith");

		// sleep(1000);

//	Step 3: Enter the password
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("SuperSecretPassword!");

		// sleep(3000);

//	Step 4: Click on Login button 
		WebElement logInButton = driver.findElement(By.tagName("button"));
		logInButton.click();

		// sleep(2000);


//	Verifications:

//	Step4a: New URL verifications
		String expectedUrl = "https://the-internet.herokuapp.com/secure";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "\nActual page URL is not as expected");
		System.out.println("\n**** Step 4a: The URL of the page is correct ****");

//	Step 4b: Logout button is visible
		WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button secondary radius']"));
		Assert.assertTrue(logOutButton.isDisplayed(), "\nThe Logout button is not displayed");
		System.out.println("\n**** Step 4b: The Logout button is visible ****");
		// WebElement logOutButton = driver.findElement(By.xpath("//a[@class='button
		// secondary radius broken']"));

//	Step4c: Successful login message
		// WebElement successMessage = driver.findElement(By.cssSelector("#flash"));
		WebElement successMessage = driver.findElement(By.xpath("//div[@id='flash']"));
		String expectedMessage = "You logged into a secure area!";
		String actualMessage = successMessage.getText();
		// Assert.assertEquals(actualMessage, expectedMessage, "\nActual message is not
		// as expected");
		Assert.assertTrue(actualMessage.contains(expectedMessage),
				"\nThe actual message does not contain the expected message.\nActual message: " + actualMessage
						+ "\nExpected message: " + expectedMessage);
		System.out.println("\n**** Step 4c: Successful login message\nThe actual message does contain the expected message.\nActual message: " + actualMessage
		+ "\nExpected message: " + expectedMessage);

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
