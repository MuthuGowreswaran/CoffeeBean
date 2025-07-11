package com.framework.selenium.salesforcepages;

import com.framework.selenium.api.design.Locators;
import com.framework.testng.api.base.BaseMethods;

public class LeadPage extends BaseMethods {

	public LeadPage clickNew() {
		click(locateElement(Locators.XPATH, "//button[@name='New']"));
		reportStep("Clicked on New button successfully", "Pass", true);
		return this;
	}

	public LeadPage enterLeadDetails(String fName, String lName, String company) {
		click(locateElement(Locators.XPATH, "//label[text()='Salutation']//following::button[1]"));
		reportStep("Clicked on Salutation button successfully", "Pass", true);

		click(locateElement(Locators.XPATH, "//span[text()='Mr.']"));
		reportStep("Selected Mr. from dropdown successfully", "Pass", true);

		clearAndType(locateElement(Locators.XPATH, "//input[@name='firstName']"), fName);
		reportStep("Entered first name successfully " + fName, "Pass", true);

		clearAndType(locateElement(Locators.XPATH, "//input[@name='lastName']"), lName);
		reportStep("Entered last name successfully " + lName, "Pass", true);

		clearAndType(locateElement(Locators.XPATH, "//input[@name='Company']"), company);
		reportStep("Entered company name successfully " + company, "Pass", true);

		return this;
	}

	public String getToastMessage() {
		String toastMessage = getElementText(locateElement(Locators.XPATH, "//a[@class='forceActionLink']"));
		if (toastMessage.contains("Lead")) {
			reportStep("Toast message displayed: " + toastMessage, "Pass", true);
		}

		return toastMessage;
	}

	public LeadPage saveLead(String user) {
		click(locateElement(Locators.XPATH, "//button[@name='SaveEdit']"));
		reportStep("Clicked on Save button successfully", "Pass", true);
		return this;
	}

	public LeadPage searchLead(String name) throws InterruptedException {
		typeAndEnter(locateElement(Locators.XPATH, "//input[@name='Lead-search-input']"), name);
		reportStep("Entered search query " + name, "Pass", true);
		Thread.sleep(3000);
		return this;
	}

	public LeadPage clickEdit() {
		clickUsingJs(locateElement(Locators.XPATH, "//div[text()='Edit']"));
		reportStep("Clicked on Edit button successfully", "Pass", true);
		return this;
	}

	public LeadPage clickExpandButton() throws InterruptedException {
		Thread.sleep(3000);
		click(locateElement(Locators.XPATH, "(//button[contains(@class,'slds-button slds-button_icon-border')])[2]"));
		reportStep("Clicked on Expand button successfully", "Pass", true);
		return this;
	}

	public LeadPage clickDelete() throws InterruptedException {
		Thread.sleep(3000);
		click(locateElement(Locators.XPATH, "//a[@title='Delete']"));
		reportStep("Clicked on Delete option successfully", "Pass", true);

		click(locateElement(Locators.XPATH, "//span[text()='Delete']"));
		reportStep("Confirmed Delete action", "Pass", true);
		return this;
	}
}
