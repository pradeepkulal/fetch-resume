package com.naukri.web.actions.login;

import com.naukri.web.locators.login.LoginLocators;
import org.openqa.selenium.WebDriver;

import static com.naukri.queryForm.QueryForm.email;
import static com.naukri.queryForm.QueryForm.password;

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
