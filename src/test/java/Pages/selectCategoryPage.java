package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class selectCategoryPage {
    WebDriver driver;

    public selectCategoryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement get_apparelCategory(){
        return driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/a"));
    }

    public WebElement get_shoesSubCategory(){
        return  driver.findElement(By.xpath("/html/body/div[6]/div[2]/ul[1]/li[3]/ul/li[1]/a"));
    }

    public WebElement get_redColor(){
        return  driver.findElement(By.id("attribute-option-15"));
    }
    public List<WebElement> get_AllCategories(){
        return driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li"));
    }
    public List<WebElement> get_AllSubCats(WebElement x){
        return  x.findElements(By.cssSelector("ul>li"));
    }

    public String selectRandomCategory(){
        Actions action = new Actions(driver);
        //List<WebElement> categories=driver.findElements(By.xpath("/html/body/div[6]/div[2]/ul[1]/li"));
        List<WebElement> categories=get_AllCategories();
        Random randomNo=new Random();
        int x=randomNo.nextInt(0,categories.size());

        WebElement randomCat = categories.get(x);
        System.out.println("cat name : "+randomCat.getText());
        List<WebElement> randomCatSubELements=get_AllSubCats(randomCat);
       // List<WebElement> randomCatSubELements=randomCat.findElements(By.cssSelector("ul>li"));

        if(randomCatSubELements.size()!=0){

            Random randomNo2=new Random();
            int y=randomNo2.nextInt(0,randomCatSubELements.size());


            action.moveToElement(randomCat);
            action.moveToElement(randomCatSubELements.get(y));
            String temp=randomCatSubELements.get(y).getText();
            action.click().build().perform();

            return temp;
        }
        else {
            String temp=randomCat.getText();
            randomCat.click();
            return temp;
        }

    }

    public void goToShoesCategory(){
        Actions actions = new Actions(driver);
        actions.moveToElement(get_apparelCategory());
        actions.moveToElement(get_shoesSubCategory());
        actions.click().build().perform();
    }
    public void filterByColor(){
        get_redColor().click();
    }
    public boolean validateFilter(){
        return get_redColor().isSelected();
    }

}
