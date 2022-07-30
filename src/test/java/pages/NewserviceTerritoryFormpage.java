package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import base.ProjectSpecificmethods;

public class NewserviceTerritoryFormpage extends ProjectSpecificmethods {

	public WebDriverWait wait;

	public NewserviceTerritoryFormpage(ChromeDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	}

	public NewserviceTerritoryFormpage NSTFEntername() {
		driver.findElement(By.xpath("//input[@class=' input']")).sendKeys("Mike");
		return this;

	}

	public NewserviceTerritoryFormpage NSTFsearchOphours() {
		driver.findElement(By.xpath("//input[@placeholder='Search Operating Hours...']")).click();
		return this;

	}

	public NewserviceTerritoryFormpage NSTFSelectnewOphours() {
		driver.findElement(By.xpath("//span[@title='New Operating Hours']")).click();
		return this;

	}

	public NewserviceTerritoryFormpage NSTFnewOphoursEntername() {
		driver.findElement(By.xpath("(//input[@class=' input'])[2]")).sendKeys("Richard");
		return this;

	}

	public NewserviceTerritoryFormpage NSTFClicknewOprhoursave() {
		driver.findElement(
				By.xpath("//h2[text()='New Operating Hours']//following::button[@type='button'][@title='Save']"))
				.click();
		WebElement opHourtoast = null;
		try {
			opHourtoast = driver
					.findElement(By.xpath("//span[contains(@class,'toastMessage')][contains(text(),'Operating Hours')]"));
			wait.until(ExpectedConditions.invisibilityOf(opHourtoast));
		} catch (Exception e) {
			e.printStackTrace();
			wait.until(ExpectedConditions.invisibilityOf(opHourtoast));
		}
		return this;

	}

	public NewserviceTerritoryFormpage NSTFclickActivechbox() {
		driver.findElement(By.xpath("//h2[text()='New Service Territory']//following::input[@type='checkbox']"))
				.click();
		return this;

	}

	public NewserviceTerritoryFormpage NSTFEntercity() {
		driver.findElement(By.xpath("//input[@placeholder='City']")).sendKeys("Chennai");
		return this;
	}

	public NewserviceTerritoryFormpage NSTFEnterstatename() {
		driver.findElement(By.xpath("//input[@placeholder='State/Province']")).sendKeys("TamilNadu");
		return this;

	}

	public NewserviceTerritoryFormpage NSTFEnterZipcode() {
		driver.findElement(By.xpath("//input[@placeholder='Zip/Postal Code']")).sendKeys("6006477");
		return this;

	}

	public NewserviceTerritoryFormpage NSTFEntercountryname() {
		driver.findElement(By.xpath("//input[@placeholder='Country']")).sendKeys("India");
		return this;

	}

	public NewserviceTerritoryFormpage NSTFClicksave() {
		driver.findElement(
				By.xpath("//h2[text()='New Service Territory']//following::button[@type='button'][@title='Save']"))
				.click();
		return this;
		// return new ServiceTerritoryDetailpage(driver);

	}

	public ServiceTerritoryDetailpage NSTFVerifytoastmsg() {
		System.out.println("Toast displayed "+driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).isDisplayed());
		String poptext = driver.findElement(By.xpath("//span[contains(@class,'toastMessage')]")).getText();
		System.out.println("Poptext "+poptext);
	 	String name1 = poptext.toString().split(" ")[2];
	// 	String name = name1.split(" ")[2].toString();
		System.out.println(name1);
		//System.out.println(name);
		Assert.assertTrue(poptext.equalsIgnoreCase("Service Territory " + name1 + " was created."));
		return new ServiceTerritoryDetailpage(driver);
	}

}
