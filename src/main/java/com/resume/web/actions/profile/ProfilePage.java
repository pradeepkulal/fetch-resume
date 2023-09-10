package com.resume.web.actions.profile;

import com.resume.web.locators.profile.ProfileLocators;
import org.openqa.selenium.WebDriver;

import java.util.Date;

import static com.resume.lib.support.TestData.getCurrentDate;
import static com.resume.lib.support.TestData.getRandomNumberBetweenTwoNumbers;

public class ProfilePage {

    ProfileLocators profileLocators;

    public ProfilePage(WebDriver driver){
        profileLocators = new ProfileLocators(driver);
    }

    public String getEmail(){
        profileLocators.switchToTab(1);
        return profileLocators.getEmail();
    }

    public void addComment(){
        profileLocators.clickOnAddCommentButton();
        profileLocators.waitForSeconds(2);
        profileLocators.enterCommentText("Downloaded on " + getCurrentDate());
        profileLocators.waitForSeconds(2);
        profileLocators.clickOnPostButton();
    }

    public void download(){
        try {
            profileLocators.clickOnAttachedCsvButton();
            profileLocators.clickOnDownloadCsvButton();
            profileLocators.waitForSeconds(3);
        }catch (Exception e){
            System.out.println("Not able to download");
            e.printStackTrace();
        }
        profileLocators.closeTab();
        profileLocators.switchToTab(0);
    }

    public void switchToTab(int index){
        profileLocators.switchToTab(index);
    }

    public boolean checkAddComment(){
        return  profileLocators.checkAddCommentButton();
    }

    public void goTo(){
        profileLocators.closeTab();
        profileLocators.switchToTab(0);
    }

    public void download1(){
        try {
            profileLocators.clickOnAttachedCsvButton();
            profileLocators.clickOnDownloadCsvButton();
            profileLocators.waitForSeconds(3);
        }catch (Exception e){
            System.out.println("Not able to download");
            e.printStackTrace();
        }
    }

}
