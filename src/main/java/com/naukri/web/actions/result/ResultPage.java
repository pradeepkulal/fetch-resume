package com.naukri.web.actions.result;

import com.naukri.dataSet.DataEntry;
import com.naukri.lib.utils.Log;
import com.naukri.web.locators.result.ResultLocators;
import com.opencsv.CSVWriter;
import org.openqa.selenium.WebDriver;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

import static com.naukri.lib.support.TestData.convertListToCSVString;

public class ResultPage {

    ResultLocators resultLocators;
    List<String> candidatesNameList;
    List<String> keySkillsFinalize = new ArrayList<>();
    List<String> namesList = new ArrayList<>();
    List<String> experienceList = new ArrayList<>();
    List<String> annualSalaryList = new ArrayList<>();
    List<String> currentLocationList = new ArrayList<>();
    List<String> previousPositionList = new ArrayList<>();
    List<String> previousCompanyList = new ArrayList<>();
    List<String> currentPositionList = new ArrayList<>();
    List<String> currentCompanyList = new ArrayList<>();
    List<String> educationList = new ArrayList<>();
    List<String> preferredLocationsList = new ArrayList<>();
    List<String> keySkillsList = new ArrayList<>();
    int sizeOfData;
    Map<Integer, DataEntry> dataMap = new LinkedHashMap<>();
    int totalSizeData;
    Map<Integer, DataEntry> sortedData = new LinkedHashMap<>();


    public ResultPage(WebDriver driver){
        resultLocators = new ResultLocators(driver);
    }

    public void get(){
        Log.info(resultLocators.getPageValueText());
        Log.info(resultLocators.getTotalProfilesCount());
    }

    public void get1(){
        for ( int k = 0 ; k < 1 ; k ++){
            resultLocators.waitForSeconds(5);
            candidatesNameList = resultLocators.getCandidatesName();
            keySkillsList = resultLocators.getCandidatesDetailsList();
//            resultLocators.clickOnNextPageButton();
        }
    }

    public void get2(){
        for ( int k = 0 ; k < keySkillsList.size() ; k ++){
            String data = keySkillsList.get(k);
            data = data.replaceAll("[\\n ]", "").replace("|", ",");
            Log.info((k+1) + " . " + candidatesNameList.get(k) + " : " + data);
            keySkillsFinalize.add(data);
        }
    }

    public void get3(){
        List<String> candidatesUrlsList = resultLocators.getCandidatesUrlsList();
        for(String candidateUrl : candidatesUrlsList){
            Log.info(candidateUrl);
        }
    }

    public void gotoLastPaginationValue(){
        resultLocators.clickOnNumberOfPages();
        resultLocators.waitForSeconds(2);
        resultLocators.clickOnLastPaginationValue();
        resultLocators.waitForSeconds(5);
    }

    public void refreshPage(){
        resultLocators.refreshPage();
        resultLocators.waitForSeconds(3);
    }

    public void numberOfDataShown(){
        sizeOfData = resultLocators.getTupleDataListCount();
        totalSizeData += sizeOfData;
        Log.info("totalSizeData : " +totalSizeData);
    }

    public void getNamesDetails(){
        Log.info("Name : ");
        for ( int k = 1 ; k <= sizeOfData; k ++) {
            namesList.add(resultLocators.getName(k).trim());
        }
        Log.info("************************************");
    }

    public void getExperienceDetails(){
        Log.info("Experience Details : ");
        for ( int k = 1 ; k <= sizeOfData; k ++) {
            experienceList.add(resultLocators.getExperience(k));
        }
        Log.info("************************************");
    }

    public void getAnnualSalaryDetails(){
        Log.info("Annual Salary : ");
        for ( int k = 1 ; k <= sizeOfData; k ++) {
            annualSalaryList.add(resultLocators.getAnnualSalary(k));
        }
        Log.info("************************************");
    }

    public void getCurrentLocationDetails(){
        Log.info("Current Location : ");
        for ( int k = 1 ; k <= sizeOfData; k ++) {
            currentLocationList.add(resultLocators.getCurrentLocation(k).split("/")[0]);
        }
        Log.info("************************************");
    }
    public void getPreviousPositionDetails(){
        Log.info("Previous Position : ");
        for ( int k = 1 ; k <= sizeOfData ; k ++) {
            List<String> dataList = resultLocators.getPreviousPosition(k);
            if(dataList.isEmpty()){
                previousPositionList.add("");
            }else {
                previousPositionList.add(dataList.get(0));
            }
        }
        Log.info("************************************");
    }

