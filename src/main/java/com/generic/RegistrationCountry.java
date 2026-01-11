package com.generic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationCountry {

	public static void main(String[] args) throws InterruptedException {
        RegistrationCountry test = new RegistrationCountry();
        test.getRegistrationCountry();
    }
	
	public void getRegistrationCountry() throws InterruptedException {
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://demo.guru99.com/test/newtours/");
		Thread.sleep(1500);
		
		List<WebElement> closeButton = driver.findElements(By.xpath("//div[contains(@class, 'cb-close')]"));

        if (closeButton.size() > 0) {
            System.out.println("Popup found. Closing...");
            closeButton.get(0).click();
        }
		
driver.findElement(By.xpath("//a[contains(text(), 'REGISTER')]")).click();
        
        Thread.sleep(2000);
        
        if (closeButton.size() > 0) {
            System.out.println("Popup found. Closing...");
            closeButton.get(0).click();
        }
        
WebElement countryDropdown = driver.findElement(By.xpath("//select[contains(@name, 'country')]"));
        
        Select select = new Select(countryDropdown);
        
        if (closeButton.size() > 0) {
            System.out.println("Popup found. Closing...");
            closeButton.get(0).click();
        }
        
        select.selectByVisibleText("BANGLADESH");
        Thread.sleep(1000);
        
        if (closeButton.size() > 0) {
            System.out.println("Popup found. Closing...");
            closeButton.get(0).click();
        }
        
        select.selectByIndex(12);
        Thread.sleep(1000);
        
        if (closeButton.size() > 0) {
            System.out.println("Popup found. Closing...");
            closeButton.get(0).click();
        }
        
        select.selectByValue("CHINA");
        Thread.sleep(1000);
        
        if (closeButton.size() > 0) {
            System.out.println("Popup found. Closing...");
            closeButton.get(0).click();
        }
		
        List<WebElement> dropDownOptions = select.getOptions();
        int optionsCount = dropDownOptions.size();
        
        if (closeButton.size() > 0) {
            System.out.println("Popup found. Closing...");
            closeButton.get(0).click();
        }
		
		for (int i = 0; i < optionsCount; i++) {
			String value = dropDownOptions.get(i).getText();
			
			if (closeButton.size() > 0) {
	            System.out.println("Popup found. Closing...");
	            closeButton.get(0).click();
	        }
		
			if (value.equals("UNITED STATES")) {
                select.selectByIndex(i);
                System.out.println("Selected: " + value);
                break;
            }
		}

		if (closeButton.size() > 0) {
            System.out.println("Popup found. Closing...");
            closeButton.get(0).click();
        }
		
		Thread.sleep(3000);
		driver.quit();
		
	}
}
