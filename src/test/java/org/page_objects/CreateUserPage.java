package org.page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.utils.ReusableMethods;

public class CreateUserPage extends ReusableMethods {
	public static By usersLinkBy = By.linkText("Users");
	public static By usersPageTitleBy = By.xpath("//table[@id='title_and_home_link']//h1");
	public static By firstnameBy = By.id("fname");
	public static By LastnameBy = By.id("lname");
	public static By EmailIDBy = By.id("email");
	public static By AddUsrButBy = By.xpath("//table[@id='manage_user_inputs']//input[@type='button']");
	public static String FirstNameOfUser;
	 

	public static By getCreatedUserByLocator() {
		return By.xpath(" //td[text()='" + FirstNameOfUser + "']");
	}
	
	public static By RemoveButtonByLocator() {
		return By.xpath(" //td[text()='" + FirstNameOfUser +"']/following-sibling::td/a[text()='Remove']");
	}

	public static void clickUserLink() {
		click(usersLinkBy);
	}

	public static String PageTitleCheck() {

		String PageTitle = driver.findElement(usersPageTitleBy).getText();
		System.out.println(PageTitle);
		return PageTitle;

	}

	public static String enterFirstName(String UserName) {
		FirstNameOfUser = UserName;
		sendText(firstnameBy, UserName);
		return FirstNameOfUser;
	}

	public static void enterLastName(String data) {
		System.out.println(FirstNameOfUser);
		sendText(LastnameBy, data);
	}

	public static void enterEmailID(String data) {
		sendText(EmailIDBy, data);
	}

	public static void clickOnAddUserBtn() {
		click(AddUsrButBy);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void verifyIfUserGotCreated() {
		String createdUser = driver.findElement(By.xpath("//td[text()='" + FirstNameOfUser + "']")).getText();
		Assert.assertEquals(createdUser, FirstNameOfUser);
	}

	public static void removeUser() {
		By RemoveButtonBy = RemoveButtonByLocator();
		click(RemoveButtonBy);
	}
}	
