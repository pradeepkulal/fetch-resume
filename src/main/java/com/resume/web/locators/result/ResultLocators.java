package com.resume.web.locators.result;

import com.resume.lib.base.CommonUiBase;
import com.resume.lib.base.GlobalConstant;
import com.resume.lib.utils.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ResultLocators extends CommonUiBase {

    public WebDriver driver;
    public ResultLocators(WebDriver driver){
        System.out.println(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h1[contains(@class,'top-band')]")
    private WebElement totalProfilesCount;

    @FindBy(xpath = "//span[@class='page-value']")
    private WebElement pageValue;

    @FindBy(xpath = "//div[contains(@class,'candidate-headline')]//a//span")
    private List<WebElement> candidatesNameList;

    @FindBy(xpath = "//button[@data-testid='next-page']")
    private WebElement nextPageButton;

    @FindBy(xpath = "//span[@class='key-skills']")
    private List<WebElement> candidatesDetailsList;

    @FindBy(xpath = "//a[@title and contains(@class,'candidate-name')]")
    private List<WebElement> candidatesUrlsList;

    @FindBy(xpath = "//input[contains(@name,'resume-per-page')]")
    private WebElement resumePerPage;

    @FindBy(xpath = "//div[contains(@id,'resume-per-page')]//li" )
    private List<WebElement> paginationList;

    @FindBy(xpath = "//div[@class='tuple on']")
    private List<WebElement> tupleList;

    @FindBy(xpath = "//p[contains(@title,'Profile viewed by')]//ancestor::div[@class='tuple on']")
    private List<WebElement> profileViewedTuplelist;

    @FindBy(xpath = "//div[@class='tuple on']//div[contains(@class,'pref-loc')]//span[@title]")
    private List<WebElement> preferredLocationsList;

    @FindBy(xpath = "//div[@class='tuple on']//div[@class='education']")
    private List<WebElement> educationList;

    public String getTotalProfilesCount(){
        awaitForElementPresence(driver, totalProfilesCount, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        return totalProfilesCount.getText();
    }

    public String getPageValueText(){
        awaitForElementPresence(driver, pageValue, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        return pageValue.getText();
    }

    public List<String> getCandidatesName(){
        awaitForWebElementListLoad(candidatesNameList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        return getListElementText(candidatesNameList);
    }

    public void clickOnNextPageButton(){
        awaitForElementToBeClickable(driver, nextPageButton, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        nextPageButton.click();
    }

    public List<String> getCandidatesDetailsList(){
        awaitForWebElementListLoad(candidatesDetailsList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        return getListElementText(candidatesDetailsList);
    }

    public List<String> getCandidatesUrlsList(){
        awaitForWebElementListLoad(candidatesUrlsList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        return getListElementAttributeValue(candidatesUrlsList , "href");
    }

    public void clickOnNumberOfPages(){
        awaitForElementToBeClickable(driver, resumePerPage, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        resumePerPage.click();
    }

    public void clickOnLastPaginationValue(){
        awaitForWebElementListLoad(paginationList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        WebElement element = paginationList.get(paginationList.size()-1);
        scrollToWebElement(driver, element);
        awaitForElementToBeClickable(driver, element, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        element.click();
    }

    public int getTupleDataListCount(){
        awaitForWebElementListLoad(tupleList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        return tupleList.size();
    }

    public void waitForEducationsList(){
        awaitForWebElementListLoad(educationList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
    }

    public void waitForPreferredLocationsList(){
        awaitForWebElementListLoad(preferredLocationsList, GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
    }

    public String getName(int index){
        String path = "//div[@class='tuple on'][" + index + "]//div[contains(@class,'candidate-headline')]//a" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementText(elementList);
        Log.info(dataList);
        return dataList.get(0);
    }

    public String getExperience(int index){
        String path = "//div[@class='tuple on'][" + index + "]//*[@title='Experience']//parent::div//span[@title]" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementText(elementList);
        Log.info(dataList);
        return dataList.get(0);
    }

    public String getAnnualSalary(int index){
        String path = "//div[@class='tuple on'][" + index + "]//*[@title='Annual salary']//parent::div//span[@title]" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementText(elementList);
        Log.info(dataList);
        return dataList.get(0);
    }

    public String getCurrentLocation(int index){
        String path = "//div[@class='tuple on'][" + index + "]//span[@class='location']" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementText(elementList);
        Log.info(dataList);
        return dataList.get(0);
    }

    public List<String> getPreviousPosition(int index){
        String path = "//div[@class='tuple on'][" + index + "]//label[text()='Previous']//parent::div//button[1]" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementText(elementList);
        Log.info(dataList);
        return dataList;
    }

    public List<String> getPreviousCompany(int index){
        String path = "//div[@class='tuple on'][" + index + "]//label[text()='Previous']//parent::div//button[2]" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementText(elementList);
        Log.info(dataList);
        return dataList;
    }

    public List<String> getCurrentPosition(int index){
        String path = "//div[@class='tuple on'][" + index + "]//label[text()='Current']//parent::div//button[1]" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementText(elementList);
        Log.info(dataList);
        return dataList;
    }

    public List<String> getCurrentCompany(int index){
        String path = "//div[@class='tuple on'][" + index + "]//label[text()='Current']//parent::div//button[2]" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementText(elementList);
        Log.info(dataList);
        return dataList;
    }

    public List<String> getEducation(int index){
        String path = "//div[@class='tuple on'][" + index + "]//div[@class='education']" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementText(elementList);
        Log.info(dataList);
        return dataList;
    }

    public List<String> getPreferredLocations(int index){
        String path = "//div[@class='tuple on'][" + index + "]//div[contains(@class,'pref-loc')]//span[@title]" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementAttributeValue(elementList , "title");
        Log.info(dataList);
        return dataList;
    }

    public String getKeySkills(int index){
        String path = "//div[@class='tuple on'][" + index + "]//span[@class='key-skills']" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        return elementList.get(0).getText();
    }

    public void clickOnNameByIndex(int index){
        String path = "//div[@class='tuple on'][" + index + "]//div[contains(@class,'candidate-headline')]//a" ;
        WebElement wb = awaitElementAppearByXpath(driver, path , GlobalConstant.MAX_TIMEOUT_IN_SECONDS);
        wb.click();
    }

    public List<String> getLink(int index){
        String path = "//div[@class='tuple on'][" + index + "]//div[contains(@class,'candidate-headline')]//a" ;
        List<WebElement> elementList = driver.findElements(By.xpath(path));
        List<String> dataList = getListElementAttributeValue(elementList , "href");
        Log.info(dataList);
        return dataList;
    }

    public void refreshPage(){
        driver.navigate().refresh();
    }

    public void navigateToUrl(String url){
        driver.navigate().to(url);
    }
}
