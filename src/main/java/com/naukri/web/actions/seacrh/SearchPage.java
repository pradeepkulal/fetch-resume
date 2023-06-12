package com.naukri.web.actions.seacrh;

import com.naukri.web.locators.search.SearchLocators;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchPage {

    SearchLocators searchLocators;

    public SearchPage(WebDriver driver){
        searchLocators = new SearchLocators(driver);
    }

    public void enterSimpleSearchQuery(String query){
        if(!(query.isEmpty())) {
            List<String> queryList = Arrays.asList(query.split(","));
            for (String keyword : queryList) {
                searchLocators.enterSimpleSearch(keyword);
                searchLocators.waitForSeconds(1);
            }
            searchLocators.clickOnBodyHeader();
        }
    }

    public void useBooleanOn(){
        searchLocators.clickOnBoolean();
    }

    public void enterSearchBoolQuery(String value){
        searchLocators.enterSearchBool(value);
    }

    public void checkedOnMarkMandatorySkills(){
        searchLocators.clickOnMarkMandatorySkills();
    }

    public void enterExcludeKeywords(String keyWords){
        searchLocators.clickOnAddExcludeKeywords();
        List<String> queryList = Arrays.asList(keyWords.split(","));
        for (String keyword : queryList){
            searchLocators.enterExcludeKeywords(keyword);
            searchLocators.waitForSeconds(1);
        }
        searchLocators.clickOnBodyHeader();
    }

    public void enterExperienceRange(String minExperience , String maxExperience){
        searchLocators.enterMinExperience(minExperience);
        searchLocators.enterMaxExperience(maxExperience);
    }

    public void enterMinimumExperience(String minExperience){
        searchLocators.enterMinExperience(minExperience);
    }

    public void enterMaximumExperience(String maxExperience){
        searchLocators.enterMaxExperience(maxExperience);
    }

    public void enterLocations(String locations){
        List<String> locationsList = Arrays.asList(locations.split(","));
        for (String location : locationsList){
            searchLocators.enterLocations(location);
            searchLocators.waitForSeconds(1);
        }
        searchLocators.pressEscapeKeyAfterLocations();
    }

    public void checkedOffIncludeCandidatesCheckbox(){
        searchLocators.clickOnIncludeCandidatesCheckbox();
    }

    public void enterSalaryRange(String minSalary , String maxSalary){
        searchLocators.enterMinSalary(minSalary);
        searchLocators.enterMaxSalary(maxSalary);
    }

    public void enterMinimumSalary(String minSalary){
        searchLocators.enterMinSalary(minSalary);
    }

    public void enterMaximumSalary(String maxSalary){
        searchLocators.enterMaxSalary(maxSalary);
    }

    public void openEmploymentDetails(){
        searchLocators.clickOnEmploymentDetails();
        searchLocators.waitForSeconds(3);
    }

    public void enterCurrentDesignation(String value){
        searchLocators.enterDesignation(value);
    }

    public void enterNoticePeriod(String noticePeriod){
        if(!(noticePeriod.isEmpty())){
            List<String> noticePeriodList = Arrays.asList(noticePeriod.split(","));
            searchLocators.clickOnEmploymentDetails();
            searchLocators.waitForSeconds(3);
            for (String period : noticePeriodList) {
                searchLocators.clickOnNoticeServicePeriod(searchLocators.getEntityIndexForNoticePeriod(period));
                searchLocators.waitForSeconds(2);
            }
        }
    }

    public void openDiversityDetails(){
        searchLocators.clickOnDiversityDetails();
    }

    public void enterCandidatesAge(String minAge , String maxAge){
        searchLocators.enterMinimumAge(minAge);
        searchLocators.enterMaximumAge(maxAge);
    }

    public void enterActiveIn(String activeIn){
        if(!(activeIn.isEmpty())){
            searchLocators.clickOnInputActiveIn();
            searchLocators.clickOnActiveInValue(searchLocators.getEntityIndexForActiveIn(activeIn));
        }
    }

    public void selectAttachedResumes(){
        searchLocators.clickOnAttachedResumes();
    }


    public void clickOnSearchCandidates(){
        searchLocators.clickOnSearchCandidates();
    }
}
