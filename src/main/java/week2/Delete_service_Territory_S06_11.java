package week2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

public class Delete_service_Territory_S06_11 {

	public ChromeDriver driver;

	@Parameters({"url","username","password"})
	@BeforeMethod
	public void browserLaunch(String url, String uname, String pwd) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		// URL launched
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();
	}

	@Test
	public void service_Territory_Deletion() throws InterruptedException {

		//Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement launcher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.visibilityOf(launcher)).click();
		// click the App launcher
		

		// click view all
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		wait.until(ExpectedConditions.visibilityOf(viewAll)).click();
		
		WebElement serviceTertry = driver.findElement(By.xpath("//p[text()='Service Territories']"));
		driver.executeScript("arguments[0].click();", serviceTertry);
		driver.findElement(By.xpath("//button[@title='Select a List View']")).click();
		driver.findElement(By.xpath("//span[text()='All Service Territories']")).click();
		// driver.findElementByXPath("//a[@title='Show 2 more actions']").click();
		// driver.findElementByClassName("oneActionsDropDown").click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//span[contains(@class,'slds-icon')])[1]")).click();
		// driver.findElementByXPath("(//a[contains(@class,'slds-button
		// slds-button--icon-x-small')])[1]").click();
		driver.findElement(By.xpath("//a[@title='Delete']")).click();
		driver.findElement(By.xpath("//button[@title='Delete']")).click();
		// String deleteMessage =
		// driver.findElementByXPath("//span[contains(text(),'Service
		// Territory')]").getText();
		String deleteMessage = driver
				.findElement(By.xpath("//span[contains(@class,'toastMessage')][contains(text(),'Service Territory')]"))
				.getText();
		System.out.println(deleteMessage);
		if (deleteMessage.contains("deleted")) {
			Assert.assertTrue(true);
		} else {
			Assert.assertTrue(false);
		}

	}

	@AfterMethod
	public void tearDown() throws Exception {
		driver.close();
	}
}
