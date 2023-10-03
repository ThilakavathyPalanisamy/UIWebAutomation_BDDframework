package org.saucedemo.Pages;

import org.saucedemo.Utilites.WebElementUtility;
import org.saucedemo.Bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    WebElementUtility utilityaction;
    @FindBy (xpath = "//div[@class='login_logo']")
    private WebElement title;
    @FindBy (id="user-name")
    private WebElement username;
    @FindBy (id="password")
    private WebElement password;
    @FindBy (id="login-button")
    private WebElement loginbutton;

    //Initializing the page Object:
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        utilityaction =new WebElementUtility(driver);
    }
    public String tilename(){
        return title.getText();
    }
    public String username(String name){
       return utilityaction.sendkey(username,name);
    }
    public String password(String userpassword){
        return utilityaction.sendkey(password,userpassword);
    }
    public WebElement loginbutton(){
       return loginbutton;
    }

}
