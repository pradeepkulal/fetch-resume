package com.naukri.web.flows.login;

import com.naukri.web.actions.login.LoginPage;
import org.openqa.selenium.WebDriver;

public class LoginFlow {

    LoginPage loginPage;

    public LoginFlow(WebDriver driver){
        loginPage = new LoginPage(driver);
    }

    public void login(String email , String password){
        loginPage.openLoginRegisterTab();
//        loginPage.enterDetails("swetha@intuitiveapps.com","May@2023");
        loginPage.enterDetails(email,password);
    }
}
