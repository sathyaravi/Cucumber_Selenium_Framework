package com.automation.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
		features = "src/test/resources/features",
		glue = "com.automation.stepDefs",
		plugin = {
        "pretty",
        "html:target/cucumber-reports/report.html",
        "json:target/cucumber-reports/report.json",
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
},
		monochrome = true,
		tags="not @pdf",
		publish=true
		)

public class TestRunner extends AbstractTestNGCucumberTests{

}
