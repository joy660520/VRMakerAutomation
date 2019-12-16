package tasks;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.server.handler.FindElement;

import element.FindElementForDeleteLiveTour;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Assert;
import model.UserModel;
import util.Constants;
import util.Element;

public class DeleteLiveTour extends FindElementForDeleteLiveTour{
	AndroidDriver driver;
	public DeleteLiveTour(AndroidDriver driver) {
		super(driver);
	}

	public void deleteLiveTour(UserModel userModel) throws FileNotFoundException, IOException, InterruptedException {
		boolean result=findElement(userModel);
		Assert.assertFalse(result);
		System.out.println("Delete LiveTour successfully!");
	}
}
