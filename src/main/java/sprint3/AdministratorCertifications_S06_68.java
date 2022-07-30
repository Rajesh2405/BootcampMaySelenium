package sprint3;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications_S06_68 {

	public WebDriverWait wait;
	
	public String[] explist = {"Administrator", "Advanced Administrator", "Business Analyst", "CPQ Specialist", "Marketing Cloud Administrator", "Platform App Builder"};

	@Test
	public void verifyAdministratorCertification() throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();

		driver.get("https://login.salesforce.com");
		driver.findElement(By.id("username")).sendKeys("mars@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("BootcampSel$123");
		driver.findElement(By.name("Login")).click();
		wait = new WebDriverWait(driver, Duration.ofSeconds(6));
		WebElement mobilePublisher = driver.findElement(
				By.xpath("//span[contains(text(),'Mobile Publisher')]//preceding::span[text()='Learn More']"));
		wait.until(ExpectedConditions.visibilityOf(mobilePublisher)).click();

		String parent = driver.getWindowHandle();
		Set<String> windows = driver.getWindowHandles();
		// Now iterate using Iterator
		Iterator<String> I1 = windows.iterator();
		String child_window = null;
		while (I1.hasNext()) {
			child_window = I1.next();
			if (!parent.equals(child_window)) {

				driver.switchTo().window(child_window);
				/*
				 * if (driver.getTitle().contains("Create and Publish")) {
				 * driver.switchTo().window(child_window);
				 * System.out.println("p1"+driver.getTitle()); }
				 */
			}
		}
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		WebElement root = driver.findElement(By.xpath("//hgf-c360nav"));
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		SearchContext shadowHost = (SearchContext) jsDriver.executeScript("return arguments[0].shadowRoot", root);
		WebElement shadowElement = shadowHost.findElement(By.cssSelector("nav>ul>li:nth-child(3)"));
		shadowElement.click();

		Thread.sleep(3000);
		SearchContext shadowHost1 = (SearchContext) jsDriver.executeScript("return arguments[0].shadowRoot", root);
		WebElement shadowElement2 = shadowHost1
				.findElement(By.cssSelector("nav>ul>li:nth-child(3)>div>div>div>ul hgf-button"));

		// WebElement salesforcecert = driver.findElement(By.linkText("Salesforce
		// Certification"));

		SearchContext shadowHost2 = (SearchContext) jsDriver.executeScript("return arguments[0].shadowRoot",
				shadowElement2);
		WebElement shadowElement3 = shadowHost2.findElement(By.cssSelector("button"));
		Actions action = new Actions(driver);

		action.moveToElement(shadowElement3).perform();

		Shadow shadow = new Shadow(driver);

		WebElement salesforcecert = shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		
		action.moveToElement(salesforcecert).click().build().perform();
	
		ArrayList<WebElement> certLists = new ArrayList<WebElement>();

		certLists = (ArrayList<WebElement>) driver.findElements(
				By.xpath("//div[@class='credentials-card ']//following::div[@class='credentials-card_title']/a"));

		System.out.println(certLists.size());
		ArrayList <String>	uiList = new ArrayList<String>();
		for (WebElement webElement : certLists) {
			String certName = webElement.getText();
			uiList.add(certName);
		}
		System.out.println("Actual "+uiList);
		
		ArrayList<String> expectedList = new ArrayList<String>(Arrays.asList(explist));
		System.out.println("Expected "+expectedList);
		
		if (uiList.equals(expectedList)) {
			Assert.assertTrue(true, "Certificates list are matched");
		}
		
	}
}
