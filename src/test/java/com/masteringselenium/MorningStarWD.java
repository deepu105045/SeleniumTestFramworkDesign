package com.masteringselenium;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.masteringselenium.pages.MorningStarHeader;

public class MorningStarWD extends DriverFactory{
	
	@Test()
	public void checkMorningStarHeader() throws Exception{
		WebDriver driver=DriverFactory.getDriver();
		MorningStarHeader header= new MorningStarHeader();
		driver.get(header.getUrl());	
		driver.navigate().refresh();
		
		Assert.assertEquals(header.getWelComeText(), "Welcome to the New Morningstar.com");
	}


}
