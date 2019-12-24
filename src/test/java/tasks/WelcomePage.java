package tasks;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;

import element.FindElementForAccountLogin;
import element.FindElementForWelcomePage;
import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.Constants;

public class WelcomePage extends FindElementForWelcomePage {
	AndroidDriver driver;

	public WelcomePage(AndroidDriver driver) {
		super(driver);
	}

	public void welcomePage(UserModel userModel) throws FileNotFoundException, IOException, InterruptedException {
		boolean result = findElement(userModel);
		Assert.assertTrue(result);
		System.out.println("Login successfully!");
	}

}
