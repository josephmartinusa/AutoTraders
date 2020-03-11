package com.autotraders.StepDefinitions;


import com.autotraders.utils.MyDriver;
import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hook {

	@Before
	public void setup() {

		System.out.println("####  start d######\n");

		MyDriver.get().manage().window().maximize();
	}

	@After
	public void teardown(Scenario scenario) {
		//if test failed - do this
		if (scenario.isFailed()) {
			System.out.println("Test failed!");
			byte[] screenshot = ((TakesScreenshot) MyDriver.get()).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} else {
			System.out.println("All cleanup!");
			System.out.println("Test is done");
		}
		System.out.println("###########-DONE-###################");
		//after every test, we gonna close browser
		MyDriver.close();
	}

}
