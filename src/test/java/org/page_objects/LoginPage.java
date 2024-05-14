package org.page_objects;

import org.openqa.selenium.By;
import org.utils.ReusableMethods;

public class LoginPage extends ReusableMethods {

	public static By uname = By.id("user_name");
	public static By passw = By.id("user_pass");
	public static By loginBtn = By.id("login_button");

	public static void openbrowser() {
		initializeWebBrowser();
	}

	public static void enteruname(String data) {
		sendText(uname, data);
	}

	public static void enterpass(String data) {
		sendText(passw, data);
	}

	public static void clickLogin() {
		click(loginBtn);
	}

	public static String verifyTitle() {
		return driver.getTitle();
	}
}
