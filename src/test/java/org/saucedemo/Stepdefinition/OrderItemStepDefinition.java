package org.saucedemo.Stepdefinition;

import org.saucedemo.Pages.OrderItemPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.saucedemo.Bases.BasePage;
import org.testng.Assert;

import java.util.List;

public class OrderItemStepDefinition extends BasePage {
    OrderItemPage order;
    public Scenario scenario;
    @Before
    public void beforeStep(Scenario scenario) {
        this.scenario = scenario;
        System.out.println("Scenario "+this.scenario);
    }
    @Then("Select the product {string} and add the card")
    public void select_the_product_and_add_the_card(String string) {
//        if(driver==null){
//            scenario.log("driver is null");
//        }
        if (order==null){
            order=new OrderItemPage(driver);}
        order.selectItem(string);
    }

    @Then("Go to the cart and check Item with QTY")
    public void go_to_the_cart_and_check_item_with_qty() {
        if (order==null){
            order=new OrderItemPage(driver);}
        String count = order.Addcart();
        scenario.log("Add cart count is: "+count);
        order.ClickCart();
    }

    @When("Checkout the product")
    public void checkout_the_product() {
        String Status=order.CheckoutStatus();
        Assert.assertTrue(Status.isEmpty()==false, "Status is empty");
        scenario.log("Status is: "+Status);
        String QTYcount=order.QTY();
        Assert.assertTrue(QTYcount.isEmpty()==false, "Quantity is empty");
        scenario.log("Quantity is: "+QTYcount);
        String ProductItem=order.Itemname();
        Assert.assertTrue(ProductItem.isEmpty()==false, "Product Item is empty");
        scenario.log("ProductItem is: "+ProductItem);
        order.ClickCheckout();
    }

    @Then("Verify the checkout title")
    public void verify_the_checkout_title() {
        String Status=order.CheckoutStatus();
        Assert.assertTrue(Status.isEmpty()==false, "Status is empty");
        scenario.log(Status);
    }

    @Then("Enter the {string} then {string} and {string}")
    public void enter_the_then_and(String string, String string2, String string3) {
        String name=order.Firstname(string);
        Assert.assertTrue(name.isEmpty()==false, "First name is empty");
        scenario.log("First Name: "+name);
        String lastname=order.Lastname(string2);
        Assert.assertTrue(lastname.isEmpty()==false, "Last name is empty");
        scenario.log("Last Name: "+lastname);
        String code=order.Postalcode(string3);
        Assert.assertTrue(code.isEmpty()==false, "Post Code is empty");
        scenario.log("Post Code "+code);
    }

    @Then("Checkout Overview observe the product QTY Payment Information, Shipping information, Price Total, Total")
    public void checkout_overview_observe_the_product_qty_payment_information_shipping_information_price_total_total() {
        order.ClickContinue();
        String Status=order.CheckoutStatus();
        Assert.assertTrue(Status.isEmpty()==false, "Status is empty");
        scenario.log("Status is: "+Status);
        String QTYcount=order.QTY();
        Assert.assertTrue(QTYcount.isEmpty()==false, "Quantity is empty");
        scenario.log("Quantity is: "+QTYcount);
        String ProductItem=order.Itemname();
        Assert.assertTrue(ProductItem.isEmpty()==false, "Product Item is empty");
        scenario.log("Product item is: "+ProductItem);
        List<String> summaryList=order.Summary();
        Assert.assertTrue(summaryList.isEmpty()==false, "Summary List is empty");
        System.out.println(summaryList);
        String price=order.Totalprice();
        Assert.assertTrue(price.isEmpty()==false, "Price is empty");
        scenario.log("Price is: "+price);
    }

    @Then("Click the button Finish")
    public void click_the_button_finish() {
       order.ClickFinish();
    }

    @Then("Checkout the status")
    public void checkout_the_status() {
        String Status=order.CheckoutStatus();
        Assert.assertTrue(Status.isEmpty()==false, "Status is empty");
        scenario.log("Status is: "+Status);
    }
    @After
    public void teardown(){
        driver.quit();
    }
}
