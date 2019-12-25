package element;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ById;
import org.openqa.selenium.support.ByIdOrName;

import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.Constants;
import util.Element;

public class FindElementForDeleteLiveTour extends Element {
	AndroidDriver driver;

	public FindElementForDeleteLiveTour(AndroidDriver driver) {
		super(driver);

	}

	public boolean findElement(UserModel userModel) throws InterruptedException {
		// login
		clickWhenReady(By.id(Constants.START_BTN_ID));
		sendKeys(By.id(Constants.INPUT_USERNAME_ID), userModel.getName());
		sendKeys(By.id(Constants.INPUT_PASSWORD_ID), userModel.getPassword());
		clickWhenReady(By.id(Constants.CLICK_LOGIN_BTN_ID));
		Thread.sleep(5000);

		// create new livetour
		clickWhenReady(By.id(Constants.CREATE_NEW_LIVETOUR_BTN_ID));
		clearWhenReady(By.id(Constants.EDIT_NEW_LIVETOURNAME_BTN_ID));
		sendKeys(By.id(Constants.EDIT_NEW_LIVETOURNAME_BTN_ID), Constants.INPUT_NEW_LIVETOURNAME_FOR_DELETE_TEST);
		clickWhenReady(By.id(Constants.CONFIRM_CREATE_NEW_LIVETOUR_BTN_ID));
		Thread.sleep(1000);
		getToast(By.xpath(Constants.CREATE_NEWLIVETOUR_TOAST_XPATH));
		Thread.sleep(2000);

		// delete livetour
		clickWhenReady(By.id(Constants.EDIT_BTN_ID));
		clickWhenReadyContainsText(ByIdOrName.id(Constants.SELECT_LIVETOUR_TO_BE_DELETED_ID),
				Constants.SELECT_LIVETOUR_TO_BE_DELETED_TEXT);
		clickWhenReady(By.id(Constants.DELETE_LIVETOUR_BTN_ID));
		clickAlertAccept();
		Thread.sleep(1000);
		getToast(By.xpath(Constants.DELETE_LIVETOUR_TOAST_XPATH));
		boolean result = getText(ByIdOrName.id(Constants.SELECT_LIVETOUR_TO_BE_DELETED_ID)).contains(Constants.SELECT_LIVETOUR_TO_BE_DELETED_TEXT);
		return result;
	}

}
