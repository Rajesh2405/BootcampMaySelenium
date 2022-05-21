package week2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Delete_service_Territory_S06_11 {
	
	@Test
	public void service_Territory_Deletion() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		
		ChromeDriver driver = new ChromeDriver(option);
		
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
		Thread.sleep(3000);
		driver.findElementByXPath("//button[text()='View All']").click();
		WebElement serviceTertry = driver.findElementByXPath("//p[text()='Service Territories']");
		driver.executeScript("arguments[0].click();", serviceTertry);
		driver.findElementByXPath("//button[@title='Select a List View']").click();
		driver.findElementByXPath("//span[text()='All Service Territories']").click();
	//	driver.findElementByXPath("//a[@title='Show 2 more actions']").click();
		//driver.findElementByClassName("oneActionsDropDown").click();
		Thread.sleep(3000);
		driver.findElementByXPath("(//span[contains(@class,'slds-icon')])[1]").click();
		//driver.findElementByXPath("(//a[contains(@class,'slds-button slds-button--icon-x-small')])[1]").click();
		driver.findElementByXPath("//a[@title='Delete']").click();
		driver.findElementByXPath("//button[@title='Delete']").click();
		//String deleteMessage = driver.findElementByXPath("//span[contains(text(),'Service Territory')]").getText();
		String deleteMessage = driver.findElementByXPath("//span[contains(@class,'toastMessage')][contains(text(),'Service Territory')]").getText();
		System.out.println(deleteMessage);
		if (deleteMessage.contains("deleted")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
		

}
}
