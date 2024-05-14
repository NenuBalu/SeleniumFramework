package org.page_objects;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.utils.ReusableMethods;

public class CreateCustomePage extends ReusableMethods {

	public static By customerLinkBy = By.linkText("Customers");
	public static By AccountNumberBy = By.id("account_number");
	public static By CustomerNameBy = By.id("customer_name");
	public static By CustomerComapanyNameBy = By.id("company_name");
	public static By CustomerSubmitButtonBy = By.xpath("//input[@value='Add Customer']");
	public static By CustomerStreetAddrBy = By.id("account_street_address");
	public static By CustomerCityBy = By.id("account_city");
	public static By CustomerStateBy = By.id("account_state");
	public static By CustomerZipCodeBy = By.id("account_zip_code");
	public static By CustomerEmailBy = By.id("account_email");
	public static By CustomerPhoneNumBy = By.id("account_phone");
	public static By CustomerLevelBy = By.id("account_level");
	public static By CustomerAccountCreatedBy = By.id("datepicker");
	public static By CustomerSSNID = By.id("account_ssn_code");
	public static By CustomerPersonalID= By.id("account_ssn_code");

	public static void clickCustomerLink() {
		click(customerLinkBy);
	}
	
	public static void enterCustomerPersonalID(String data) {
		sendText(CustomerPersonalID, data);
	}
	public static void enterCustomerStreetAddress(String data) {
		sendText(CustomerStreetAddrBy, data);
	}

	public static void enterCustomerCity(String data) {
		sendText(CustomerCityBy, data);
	}

	public static void enterCustomerState(String data) {
		sendText(CustomerStateBy, data);
	}

	public static void enterCustomerZipCode(String data) {
		sendText(CustomerZipCodeBy, data);
	}

	public static void enterCustomerEmailID(String data) {
		sendText(CustomerEmailBy, data);
	}

	public static void enterCustomerPhoneNum(String data) {
		sendText(CustomerPhoneNumBy, data);
	}

	public static void SelectLevel(String SelectALevel) {
		click(CustomerLevelBy);
		By SelectLevelBy = By.xpath("//option[@value='" + SelectALevel + "']");
		waitforelementpresence(SelectLevelBy);
		click(SelectLevelBy);
	}

	public static void enterAccounOpenedDate(String Date, String Month, String Year) {
		System.out.println("entering the date given by date picker is ::: " + Date + "-" + Month + "-" + Year);
		datePicker(CustomerAccountCreatedBy, Date, Month, Year);
	}

	public static void verifyCustomerPage() {
		String CustomerPageTitle = driver.getTitle();
		Assert.assertEquals(CustomerPageTitle, "Customers | Pega Studio Training Web Application");
	}

	public static void enterAccountNumber(String data) {
		System.out.println("entering accountnumber in here" + AccountNumberBy + "and the data is " + data);
		sendText(AccountNumberBy, data);
	}

	public static void enterCustomerName(String data) {
		System.out.println("entering customer name in :: " + CustomerNameBy + "data loaded is :: " + data);
		sendText(CustomerNameBy, data);
	}

	public static void enterCompanyNameOfCustomer(String data) {
		System.out.println("entering customer's company name in :: " + CustomerComapanyNameBy + "and the data entered is " + data);
		sendText(CustomerComapanyNameBy, data);
	}

	public static void enterCustomerSSNID(String data) {
		sendText(CustomerSSNID, data);
	}

	public static void clickOnCustomerSubmitButton() {
		System.out.println("clicking on submit button");
		click(CustomerSubmitButtonBy);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
