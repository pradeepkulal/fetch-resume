package com.resume.web.flows.search;

import com.naukri.web.actions.seacrh.SearchPage;
import org.openqa.selenium.WebDriver;


import static com.naukri.queryForm.QueryForm.*;

public class SearchFlow {

    SearchPage searchPage;

    public SearchFlow(WebDriver driver){
        searchPage = new SearchPage(driver);
    }

    public void searchQuery(){
        searchPage.useBooleanOn();
        searchPage.enterSearchBoolQuery(query);
        searchPage.enterExperienceRange(minExperience, maxExperience);
        searchPage.enterLocations(locations);
        searchPage.clickOnSearchCandidates();
    }

    public void checkWhichSearchQueryUsed(){

    }

    public void searchQuery1(){
        searchPage.enterSimpleSearchQuery("c++,git,python");
        searchPage.checkedOnMarkMandatorySkills();
        searchPage.enterExcludeKeywords("testing,support");
        searchPage.enterExperienceRange("3", "6");
        searchPage.enterLocations("Gurugram,Bangalore,Noida");
        searchPage.checkedOffIncludeCandidatesCheckbox();
        searchPage.enterSalaryRange("6","12");
        searchPage.enterNoticePeriod("3 months,2 months");
        searchPage.openDiversityDetails();
//        searchPage.enterCandidatesAge("20","30");
        searchPage.selectAttachedResumes();
        searchPage.enterActiveIn("3 months");
        searchPage.clickOnSearchCandidates();
    }

    public void searchQuery2(){
        searchPage.enterSimpleSearchQuery("c++,git");
        searchPage.checkedOnMarkMandatorySkills();
        searchPage.enterExcludeKeywords("testing,support");
        searchPage.enterExperienceRange("3", "6");
        searchPage.enterLocations("Gurugram,Bangalore");
        searchPage.checkedOffIncludeCandidatesCheckbox();
        searchPage.enterSalaryRange("6","12");
        searchPage.enterNoticePeriod("3 months,2 months");
        searchPage.enterCandidatesAge("20","30");
        searchPage.enterActiveIn("");
        searchPage.clickOnSearchCandidates();
    }

    public void searchQuery3(){
        searchPage.enterSimpleSearchQuery("c++,git,python");
        searchPage.enterExperienceRange("3", "6");
        searchPage.enterLocations("Gurugram,Bangalore,Noida");
        searchPage.checkedOffIncludeCandidatesCheckbox();
        searchPage.enterNoticePeriod("3 months,2 months");
        searchPage.openDiversityDetails();
        searchPage.selectAttachedResumes();
        searchPage.enterActiveIn("1 year");
        searchPage.clickOnSearchCandidates();
    }

    public void searchCandidates(){
        searchPage.enterMaximumExperience("6");
        searchPage.enterLocations("Bangalore");
        searchPage.enterMaximumSalary("21");
        searchPage.openEmploymentDetails();
        searchPage.enterCurrentDesignation("Member Technical Staff 3");
        searchPage.clickOnSearchCandidates();
    }

    public void searchCandidates1(){
        searchPage.enterMaximumExperience("4");
        searchPage.enterLocations("Gurgaon");
        searchPage.enterMaximumSalary("15");
        searchPage.openEmploymentDetails();
        searchPage.enterCurrentDesignation("R&D Senior Software Engineer");
        searchPage.clickOnSearchCandidates();
    }
}
