package com.naukri.web.tests;

import com.naukri.lib.base.BaseConfig;
import com.naukri.lib.base.DriverManager;
import com.naukri.web.flows.home.HomeFlow;
import com.naukri.web.flows.login.LoginFlow;
import com.naukri.web.flows.result.ResultFlow;
import com.naukri.web.flows.search.SearchFlow;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Script2 {

    LoginFlow loginFlow;
    HomeFlow homeFlow;
    SearchFlow searchFlow;
    ResultFlow resultFlow;

    @BeforeClass
    public void initBaseFlow(){
        DriverManager driverManager = new DriverManager();
        WebDriver driver = driverManager.initialize_driver("");
        driver.get(BaseConfig.getBaseUrl());
        driver.manage().window().maximize();
        loginFlow = new LoginFlow(driver);
        homeFlow = new HomeFlow(driver);
        searchFlow = new SearchFlow(driver);
        resultFlow = new ResultFlow(driver);
    }



    @Test
    public void tc2(){
        loginFlow.login("","");
        homeFlow.gotoSearchResumes();
        searchFlow.searchCandidates();
        resultFlow.get5("Megha Nagar");
        homeFlow.gotoSearchResumes();
        searchFlow.searchCandidates1();
        resultFlow.get5("Haneesh Bhardwaj");
        try {
            Thread.sleep(100000000);
        }catch (Exception e){
        }
    }
}
