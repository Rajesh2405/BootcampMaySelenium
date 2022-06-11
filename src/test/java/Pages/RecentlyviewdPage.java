package Pages;

import org.openqa.selenium.By;

import Base.ProjectSpecificmethods;

public class RecentlyviewdPage extends ProjectSpecificmethods {
	
	public	NewserviceTerritorypage clickNewoption() {
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		
		return new NewserviceTerritorypage();
	}
	

}
