package week1;

import java.time.Duration;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Create_Service_Territories {
	
	public ChromeDriver driver;
	
	@Parameters({"url","username","password"})
	@BeforeMethod
	public void browserLaunch(String url, String uname, String pwd) {
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// URL launched
		driver.get(url);
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.id("Login")).click();
	}
	
	
	@Test
	public void service_Territory_Creation() throws InterruptedException {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//click the App launcher
		WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.visibilityOf(appLauncher)).click();
		
		//click view all
		WebElement viewAll = driver.findElement(By.xpath("//button[text()='View All']"));
		wait.until(ExpectedConditions.visibilityOf(viewAll)).click();;
		WebElement serviceTertry = driver.findElement(By.xpath("//p[text()='Service Territories']"));
		driver.executeScript("arguments[0].click();", serviceTertry);
		//click new
		
		driver.findElement(By.xpath("//div[@title='New']")).click();
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Christine");
		driver.findElement(By.xpath("//input[@placeholder='Search Operating Hours...']")).click();
		driver.findElement(By.xpath("//span[@title='New Operating Hours']")).click();
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("RajeshKumar");
		driver.findElement(By.xpath("//h2[text()='New Operating Hours']//following::button[@type='button'][@title='Save']")).click();
		WebElement opHourtoast = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')][contains(text(),'Operating Hours')]"));
		wait.until(ExpectedConditions.invisibilityOf(opHourtoast));
		driver.findElement(By.xpath("//h2[text()='New Service Territory']//following::input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("Chennai");
		driver.findElement(By.xpath("//input[@placeholder='State/Province']")).sendKeys("TamilNadu");
		driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("6006477");
		driver.findElement(By.xpath("//input[@placeholder='Country']")).sendKeys("India");
		driver.findElement(By.xpath("//h2[text()='New Service Territory']//following::button[@type='button'][@title='Save']")).click();
		String poptext = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')][contains(text(),'Service Territory')]")).getText();
		System.out.println(poptext);
		String Name = poptext.split(" ")[2].toString();
		System.out.println(Name);
		Assert.assertTrue(poptext.equalsIgnoreCase("Service Territory "+Name+" was created."));
		
		
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		
	}

}
