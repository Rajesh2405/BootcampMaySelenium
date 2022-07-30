package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificmethods;

public class Loginpage extends ProjectSpecificmethods{
	
	
	public WebDriverWait wait;
	
	  public Loginpage(ChromeDriver chrome) { 
		  driver = chrome;
		  wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		  
		  }
	 

	
	public Loginpage enterusername() throws IOException {
		
		try {
			driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
			
			//wait.until(ExpectedConditions.presen
			reportStep("user name entered successfully","pass");
		} catch (WebDriverException e) {
			reportStep("user name not entered successfully","fail");
		}

		return this;
	}

	public Loginpage enterPwd() throws IOException {
		
		try {
			driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
			reportStep("password entered successfully","pass");
		} catch (Exception e) {
			reportStep("password not entered successfully","fail");
		}

		return this;
	}

	public Homepage clickLoginbutton() throws IOException {
		try {
			driver.findElement(By.id("Login")).click();
			reportStep("login button clicked", "pass");
		} catch (Exception e) {
			reportStep("login not button clicked", "pass");
		}
		

		return new Homepage(driver);
	}
	
	
}
