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
}
