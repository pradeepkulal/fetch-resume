package com.resume.web.actions.login;

import com.resume.web.locators.login.LoginLocators;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    LoginLocators loginLocators;

    public LoginPage(WebDriver driver){
        loginLocators = new LoginLocators(driver);
    }

    public void openLoginRegisterTab(){
        loginLocators.clickOnLoginRegisterTab();
    }

    public void enterDetails(String email , String password){
        loginLocators.enterEmail(email);
        loginLocators.enterPassword(password);
        loginLocators.clickOnLoginButton();
    }
}
