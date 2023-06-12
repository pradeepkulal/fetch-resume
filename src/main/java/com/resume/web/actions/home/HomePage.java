package com.naukri.web.actions.home;

import com.naukri.web.locators.home.HomeLocators;
import org.openqa.selenium.WebDriver;

import static com.naukri.lib.support.TestData.getRandomNumberLessThanGivenNumber;

public class HomePage {

    HomeLocators homeLocators;

    public HomePage(WebDriver driver){
        homeLocators = new HomeLocators(driver);
    }

    public void hoverOnResdex(){
        homeLocators.hoverOnResdex();
    }

    public void clickOnSearchResumes(){
        homeLocators.clickOnSearchResumes();
    }

    public void clickOnSelectUsername(){
        homeLocators.clickOnSelectUsername();
    }

    public void clickOnUsernameOptions(){
        int number = homeLocators.getUsernameListSize();
        homeLocators.clickOnUsernameByIndex(number-1);
        homeLocators.clickOnBodyHeader();
    }

    public void clickOnUsernameOptions(String email){
        int number = homeLocators.getUsernameListSize();
        homeLocators.clickOnUsernameByIndex(0);
        homeLocators.clickOnBodyHeader();
    }

    public void clickOnLogin(){
        homeLocators.clickOnLogin();
    }

    public void resetAndLogin(){
        homeLocators.clickOnResetSubUser();
        homeLocators.clickOnResetLogin();
    }
}
