package week1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Service_Territories {
	
	
	@Test
	public void service_Territory_Creation() throws InterruptedException {
		
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
		driver.findElementByXPath("//button[text()='View All']").click();
		WebElement serviceTertry = driver.findElementByXPath("//p[text()='Service Territories']");
		driver.executeScript("arguments[0].click();", serviceTertry);
		//click new
		Thread.sleep(2000);
		driver.findElementByXPath("//div[@title='New']").click();
		driver.findElementByXPath("//input[@class=' input']").sendKeys("Christine");
		driver.findElementByXPath("//input[@placeholder='Search Operating Hours...']").click();
		driver.findElementByXPath("//span[@title='New Operating Hours']").click();
		driver.findElementByXPath("(//input[@class=' input'])[2]").sendKeys("RajeshKumar");
		driver.findElementByXPath("//h2[text()='New Operating Hours']//following::button[@type='button'][@title='Save']").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//h2[text()='New Service Territory']//following::input[@type='checkbox']").click();
		driver.findElementByXPath("//input[@placeholder='City']").sendKeys("Chennai");
		driver.findElementByXPath("//input[@placeholder='State/Province']").sendKeys("TamilNadu");
		driver.findElementByXPath("//input[@placeholder='Zip/Postal Code']").sendKeys("6006477");
		driver.findElementByXPath("//input[@placeholder='Country']").sendKeys("India");
		driver.findElementByXPath("//h2[text()='New Service Territory']//following::button[@type='button'][@title='Save']").click();
		String poptext = driver.findElementByXPath("//span[contains(@class,'toastMessage')][contains(text(),'Service Territory')]").getText();
		System.out.println(poptext);
		Assert.assertTrue(poptext.contains("created"));
		
		
	}

}
