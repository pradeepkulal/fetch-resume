package com.naukri.lib.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UiBase{


    private WebElement waitForElementVisibility(WebDriver driver, WebElement element, int timeOutInSeconds){
        return (new WebDriverWait(driver , Duration.ofSeconds(timeOutInSeconds))).until(
                ExpectedConditions.visibilityOf(element));
    }

    private WebElement waitForElementToBeClickable(WebDriver driver, WebElement element, int timeOutInSeconds){
        return (new WebDriverWait(driver, Duration.ofSeconds(timeOutInSeconds))).until(
                ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForSeconds(int second){
        try{
            Thread.sleep(second * 1000L);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean awaitForElementPresence(WebDriver driver, WebElement element, int timeOutInSeconds){
        try {
            waitForElementVisibility(driver, element, timeOutInSeconds);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean awaitForElementToBeClickable(WebDriver driver, WebElement element, int timeOutInSeconds){
        try {
            waitForElementToBeClickable(driver, element, timeOutInSeconds);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void moveCursorToWebElement(WebDriver driver, WebElement element, int timeOutInSeconds){
        awaitForElementPresence(driver, element, timeOutInSeconds);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
        waitForSeconds(2);
    }

    public void awaitForWebElementListLoad(List<WebElement> elementList, int timeOutInSeconds){
        for(int k = 0; k < timeOutInSeconds; k++){
            if(!(elementList.size() > 0)){
                waitForSeconds(1);
            }else {
                break;
            }
        }
    }

    public List<String> getListElementText(List<WebElement> element){
        List<String> listElementText = new ArrayList<>();
        for (WebElement webElement : element){
            listElementText.add(webElement.getText());
        }
        return listElementText;
    }

    public List<String> getListElementAttributeValue(List<WebElement> element, String attributeValue){
        List<String> listElementText = new ArrayList<>();
        for (WebElement webElement : element){
            listElementText.add(webElement.getAttribute(attributeValue));
        }
        return listElementText;
    }

    public void scrollToWebElement(WebDriver driver, WebElement element){
        JavascriptExecutor je = (JavascriptExecutor)driver;
        je.executeScript("arguments[0].scrollIntoView(true);", element);
        waitForSeconds(2);
    }

    private WebElement waitForElementVisibilityToBeLocatedByXpath(WebDriver driver, String xpath , int timeOutInSeconds){
        return (new WebDriverWait(driver , Duration.ofSeconds(timeOutInSeconds))).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement awaitElementAppearByXpath(WebDriver driver, String path , int timeOutInSeconds){
        try{
            return waitForElementVisibilityToBeLocatedByXpath(driver, path , timeOutInSeconds);
        }catch (Exception e){
            return null;
        }
    }


}
