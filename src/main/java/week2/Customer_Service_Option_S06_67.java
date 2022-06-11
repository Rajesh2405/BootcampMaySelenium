package week2;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Customer_Service_Option_S06_67 {

	@Test
	public void customerServiceOption() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");

		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		// driver.manage().timeouts().pageLoadTimeout(2000, TimeUnit.SECONDS);

		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
		driver.findElement(By.name("Login")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@title='Learn More']/span[text()='Learn More']")).click();

		Thread.sleep(2000);
		String parrent = driver.getWindowHandle();
		System.out.println("parrent"+parrent);
		Set<String> windowHandles = driver.getWindowHandles();

		for (String windows : windowHandles) {
			if (!windows.equals(parrent)) {
				System.out.println("child"+windows);
				driver.switchTo().window(windows);
			}
		}
		
		System.out.println(driver.getTitle());

		WebElement host = driver.findElement(By.xpath("//hgf-globalnavigation"));
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;	
		SearchContext shadowHost = (SearchContext) jsDriver.executeScript("return arguments[0].shadowRoot", host);
		WebElement shadowEle = shadowHost
				.findElement(By.cssSelector("header nav li[data-tracking-id=\"products\"]>button"));
		shadowEle.click();

		WebElement serviceShadow = shadowHost
				.findElement(By.cssSelector("li[data-tracking-id=\"products\"] div.sub-nav>ul>li:nth-child(3)"));

		Actions act = new Actions(driver);
		act.moveToElement(serviceShadow).click().build().perform();
		

	}

}
