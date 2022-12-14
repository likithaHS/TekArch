package com.test.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(plugin = { "pretty", "html:target/cucumber-reports/cucumber.html",
"json:target/cucumber-reports/cucumber.json" },
features= {"src/test/resources/CrudAPIRest.feature"},
glue={"com.tests"},
dryRun = true,
tags = "@GetData"
)

public class Runner extends AbstractTestNGCucumberTests{

}
