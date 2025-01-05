package com.ui;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;



public class EbayPage extends ProjectSpecifics {

	public RemoteWebDriver driver;

	public EbayPage(RemoteWebDriver driver) {
		this.driver = driver;
	
	}
	
	public EbayPage searchBook() throws IOException {
		try {
			WebElement searchInput = driver.findElement(By.name("_nkw"));

			searchInput.sendKeys("Books");
			searchInput.submit();
			System.out.println("Enter Book in the Ebay serarch is passed");

		} catch (Exception e) {

			System.out.println("Enter Book in the Ebay serarch failed" + e);

		}
		return this;
	}

	public EbayPage selectFirstBook() throws IOException {
		try {
			WebElement firstBook = driver.findElement(By.xpath("(//span[@role='heading'])[3]"));
			firstBook.click();
			System.out.println("First Book of the Result in Ebay is passed");
		} catch (Exception e) {
			
			System.out.println("Select the First Result for Book has failed"+e);
		}
		return this;
	}

	public EbayPage switchToNewWindow() throws IOException {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			List<String> window = new ArrayList<String>(windowHandles);
			driver.switchTo().window(window.get(1));
			System.out.println(driver.getTitle());
			System.out.println("Switch to new window to add to Cart is passed");
		} catch (Exception e) {
			
			System.out.println("Switch to new window step is failed"+e);
		}
		return this;
	}

	public EbayPage clickAddToCart() throws IOException {

		try {
			WebElement addToCart = driver.findElement(By.xpath("//span[text()='Add to cart']"));
			addToCart.click();
			String cartValue = driver.findElement(By.xpath("//i[@id='gh-cart-n']")).getText();
			System.out.println("Cartvalue :"+cartValue);
			
		} catch (Exception e) {
			
			System.out.println("Book add to the Cart step is Failed"+e);
		}
		return this;
	}

}
