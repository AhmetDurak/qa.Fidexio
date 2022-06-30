package com.Runner;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import com.Utilities.*;

import java.util.concurrent.TimeUnit;

public class Hooks {
    @Before
    public void setUp(){
        Driver.get().get(ConfigurationReader.get("url"));
        Driver.get().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(){
        //Driver.closeDriver();
    }
}
