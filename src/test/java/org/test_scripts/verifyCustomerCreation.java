package org.test_scripts;

import org.base.BasePage;
import org.openqa.selenium.By;
import org.page_objects.CreateCustomePage;
import org.page_objects.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class verifyCustomerCreation {

	@BeforeTest
	public void init() {
		BasePage.initializeWebBrowser();
	}
@Test
	public void createCustomer() {
		verifyLogIn.verifyLoginPage();
		HomePage.MouseOverOnSettingsIcon();
		CreateCustomePage.clickCustomerLink();
		CreateCustomePage.verifyCustomerPage();
		CreateCustomePage.enterAccountNumber(BasePage.configProp.getProperty("CustomerAccountNumber"));
		CreateCustomePage.enterCustomerName(BasePage.configProp.getProperty("CustomerName"));
		CreateCustomePage.enterCompanyNameOfCustomer(BasePage.configProp.getProperty("CustomerCompany"));
		CreateCustomePage.clickOnCustomerSubmitButton();
		CreateCustomePage.enterCustomerCity("Hyderabad");
		CreateCustomePage.enterCustomerEmailID("nnnnn@gmail.com");
		CreateCustomePage.enterCustomerPhoneNum("1000002555");
		CreateCustomePage.enterCustomerState("telangana");
		CreateCustomePage.enterCustomerStreetAddress("street");
		CreateCustomePage.enterCustomerZipCode("505050");
		CreateCustomePage.SelectLevel("Bronze");
		CreateCustomePage.enterCustomerPersonalID("555555");
		CreateCustomePage.enterAccounOpenedDate("20", "July", "2023");
		CreateCustomePage.driver.findElement(By.xpath("//input[@type='submit']"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CreateCustomePage.driver.close();

	}
}
