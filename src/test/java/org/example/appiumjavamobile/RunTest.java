package org.example.appiumjavamobile;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"json:target/reports/cucumberTests.json", "html:target/reports/report.html"},
        features = "src/test/resources/features",
        tags = "@test",
        glue = {"steps"}
)
public class RunTest {
    @AfterClass
    public static void closeApp(){
        Hooks.quitDriver();
    }
}
