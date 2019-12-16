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

import element.FindElementForAccountLogout;
import io.appium.java_client.android.AndroidDriver;
import model.UserModel;
import util.CheckElementPresent;
import util.Constants;
import util.Element;



public class AccountLogout extends FindElementForAccountLogout {
	AndroidDriver driver;

	public AccountLogout(AndroidDriver driver) {
		super(driver);
	}

	public void accountLogout(UserModel userModel) throws FileNotFoundException, IOException, InterruptedException {
		boolean result = findElement(userModel);
		Assert.assertTrue(result);
		System.out.println("Logout successfully!");

	}

}
