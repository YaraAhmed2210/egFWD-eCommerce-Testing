package stepDefinitions;

import Pages.loggedUserPage;
import Pages.loginPage;
import Pages.searchPage;
import Pages.selectTagPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class selectTag {

    public static WebDriver driver=null;
    public static selectTagPage myTag;


    @When("^user selects tag \"(.*)\"$")
    public void selectTag(String tagName) throws InterruptedException {
       Thread.sleep(4500);
       myTag.clickOnTag(tagName);
    }
    @Then ("^user shall be directed to this tag \"(.*)\" page$")
    public void validateRedirectionToTagPage(String tagName) throws InterruptedException {
        Thread.sleep(4500);
        Assert.assertTrue(driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[1]/h1")).getText().contains(tagName));

    }

}
