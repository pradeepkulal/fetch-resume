package com.resume.web.locators.profile;

import com.resume.lib.base.CommonUiBase;
import com.resume.lib.base.GlobalConstant;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfileLocators extends CommonUiBase {

    private WebDriver driver;

    public ProfileLocators(WebDriver driver){
        System.out.println(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'email') and @title]")
    private WebElement email;

    @FindBy(xpath = "//div[contains(@id,'videoAndCv')]")
    private WebElement attachedCv;

    @FindBy(xpath = "//*[contains(@class,'icon-download')]")
    private WebElement downloadCSv;

    @FindBy(xpath = "//button[contains(@class,'add-comm-btn')]")
    private WebElement addComment;

    @FindBy(xpath = "//div[contains(@class,'comments-editable')]")
    private WebElement comment;

    @FindBy(xpath = "//button[contains(@class,'comment-btn')]")
    private WebElement post;

    public String getEmail(){
        awaitForElementPresence(driver, email, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        return email.getText();
    }

    public void clickOnAttachedCsvButton(){
        awaitForElementToBeClickable(driver, attachedCv, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        attachedCv.click();
    }

    public void clickOnDownloadCsvButton(){
        awaitForElementToBeClickable(driver, downloadCSv, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        downloadCSv.click();
    }

    public void switchToTab(int index){
        switchToTab(driver, index);
    }

    public void closeTab(){
        closeCurrentTab(driver);
    }

    public void clickOnAddCommentButton(){
        awaitForElementToBeClickable(driver, addComment, 2 * GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        addComment.click();
    }

    public void enterCommentText(String value){
        awaitForElementPresence(driver, comment, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        comment.sendKeys(value);
    }

    public void clickOnPostButton(){
        awaitForElementToBeClickable(driver, post, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        post.click();
    }

    public boolean checkAddCommentButton(){
        return awaitForElementPresence(driver, addComment, 2 * GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
    }

}
