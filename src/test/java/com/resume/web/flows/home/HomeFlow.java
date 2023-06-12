package com.resume.web.flows.home;

import com.naukri.web.actions.home.HomePage;
import org.openqa.selenium.WebDriver;

public class HomeFlow {

    HomePage homePage;

    public HomeFlow(WebDriver driver){
        homePage = new HomePage(driver);
    }

    public void gotoSearchResumes(){
        homePage.hoverOnResdex();
        homePage.clickOnSearchResumes();
    }

    public void selectUsernameAndLogin(){
        homePage.clickOnSelectUsername();
        homePage.clickOnUsernameOptions();
        homePage.clickOnLogin();
    }

    public void resetAndLoginUser(){
        homePage.resetAndLogin();
    }

}
