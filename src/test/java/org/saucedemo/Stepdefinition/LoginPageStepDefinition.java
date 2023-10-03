package org.saucedemo.Stepdefinition;

import org.saucedemo.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.saucedemo.Bases.BasePage;
import org.testng.Assert;

public class LoginPageStepDefinition extends BasePage {
    LoginPage loginpage;

    @Given("Open saucedemo launch login page")
    public void open_saucedemo_launch_login_page() {
       initialization();
    }
    @Given("Verify the title")
    public void verify_the_title() throws InterruptedException {
        if(driver==null){
            System.out.println("driver is null");
        }
        loginpage=new LoginPage(driver);
        Thread.sleep(3000);
        String TitleName=loginpage.tilename();
        Assert.assertTrue(TitleName.isEmpty()==false, "Title is empty");
        Assert.assertEquals("Swag Labs",TitleName);
    }

    @Then("Enter the value {string} and {string}")
    public void enter_the_value_and(String user, String userpassword) {
        if (loginpage==null){
        loginpage= new LoginPage(driver);}
        String username=loginpage.username(user);
        Assert.assertTrue(username.isEmpty()==false, "User Name is empty");
        String password=loginpage.password(userpassword);
        Assert.assertTrue(password.isEmpty()==false, "Password incorrect or empty");
    }
    @Then("Click login button")
    public void click_login_button() {
        loginpage.loginbutton().click();
    }
}
