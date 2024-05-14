package org.utils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods extends BasePage {

	public static void waitforelementpresence(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
	}

	public static void highlightingWebelement(WebElement ele) {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].style.border='3px solid yellow'", ele);

	}

	public static void captureScreenshot() {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filePath = "../pomFramework_Pega/screenshot/";
		File destinationpath = new File(filePath + System.currentTimeMillis() + ".png");
		try {
			FileUtils.copyFile(screenshot, destinationpath);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void sendText(By by, String data) {
		WebElement element = driver.findElement(by);
		waitforelementpresence(by);
		highlightingWebelement(element);
		captureScreenshot();
		if (element.isDisplayed()) {
			element.sendKeys(data);
			captureScreenshot();
			System.out.println("entered data in : :" + by);
		} else {
			System.out.println("unable to enter data :: " + by);
		}
	}

	public static void waitforelementClickable(By by) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(by));
	}

	public static void click(By by) {
		waitforelementClickable(by);
		WebElement element = driver.findElement(by);
		highlightingWebelement(element);
		captureScreenshot();
		if (element.isEnabled()) {
			element.click();
			System.out.println("clicked on the element :: " + by);
		} else {
			System.out.println("unable to click :: " + by);
		}
	}

	public static void MouseOver(By by) {
		waitforelementpresence(by);
		WebElement element = driver.findElement(by);
		highlightingWebelement(element);
		captureScreenshot();
		if (element.isDisplayed()) {
			Actions a = new Actions(driver);
			a.moveToElement(element).build().perform();
			System.out.println("performed mouse over on " + by);
		} else {
			System.out.println("there is no element" + by);
		}
	}

	public static void datePicker(By by, String day, String month, String year) {
		waitforelementpresence(by);
		WebElement element = driver.findElement(by);
		highlightingWebelement(element);
		if (element.isDisplayed()) {
			element.click();
			String amonth = driver.findElement(By.className("ui-datepicker-month")).getText();
			System.out.println(amonth);
			String ayear = driver.findElement(By.className("ui-datepicker-year")).getText();
			System.out.println(ayear);
			while (!(amonth.equals(month) && ayear.equals(year))) {
				driver.findElement(By.xpath("//a[@data-handler='prev']")).click();
				amonth = driver.findElement(By.className("ui-datepicker-month")).getText();
				ayear = driver.findElement(By.className("ui-datepicker-year")).getText();
			}
			driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='" + day + "']")).click();
		}
	}

}
