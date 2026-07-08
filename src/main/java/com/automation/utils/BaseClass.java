package com.automation.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static WebDriver driver;
	
	public static void initDriver() {
		
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();

	    Map<String, Object> prefs = new HashMap<String, Object>();
	    prefs.put("credentials_enable_service", false);
	    prefs.put("profile.password_manager_enabled", false);
	    prefs.put("profile.password_manager_leak_detection", false);
	    prefs.put("profile.default_content_setting_values.notifications", 2);
	    prefs.put("autofill.profile_enabled", false);  

	    options.setExperimentalOption("prefs", prefs);

	    
	    List<String> excludeSwitches = new ArrayList<>();
	    excludeSwitches.add("enable-automation");
	    options.setExperimentalOption("excludeSwitches", excludeSwitches);
	    options.setExperimentalOption("useAutomationExtension", false);

	    options.addArguments("--disable-save-password-bubble");
	    options.addArguments("--disable-notifications");
	    options.addArguments("--disable-popup-blocking");
	    options.addArguments("--no-sandbox");
	    options.addArguments("--disable-dev-shm-usage");
	    options.addArguments("--remote-allow-origins=*");
	    options.addArguments("--disable-features=PasswordLeakDetection");
	    options.addArguments("--disable-features=SafeBrowsingEnhancedProtection"); 
	    options.addArguments("--password-store=basic");
	    options.addArguments("--use-mock-keychain"); 

	    String headless = System.getProperty("headless", "false");
	    if(headless.equals("true")) {
	        options.addArguments("--headless");
	        options.addArguments("--window-size=1920,1080");
	    }

		driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		

	}
	
	
	public static void dismissPasswordDialog() {
	    try {
	        Thread.sleep(200);
	       
	        org.openqa.selenium.WebElement okButton = driver.findElement(
	            By.xpath("//button[text()='OK']"));
	        if(okButton.isDisplayed()) {
	            okButton.click();
	            System.out.println("Password dialog dismissed");
	        }
	    } catch(Exception e) {
	        System.out.println("No dialog found");
	    }
	}
	
	public static void quitDriver() {
		
		if(driver!=null) {
			
			driver.quit();
			
			driver = null;
		}
	}

}
