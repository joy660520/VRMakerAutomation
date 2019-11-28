package util;

import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class SetCapacities {
	public static AndroidDriver<WebElement> driver;
	

	public static void setCapacities() throws InterruptedException {

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
			capabilities.setCapability("unicodeKeyboard", true); // disable the keyboard (using appium IME but it's transparent, not affect sendkeys)
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
	}
}
