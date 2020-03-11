package com.autotraders.Pages;

import com.autotraders.utils.MyDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AutotradersPage extends BasePage {

	/**
	 * Locators
	 */
	@FindBy(xpath = "//span[contains(@title,'Browse by Make')]")
	public WebElement browseByMake;

	@FindBy(xpath = "//span[contains(@title,'Browse by Style')]")
	public WebElement browseByStyle;

	@FindBy(xpath = "//a[contains(text(),'Advanced Search')]")
	public WebElement advanceSearch;

	@FindBy(xpath = "//button[@id='search']")
	public WebElement searchButton;


	@FindBy(xpath = "//select[@id='makeCodeListPlaceHolder']")
	public WebElement makeElement;

	@FindBy(xpath = "//select[@id='modelCodeListPlaceHolder']")
	public WebElement modelElement;


	//for initialize the @FindBy annotations.
	public AutotradersPage() {

		PageFactory.initElements(MyDriver.get(), this);
	}

	//Verifying the make,style and advance search elements visibility.
	public void verification(String expected) {


		if (expected.equals(browseByMake.getText())) {
			String actual = browseByMake.getText();
			Assert.assertEquals(expected, actual);

		} else if (expected.equals(browseByStyle.getText())) {
			String actual = browseByStyle.getText();
			Assert.assertEquals(expected, actual);

		} else {
			String actual = advanceSearch.getText();
			Assert.assertEquals(expected, actual);

		}

	}

	//Verifying the Search Button is enabled.
	public void verifyButton() {

		Assert.assertTrue(searchButton.isEnabled());

	}

	//Verifying the Make and Model dropdowns are visible.
	public void verifyMakeAndModel(String make, String model) {

		Assert.assertTrue(makeElement.isDisplayed());
		Assert.assertTrue(modelElement.isDisplayed());

	}


}



