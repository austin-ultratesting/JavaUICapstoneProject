package com.ultranauts.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        plugin = {"pretty",
                "html:target/cucumber-reports-regular/cucumber.html",
                "json:target/cucumber-json/cucumber.json"
        },
        features = {"src/test/resources/features"},
        glue = {"com.ultranauts.cucumber"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}