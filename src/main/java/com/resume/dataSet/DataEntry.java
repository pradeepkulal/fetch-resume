package com.resume.dataSet;

import java.io.File;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain=true)
public class DataEntry {

    private String name;
    private String experience;
    private String annualSalary;
    private String currentLocation;
    private String previousPosition;
    private String previousCompany;
    private String currentPosition;
    private String currentCompany;
    private String education;
    private String preferredLocations;
    private String keySkills;
    private int ranking;
    private String email;
    private File resumeFile;
    private String nameLink;

}
