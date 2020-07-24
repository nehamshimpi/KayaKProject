package com.kayak.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="KayakFeatureFiles", 
		glue={"com.kayak.stepDefination"},
		plugin = {"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html"}
		)

public class runner {
	@AfterClass
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/main/resources/extent-config.xml");
    }
	
}
