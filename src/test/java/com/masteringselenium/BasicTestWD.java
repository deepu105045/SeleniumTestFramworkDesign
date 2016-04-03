package com.masteringselenium;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BasicTestWD extends DriverFactory{
	
	private void googleExampleThatSearchesFor(final String searchString)throws Exception{
		WebDriver driver=DriverFactory.getDriver();
		driver.get("http://www.google.com");
		WebElement searchField=driver.findElement(By.name("q"));
		searchField.clear();
		searchField.sendKeys(searchString);
		System.out.println("Page Title is : "+ driver.getTitle());
		searchField.submit();
		(new WebDriverWait(driver, 10))
			.until(new ExpectedCondition<Boolean>() {
				public Boolean apply(WebDriver driverObject) {
					return driverObject.getTitle().toLowerCase().startsWith(searchString.toLowerCase());
				}
			});
		
	}
	
	
	@Test
	public void googleCheeseExample() throws Exception{
		googleExampleThatSearchesFor("Cheese1");
	}
	
	@Test
	public void googleMilkExample() throws Exception{
		googleExampleThatSearchesFor("Milk");
	}
	@Test
	public void googleSachineExample() throws Exception{
		googleExampleThatSearchesFor("Sachin");
		Assert.fail();
	}
	@Test
	public void googleDohniExample() throws Exception{
		googleExampleThatSearchesFor("Dhoni");
	}
	@Test
	public void googleGangulyExample() throws Exception{
		googleExampleThatSearchesFor("Ganguly");
	}

}
