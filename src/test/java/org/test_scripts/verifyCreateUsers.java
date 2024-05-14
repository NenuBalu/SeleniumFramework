package org.test_scripts;

import org.base.BasePage;
import org.page_objects.CreateUserPage;
import org.page_objects.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyCreateUsers {
	@BeforeTest
	public void init() {
		BasePage.initializeWebBrowser();
	}
	@Test
	public void createUsers() {
		verifyLogIn.verifyLoginPage();
		HomePage.MouseOverOnSettingsIcon();
		CreateUserPage.clickUserLink();
		CreateUserPage.PageTitleCheck();
		CreateUserPage.enterFirstName("balaji");
		CreateUserPage.enterLastName("bathina");
		CreateUserPage.enterEmailID("bathina@gmail.com");
		CreateUserPage.clickOnAddUserBtn();
		CreateUserPage.verifyIfUserGotCreated();
		CreateUserPage.removeUser();
	}
}
