package element;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.Constants;
import util.Element;

public class FindElementForWelcomePage extends Element{
	AndroidDriver driver;

	public FindElementForWelcomePage(AndroidDriver driver) {
		super(driver);
	}

	public boolean findElement(UserModel userModel) throws InterruptedException {
		Thread.sleep(3000);
		slideToLeft();
		clickWhenReady(By.id(Constants.START_BTN_ID));
		sendKeys(By.id(Constants.INPUT_USERNAME_ID), userModel.getName());
		sendKeys(By.id(Constants.INPUT_PASSWORD_ID), userModel.getPassword());
		clickWhenReady(By.id(Constants.CLICK_LOGIN_BTN_ID));
		Thread.sleep(5000);
		isDisplayed(By.id(Constants.LIVETOUR_TAB_NAME));
		boolean result=listOfElement(By.className(Constants.LIST_BY_CLASS));
		return result;
	}
}
