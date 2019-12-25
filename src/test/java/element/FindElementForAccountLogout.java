package element;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ByIdOrName;

import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.Constants;
import util.Element;

public class FindElementForAccountLogout extends Element {
	AndroidDriver driver;

	public FindElementForAccountLogout(AndroidDriver driver) {
		super(driver);
	}

	public boolean findElement(UserModel userModel) throws InterruptedException {
		//login
		clickWhenReady(By.id(Constants.START_BTN_ID));
		sendKeys(By.id(Constants.INPUT_USERNAME_ID), userModel.getName());
		sendKeys(By.id(Constants.INPUT_PASSWORD_ID), userModel.getPassword());
		clickWhenReady(By.id(Constants.CLICK_LOGIN_BTN_ID));
		Thread.sleep(5000);
		
		clickWhenReady(By.id(Constants.NAVI_MORE_BTN_ID));
		clickWhenReady(By.id(Constants.LOGOUT_BTN_ID));
		clickWhenReady(ByIdOrName.id(Constants.CONFIRM_LOGOUT_BTN));
		Thread.sleep(3000);
		boolean nameCheck = isDisplayed(By.id(Constants.INPUT_USERNAME_ID));
		boolean psdCheck = isDisplayed(By.id(Constants.INPUT_PASSWORD_ID));
		String userName = getText(By.id(Constants.INPUT_USERNAME_ID));
		String password = getText(By.id(Constants.INPUT_PASSWORD_ID));
		System.out.println(userName);
		if ((nameCheck == true) && (psdCheck == true)) {
			System.out.println("使用者名稱： " + userName);
			System.out.println("密碼： " + password);
		} else {
			System.out.println("can't find the element");
		}

		boolean result = password.equalsIgnoreCase(Constants.CLICK_PASSWORD_CONFIRM_BTN_ID);

		return result;
	}
}
