package com.Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {
                "html:target/cucumber-report.html",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                "rerun:target/rerun.txt",
                "json:target/jira-report.json"
        },
        features = "src/test/resources/features",
        glue = "com/StepDefinitions",
        dryRun = false,
        tags = "@LogoutAutomated"
)

public class CukesRunner {
}
