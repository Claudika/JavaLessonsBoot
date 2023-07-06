package Cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


    @CucumberOptions(
            features = "src/test/resources/features",
            glue="cucumber",
            plugin = {"pretty","html:test-output/cucumber/cucumber-reports.html"}
    )
    public class TestRunner extends AbstractTestNGCucumberTests{

    }

