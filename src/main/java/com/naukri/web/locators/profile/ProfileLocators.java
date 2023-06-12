package com.naukri.web.locators.profile;

import com.naukri.lib.base.CommonUiBase;
import com.naukri.lib.base.DriverManager;
import com.naukri.lib.base.GlobalConstant;
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
}
