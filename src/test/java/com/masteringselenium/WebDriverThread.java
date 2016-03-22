package com.masteringselenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import com.masteringselenium.config.DriverType;
import static com.masteringselenium.config.DriverType.FIREFOX;
import static com.masteringselenium.config.DriverType.valueOf;

public class WebDriverThread {
	private WebDriver webdriver;
	private DriverType selectedDriverType;
	private final DriverType defaultDriverType=FIREFOX;
	private String browser=System.getProperty("browser").toUpperCase();
	private String operatingSystem=System.getProperty("os.name").toUpperCase();
	private final String systemArchitecture=System.getProperty("os.arch");
	
	public WebDriver getDriver() throws Exception{
		if(null==webdriver){
			selectedDriverType=determineEffectiveDriverType();
			DesiredCapabilities desiredCapabilities=selectedDriverType.getDesiredCapabilites();
			instatiateWebDriver(desiredCapabilities);
		}
		return webdriver;
	}
	public void quiteDriver(){
		if(null!=webdriver){
			webdriver.quit();
			webdriver=null;
		}
	}
	
	private void instatiateWebDriver(DesiredCapabilities desiredCapabilities) {
		System.out.println("");
		System.out.println("Current Operating System: "+ operatingSystem);
		System.out.println("Current Architecture: "+systemArchitecture);
		System.out.println("Current Browser Selection: "+selectedDriverType);
		System.out.println("");
		webdriver=selectedDriverType.getWebDriverObject(desiredCapabilities);
	}

	private DriverType determineEffectiveDriverType() {
		DriverType driverType=defaultDriverType;
		try{
			driverType=valueOf(browser);
		}catch(IllegalArgumentException ignored){
			System.err.println("Unknown driver specified defaulting to "+driverType+"...");
		}catch(NullPointerException ignored){
			System.err.println("No driver Specified, defaulting to "+driverType+"...");
		}
		return driverType;
	}



}
