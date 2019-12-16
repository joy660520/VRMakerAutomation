package util;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.UUID;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestNGException;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class Element {
	AndroidDriver driver;

	public Element(AndroidDriver driver) {
		this.driver = driver;
	}

	public void clickWhenReady(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).click();
	}

	public void clickAlertAccept() {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void clickWhenReadyContainsText(By element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).getText().contains(text);
		driver.findElement(element).click();
	}

	public void clearWhenReady(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).click();
		driver.findElement(element).clear();
	}

	public void sendKeys(By element, String keys) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		driver.findElement(element).sendKeys(keys);
	}

	public String getText(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		return driver.findElement(element).getText();
	}

	public boolean isDisplayed(By element) {
		WebDriverWait wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		boolean result = driver.findElement(element).isDisplayed();
		return result;
	}

	public boolean listOfElement(By elements) {
		List list = driver.findElements(elements);
		boolean result = list.size() != 0;
		return result;
	}

	public void getToast(By element) {
		try {
			WebElement element1 = new WebDriverWait(driver, 30).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(element);
				}
			});
			String toast = element1.getText();
			System.out.println("toast : " + toast);
		} catch (Exception e) {
			throw new TestNGException(e);
		}
	}
	
	public String getErrorMessageToast(By element) {
		try {
			WebElement element1 = new WebDriverWait(driver, 30).until(new ExpectedCondition<WebElement>() {
				public WebElement apply(WebDriver driver) {
					return driver.findElement(element);
				}
			});
			String toast = element1.getText();
			System.out.println("toast : " + toast);
			return toast;
		} catch (Exception e) {
			throw new TestNGException(e);
		}
		
	}

	public String getRandomString() throws InterruptedException {
		String s = UUID.randomUUID().toString();
		return s.toString();
	}

	public void getScreenshots() throws Exception {
		String fileName = getRandomString() + ".png";
		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "screenshot");
		// String directory = "/Users/joyshen/Documents/autotesting screenshot";
		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(sourceFile, new File(appDir, fileName));
	}

	public void slideToLeft() {
		int width = driver.manage().window().getSize().width;
		int height = driver.manage().window().getSize().height;
		for (int i = 1; i <= 3; i++) {
			TouchAction action = new TouchAction(driver);
			action.press(PointOption.point(width * 9 / 10, height / 2)).moveTo(PointOption.point(width / 10, height / 2))
					.release().perform();
			
			//skip welcomepage
//			Duration duration = Duration.ofSeconds(3);
//			TouchAction ta = new TouchAction(driver).press(PointOption.point(width / 2, height * 3 / 4))
//					.waitAction(WaitOptions.waitOptions(duration)).moveTo(PointOption.point(width / 2, height / 4))
//					.release();
//			ta.perform();
		}
	}

}
