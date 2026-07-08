package com.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.automation.stepDefs",
		plugin = {
        "pretty",
        "html:target/cucumber-reports/report.html",
        "json:target/cucumber-reports/report.json"
},
		monochrome = true,
		tags="not @pdf"
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
