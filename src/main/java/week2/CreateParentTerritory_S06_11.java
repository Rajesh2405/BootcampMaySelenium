package week2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateParentTerritory_S06_11 {
	
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
	public void parentTerritoryCreation() throws InterruptedException {
		
		WebDriverWait wait =new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement appLauncher = driver.findElement(By.xpath("//div[@class='slds-icon-waffle']"));
		wait.until(ExpectedConditions.visibilityOf(appLauncher)).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='View All']")).click();
		WebElement serviceTerritory = driver.findElement(By.xpath("//p[text()='Service Territories']"));
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);",serviceTerritory);
		serviceTerritory.click();
		Thread.sleep(3000);
		
		//driver.findElementByXPath("//span[text()='Edit Parent Territory: Item 1']").click();
		WebElement pSt = driver.findElement(By.xpath("//table[@role='grid']//tr[1]/td[5]"));
		
		Actions action = new Actions(driver);
		action.moveToElement(pSt).build().perform();
		driver.findElement(By.xpath("//table[@role='grid']//tr[1]/td[5]//span[@class='triggerContainer']")).click();
		driver.findElement(By.xpath("//span[@title='New Service Territory']")).click();
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Mukesh Ambani");
		driver.findElement(By.xpath("//input[@placeholder='Search Operating Hours...']")).click();
		driver.findElement(By.xpath("//span[@title='New Operating Hours']")).click();
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("Mukesh Ambani");
		driver.findElement(By.xpath("//span[text()='Time Zone']/following::a[1]")).click();
		driver.findElement(By.xpath("//div[@role='menu']//following::li/a[contains(text(),'India Standard Time (Asia/Kolkata)')]")).click();
		driver.findElement(By.xpath("//h2[text()='New Operating Hours']//following::button[@type='button'][@title='Save']")).click();
		String opratingmsg = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')][contains(text(),'Operating Hours')]")).getText();
		System.out.println(opratingmsg);
		driver.findElement(By.xpath("//h2[text()='New Service Territory']//following::button[@title='Save']")).click();
		String nwlycreatdPT = driver.findElement(By.xpath("//span[contains(@class,'toast')]")).getText();
		System.out.println(nwlycreatdPT);
		Assert.assertTrue(nwlycreatdPT.contains("created"));
	}
	
	@AfterMethod
	public void tearDown()  {
		
		driver.close();
		
	}
	
	
}
