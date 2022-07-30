package testcases;

import java.io.IOException;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificmethods;
import pages.Loginpage;

public class CreateServiceTerritoryTest extends ProjectSpecificmethods {

	@BeforeTest
	public void provideTestDetails() {

		testname = "CreateService Territory";
		testDescription = "Creating new service Territory";
		author = "Rajesh";
		category = "Sanity";
	}

	@Test
	public void createServiceTerritoryTest() throws IOException, InterruptedException {
		new Loginpage(driver)

				.enterusername().enterPwd().clickLoginbutton().clickApplauncher().clickviewAll().clickserviceTerritory()

				.clickNewoption().NSTFEntername().NSTFsearchOphours().NSTFSelectnewOphours().NSTFnewOphoursEntername()
				.NSTFClicknewOprhoursave().NSTFEntercity().NSTFEnterstatename().NSTFEnterZipcode()
				.NSTFEntercountryname().NSTFClicksave().NSTFVerifytoastmsg();

	}

}
