package com.resume.web.tests;

import com.resume.lib.base.BaseConfig;
import com.resume.lib.base.DriverManager;
import com.resume.web.flows.home.HomeFlow;
import com.resume.web.flows.login.LoginFlow;
import com.resume.web.flows.profile.ProfileFlow;
import com.resume.web.flows.result.ResultFlow;
import com.resume.web.flows.search.SearchFlow;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

public class Script2 {

    LoginFlow loginFlow;
    HomeFlow homeFlow;
    SearchFlow searchFlow;
    ResultFlow resultFlow;
    ProfileFlow profileFlow;
    WebDriver driver;

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
    public void tc2(){
        loginFlow.login("swetha@intuitiveapps.com","Mar@2024");
        homeFlow.gotoSearchResumes();
        resultFlow.get5("");
        profileFlow.profileGet();
        try {
            Thread.sleep(100000000);
        }catch (Exception e){
        }
    }
}
