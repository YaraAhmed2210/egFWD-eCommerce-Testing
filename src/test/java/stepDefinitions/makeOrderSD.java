package stepDefinitions;

import Pages.makeOrderPage;
import Pages.selectCategoryPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class makeOrderSD {

    public static WebDriver driver=null;
    public static makeOrderPage makeOrder;

    @When ("click on agree on terms and checkout buttons")
        public void clickOnAgreeAndCheckout(){
        makeOrder.clickOnCheckOut();

    }

    @And ("logged user shall fill Billing address section")
        public void fillBillingAddressSection() throws InterruptedException {

        makeOrder.fillBillingAddressSection();
        Thread.sleep(3000);

    }
    @And("logged user shall fill shipping address section")
    public void fillShippingAddress() throws InterruptedException {
        Thread.sleep(4000);
        makeOrder.shippingAddressSection();
    }
    @And ("logged user shall fill shipping method section")
    public void fillShippingMethod() throws InterruptedException {
        makeOrder.shippingMethodSection();
        Thread.sleep(3000);
    }
    @And("logged user shall fill payment method section")
    public void fillPaymentMethod() throws InterruptedException {
        makeOrder.paymentMethodSection();
    }

    @And("logged user shall fill payment Info section")
    public void fillPaymentInfo() throws InterruptedException {
        makeOrder.paymentInfoSection();
    }
    @And("logged user shall place order")
    public void placeOrder() throws InterruptedException {
        Thread.sleep(3000);
        makeOrder.placeOrder();
    }
    @Then("order should be completed")
    public void validateOrderCompletion() throws InterruptedException {
        Thread.sleep(3000);
        makeOrder.validateOrderDone();
    }


}
