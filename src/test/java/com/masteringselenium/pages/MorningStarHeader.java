package com.masteringselenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.masteringselenium.DriverFactory;

public class MorningStarHeader extends PageFactory{
	WebDriver driver=DriverFactory.getDriver();
	
	@FindBy(how=How.CSS,using="[data-mod='headernotification']")
	private WebElement fullHeaderBlock;
	
	@FindBy(how=How.CSS,using="[data-mod='headernotification'] span")
	private WebElement welcomeText;
	
	public String getWelComeText(){
		return welcomeText.getText();
	}
	
	public String getUrl(){
		return "http://beta.morningstar.com";
	}
	
	public void isPageLoaded() throws Error, Exception{
		waitForVisibility(welcomeText);
	}
    private void waitForVisibility(WebElement element) throws Error, Exception{
        new WebDriverWait(driver, 60*5)
             .until(ExpectedConditions.visibilityOf(element));
    	}
	
	public MorningStarHeader() throws Exception{
		PageFactory.initElements(driver, this);
		isPageLoaded();
	}

}
