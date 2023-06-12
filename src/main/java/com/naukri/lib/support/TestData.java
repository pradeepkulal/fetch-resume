package com.naukri.lib.support;

import java.util.List;
import java.util.Random;

public class TestData {

    public static int getRandomNumberLessThanGivenNumber(int number){
        return new Random().nextInt(number);
    }

    public static int getRandomNumberBetweenTwoNumbers(int lowerBound , int upperBound){
        return (new Random().nextInt(upperBound - lowerBound)) + lowerBound;
    }

    public static String convertListToCSVString(List<String> data) {
        StringBuilder csvString = new StringBuilder();

        // Append each item in the list to the CSV string
        for (String item : data) {
            csvString.append(item).append(",");
        }

        // Remove the trailing comma if it exists
        if (csvString.length() > 0) {
            csvString.setLength(csvString.length() - 1);
        }

        return csvString.toString();
    }
}
