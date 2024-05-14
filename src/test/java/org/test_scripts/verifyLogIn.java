package org.test_scripts;

import org.base.BasePage;
import org.page_objects.LoginPage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.Assert;

public class verifyLogIn {

	@BeforeTest
	public void init() {
		BasePage.initializeWebBrowser();
	}

	@Test
	public static void verifyLoginPage() {
		LoginPage.enteruname(BasePage.configProp.getProperty("username"));
		LoginPage.enterpass(BasePage.configProp.getProperty("password"));
		LoginPage.clickLogin();
		Assert.assertEquals(LoginPage.verifyTitle(), "Home | Pega Studio Training Web Application");
		
	}
	public void close_browser() {
		LoginPage.driver.close();
	}
}
