package element;

import org.openqa.selenium.By;

import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.Constants;
import util.Element;

public class FindElementForCreateNewLiveTour extends Element {
	AndroidDriver driver;

	public FindElementForCreateNewLiveTour(AndroidDriver driver) {
		super(driver);
	}
	public boolean findElement(UserModel userModel) throws InterruptedException {
		//login
		clickWhenReady(By.id(Constants.START_BTN_ID));
		sendKeys(By.id(Constants.INPUT_USERNAME_ID), userModel.getName());
		sendKeys(By.id(Constants.INPUT_PASSWORD_ID), userModel.getPassword());
		clickWhenReady(By.id(Constants.CLICK_LOGIN_BTN_ID));
		Thread.sleep(5000);
		
		//create new livetour
		clickWhenReady(By.id(Constants.CREATE_NEW_LIVETOUR_BTN_ID));
		clearWhenReady(By.id(Constants.EDIT_NEW_LIVETOURNAME_BTN_ID));
		sendKeys(By.id(Constants.EDIT_NEW_LIVETOURNAME_BTN_ID), Constants.INPUT_NEW_LIVETOURNAME);
		clickWhenReady(By.id(Constants.CONFIRM_CREATE_NEW_LIVETOUR_BTN_ID));
		Thread.sleep(1000);
		getToast(By.xpath(Constants.CREATE_NEWLIVETOUR_TOAST_XPATH));
		Thread.sleep(2000);
		String newLiveTourName = getText(By.id(Constants.NEW_LIVETOUR_NAME_ID));
		System.out.println("新增物件名稱： " + newLiveTourName);
		boolean result = newLiveTourName.equalsIgnoreCase(Constants.INPUT_NEW_LIVETOURNAME);
		return result;
	}

}
