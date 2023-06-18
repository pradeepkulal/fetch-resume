package com.resume.lib.support;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class TestData {

    private static final String PDF_EXTENSION = "pdf";

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

    public static File getLatestDownloadedFile(String downloadDir) {
        File dir = new File(downloadDir);



        // Filter files only (not directories)
        File[] files = dir.listFiles(file -> file.isFile() && file.getName().toLowerCase().endsWith("." + PDF_EXTENSION));

        // Sort files by last modified timestamp in descending order
        if (files != null && files.length > 0) {
            Comparator<File> comparator = Comparator.comparingLong(File::lastModified).reversed();
            Arrays.sort(files, comparator);

            // Return the latest downloaded file
            return files[0];
        }

        return null;
    }

    public static String convertStringToYears(String input) {
        String[] values = input.split(" ");
        float years = 0;
        float months = 0;

        for (String value : values) {
            if (value.endsWith("y")) {
                years = Integer.parseInt(value.substring(0, value.length() - 1));
            } else if (value.endsWith("m")) {
                months = Integer.parseInt(value.substring(0, value.length() - 1));
            }
        }

        return String.valueOf((int) Math.ceil(years + (months / 12)));
    }

    public static void openPDF(File file) {
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
            try {
                Desktop.getDesktop().open(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static String getExactAnnualSalaryNumber(String input) {
        String[] parts = input.split(" ");
        return parts[1];
    }
}
