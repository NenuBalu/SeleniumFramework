package org.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static WebDriver driver;
	public static File configFile;
	public static FileInputStream configFis;
	public static Properties configProp;

	public static void geturl() {
		String url = configProp.getProperty("baseurl");
		driver.get(url);
	}

	public static void readConfigProp() {
		configFile = new File("../pomFramework_Pega/src/test/java/org/resources/config.properties");
		try {
			configFis = new FileInputStream(configFile);
			configProp = new Properties();
			configProp.load(configFis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void initializeWebBrowser() {
		readConfigProp();
		String browser = configProp.getProperty("browser");
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			geturl();
		}
	}
}
