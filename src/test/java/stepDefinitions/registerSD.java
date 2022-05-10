package stepDefinitions;

import Pages.loginPage;
import Pages.registerPage;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Hook;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class registerSD {

    public WebDriver driver=null;
    registerPage register;
    @Given("user open browser for register")
    public void userOpenBrowser() throws InterruptedException {
        String chromePath= System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver",chromePath); //input1: yfhm elcode enu hyt3aml m3 chromeDriver,input2: path of chromeDriver

        //2 New object of webDriver
        driver= new ChromeDriver(); //as mouse and keyboard of automation
        driver.manage().window().maximize(); //maximize screen when it open
        Thread.sleep(3000);
        Hooks.driver=driver;
        register=new registerPage(driver);
    }
    @And("user navigates to register page")
    public void navigateToRegisterPage() throws InterruptedException {
        driver.navigate().to("https://demo.nopcommerce.com/");

        Boolean isPresent = driver.findElements(By.className("ico-register")).size() > 0;
        if(!isPresent){

            driver.findElement(By.className("ico-logout")).click();
            Thread.sleep(3000);
        }

        driver.findElement(By.className("ico-register")).click();

    }

    @When ("user enter valid data and click on register")
    public void register_ValidData(){
        register.registerData("Yara","Ahmed","22","10","1998","yaraa2211@yahoo.com","123456","123456");
    }

    @Then("user could register successfully")
    public void validateRegistration(){

        Assert.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/registerresult/1?returnUrl=/");
        String expectedResult= "Your registration completed";
        String actualResult=driver.findElement(By.className("result")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }






}
