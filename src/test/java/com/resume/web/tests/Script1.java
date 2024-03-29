package com.resume.web.tests;

import com.resume.lib.base.BaseConfig;
import com.resume.lib.base.DriverManager;
import com.resume.web.flows.home.HomeFlow;
import com.resume.web.flows.login.LoginFlow;
import com.resume.web.flows.profile.ProfileFlow;
import com.resume.web.flows.result.ResultFlow;
import com.resume.web.flows.search.SearchFlow;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Script1 {

    WebDriver driver;

    LoginFlow loginFlow;
    HomeFlow homeFlow;
    SearchFlow searchFlow;
    ResultFlow resultFlow;
    ProfileFlow profileFlow;


    @BeforeClass
    public void initBaseFlow(){
        DriverManager driverManager = new DriverManager();
        driver = driverManager.initialize_driver("--user-data-dir=/Users/intuitiveapps/Library/Application Support/Google/Chrome/Default");
        driver.get(BaseConfig.getBaseUrl());
        driver.manage().window().maximize();
        loginFlow = new LoginFlow(driver);
        homeFlow = new HomeFlow(driver);
        searchFlow = new SearchFlow(driver);
        resultFlow = new ResultFlow(driver);
        profileFlow = new ProfileFlow(driver);
    }


    @Test
    public void tc1()throws Exception{
      //  loginFlow.login("swetha@intuitiveapps.com","Mar@2024");
        //Thread.sleep(10000);
        driver.get("https://resdex.naukri.com/v3");
        searchFlow.searchQuery101();
      //  Thread.sleep(60000);
        searchFlow.get0102();
        searchFlow.downloadResumesOf(4);
        try {
            Thread.sleep(100000000);
        }catch (Exception e){
            System.out.println("----------------------------");
        }
    }

    @AfterClass
    public void tearUp(){
        driver.quit();
    }
}
