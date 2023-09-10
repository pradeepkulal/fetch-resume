package com.resume.web.flows.profile;

import com.resume.dataSet.DataEntry;
import com.resume.web.actions.profile.ProfilePage;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.util.LinkedHashMap;

import static com.resume.lib.support.TestData.getLatestDownloadedFile;
import static com.resume.lib.support.TestData.openPDF;

public class ProfileFlow {

    ProfilePage profilePage;

    public ProfileFlow(WebDriver driver){
        profilePage = new ProfilePage(driver);
    }

    public String getEmail(){
        return profilePage.getEmail();
    }

    public void profileGet(){
        profilePage.download();
    }

    public void profileGet101(){
        profilePage.switchToTab(1);
        if(profilePage.checkAddComment()){
            profilePage.addComment();
            profilePage.download();
        }else{
            profilePage.goTo();
        }
    }

    public void profileGet102(){
        if(profilePage.checkAddComment()){
            profilePage.addComment();
            profilePage.download1();
        }else{
            System.out.println("Showing error on page");
        }
    }
}
