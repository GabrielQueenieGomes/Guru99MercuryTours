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
		
List<WebElement> closeButton = driver.findElements(By.className("cb-close"));
        
        if (closeButton.size() > 0) {
            System.out.println("Popup detected. Closing it...");
            closeButton.get(0).click();
        } else {
            System.out.println("No popup detected. Proceeding...");
        }
		
        driver.findElement(By.linkText("REGISTER")).click();
        Thread.sleep(2000);
        
        WebElement countryDropdown = driver.findElement(By.name("country"));
        Select select = new Select(countryDropdown);
        
        System.out.println("Selecting BANGLADESH by Visible Text");
        select.selectByVisibleText("BANGLADESH");
        Thread.sleep(1500);
        
        System.out.println("Selecting Index 12 (ANTARCTICA)");
        select.selectByIndex(12);
        Thread.sleep(1500);
		
        System.out.println("Selecting CHINA by Value");
        select.selectByValue("CHINA");
        Thread.sleep(1500);
		
        List<WebElement> dropDownOptions = select.getOptions();
        int optionsCount = dropDownOptions.size();
        System.out.println("Total Countries found: " + optionsCount);
		
		for (int i = 0; i < optionsCount; i++) {
			String value = select.getOptions().get(i).getText();
			System.out.println(value);
		
			if (value.equals("UNITED STATES")) {
                System.out.println("Found UNITED STATES at index " + i + ". Selecting it now.");
                select.selectByIndex(i);
                break; // Exit loop once found
            }
		}

		Thread.sleep(3000);
		driver.quit();
		
	}
}
