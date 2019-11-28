package tasks;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.server.handler.FindElement;
import org.openqa.selenium.support.ByIdOrName;
import org.testng.Assert;

import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.CheckElementPresent;
import util.Constants;
import util.Element;
import util.ReadProperties;
import util.ScrollingElementToView;

public class AccountLogout extends Element {
	AndroidDriver driver;

	public AccountLogout(AndroidDriver driver) {
		super(driver);
	}

	public void accountLogout() throws FileNotFoundException, IOException, InterruptedException {
		clickWhenReady(By.id(Constants.NAVI_MORE_BTN_ID));
		clickWhenReady(By.id(Constants.LOGOUT_BTN_ID));
		clickWhenReady(ByIdOrName.id(Constants.CONFIRM_LOGOUT_BTN));
		// driver.findElement(By.id(Constants.NAVI_MORE_BTN_ID)).click();
		// driver.findElement(By.id(Constants.LOGOUT_BTN_ID)).click();
		// Thread.sleep(3000);
		// driver.findElementById("android:id/button1").click();

		Thread.sleep(3000);
		boolean nameCheck = isDisplayed(By.id(Constants.INPUT_USERNAME_ID));
		boolean psdCheck = isDisplayed(By.id(Constants.INPUT_PASSWORD_ID));
		String userName = getText(By.id(Constants.INPUT_USERNAME_ID));
		String password = getText(By.id(Constants.INPUT_PASSWORD_ID));
		// boolean nameCheck =
		// driver.findElement(By.id(Constants.INPUT_USERNAME_ID)).isDisplayed();
		// boolean psdCheck =
		// driver.findElement(By.id(Constants.INPUT_PASSWORD_ID)).isDisplayed();
		// String userName =
		// driver.findElement(By.id(Constants.INPUT_USERNAME_ID)).getText();
		// String password =
		// driver.findElement(By.id(Constants.INPUT_PASSWORD_ID)).getText();
		System.out.println(userName);
		if ((nameCheck == true) && (psdCheck == true)) {
			System.out.println("使用者名稱： " + userName);
			System.out.println("密碼： " + password);
		} else {
			System.out.println("can't find the element");
		}

		boolean result = password.equalsIgnoreCase(Constants.CLICK_PASSWORD_CONFIRM_BTN_ID);
		Assert.assertTrue(result);
		System.out.println("Logout successfully!");

	}

}
