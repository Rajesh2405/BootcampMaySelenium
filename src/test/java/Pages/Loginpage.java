package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Base.ProjectSpecificmethods;

public class Loginpage extends ProjectSpecificmethods{

	
	public Loginpage enterusername() {
		
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");

		return this;
	}

	public Loginpage enterPwd() {
		
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");

		return this;
	}

	public Homepage clickLoginbutton() {
		
		driver.findElement(By.id("Login")).click();

		return new Homepage();
	}
	
	
}
