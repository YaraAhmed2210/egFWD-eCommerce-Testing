package Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class makeOrderPage {
    WebDriver driver;

    public makeOrderPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement get_agreeOnTermsCheck(){
        return driver.findElement(By.id("termsofservice"));
    }
    public WebElement get_checkoutBtn(){
        return driver.findElement(By.id("checkout"));
    }

    public WebElement get_addressDrp(){
        return driver.findElement(By.id("billing-address-select"));
    }

    public WebElement get_countryDrp(){
        return driver.findElement(By.id("BillingNewAddress_CountryId"));
    }
    public WebElement get_cityInput(){
        return driver.findElement(By.id("BillingNewAddress_City"));
    }
    public WebElement get_addressInput(){
        return driver.findElement(By.id("BillingNewAddress_Address1"));
    }
    public WebElement get_postalCode(){
        return driver.findElement(By.id("BillingNewAddress_ZipPostalCode"));
    }
    public WebElement get_phone(){
        return driver.findElement(By.id("BillingNewAddress_PhoneNumber"));
    }
    public WebElement get_continueBtn1(){
        return driver.findElement(By.xpath("//*[@id=\"billing-buttons-container\"]/button[4]"));
    }
    public WebElement get_continueBtn2(){
        //*[@id="shipping-buttons-container"]/button]
        //*[@id="shipping-buttons-container"]/button
        return driver.findElement(By.xpath("//*[@id=\"shipping-buttons-container\"]/button"));
    }
    //*[@id="shipping-method-buttons-container"]/button
    public WebElement get_shippingMethodContinueBtn(){
        return driver.findElement(By.xpath("//*[@id=\"shipping-method-buttons-container\"]/button"));
    }
    public WebElement get_paymenMethodContinueBtn(){
        return driver.findElement(By.xpath("//*[@id=\"payment-method-buttons-container\"]/button"));
    }
    public WebElement get_paymenInfoContinueBtn(){
        return driver.findElement(By.xpath("//*[@id=\"payment-info-buttons-container\"]/button"));
    }
    public WebElement get_ConfirmBtn(){
        return driver.findElement(By.xpath("//*[@id=\"confirm-order-buttons-container\"]/button"));
    }

    public WebElement get_orderDone(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div/div[1]/strong"));
    }

    public void clickOnCheckOut(){
        get_agreeOnTermsCheck().click();
        get_checkoutBtn().click();
    }
    public void fillBillingAddressSection(){

        Boolean isPresent = driver.findElements(By.id("billing-address-select")).size() > 0;

        if(isPresent){

            Select drpAddressOptions= new Select(get_addressDrp());
            String selectedOption=drpAddressOptions.getFirstSelectedOption().getText();
           if(selectedOption.contains("New Address")){
               Select drpCountry= new Select(get_countryDrp());
               drpCountry.selectByValue("123");
               get_cityInput().sendKeys("Cairo");
               get_addressInput().sendKeys("Hadayek El-Qobba");
               get_postalCode().sendKeys("11646");
               get_phone().sendKeys("01158129971");
               get_continueBtn1().click();
           }
           else{
               driver.findElement(By.id("ShipToSameAddress")).click();
               get_continueBtn1().click();
           }
       }
       else{

           Select drpCountry= new Select(get_countryDrp());
           drpCountry.selectByValue("123");
           get_cityInput().sendKeys("Cairo");
           get_addressInput().sendKeys("Hadayek El-Qobba");
           get_postalCode().sendKeys("11646");
           get_phone().sendKeys("01158129971");
           get_continueBtn1().click();
       }

    }
    public void shippingAddressSection() throws InterruptedException {
        Thread.sleep(3500);

        boolean isPresent=driver.findElements(By.xpath("//*[@id=\"shipping-buttons-container\"]/button")).size() > 0;
        if(isPresent==true){
        get_continueBtn2().click();
        }
    }
    public void shippingMethodSection() throws InterruptedException {
        Thread.sleep(3000);
        get_shippingMethodContinueBtn().click();
    }
    public void paymentMethodSection() throws InterruptedException{
        Thread.sleep(2000);
        get_paymenMethodContinueBtn().click();
    }

    public void paymentInfoSection() throws InterruptedException{
        Thread.sleep(2000);
        get_paymenInfoContinueBtn().click();
    }
    public void placeOrder(){
        get_ConfirmBtn().click();
    }
    public void validateOrderDone(){
       Assert.assertTrue(get_orderDone().getText().contains("Your order has been successfully processed!"));
    }


}
