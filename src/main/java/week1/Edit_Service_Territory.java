package week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Edit_Service_Territory {
	
	public ChromeDriver driver;
	
	@Test
	public void Service_Territory_Edit() throws InterruptedException {
		
       WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(option);
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		//URL launched
		driver.get("https://login.salesforce.com");
		
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElementById("password").sendKeys("BootcampSel$123");
		driver.findElementByName("Login").click();
		Thread.sleep(2000);
		//click the App launcher
		driver.findElementByXPath("//div[@class='slds-icon-waffle']").click();
		
		//click view all
		driver.findElementByXPath("//button[text()='View All']").click();
		WebElement serviceTertry = driver.findElementByXPath("//p[text()='Service Territories']");
		driver.executeScript("arguments[0].click();", serviceTertry);
		Thread.sleep(2000);
		driver.findElementByXPath("(//div[contains(@class,'forceVirtualAction')])[1]//a").click();
		//Actions act = new Actions(driver);
		//act.moveToElement(driver.findElementByXPath("//div[text()='Edit']")).click();
		Thread.sleep(2000);
		driver.findElementByXPath("//a[@title='Edit']").click();
	
		String CreatedBy = driver.findElementByXPath("(//span[text()='mars testleaf'])[2]").getText();
		System.out.println(CreatedBy);
		String ModifyBy = driver.findElementByXPath("(//span[text()='mars testleaf'])[3]").getText();
		System.out.println(ModifyBy);
		String Owner = driver.findElementByXPath("(//span[text()='mars testleaf'])[3]").getText();
		System.out.println(Owner);
		
		Assert.assertEquals("mars testleaf", CreatedBy);
		Assert.assertEquals("mars testleaf", ModifyBy);
		Assert.assertEquals("mars testleaf", Owner);
		driver.findElementByXPath("//input[@placeholder='Country']").clear();
		driver.findElementByXPath("//input[@placeholder='Country']").sendKeys("North America");
		driver.findElementByXPath("//span[contains(text(),'New')]/following::span[text()='Save']").click();
		String text = driver.findElementByXPath("//span[@class='slds-truncate uiOutputDateTime']").getText();
		System.out.println(text);
	}
	
	/*
	 * @AfterMethod public void logout() { driver.close(); }
	 */
}
