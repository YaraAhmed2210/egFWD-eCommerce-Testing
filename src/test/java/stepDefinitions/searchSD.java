package stepDefinitions;

import Pages.loginPage;
import Pages.searchPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class searchSD {
   /* public static WebDriver driver=null;
    searchPage search;
    loginPage login;

    @Given("user open the browser")
    public void userOpenBrowser() throws InterruptedException {
        String chromePath= System.getProperty("user.dir") + "\\src\\main\\resources\\chromedriver.exe";
        System.out.println(chromePath);
        System.setProperty("webdriver.chrome.driver",chromePath); //input1: yfhm elcode enu hyt3aml m3 chromeDriver,input2: path of chromeDriver

        //2 New object of webDriver
        driver= new ChromeDriver(); //as mouse and keyboard of automation
        driver.manage().window().maximize(); //maximize screen when it open
        Thread.sleep(3000);
        login=new loginPage(driver);
        search=new searchPage(driver);

    }

    @And("user navigates to the login page")
    public void navigateToLoginPage(){

        driver.navigate().to("https://demo.nopcommerce.com/");
        By LoginBtn=By.className("ico-login");
        WebElement LoginBtnEle=driver.findElement(LoginBtn);
        LoginBtnEle.click();

    }
    @When("^user enter \"(.*)\" and \"(.*)\" then click on login btn$")
    public void loginWithValidUsernameAndPassword(String userName, String pass) throws InterruptedException {
        login.loginSteps(userName, pass);

    }

    @And("user logged in successfully to the home page")
    public void successLogin_goToHomePage(){
       Assert.assertEquals(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"),true);
       Assert.assertEquals(driver.findElement(By.className("ico-logout")).getText().contains("Log out"),true);

    }
    @And ("^user enter \"(.*)\" in search box$")
    public void enterSearchWord(String word){
        search.searchWord(word);
    }

    @Then ("search results shall appear")
    public void validateSearchResult() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.className("product-title")).getText().contains("Pride and Prejudice"));
    }


*/
}
