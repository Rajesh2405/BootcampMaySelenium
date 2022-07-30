package base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProjectSpecificmethods {

	public ChromeDriver driver;

	public static ExtentHtmlReporter reporter;
	public static ExtentReports extent;
	public static ExtentTest test, node;

	public String testname, testDescription, author, category;

	@BeforeSuite
	public void startReport() {

		reporter = new ExtentHtmlReporter("./Report/data.html");

		extent = new ExtentReports();

		extent.attachReporter(reporter);
		System.out.println("********Report Starting*****");
	}

	public long takeSnap() throws IOException {
		long random = (long) (Math.random() * 99999999L);
		File source = driver.getScreenshotAs(OutputType.FILE);
		File target = new File("./Snaps/img" + random + ".png");
		FileUtils.copyFile(source, target);
		return random;
	}

	public void reportStep(String msg, String status) throws IOException {

		if (status.equalsIgnoreCase("pass")) {
			test.pass(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././Snaps/img" + takeSnap() + ".png").build());
			// node.pass(msg);
		} else if (status.equalsIgnoreCase("fail")) {
			test.fail(msg,
					MediaEntityBuilder.createScreenCaptureFromPath(".././Snaps/img" + takeSnap() + ".png").build());
			// node.fail(msg);
		}

	}

	@BeforeClass
	public ExtentTest testDetails() {
		// test.assignAuthor(author);
		// test.assignCategory(category);
		test = extent.createTest(testname, testDescription);

		return test;
	}

	@BeforeMethod
	public ExtentTest launchBrowser() {
		test.assignAuthor(author);
		test.assignCategory(category);
		node = test.createNode(testname);

		WebDriverManager.chromedriver().setup();
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--disable-notifications");
		driver = new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(2000, TimeUnit.SECONDS);
		// URL launched

		driver.get("https://login.salesforce.com");
		System.out.println("Node " + node);
		return node;
	}

	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}

	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}
