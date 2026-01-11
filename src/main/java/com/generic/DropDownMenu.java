package com.generic;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownMenu {
	
	public void getMenu() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://demo.guru99.com/test/newtours/register.php"); // 1st window
		
		 WebElement dropDownMenu=driver.findElement(By.xpath("//*[@name='country']"));
		// HTML => select tag = yes
		 
		 Select sel = new Select(dropDownMenu);
		 // select by
		 sel.selectByIndex(0); // 1st
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 sel.selectByValue("ALBANIA");
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 sel.selectByVisibleText("CANADA");
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 // find all options to select
		 
		List<WebElement> allOptions = sel.getOptions();
		// java 7
		for(int i=0;i<allOptions.size();i++) {
			System.out.println("All value = "+allOptions.get(i).getText());
			if(allOptions.get(i).getText().contains("UNITED STATES")) {
				System.out.println("Only USA ="+allOptions.get(i).getText());
			}
		}
		
		// java 8 = foreach & filter
		allOptions
		.stream()
		.filter(eachOption -> eachOption.getText().contains("UNITED STATES"))
		.forEach(eachOption -> System.out.println(eachOption.getText()));
		
		// java 8 peek & filter
		allOptions
		.stream()
		.filter(eachOption -> eachOption.getText().contains("UNITED STATES"))
		.peek(eachOption -> System.out.println(eachOption.getText()))
		.collect(Collectors.toList());
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DropDownMenu obj = new DropDownMenu();
		obj.getMenu();

	}

}
