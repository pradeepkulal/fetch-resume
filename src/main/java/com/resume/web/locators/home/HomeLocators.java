package com.resume.web.locators.home;

import com.resume.lib.base.CommonUiBase;
import com.resume.lib.base.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomeLocators extends CommonUiBase {

    private WebDriver driver;

    public HomeLocators(WebDriver driver){
        System.out.println(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[text()='Resdex']")
    private WebElement resdex;

    @FindBy(xpath = "//a[text()='Search Resumes']")
    private WebElement searchResumes;

    @FindBy(xpath = "//select[@id='userNameId']")
    private WebElement selectUsername;

    @FindBy(xpath = "//select[@id='userNameId']//option[@title]")
    private List<WebElement> userNameList;

    @FindBy(xpath = "//body")
    private WebElement bodyHeader;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement login;

    @FindBy(xpath = "//span[contains(text(),'Reset')]//parent::a")
    private WebElement resetTab;

    @FindBy(xpath = "//input[@id='resetLoginRadioBtn']")
    private WebElement resetAndLogin;

    public void hoverOnResdex(){
        moveCursorToWebElement(driver, resdex , GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
    }

    public void clickOnSearchResumes(){
        awaitForElementToBeClickable(driver, searchResumes, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        searchResumes.click();
    }

    public void clickOnSelectUsername(){
        awaitForElementToBeClickable(driver, selectUsername, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        selectUsername.click();
    }

    public int getUsernameListSize(){
        awaitForWebElementListLoad(userNameList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        return userNameList.size();
    }

    public void clickOnUsernameByIndex(int index){
        awaitForWebElementListLoad(userNameList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        userNameList.get(index).click();
    }

    public void clickOnBodyHeader(){
        awaitForElementPresence(driver, bodyHeader, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        bodyHeader.click();
    }

    public void clickOnLogin(){
        awaitForElementToBeClickable(driver, login, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        login.click();
    }

    public void clickOnResetSubUser(){
        awaitForElementToBeClickable(driver, resetTab, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        resetTab.click();
    }

    public void clickOnResetLogin(){
        awaitForElementToBeClickable(driver, resetAndLogin, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        resetAndLogin.click();
    }
}
