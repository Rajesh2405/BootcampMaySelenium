package Testcases;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Base.ProjectSpecificmethods;
import Pages.Loginpage;

public class LoginTest extends ProjectSpecificmethods{
	
	
	@Test
	public void loginpageTest() {
		Loginpage lp = new Loginpage();
		
		lp.enterusername().enterPwd().clickLoginbutton()
		.clickApplauncher()
		.clickviewAll()
		.clickserviceTerritory()
		.clickNewoption();
	}

}
