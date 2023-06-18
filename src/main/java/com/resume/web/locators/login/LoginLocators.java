package com.resume.web.locators.login;

import com.resume.lib.base.CommonUiBase;
import com.resume.lib.base.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLocators extends CommonUiBase {

    private WebDriver driver;

    public LoginLocators(WebDriver driver){
        System.out.println(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id='loginRegTab']")
    private WebElement loginRegTab;

    @FindBy(xpath = "//input[@id='loginEmail']")
    private WebElement inputEmail;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@id='loginBtn']")
    private WebElement loginButton;

    public void clickOnLoginRegisterTab(){
        awaitForElementToBeClickable(driver, loginRegTab, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        loginRegTab.click();
    }

    public void enterEmail(String value){
        awaitForElementPresence(driver, inputEmail, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        inputEmail.sendKeys(value);
    }

    public void enterPassword(String value){
        awaitForElementPresence(driver, inputPassword, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        inputPassword.sendKeys(value);
    }

    public void clickOnLoginButton(){
        awaitForElementToBeClickable(driver, loginButton, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        loginButton.click();
    }


}
