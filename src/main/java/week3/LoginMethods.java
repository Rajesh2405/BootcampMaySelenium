package week3;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginMethods {
	
	public ChromeDriver driver;
	
	@BeforeMethod
	public void browserLaunch() {
		
		WebDriverManager.chromedriver().setup();
		driver =new ChromeDriver();
		driver.get("https://login.salesforce.com");
		
	}
	
	
	@Test(dataProviderClass=HashmapExcelRead.class,dataProvider="dp")
	public void login1(HashMap<String, String> map) {
		
		String uname = map.get("Username");
		String pwd = map.get("Password");
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
	}
	
	
	@Test(dataProviderClass=HashmapExcelRead.class,dataProvider="dp")
	public void login2(HashMap<String, String>map) {
		
		String uname = map.get("Username");
		String pwd = map.get("Password");
		
		driver.findElement(By.id("username")).sendKeys(uname);
		driver.findElement(By.id("password")).sendKeys(pwd);
	}
	
	@AfterMethod
	public void browserClose() {
		
		driver.close();
	}
	
	
}
