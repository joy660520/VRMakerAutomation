package tasks;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import element.FindElementForAccountLogin;
import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.Constants;

public class AccountLogin extends FindElementForAccountLogin {
	AndroidDriver driver;

	public AccountLogin(AndroidDriver driver) {
		super(driver);
	}

	public void accountLogin(UserModel userModel) throws FileNotFoundException, IOException, InterruptedException {
		boolean result = findElement(userModel);
		Assert.assertTrue(result);
		System.out.println("Login successfully!");
	}

}
// driver.findElementsByAndroidUIAutomator("new UiSelector().text(\"開始體驗\")");
// driver.findElementByXPath("android.widget.TextView[contains(@resource-id,'com.iStaging.vrcameraphone:id/textView')]");
// driver.findElementById("com.iStaging.vrcameraphone:id/textView").click();
// //ById要使用完整路徑，如果是By.id只要寫textView