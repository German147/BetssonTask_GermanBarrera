package stepDefinitions.hooks;

import base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import java.net.MalformedURLException;

public class Hooks extends BaseTest {

    @Before
    public void setUp() throws MalformedURLException {
        initializeDriver();
    }
    @After
    public void tearDown(){
        quitDriver();
    }
}
