package com.demo.qa.test;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class BuildJobTest {
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                options.addArguments("--disable-browser-side-navigation");
                options.addArguments("--start-maximized");
                options.addArguments("--no-sandbox");
                options.addArguments("--headless");
                options.addArguments("--disable-dev-shm-usage");
                options.setExperimentalOption("useAutomationExtension", false);
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit wait
		driver.get("https://www.rnsangwan.com/");
	}
	
	@Test
	public void ToolsQaTest()
	{
		driver.findElement(By.xpath("(//div[@class=\"card-up\"])[1]")).click();
		String expectedtext="Elements";
		String actualtext=driver.findElement(By.xpath("(//div[contains(text(),\"Elements\")])[1]")).getText();
		Assert.assertEquals(expectedtext, actualtext, "Message is not Displaying as expected");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
	}

}
