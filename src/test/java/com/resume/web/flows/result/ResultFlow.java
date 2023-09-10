package com.resume.web.flows.result;

import com.resume.lib.utils.Log;
import com.resume.web.actions.result.ResultPage;
import com.resume.web.flows.profile.ProfileFlow;
import org.openqa.selenium.WebDriver;

public class ResultFlow {

    ResultPage resultPage;
    ProfileFlow profileFlow;

    public ResultFlow(WebDriver driver){
        resultPage = new ResultPage(driver);
        profileFlow = new ProfileFlow(driver);
    }

    public void getData(){
        resultPage.gotoLastPaginationValue();
        resultPage.refreshPage();
        resultPage.numberOfDataShown();
        resultPage.getNamesDetails();
        resultPage.getExperienceDetails();
        resultPage.getAnnualSalaryDetails();
        resultPage.getCurrentLocationDetails();
        resultPage.getPreviousPositionDetails();
        resultPage.getPreviousCompanyDetails();
        resultPage.getCurrentPositionDetails();
        resultPage.getCurrentCompanyDetails();
        resultPage.getEducationDetails();
        resultPage.getPreferredLocationsDetails();
        resultPage.getKeySkillsDetails();
        resultPage.setDetails();
        resultPage.getDetails();
        resultPage.assignRanking("git,c++,linux,oops,algorithms");
        resultPage.getDetailsAfterAssignRanking();
        resultPage.filterRecordsByLocation();
//        resultPage.get();
//        resultPage.get1();
//        resultPage.get2();
//        resultPage.get3();
    }

    public void compareData(){
        resultPage.get3("git,c++,linux,oops,algorithms");
    }

    public void get4(){
        resultPage.gotoLastPaginationValue();
        resultPage.refreshPage();
        resultPage.get1234();
        resultPage.setDetails();
//        resultPage.getDetails();
        resultPage.assignRanking("git,c++,linux,oops,algorithms");
        resultPage.sortByRanking();
        resultPage.getDetailsAfterAssignRanking();
//        resultPage.filterRecordsByLocation();
    }

    public void get5(String name){
        resultPage.gotoLastPaginationValue();
        resultPage.refreshPage();
        resultPage.verifyNameDetails(name);
    }

    public void get101(){
//        resultPage.gotoLastPaginationValue();
        resultPage.refreshPage();
        int size = resultPage.numberOfDataShownCount();
        for ( int k = 0 ; k < size ; k ++){
            Log.info("value of k : " + k);
            resultPage.clickOnNameByIndex(k);
            profileFlow.profileGet101();
        }
    }
}
