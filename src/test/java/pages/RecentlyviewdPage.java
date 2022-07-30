package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import base.ProjectSpecificmethods;

public class RecentlyviewdPage extends ProjectSpecificmethods {
	
	public RecentlyviewdPage(ChromeDriver driver) {
		this.driver = driver;
	}
	
	
	public	NewserviceTerritoryFormpage clickNewoption() {
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		return new NewserviceTerritoryFormpage(driver);
	}
	

}
