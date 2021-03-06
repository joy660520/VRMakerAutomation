package tasks;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.swing.JTextField;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.TestNGException;

import element.FindElementForCreateNewLiveTour;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import model.UserModel;
import util.CheckElementPresent;
import util.Constants;


import util.Element;

public class CreateNewLiveTour extends FindElementForCreateNewLiveTour{
	AndroidDriver driver;
	public CreateNewLiveTour(AndroidDriver driver) {
		super(driver);
	}

	public void createNewLiveTour(UserModel userModel) throws FileNotFoundException, IOException, InterruptedException {
		
		boolean result =findElement(userModel);
		Assert.assertTrue(result);
		System.out.println("Create new LiveTour successfully!");

	}

}
