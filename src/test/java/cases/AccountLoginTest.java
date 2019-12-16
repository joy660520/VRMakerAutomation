package cases;

import java.net.URL;
import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import model.UserModel;
import tasks.AccountLogin;

import util.Element;

import org.testng.annotations.Parameters;

public class AccountLoginTest {
	private static Logger logger = LogManager.getLogger(AccountLoginTest.class.getName()); // 定義Logger
	AndroidDriver driver;
	UserModel userModel;
	ITestResult finalTestResult;

	@Parameters({ "username", "password" })
	@BeforeMethod
	public void setup(String username, String password) throws Exception {// 外部傳入的參數
		try {
			// System.out.println("Success!");
			DesiredCapabilities capabilities = new DesiredCapabilities();
			// hp.ImportPhoto("/Users/joyshen/setup.sh"); //使用模擬器的時候用
			capabilities.setCapability("automationName", "uiautomator2");// 這句不是必須的
			// capabilities.setCapability("deviceName", "emulator-5554"); //for emulator
			capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.ANDROID_UIAUTOMATOR2);
			capabilities.setCapability("deviceName", "SM-G930FD"); // for 實機
			capabilities.setCapability("udid", "988633443234585742");
			// capabilities.setCapability("platformVersion", "7.1.1"); //for emulator
			capabilities.setCapability("platformVersion", "8.0.0");
			capabilities.setCapability("platformName", "Android");
			capabilities.setCapability("appPackage", "com.iStaging.vrcameraphone");
			capabilities.setCapability("appActivity", "com.iStaging.vrcameraphone.MainActivity"); // 啟動app的第一個畫面
			// capabilities.setCapability("app",
			// "/Users/joyshen/Desktop/vrmaker_android_e2e_testing/apk/app-release-test.apk");
			// // 安裝apk，如果已經裝了apk，可以不用這行
			// capabilities.setCapability("app",
			// "/Users/joyshen/Desktop/vrmaker_android_e2e_testing/apk/app-release-prod.apk");
			// // 安裝apk，如果已經裝了apk，可以不用這行
			capabilities.setCapability("autoGrantPermissions", true);
			capabilities.setCapability("unicodeKeyboard", true); // disable the keyboard (using appium IME but it's
																	// transparent, not affect sendkeys)
			capabilities.setCapability("autoAcceptAlerts", true);
			capabilities.setCapability("resetKeyboard", true);
			capabilities.setCapability("chromedriverExecutable",
					"/Users/joyshen/node_modules/appium/node_modules/appium-chromedriver/chromedriver/mac/chromedriver");
			driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities); // 本機IP：127.0.0.1:4723
			Thread.sleep(2000);
		} catch (Exception ee) {
			ee.printStackTrace();
		}
		Thread.sleep(3000);

		userModel = new UserModel();
		userModel.setName(username);
		userModel.setPassword(password);
		// logger.info("browser is" + browser + "url is" + url);

	}

	@Test
	public void runTest() throws Exception {
		AccountLogin al = new AccountLogin(driver);
		al.accountLogin(userModel);

	}

	@AfterMethod
	public void tearDown(ITestResult testResult) throws Exception {
		// driver = SetCapacities.driver;
		this.finalTestResult = testResult;
		if (finalTestResult.getStatus() == ITestResult.FAILURE) {
			Element el = new Element(driver);
			el.getScreenshots();
		}
		driver.quit();

	}

}
