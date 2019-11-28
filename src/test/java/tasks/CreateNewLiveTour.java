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

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import model.UserModel;
import util.CheckElementPresent;
import util.Constants;
import util.ReadProperties;
import util.ScrollingElementToView;
import util.Element;

public class CreateNewLiveTour extends Element {
	AndroidDriver driver;
	public CreateNewLiveTour(AndroidDriver driver) {
		super(driver);
	}

	public void createNewLiveTour() throws FileNotFoundException, IOException, InterruptedException {
		
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
		Assert.assertTrue(result);
		System.out.println("Create new LiveTour successfully!");

	}

}
