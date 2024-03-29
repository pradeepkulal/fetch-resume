package com.resume.lib.base;

import com.resume.queryForm.QueryForm;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;

public class BaseSetup {

    public WebDriver driver;

    @BeforeSuite
    public void testSuiteStart(){

////        QueryForm.launchForm();
//        DriverManager driverManager = new DriverManager();
//
//        driver = driverManager.initialize_driver();
//        driver.get(BaseConfig.getBaseUrl());
//        driver.manage().window().setSize(new Dimension(1680,950));
//        driver.manage().window().maximize();

    }

}
