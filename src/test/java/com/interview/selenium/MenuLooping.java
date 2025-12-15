package com.interview.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MenuLooping {
	
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours/");
		List<WebElement> tourmenu=driver.findElements(By.xpath("//*[@class='collapse navbar-collapse']//a"));
		System.out.println(tourmenu.size());
		
			for(int i=0;i<tourmenu.size();i++) {
				System.out.println(tourmenu.get(i).getText());
			}

		driver.quit();
	}
	
}
