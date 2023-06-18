package com.resume.web.actions.profile;

import com.resume.web.locators.profile.ProfileLocators;
import org.openqa.selenium.WebDriver;

public class ProfilePage {

    ProfileLocators profileLocators;

    public ProfilePage(WebDriver driver){
        profileLocators = new ProfileLocators(driver);
    }

    public String getEmail(){
        profileLocators.switchToTab(1);
        return profileLocators.getEmail();
    }

    public void download(){
        profileLocators.clickOnAttachedCsvButton();
        profileLocators.clickOnDownloadCsvButton();
        profileLocators.switchToTab(0);
        profileLocators.waitForSeconds(10);
    }
}
