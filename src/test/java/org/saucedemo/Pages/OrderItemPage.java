package org.saucedemo.Pages;

import org.saucedemo.Utilites.WebElementUtility;
import org.saucedemo.Bases.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class OrderItemPage extends BasePage {
    WebElementUtility utilityaction;
    @FindBy (xpath = "//div[@class='inventory_item_name']")
    private List<WebElement> itemlist;
    @FindBy (xpath = "/ancestor::div[@class='inventory_item_label']/following::button")
    private WebElement addbutton;
    @FindBy (xpath = "//button[@class='btn btn_primary btn_small btn_inventory']")
    private WebElement clickbutton;
    @FindBy (xpath = "//a[@class='shopping_cart_link']//span")
    private WebElement cartcount;
    @FindBy (xpath = "//div[@class='cart_quantity']")
    private WebElement qty;
    @FindBy (xpath = "//div[@class='inventory_item_name']")
    private WebElement itemname;
    @FindBy (id = "checkout")
    private WebElement checkout;
    @FindBy (xpath = "//span[@class='title']")
    private WebElement checkoutinfo;
    @FindBy (id = "first-name")
    private WebElement firstname;
    @FindBy (id = "last-name")
    private WebElement lastname;
    @FindBy (id = "postal-code")
    private WebElement postalcode;
    @FindBy (id = "continue")
    private WebElement continuebutton;
    @FindBy (id = "remove-sauce-labs-backpack")
    private WebElement removebutton;
    @FindBy (xpath = "//div[@class='summary_info_label']")
    private List<WebElement> summary;
    @FindBy (xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement totalprice;
    @FindBy (id = "finish")
    private WebElement finish;

    //Initializing the page Object:
    public OrderItemPage(WebDriver driver){
        PageFactory.initElements(driver, this);
        utilityaction =new WebElementUtility(driver);
    }
    public void selectItem(String item) {
        System.out.println("Size of list "+itemlist.size());
        for (int i=0;i<itemlist.size()-1;i++){
            System.out.println("outside loop"+ itemlist.get(i).getText());
            if(itemlist.get(i).getText().contains(item)){
                System.out.println(itemlist.get(i).getText()+ "inside loop");
                itemlist.get(i).click();
                utilityaction.click(clickbutton);
                break;
            }
            }
    }
    public String Addcart(){
       return utilityaction.getText(cartcount);
    }
    public void ClickCart(){
        utilityaction.click(cartcount);
    }
    public String QTY(){
       return utilityaction.getText(qty);
    }
    public String Itemname(){
        return utilityaction.getText(itemname);
    }
    public void ClickCheckout(){
        utilityaction.click(checkout);
    }
    public String CheckoutStatus(){
        return utilityaction.getText(checkoutinfo);
    }
    public String Firstname(String enterfirstname){
        return utilityaction.sendkey(firstname,enterfirstname);
    }
    public String Lastname(String enterlastname) {
        return utilityaction.sendkey(lastname,enterlastname);
    }
    public String Postalcode(String enterpostalcode){
        return utilityaction.sendkey(postalcode,enterpostalcode);
    }
    public void ClickContinue(){
        utilityaction.click(continuebutton);
    }
    public List<String> Summary(){
        List<String> summaryList= new ArrayList<String>();
        for (WebElement Summary:summary) {
           String text= Summary.getText();
           summaryList.add(text);
        }
        return summaryList;
    }
    public String Totalprice(){
        return utilityaction.getText(totalprice);
    }
    public void ClickFinish(){
        utilityaction.click(finish);
    }
}
