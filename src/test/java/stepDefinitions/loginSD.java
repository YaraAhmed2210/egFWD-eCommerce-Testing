package stepDefinitions;

import Pages.loginPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class loginSD {

    public static WebDriver driver=null;
    loginPage login;


@Given("user open browser")
public void userOpenBrowser() throws InterruptedException {
    String chromePath= System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
    System.out.println(chromePath);
    System.setProperty("webdriver.chrome.driver",chromePath); //input1: yfhm elcode enu hyt3aml m3 chromeDriver,input2: path of chromeDriver

    //2 New object of webDriver
    driver= new ChromeDriver(); //as mouse and keyboard of automation
    driver.manage().window().maximize(); //maximize screen when it open
    Thread.sleep(3000);
    login=new loginPage(driver);
    Hooks.driver=driver;
    // searchSD.setDriver(driver);
}
@And("user navigates to login page")
public void navigateToLoginPage(){

    driver.navigate().to("https://demo.nopcommerce.com/");
    By LoginBtn=By.className("ico-login");
    WebElement LoginBtnEle=driver.findElement(LoginBtn);
    LoginBtnEle.click();
}

@When("^user enter \"(.*)\" and \"(.*)\" then click on login button$")
public void loginWithValidUsernameAndPassword(String userName, String pass) throws InterruptedException {
    login.loginSteps(userName, pass);

}

@Then("user could login successfully to the home page")
public void successLogin_goToHomePage(){
    Assert.assertEquals(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"),true);
}


@When ("user click on forgot password")
public void clickForgotPassword(){
    driver.findElement(By.className("forgot-password")).click();
}
@And ("user redirected to reset page")
public void redirectToResetPage(){
    Assert.assertEquals(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/passwordrecovery"),true);
}
@And ("user enter his valid mail then click recover button")
public void enterValidMail(){
    login.resetPassword("yaraa2211@yahoo.com");
    driver.findElement(By.name("send-email")).click();
}
@Then ("reset mail should be sent to user")
public void validateReset(){

    Assert.assertTrue(driver.findElement(By.id("bar-notification")).isDisplayed());
    Assert.assertEquals(driver.findElement(By.className("content")).getText().contains("Email with instructions has been sent to you."),true);
}
   /* @After
    public void close_browser(){
        driver.quit();
    }*/

}
