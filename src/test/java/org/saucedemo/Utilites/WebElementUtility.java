package org.saucedemo.Utilites;

import org.saucedemo.Bases.BasePage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WebElementUtility {
    WebDriverWait wait;
    public WebElementUtility(WebDriver driver){
        wait=new WebDriverWait(driver, Duration.ofSeconds(50));
    }

    public void click(WebElement element) {
        waitForElementToBeClickable(element);
        element.click();
    }

    public void clear(WebElement element) {
        waitForElementVisibility(element);
        element.clear();
    }
    public String sendkey(WebElement element,String name){
        waitForElementVisibility(element);
        element.clear();
        element.sendKeys(name);
        return name;
    }
    public void sendkeyusingjavascrpit(WebElement element,String name){
        waitForElementVisibility(element);
        JavascriptExecutor js =(JavascriptExecutor) BasePage.driver;
        String id =element.getAttribute("id");
        js.executeScript("document.getElementById('"+id+"').value='"+name+"'");

    }

    public String getText(WebElement element) {
        waitForElementVisibility(element);
        return element.getText();
    }

    public String getAttribute(WebElement element) {
        waitForElementVisibility(element);
        return element.getText();
    }

    public void waitForElementVisibility(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public Boolean waitForElementToBeEnabled(WebElement element) {
        waitForElementToBeClickable(element);
        return element.isEnabled();
    }

    public Boolean waitForElementToBeDisplayed(WebElement element) {
        waitForElementVisibility(element);
        return element.isDisplayed();
    }

    public void waitForAllElementsVisibility(List<WebElement> element) {
        wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElements(element)));
    }
}
