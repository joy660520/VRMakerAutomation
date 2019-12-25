package element;

import org.openqa.selenium.By;
import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.Constants;
import util.Element;

public class FindElementForImportPhotosFromGallery extends Element {
	AndroidDriver driver;

	public FindElementForImportPhotosFromGallery(AndroidDriver driver) {
		super(driver);
	}

	public boolean findElement(UserModel userModel) throws InterruptedException {
		
		// login
		clickWhenReady(By.id(Constants.START_BTN_ID));
		sendKeys(By.id(Constants.INPUT_USERNAME_ID), userModel.getName());
		sendKeys(By.id(Constants.INPUT_PASSWORD_ID), userModel.getPassword());
		clickWhenReady(By.id(Constants.CLICK_LOGIN_BTN_ID));
		Thread.sleep(5000);

		// create livetour
		clickWhenReady(By.id(Constants.CREATE_NEW_LIVETOUR_BTN_ID));
		clearWhenReady(By.id(Constants.EDIT_NEW_LIVETOURNAME_BTN_ID));
		sendKeys(By.id(Constants.EDIT_NEW_LIVETOURNAME_BTN_ID), Constants.INPUT_NEW_LIVETOURNAME_FOR_IMPORT_PHOTOS);
		clickWhenReady(By.id(Constants.CONFIRM_CREATE_NEW_LIVETOUR_BTN_ID));
		clickWhenReadyContainsText(By.id(Constants.NEW_LIVETOUR_NAME_ID),
				Constants.INPUT_NEW_LIVETOURNAME_FOR_IMPORT_PHOTOS);

		// add panos
		clickWhenReady(By.id(Constants.ADD_PANO_BTN_ID));
		clickWhenReady(By.id(Constants.GALLERY_ICON_ID));
		Thread.sleep(5000);
		slideToHistoryPage();
		selectPhotosFromGallery();
		clickWhenReady(By.id(Constants.ACTION_SAVE_BTN_ID));
		waitForVisible(By.id(Constants.LIVETOUR_TITLE_ID), 90);
		waitForVisibleForToast(By.xpath(Constants.IMPORT_PHOTOS_TOAST_XPATH), 3);
		Thread.sleep(3000);
		clickWhenReady(By.id(Constants.BUILDING_DETAIL_PAGE_EDIT_BTN_ID));
		int panoAmount = checkImportPhotoNumber();
		System.out.println("uploaded pano number= " + panoAmount);
		if (panoAmount >= 0) {
			return true;
		} else {
			return false;
		}
	}

}
