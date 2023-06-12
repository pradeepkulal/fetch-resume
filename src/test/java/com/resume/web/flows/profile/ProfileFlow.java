package com.resume.web.flows.profile;

import com.naukri.web.actions.profile.ProfilePage;
import org.openqa.selenium.WebDriver;

public class ProfileFlow {

    ProfilePage profilePage;

    public ProfileFlow(WebDriver driver){
        profilePage = new ProfilePage(driver);
    }

    public void profileGet(){
//        profilePage.download();
    }
}
