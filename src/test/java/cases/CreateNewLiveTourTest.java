package cases;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import tasks.AccountLogin;
import tasks.AccountLogout;
import tasks.CreateNewLiveTour;

import util.Constants;

import org.testng.annotations.Parameters;

public class CreateNewLiveTourTest extends AccountLoginTest {

	@Test
	public void runTest() throws Exception {
		
		CreateNewLiveTour ct = new CreateNewLiveTour(driver);
		ct.createNewLiveTour(userModel);

	}

}
