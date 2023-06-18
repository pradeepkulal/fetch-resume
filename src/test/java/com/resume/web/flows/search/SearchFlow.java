package com.resume.web.flows.search;

import com.resume.dataSet.DataEntry;
import com.resume.web.actions.result.ResultPage;
import com.resume.web.actions.seacrh.SearchPage;
import com.resume.web.flows.profile.ProfileFlow;
import com.resume.web.flows.result.ResultFlow;
import org.openqa.selenium.WebDriver;


import javax.xml.crypto.Data;
import java.io.File;
import java.util.Map;

import static com.resume.lib.support.TestData.*;
import static com.resume.queryForm.QueryForm.*;
import static com.resume.web.actions.result.ResultPage.sortedData;

public class SearchFlow {

    SearchPage searchPage;
    ResultFlow resultFlow;
    ProfileFlow profileFlow;

    public SearchFlow(WebDriver driver){
        searchPage = new SearchPage(driver);
        resultFlow = new ResultFlow(driver);
        profileFlow = new ProfileFlow(driver);
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

    public void searchCandidates2(){
        int z = 0;
        for (Map.Entry<Integer, DataEntry> entry : sortedData.entrySet()) {
            int key = entry.getKey();
            DataEntry dataEntry = entry.getValue();
            String annualSalaryNumber = getExactAnnualSalaryNumber(dataEntry.getAnnualSalary());
            System.out.println(annualSalaryNumber);
            if(annualSalaryNumber.equals("0")){
                continue;
            }else if(z<1){
                ++z;
                String data = convertStringToYears(dataEntry.getExperience());
                String data1 = String.valueOf(Integer.parseInt(data) - 2);
                searchPage.enterExperienceRange(data1, data);
                searchPage.enterLocations(dataEntry.getCurrentLocation());
                String annualSalaryNumber1 = String.valueOf(Float.parseFloat(annualSalaryNumber) - 2);
                searchPage.enterSalaryRange(annualSalaryNumber1, annualSalaryNumber);
                searchPage.openEmploymentDetails();
                searchPage.enterCurrentDesignation(dataEntry.getCurrentPosition());
                searchPage.enterActiveIn("1 year");
                searchPage.clickOnSearchCandidates();
                resultFlow.get5(dataEntry.getName());
                dataEntry.setEmail(profileFlow.getEmail());
                profileFlow.profileGet();
                File downloadedFile = getLatestDownloadedFile("/Users/intuitiveapps/Downloads");
                String downloadedFileName = downloadedFile.getName();
                System.out.println("Downloaded file name: " + downloadedFileName);
                dataEntry.setResumeFile(downloadedFile);
                System.out.println("Name: " + dataEntry.getName());
                System.out.println("Experience: " + dataEntry.getExperience());
                System.out.println("Annual Salary: " + dataEntry.getAnnualSalary());
                System.out.println("Current Location: " + dataEntry.getCurrentLocation());
                System.out.println("Previous Position: " + dataEntry.getPreviousPosition());
                System.out.println("Previous Company: " + dataEntry.getPreviousCompany());
                System.out.println("Current Position: " + dataEntry.getCurrentPosition());
                System.out.println("Current Company: " + dataEntry.getCurrentCompany());
                System.out.println("Education: " + dataEntry.getEducation());
                System.out.println("Preferred Locations: " + dataEntry.getPreferredLocations());
                System.out.println("KeySkills: " + dataEntry.getKeySkills());
                System.out.println("Ranking: "+dataEntry.getRanking());
                System.out.println("Email: "+dataEntry.getEmail());
                System.out.println("FilePath: "+dataEntry.getResumeFile());
                System.out.println();
                System.out.println("*******************************************************************");
                System.out.println("*******************************************************************");
                System.out.println();

                if (dataEntry != null) {
                    File file = dataEntry.getResumeFile();
                    openPDF(file);
                }
            }
        }

//        Map.Entry<Integer, DataEntry> firstEntry = sortedData.entrySet().iterator().next();
//        DataEntry dataEntry = firstEntry.getValue();
//        searchPage.enterMaximumExperience(convertStringToYears(dataEntry.getExperience()));
//        searchPage.enterLocations(dataEntry.getCurrentLocation());
//        searchPage.enterMaximumSalary(getExactAnnualSalaryNumber(dataEntry.getAnnualSalary()));
//        searchPage.openEmploymentDetails();
//        searchPage.enterCurrentDesignation(dataEntry.getCurrentPosition());
//        searchPage.clickOnSearchCandidates();
//        resultFlow.get5(dataEntry.getName());
//        profileFlow.profileGet();
//        File downloadedFile = getLatestDownloadedFile("/Users/intuitiveapps/Downloads");
//        String downloadedFileName = downloadedFile.getName();
//        System.out.println("Downloaded file name: " + downloadedFileName);
//        dataEntry.setResumeFile(downloadedFile);
//        System.out.println("Name: " + dataEntry.getName());
//        System.out.println("Experience: " + dataEntry.getExperience());
//        System.out.println("Annual Salary: " + dataEntry.getAnnualSalary());
//        System.out.println("Current Location: " + dataEntry.getCurrentLocation());
//        System.out.println("Previous Position: " + dataEntry.getPreviousPosition());
//        System.out.println("Previous Company: " + dataEntry.getPreviousCompany());
//        System.out.println("Current Position: " + dataEntry.getCurrentPosition());
//        System.out.println("Current Company: " + dataEntry.getCurrentCompany());
//        System.out.println("Education: " + dataEntry.getEducation());
//        System.out.println("Preferred Locations: " + dataEntry.getPreferredLocations());
//        System.out.println("KeySkills: " + dataEntry.getKeySkills());
//        System.out.println("Ranking: "+dataEntry.getRanking());
//        System.out.println("Email: "+dataEntry.getEmail());
//        System.out.println("Ranking: "+dataEntry.getResumeFile());
//        System.out.println();
//        System.out.println("*******************************************************************");
//        System.out.println("*******************************************************************");
//        System.out.println();
//
//        if (dataEntry != null) {
//            File file = dataEntry.getResumeFile();
//            openPDF(file);
//        }
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
