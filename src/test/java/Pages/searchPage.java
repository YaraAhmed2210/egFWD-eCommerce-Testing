package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class searchPage {
    WebDriver driver;

    public searchPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement get_searchEle(){
        By search=By.id("small-searchterms");
        WebElement searchEle=driver.findElement(search);
        return searchEle;
    }

    public void searchWord(String word){
        get_searchEle().sendKeys(word);
        driver.findElement(By.cssSelector("form > button[type=\"submit\"]")).click();
    }


}
