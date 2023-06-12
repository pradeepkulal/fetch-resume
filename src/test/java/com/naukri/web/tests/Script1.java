package com.naukri.web.tests;

import com.naukri.lib.base.BaseConfig;
import com.naukri.lib.base.DriverManager;
import com.naukri.web.flows.home.HomeFlow;
import com.naukri.web.flows.login.LoginFlow;
import com.naukri.web.flows.profile.ProfileFlow;
import com.naukri.web.flows.result.ResultFlow;
import com.naukri.web.flows.search.SearchFlow;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Script1 {

    LoginFlow loginFlow;
    HomeFlow homeFlow;
    SearchFlow searchFlow;
    ResultFlow resultFlow;
    ProfileFlow profileFlow;


    @BeforeClass
    public void initBaseFlow(){
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.initialize_driver("--user-data-dir=/Users/intuitiveapps/Library/Application Support/Google/Chrome/Default");
        driver.get(BaseConfig.getBaseUrl());
        driver.manage().window().maximize();
        loginFlow = new LoginFlow(driver);
        homeFlow = new HomeFlow(driver);
        searchFlow = new SearchFlow(driver);
        resultFlow = new ResultFlow(driver);
        profileFlow = new ProfileFlow(driver);
    }


    @Test
    public void tc1(){
        loginFlow.login("","");
        homeFlow.gotoSearchResumes();
        homeFlow.selectUsernameAndLogin();
        searchFlow.searchQuery3();
        resultFlow.get4();
        try {
            Thread.sleep(100000000);
        }catch (Exception e){

        }
    }
}
