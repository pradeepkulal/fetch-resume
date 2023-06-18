package com.resume.lib.base;

import java.util.HashMap;

public class CommonUiBase extends UiBase{

    public int getEntityIndexForNoticePeriod(String menu){
        HashMap<String,Integer> menus = new HashMap<>();
        menus.put("Any", 0);
        menus.put("15 days",1);
        menus.put("1 month",2);
        menus.put("2 months",3);
        menus.put("3 months",4);
        menus.put("More than 3 months",5);
        menus.put("Currently serving notice period",6);

        return menus.get(menu);
    }

    public int getEntityIndexForActiveIn(String menu){
        HashMap<String,Integer> menus = new HashMap<>();
        menus.put("All resumes", 0);
        menus.put("1 day",1);
        menus.put("3 days",2);
        menus.put("7 days",3);
        menus.put("15 days",4);
        menus.put("30 days",5);
        menus.put("2 months",6);
        menus.put("3 months",7);
        menus.put("6 months",8);
        menus.put("1 year",9);
        menus.put("8 to 15 days",10);
        menus.put("16 to 30 days",11);
        menus.put("1 to 2 months",12);
        menus.put("2 to 3 months",13);
        menus.put("3 to 6 months",14);
        menus.put("6 to 12 months",15);
        menus.put("1 year+",16);


        return menus.get(menu);
    }
}
