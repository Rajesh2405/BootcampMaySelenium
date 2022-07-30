package pages;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.ProjectSpecificmethods;

public class Homepage extends ProjectSpecificmethods {
	
	public WebDriverWait wait;
	
	public Homepage(ChromeDriver chrome) {
		driver = chrome;
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	}
	
	
	
	public	 Homepage clickApplauncher() throws IOException {
		try {
			WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
			wait.until(ExpectedConditions.visibilityOf(appLauncher)).click();
			reportStep("AppLauncher Clicked succesfully", "pass");
		} catch (Exception e) {
			reportStep("Element not Clicked", "fail");
		}
		return this;

	}
	
	public Homepage clickviewAll() throws IOException {
		
		try {
			WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
			wait.until(ExpectedConditions.visibilityOf(viewAll)).click();
			reportStep(viewAll.getText()+" Clicked succesfully", "pass");
		} catch (Exception e) {
			reportStep("Element not Clicked ", "fail");
		}
		return this;
	}
	
	public RecentlyviewdPage clickserviceTerritory() throws IOException, InterruptedException {
		//wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	//	WebElement serviceTertry = driver.findElement(By.xpath("//p[text()='Service Territories']"));
		//Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[text()='Service Territories']"))));
		WebElement serviceTertry = driver.findElement(By.xpath("//p[text()='Service Territories']"));
		try {
		//	Thread.sleep(2000);
			driver.executeScript("arguments[0].click();", serviceTertry);
		//	Thread.sleep(2000);
		//	reportStep(serviceTertry.getText()+" Clicked succesfully", "pass");
			reportStep("Service Teritory Clicked succesfully", "pass");
		} catch (Exception e) {
			reportStep(serviceTertry.getText()+" not Clicked ", "pass");
		}
		
		return new RecentlyviewdPage(driver);

	}

	

}
