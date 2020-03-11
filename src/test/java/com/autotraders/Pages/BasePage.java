package com.autotraders.Pages;

import com.autotraders.utils.MyDriver;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Set;

public class BasePage {

    //When we use @FindBy annotation in this page.
	public BasePage() {

		PageFactory.initElements(MyDriver.get(), this);
	}

	//To use for certain wait time we use this method.
	public void waitforelements() throws InterruptedException {
		Thread.sleep(3000);
	}

    /**
     * Web site was not allowing the automation browser
     * And I saw that browser was doing it with cookies and
     * I cleaned the cookies every page navigation to make sure
     * my automation works.
     */
	public static void clearCookiees() {

		Set<Cookie> a = MyDriver.get().manage().getCookies();
		System.out.println(a);
		//Delete all the cookies
		MyDriver.get().manage().deleteAllCookies();

	}
}