    public void getPreviousCompanyDetails(){
        Log.info("Previous Company : ");
        for ( int k = 1 ; k <= sizeOfData ; k ++) {
            List<String> dataList = resultLocators.getPreviousCompany(k);
            if(dataList.isEmpty()){
                previousCompanyList.add("");
            }else {
                previousCompanyList.add(dataList.get(0));
            }
        }
        Log.info("************************************");
    }

    public void getCurrentPositionDetails(){
        Log.info("Current Position : ");
        for ( int k = 1 ; k <= sizeOfData; k ++) {
            List<String> dataList = resultLocators.getCurrentPosition(k);
            if(dataList.isEmpty()){
                currentPositionList.add("");
            }else {
                currentPositionList.add(dataList.get(0));
            }
        }
        Log.info("************************************");
    }

    public void getCurrentCompanyDetails(){
        Log.info("Current Company : ");
        for ( int k = 1 ; k <= sizeOfData; k ++) {
            List<String> dataList = resultLocators.getCurrentCompany(k);
            if(dataList.isEmpty()){
                currentCompanyList.add("");
            }else {
                currentCompanyList.add(dataList.get(0));
            }
        }
        Log.info("************************************");
    }

    public void getEducationDetails(){
        Log.info("Education : ");
        for ( int k = 1 ; k <= sizeOfData; k ++) {
            List<String> educationDetails = resultLocators.getEducation(k);
            String data = convertListToCSVString(educationDetails);
            educationList.add(data);
        }
        Log.info("************************************");
    }

    public void getPreferredLocationsDetails(){
        Log.info("Preferred Locations : ");
        for ( int k = 1 ; k <= sizeOfData; k ++) {
            List<String> dataList = resultLocators.getPreferredLocations(k);
            if(dataList.isEmpty()){
                preferredLocationsList.add("");
            }else {
                preferredLocationsList.add(dataList.get(0));
            }
        }
        Log.info("************************************");
    }

    public void getKeySkillsDetails(){
        Log.info("KeySkills : ");
        for ( int k = 1 ; k <= sizeOfData ; k ++){
            String data = resultLocators.getKeySkills(k);
            data = data.replaceAll("[\\n ]", "").replace("|", ",");
            Log.info(data);
            keySkillsList.add(data);
        }
        Log.info("************************************");
    }

    public void setDetails(){
        for ( int k = 1 ; k <= totalSizeData; k ++) {
            int value = k - 1;
            DataEntry entry = new DataEntry();
            entry.setName(namesList.get(value));
            entry.setExperience(experienceList.get(value));
            entry.setAnnualSalary(annualSalaryList.get(value));
            entry.setCurrentLocation(currentLocationList.get(value));
            entry.setPreviousPosition(previousPositionList.get(value));
            entry.setPreviousCompany(previousCompanyList.get(value));
            entry.setCurrentPosition(currentPositionList.get(value));
            entry.setCurrentCompany(currentCompanyList.get(value));
            entry.setEducation(educationList.get(value));
            entry.setPreferredLocations(preferredLocationsList.get(value));
            entry.setKeySkills(keySkillsList.get(value));
            entry.setRanking(0);

            dataMap.put(k , entry);
        }
    }

    public void getDetails(){
        for (Map.Entry<Integer, DataEntry> entry : dataMap.entrySet()) {
            int key = entry.getKey();
            DataEntry data = entry.getValue();

            System.out.println("Key: " + key);
            System.out.println("Name: " + data.getName());
            System.out.println("Experience: " + data.getExperience());
            System.out.println("Annual Salary: " + data.getAnnualSalary());
            System.out.println("Current Location: " + data.getCurrentLocation());
            System.out.println("Previous Position: " + data.getPreviousPosition());
            System.out.println("Previous Company: " + data.getPreviousCompany());
            System.out.println("Current Position: " + data.getCurrentPosition());
            System.out.println("Current Company: " + data.getCurrentCompany());
            System.out.println("Education: " + data.getEducation());
            System.out.println("Preferred Locations: " + data.getPreferredLocations());
            System.out.println("KeySkills: " + data.getKeySkills());
            System.out.println("Ranking: "+data.getRanking());
            System.out.println();
            System.out.println("*******************************************************************");
            System.out.println("*******************************************************************");
            System.out.println();
        }
    }

