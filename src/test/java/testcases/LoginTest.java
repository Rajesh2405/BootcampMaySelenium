package testcases;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificmethods;
import pages.Loginpage;

public class LoginTest extends ProjectSpecificmethods {
	
	@BeforeTest
	public void provideTestDetails() {

		testname = "LoginpageVerify";
		testDescription = "Login page functionality verification";
		author = "Rajesh";
		category = "smoke";
	}

	@Test
	public void loginPageTest() throws IOException {
		
		 new Loginpage(driver)
		.enterusername()
		.enterPwd()
		.clickLoginbutton();
	}

}
