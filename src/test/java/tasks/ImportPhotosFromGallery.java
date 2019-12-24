package tasks;

import org.openqa.selenium.remote.server.handler.FindElement;
import org.testng.Assert;

import element.FindElementForImportPhotosFromGallery;
import io.appium.java_client.android.AndroidDriver;
import model.UserModel;

public class ImportPhotosFromGallery extends FindElementForImportPhotosFromGallery{
	AndroidDriver driver;
	public ImportPhotosFromGallery(AndroidDriver driver) {
		super(driver);
	}
	public void importPhotosFromGallery(UserModel userModel) throws InterruptedException {
		boolean result=findElement(userModel);
		Assert.assertTrue(result);
		System.out.println("Upload panoramas successfully!");
	}
}
