package com.autotraders.StepDefinitions;

import com.autotraders.Pages.AdvanceSearchPage;
import com.autotraders.Pages.AutotradersPage;
import com.autotraders.Pages.BasePage;
import com.autotraders.utils.ConfigurationReader;
import com.autotraders.utils.MyDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutotradersSteps {

	// I create object of pages from POM.
	//with the help of object I can reach properties of specific class
	AutotradersPage autotradersPage = new AutotradersPage();
	AdvanceSearchPage advanceSearchPage = new AdvanceSearchPage();




	@Given("User is in landing page")
	public void user_is_in_landing_page() {
		System.out.println("We are in landing Page");
        //opening the landing page.
		MyDriver.get().get(ConfigurationReader.getProperty("Url"));
	}

	@Then("Verify that {string} are present")
	public void verify_that_are_present(String string) {

		autotradersPage.verification(string);
	}

	@Then("verify that search button is present.")
	public void verify_that_search_button_is_present() {
		autotradersPage.verifyButton();

	}

	@Then("verify that {string} and {string} is visible")
	public void verify_that_and_is_visible(String string, String string2) {

		autotradersPage.verifyMakeAndModel(string, string2);

		BasePage.clearCookiees();
	}

	//user story to start
	@Given("User click Advance Search link on the home page")
	public void user_click_Advance_Search_link_on_the_home_page() throws InterruptedException {

		MyDriver.get().get(ConfigurationReader.getProperty("Url"));
		advanceSearchPage.verifyclickable();

		BasePage.clearCookiees();
		Thread.sleep(2000);
	}

	@Then("User enter {string} in the {string} text box")
	public void user_enter_in_the_text_box(String zip, String string2) {


		advanceSearchPage.verifyZipCode(zip);
	}

	@Then("User select {string} check box under {string}")
	public void user_select_check_box_under(String string, String string2) throws InterruptedException {


		advanceSearchPage.verifyclickCertifiedAndConvertible(string, string2);

		Thread.sleep(2000);
	}

	@Then("user update Year From {string} to {string}")
	public void user_update_Year_From_to(String from, String to) throws InterruptedException {

		advanceSearchPage.verifyselectStartAndEnd(from,to);
	}

	@Then("user select {string} car from Make,Model and Trim section")
	public void user_select_car_from_Make_Model_and_Trim_section(String string) throws InterruptedException {

		advanceSearchPage.verifyselectBMW();
		BasePage.clearCookiees();
	}

	@Then("User clicks {string} button")
	public void user_clicks_button(String string) throws InterruptedException {

		advanceSearchPage.verifyClickSearchButton();
	}

	@Then("User verifies that he is in result page")
	public void user_verifies_that_he_is_in_result_page() {


		advanceSearchPage.VerifyUsersInPage();
	}

	@Then("User verifies that he sees only {string} cars in listing")
	public void user_verifies_that_he_sees_only_cars_in_listing(String string) {
		advanceSearchPage.VerifyThereIsOnlyBMW();


	}

	@Then("Display in console, the number of cars listed in result page")
	public void display_in_console_the_number_of_cars_listed_in_result_page() {
		advanceSearchPage.verifyNumberOfBMW();


	}

}