    public void assignRanking(String compareString){

        List<String> list1 = Arrays.asList(compareString.split(","));

        for (DataEntry entry : dataMap.values()) {

            Set<String> commonElements = list1.stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet());

            List<String> list2 = Arrays.asList(entry.getKeySkills().split(","));

            commonElements.retainAll(list2.stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet()));
            entry.setRanking(commonElements.size());

//            System.out.println("Common Elements:");
//            for (String element : commonElements) {
//                System.out.println(element);
//            }
        }
    }

    public void getDetailsAfterAssignRanking(){
        System.out.println("After Ranking:");
        for (Map.Entry<Integer, DataEntry> entry : sortedData.entrySet()) {
            int key = entry.getKey();
            DataEntry data = entry.getValue();

            System.out.println("Key: " + key);
            System.out.println("Name: " + data.getName());
            System.out.println("Experience: " + data.getExperience());
            System.out.println("Annual Salary: " + data.getAnnualSalary());
            System.out.println("Current Location: " + data.getCurrentLocation());
            System.out.println("Previous Position: " + data.getPreviousPosition());
            System.out.println("Previous Company: " + data.getPreviousCompany());
            System.out.println("Current Position: " + data.getCurrentPosition());
            System.out.println("Current Company: " + data.getCurrentCompany());
            System.out.println("Education: " + data.getEducation());
            System.out.println("Preferred Locations: " + data.getPreferredLocations());
            System.out.println("KeySkills: " + data.getKeySkills());
            System.out.println("Ranking: "+data.getRanking());
            System.out.println();
            System.out.println("*******************************************************************");
            System.out.println("*******************************************************************");
            System.out.println();
        }
    }

    public void filterRecordsByRanking(){
        System.out.println("After Ranking:");
        for (Map.Entry<Integer, DataEntry> entry : dataMap.entrySet()) {
            int key = entry.getKey();
            DataEntry data = entry.getValue();

            System.out.println("Key: " + key);
            System.out.println("Name: " + data.getName());
            System.out.println("Experience: " + data.getExperience());
            System.out.println("Annual Salary: " + data.getAnnualSalary());
            System.out.println("Current Location: " + data.getCurrentLocation());
            System.out.println("Previous Position: " + data.getPreviousPosition());
            System.out.println("Previous Company: " + data.getPreviousCompany());
            System.out.println("Current Position: " + data.getCurrentPosition());
            System.out.println("Current Company: " + data.getCurrentCompany());
            System.out.println("Education: " + data.getEducation());
            System.out.println("Preferred Locations: " + data.getPreferredLocations());
            System.out.println("KeySkills: " + data.getKeySkills());
            System.out.println("Ranking: "+data.getRanking());
            System.out.println();
            System.out.println("*******************************************************************");
            System.out.println("*******************************************************************");
            System.out.println();
        }
    }

    public void filterRecordsByLocation(){


        Set<String> allLocations = new LinkedHashSet<>();

        for (DataEntry dataEntry : dataMap.values()) {
            allLocations.add(dataEntry.getCurrentLocation());
        }

        System.out.println(allLocations);

        int i = 1;
        for(String locationToFilter : allLocations){
            Map<Integer, DataEntry> filteredDataMap = new LinkedHashMap<>();
            filterByLocation(dataMap, filteredDataMap, locationToFilter);
            printFilteredMap(filteredDataMap);
            String csvFilePath = "location" + i + ".csv";
            try {
                exportToCSV(filteredDataMap, csvFilePath);
                System.out.println("Data exported to CSV successfully!");
            } catch (IOException e) {
                System.err.println("Error exporting data to CSV: " + e.getMessage());
            }
            i++;
        }



    }

    private static void filterByLocation(Map<Integer, DataEntry> dataMap, Map<Integer, DataEntry> filteredDataMap, String location) {
        for (Map.Entry<Integer, DataEntry> entry : dataMap.entrySet()) {
            int key = entry.getKey();
            DataEntry dataEntry = entry.getValue();

            if (dataEntry.getCurrentLocation().equals(location)) {
                filteredDataMap.put(key, dataEntry);
            }
        }
    }

    public static void printFilteredMap(Map<Integer, DataEntry> filteredDataMap){
        System.out.println("FilteredMap : ");
        for (Map.Entry<Integer, DataEntry> entry : filteredDataMap.entrySet()) {
            int key = entry.getKey();
            DataEntry data = entry.getValue();

            System.out.println("Key: " + key);
            System.out.println("Name: " + data.getName());
            System.out.println("Experience: " + data.getExperience());
            System.out.println("Annual Salary: " + data.getAnnualSalary());
            System.out.println("Current Location: " + data.getCurrentLocation());
            System.out.println("Previous Position: " + data.getPreviousPosition());
            System.out.println("Previous Company: " + data.getPreviousCompany());
            System.out.println("Current Position: " + data.getCurrentPosition());
            System.out.println("Current Company: " + data.getCurrentCompany());
            System.out.println("Education: " + data.getEducation());
            System.out.println("Preferred Locations: " + data.getPreferredLocations());
            System.out.println("KeySkills: " + data.getKeySkills());
            System.out.println("Ranking: "+data.getRanking());
            System.out.println();
            System.out.println("*******************************************************************");
            System.out.println("*******************************************************************");
            System.out.println();
        }
    }

    private static void exportToCSV(Map<Integer, DataEntry> dataMap, String csvFilePath) throws IOException {

        Path parentDirectory = Paths.get(csvFilePath).getParent();
        if (parentDirectory != null && !Files.exists(parentDirectory)) {
            Files.createDirectories(parentDirectory);
        }

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            // Write the header row
            writer.writeNext(new String[]{"Key", "Name", "Experience", "Annual Salary", "Current Location",
                    "Previous Position", "Previous Company", "Current Position", "Current Company", "Education",
            "Preferred Locations", "KeySkills", "Ranking"});

            // Write data rows
            for (Map.Entry<Integer, DataEntry> entry : dataMap.entrySet()) {
                int key = entry.getKey();
                DataEntry dataEntry = entry.getValue();

                writer.writeNext(new String[]{String.valueOf(key), dataEntry.getName(), dataEntry.getExperience(),
                        dataEntry.getAnnualSalary(), dataEntry.getCurrentLocation(), dataEntry.getPreviousPosition(),
                dataEntry.getPreviousCompany(), dataEntry.getCurrentPosition(), dataEntry.getCurrentCompany(),
                dataEntry.getEducation(), dataEntry.getPreferredLocations(), dataEntry.getKeySkills(),
                String.valueOf(dataEntry.getRanking())});
            }
        }
    }


    public void get3(String compareString){

        List<String> list1 = Arrays.asList(compareString.split(","));

        for ( int k = 0 ; k < keySkillsFinalize.size() ; k ++) {
            List<String> list2 = Arrays.asList(keySkillsFinalize.get(k).split(","));
            Log.info(list2);

            // Compare the lists (case-insensitive) and find common elements
            Set<String> commonElements = list1.stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet());

            commonElements.retainAll(list2.stream()
                    .map(String::toLowerCase)
                    .collect(Collectors.toSet()));

            // Print the common elements
            Log.info("Common Elements:");
            for (String element : commonElements) {
                Log.info(element);
            }

            // Print the size of common records
            Log.info("Size of Common Records: " + commonElements.size());
        }
    }

    public void get1234(){
        for( int k = 0 ; k < 1 ; k ++) {
            numberOfDataShown();
            getNamesDetails();
            getExperienceDetails();
            getAnnualSalaryDetails();
            getCurrentLocationDetails();
            getPreviousPositionDetails();
            getPreviousCompanyDetails();
            getCurrentPositionDetails();
            getCurrentCompanyDetails();
            getEducationDetails();
            getPreferredLocationsDetails();
            getKeySkillsDetails();
            resultLocators.clickOnNextPageButton();
            resultLocators.waitForSeconds(5);
        }
    }


    public void sortByRanking() {
        List<Map.Entry<Integer, DataEntry>> entryList = new ArrayList<>(dataMap.entrySet());

        // Sort the entry list by ranking in descending order
        entryList.sort(Comparator.comparingInt(entry -> entry.getValue().getRanking()));
        Collections.reverse(entryList);

        // Create a new LinkedHashMap from the sorted entry list
        for (Map.Entry<Integer, DataEntry> entry : entryList) {
            sortedData.put(entry.getKey(), entry.getValue());
        }
    }

    public void verifyNameDetails(String value){
        Log.info("Name : ");
        List<String> list = new ArrayList<>();
        int n = resultLocators.getTupleDataListCount();
        for ( int k = 1 ; k <= n; k ++) {
            list.add(resultLocators.getName(k).trim());
        }
        Log.info("************************************");
        int z;
        if(list.contains(value)){
            System.out.println(list.contains(value));
            z = list.indexOf(value);
            System.out.println(z);
//            resultLocators.clickOnNameByIndex(z+1);
        }
    }
}
