package com.naukri.web.locators.search;

import com.naukri.lib.base.CommonUiBase;
import com.naukri.lib.base.DriverManager;
import com.naukri.lib.base.GlobalConstant;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchLocators extends CommonUiBase {

    private WebDriver driver;
    public SearchLocators(WebDriver driver){
        System.out.println(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@name='boolKeywords']")
    private WebElement searchBool;

    @FindBy(xpath = "//input[@name='ezKeywordsAny']")
    private WebElement simpleSearch;

    @FindBy(xpath = "//div[contains(@class,'keywords')]//span[@class='ts-slider']")
    private WebElement slideBoolean;

    @FindBy(xpath = "//button[text()='Search Candidates']")
    private WebElement searchCandidates;

    @FindBy(xpath = "//input[@name='minExp']")
    private WebElement minExperience;

    @FindBy(xpath = "//input[@name='maxExp']")
    private WebElement maxExperience;

    @FindBy(xpath = "//input[@name='locations']")
    private WebElement locations;

    @FindBy(xpath = "//input[@name='minCtc']")
    private WebElement minimumSalary;

    @FindBy(xpath = "//input[@name='maxCtc']")
    private WebElement maximumSalary;

    @FindBy(xpath = "//button[@name='add-exclude-keywords']")
    private WebElement addExcludeKeywords;

    @FindBy(xpath = "//input[@name='ezKeywordsExclude']")
    private WebElement inputExcludeKeywords;

    @FindBy(xpath = "//a[contains(@aria-label,'keywords as mandatory')]//i")
    private WebElement markAllKeywordsMandatory;

    @FindBy(xpath = "//a[contains(@aria-label,'prefer to relocate')]//i")
    private WebElement preferToRelocateCheckbox;

    @FindBy(xpath = "//input[contains(@id,'active-in')]")
    private WebElement activeIn;

    @FindBy(xpath = "//div[@class='employment-details']")
    private WebElement employmentDetails;

    @FindBy(xpath = "//div[contains(@class,'notice-period')]//div[@tabindex]")
    private List<WebElement> noticePeriodList;

    @FindBy(xpath = "//div[contains(@class,'active-in')]//li")
    private List<WebElement> activeInValueList;

    @FindBy(xpath = "//div[@class='diversity-details']")
    private WebElement diversityDetails;

    @FindBy(xpath = "//input[@name='minAge']")
    private WebElement minimumAge;

    @FindBy(xpath = "//input[@name='maxAge']")
    private WebElement maximumAge;

    @FindBy(xpath = "//div[@class='education-details']")
    private WebElement educationDetails;

    @FindBy(xpath = "//body")
    private WebElement bodyHeader;

    @FindBy(xpath = "//*[@title='Attached resume']//parent::div")
    private WebElement attachedResumes;

    @FindBy(xpath = "//input[@name='designation']")
    private WebElement designation;

    public void enterSimpleSearch(String value){
        awaitForElementPresence(driver, simpleSearch, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        simpleSearch.sendKeys(value);
        simpleSearch.sendKeys(Keys.ENTER);
    }

    public void clickOnBoolean(){
        awaitForElementPresence(driver, slideBoolean, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        slideBoolean.click();
    }

    public void enterSearchBool(String value){
        awaitForElementPresence(driver, searchBool, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        searchBool.sendKeys(value);
    }

    public void clickOnMarkMandatorySkills(){
        awaitForElementToBeClickable(driver, markAllKeywordsMandatory, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        markAllKeywordsMandatory.click();
    }

    public void clickOnAddExcludeKeywords(){
        awaitForElementToBeClickable(driver, addExcludeKeywords, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        addExcludeKeywords.click();
    }

    public void enterExcludeKeywords(String value){
        awaitForElementPresence(driver, inputExcludeKeywords, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        inputExcludeKeywords.sendKeys(value);
        inputExcludeKeywords.sendKeys(Keys.ENTER);
    }

    public void enterMinExperience(String value){
        awaitForElementPresence(driver, minExperience, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        minExperience.sendKeys(value);
    }

    public void enterMaxExperience(String value){
        awaitForElementPresence(driver, maxExperience, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        maxExperience.sendKeys(value);
    }

    public void enterLocations(String value){
        awaitForElementPresence(driver, locations, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        locations.sendKeys(value);
        locations.sendKeys(Keys.ENTER);
    }

    public void pressEscapeKeyAfterLocations(){
        awaitForElementPresence(driver, locations, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        locations.sendKeys(Keys.ESCAPE);
    }

    public void clickOnIncludeCandidatesCheckbox(){
        awaitForElementToBeClickable(driver, preferToRelocateCheckbox, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        preferToRelocateCheckbox.click();
    }

    public void enterMinSalary(String value){
        awaitForElementPresence(driver, minimumSalary, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        minimumSalary.sendKeys(value);
    }

    public void enterMaxSalary(String value){
        awaitForElementPresence(driver, maximumSalary, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        maximumSalary.sendKeys(value);
    }

    public void clickOnEmploymentDetails(){
        awaitForElementToBeClickable(driver, employmentDetails, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        employmentDetails.click();
    }

    public void clickOnNoticeServicePeriod(int index){
        awaitForWebElementListLoad(noticePeriodList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        noticePeriodList.get(index).click();
    }

    public void clickOnDiversityDetails(){
        awaitForElementToBeClickable(driver, diversityDetails, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        diversityDetails.click();
    }

    public void enterMinimumAge(String value){
        awaitForElementPresence(driver, minimumAge, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        minimumAge.sendKeys(value);
    }

    public void enterMaximumAge(String value){
        awaitForElementPresence(driver, maximumAge, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        maximumAge.sendKeys(value);
    }

    public void clickOnInputActiveIn(){
        awaitForElementToBeClickable(driver, activeIn, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        activeIn.click();
    }

    public void clickOnActiveInValue(int index){
        awaitForWebElementListLoad(activeInValueList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        WebElement element = activeInValueList.get(index);
        scrollToWebElement(driver, element);
        element.click();
    }

    public void clickOnSearchCandidates(){
        awaitForElementToBeClickable(driver, searchCandidates, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        searchCandidates.click();
    }

    public void clickOnBodyHeader(){
        awaitForElementPresence(driver, bodyHeader, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        bodyHeader.click();
    }

    public void clickOnAttachedResumes(){
        awaitForElementPresence(driver, attachedResumes, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        attachedResumes.click();
    }

    public void enterDesignation(String value){
        awaitForElementPresence(driver, designation, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        designation.sendKeys(value);
        designation.sendKeys(Keys.ENTER);
    }
}
