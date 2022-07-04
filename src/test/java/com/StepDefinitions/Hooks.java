package com.StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.Utilities.*;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @After
    public void tearDown(Scenario scenario){
        if (scenario.isFailed()){
            // The screenshot will be attached in to my report
            byte [] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }
}
