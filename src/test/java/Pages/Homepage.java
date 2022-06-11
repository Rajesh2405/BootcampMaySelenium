package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Base.ProjectSpecificmethods;

public class Homepage extends ProjectSpecificmethods {
	
	
	public WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	
	public	 Homepage clickApplauncher() {
		
		WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.visibilityOf(appLauncher)).click();;
		
		return this;

	}
	
	public Homepage clickviewAll() {
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		wait.until(ExpectedConditions.visibilityOf(viewAll)).click();
		return this;
	}
	
	public RecentlyviewdPage clickserviceTerritory() {
		WebElement serviceTertry = driver.findElement(By.xpath("//p[text()='Service Territories']"));
		driver.executeScript("arguments[0].click();", serviceTertry);
		
		return new RecentlyviewdPage();

	}

	

}
