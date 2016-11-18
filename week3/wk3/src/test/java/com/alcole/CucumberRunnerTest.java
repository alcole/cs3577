package com.alcole;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@CucumberOptions(
        format = {"pretty", "html:target/cucumber"} , features="src/test/resources")
@RunWith(Cucumber.class)
public class CucumberRunnerTest {
}
