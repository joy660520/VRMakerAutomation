package tasks;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.Constants;
import util.Element;
import util.ReadProperties;

public class AccountLogin extends Element{
	AndroidDriver driver;
	public AccountLogin(AndroidDriver driver) {
		super(driver);
	}
	public void accountLogin(UserModel userModel)
			throws FileNotFoundException, IOException, InterruptedException {
		clickWhenReady(By.id(Constants.START_BTN_ID));
		sendKeys(By.id(Constants.INPUT_USERNAME_ID), userModel.getName());
		sendKeys(By.id(Constants.INPUT_PASSWORD_ID), userModel.getPassword());
		clickWhenReady(By.id(Constants.CLICK_LOGIN_BTN_ID));
		Thread.sleep(5000);
		isDisplayed(By.id(Constants.LIVETOUR_TAB_NAME));		
        boolean result=listOfElement(By.className(Constants.LIST_BY_CLASS));
		Assert.assertTrue(result);
		System.out.println("Login successfully!");
	}

}
        //driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"開始體驗\")");
		// driver.findElementByXPath("android.widget.TextView[contains(@resource-id,'com.iStaging.vrcameraphone:id/textView')]");
		// driver.findElementById("com.iStaging.vrcameraphone:id/textView").click();
		// //ById要使用完整路徑，如果是By.id只要寫textView