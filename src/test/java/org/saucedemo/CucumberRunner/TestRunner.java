package org.saucedemo.CucumberRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features ="src/test/resources/Features/OrderItem.feature", glue = "Com.Flipkart.Stepdefinition",
         plugin = {"html:target/cucumber.html", "json:target/cucumber-reports/cucumber.json"})
public class TestRunner extends AbstractTestNGCucumberTests {
    @Override
    @DataProvider(parallel = false)
    public Object[][] scenarios() {
        return super.scenarios();
    }

}
