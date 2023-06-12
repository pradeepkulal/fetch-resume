package com.naukri.lib.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {


    public WebDriver initialize_driver(String path){
        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        if(System.getProperty("os.name").contains("Linux")){
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--headless","--disable-gpu","--no-sandbox","--disable-dev-shm-usage",
                    "--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }else{
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*",path);
//            options.addArguments("--remote-allow-origins=*");
            driver = new ChromeDriver(options);
        }
        return driver;
    }
}
