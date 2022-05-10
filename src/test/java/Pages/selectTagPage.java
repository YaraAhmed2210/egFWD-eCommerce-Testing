package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class selectTagPage {
    WebDriver driver;

    public selectTagPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement get_niceTag(){
      return  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[1]/div[3]/div[2]/div[1]/ul/li[13]/a"));
    }

    public WebElement get_awesomeTag(){
        return  driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[1]/div[3]/div[2]/div[1]/ul/li[2]/a"));
    }

    public void clickOnTag(String tagName){
        if(tagName.contains("nice")){
            get_niceTag().click();
        }else{
            get_awesomeTag().click();
        }
    }


}
