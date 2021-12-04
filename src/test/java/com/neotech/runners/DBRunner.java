package com.neotech.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)

@CucumberOptions(
		// we can specify which feature/features to run
		features = "src/test/resources/features/",
		// we can specify where the code for the above feature is located
		glue = "com.neotech.steps",
		// false by default. if true, it does not run the java classes.
		// only checks cucumber files if they are glued to some java code, if steps
		// implemented or not
		dryRun = false, // (false) by default. so dont have to specify if we dont need a dry run
		// tags can do the same thing groups on TestNG do
//		tags = "@smoke or @regression"
//		monochrome = false,
		tags = "@DB",

		monochrome = true,

		plugin = {

//				"pretty", // prints the Gherkin steps in the console

				"html:target/cucumber-default-report.html", // create a basic HTML report in the target folder
				"json:target/cucumber.json"
		}

)

public class DBRunner {

}
