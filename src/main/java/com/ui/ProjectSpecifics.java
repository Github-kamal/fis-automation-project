package com.ui;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;

public class ProjectSpecifics {
	public static ChromeDriver driver;

	@BeforeMethod
	public void preCondition() {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.ebay.com/");
	}

	@AfterMethod
	public void postConition() {
		driver.quit();
	}

}
