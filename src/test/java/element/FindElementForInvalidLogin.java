package element;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.Constants;
import util.Element;

public class FindElementForInvalidLogin extends Element{
	AndroidDriver driver;

	public FindElementForInvalidLogin(AndroidDriver driver) {
		super(driver);
	}
	
	public boolean findElement(UserModel userModel) throws InterruptedException {
		clickWhenReady(By.id(Constants.START_BTN_ID));
		sendKeys(By.id(Constants.INPUT_USERNAME_ID), Constants.INPUT_INVALID_USERNAME);
		sendKeys(By.id(Constants.INPUT_PASSWORD_ID), userModel.getPassword());
		clickWhenReady(By.id(Constants.CLICK_LOGIN_BTN_ID));
		Thread.sleep(1000);
		String erroeMessage = getErrorMessageToast(By.xpath(Constants.INVALID_LOGIN_TOAST_XPATH));
		boolean result = erroeMessage.contains(Constants.INVALID_LOGIN_ERROR_MESSAGE);
		return result;
	}

}
