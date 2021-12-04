package com.neotech.steps;

import com.neotech.testbase.BaseClass;
import com.neotech.utils.CommonMethods;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BaseClass {

	@Before
	public void start() {
		setUp();
	}

	@After
	public void end(Scenario scenario) {

		byte[] picture;

		if (scenario.isFailed()) {
			// save it in failed
			picture = CommonMethods.takeScreenshot("/failed/" + scenario.getName());
		} else {
			// save it in passed
			picture = CommonMethods.takeScreenshot("/passed/" + scenario.getName());
		}

		scenario.attach(picture, "image/png", scenario.getName());

		tearDown();
	}

}
