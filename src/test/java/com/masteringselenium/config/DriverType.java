package com.masteringselenium.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

public enum DriverType implements DriverSetup{
	FIREFOX{
		public DesiredCapabilities getDesiredCapabilites() {
			DesiredCapabilities capabilities=DesiredCapabilities.firefox();
			return capabilities;
		}
		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			return new FirefoxDriver(capabilities);
		}
	},
	CHROME{
		public DesiredCapabilities getDesiredCapabilites() {
			DesiredCapabilities capabilities=DesiredCapabilities.chrome();
			capabilities.setCapability("chrome.switches", Arrays.asList("--no-default-browser-check"));
			HashMap<String,String> chromePreferences= new HashMap<String,String>();
			chromePreferences.put("profile.password.manager_enabled", "false");
			capabilities.setCapability("chrome.prefs", chromePreferences);
			return capabilities;
		}
		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			return new FirefoxDriver(capabilities);
		}
		
	},
	SAFARI{
		public DesiredCapabilities getDesiredCapabilites(){
			DesiredCapabilities capabilities=DesiredCapabilities.safari();
			capabilities.setCapability("safari.cleanSession", true);
			return capabilities; 
		}

		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			return new SafariDriver(capabilities);
		}
	},
	PHANTOMJS{

		public WebDriver getWebDriverObject(DesiredCapabilities capabilities) {
			return new PhantomJSDriver(capabilities);
		}

		public DesiredCapabilities getDesiredCapabilites() {
			DesiredCapabilities capabilities=DesiredCapabilities.phantomjs();
			final List<String> cliArguments=new ArrayList<String>();
			cliArguments.add("--web-security=false");
			cliArguments.add("--ssl-protocol=any");
			cliArguments.add("--ignore-ssl-errors=true");
			capabilities.setCapability("phantomjs.cli.args", cliArguments);
			capabilities.setCapability("takeScreenshot", true);
			return capabilities;
		}
		
	}

}
