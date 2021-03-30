package com.amazon.automation.runners;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
        features="classpath:features",
        glue="com.amazon.automation.steps",
        tags="@t", 
        plugin = {
        	"pretty", 
            "html:target/html/htmlreport.html",
            "json:target/json/file.json",
            },
        publish=true,
        dryRun=false 
        )
public class TestRunner {
   
}
