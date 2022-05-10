package Pages;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Random;

public class loggedUserPage {
    WebDriver driver;

    public loggedUserPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement get_CurrencyList(){
        By currencyList=By.id("customerCurrency");
        WebElement currencyListEle=driver.findElement(currencyList);
        return currencyListEle;
    }

    public WebElement get_navBarList(){

        By navbarList=By.xpath("//ul[@class=\"top-menu mobile\"]");
        //ul[@class="top-menu mobile"]
       // By navbarList=By.className("top-menu");
        WebElement navbarListEle=driver.findElement(navbarList);
        return navbarListEle;
    }
    public WebElement get_ProductByName(String prodName){
        By prod=By.linkText(prodName);
        WebElement prodEle=driver.findElement(prod);
        return prodEle;
    }

    public WebElement get_addToCartBtn(){
        By cart=By.xpath("//div[@class=\"add-to-cart\"]//button[@type=\"button\"]");
        WebElement cartEle=driver.findElement(cart);
        return cartEle;
    }

    public WebElement get_addToComparelistBtn(){
        By compare=By.xpath("//div[@class=\"compare-products\"]//button[@type=\"button\"]");
        WebElement compareEle=driver.findElement(compare);
        return compareEle;
    }
//div[@class="compare-products"]//button[@type="button"]

    public WebElement get_addToWishlistBtn(){
        By Wish=By.xpath("//div[@class=\"add-to-wishlist\"]//button[@type=\"button\"]");
        WebElement WishEle=driver.findElement(Wish);
        return WishEle;
    }


    public void changeCurrency(String currencyName) throws InterruptedException {
        Select drpCurr= new Select(get_CurrencyList());
        drpCurr.selectByVisibleText(currencyName);
        Thread.sleep(3000);
       // drpCurr.selectByValue(currencyName);
    }
    public boolean validateCurrChange(String currencySign){
        return driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div/div/div[2]/div[3]/div[1]/span[2]")).getText().contains(currencySign);
       // return driver.findElement(By.className("price")).getText().contains(currencySign);
    }
    public void chooseRandomCategory() throws InterruptedException {
     /* Random randNum=new Random();
      List<WebElement> listOfCategories=driver.findElements(By.className("top-menu"));
      int listCount=listOfCategories.size();
      int x=randNum.nextInt(1,listCount);
      WebElement temp=listOfCategories.get(1);
      temp.click();

      */
      List<WebElement> listOfCategories=driver.findElements(By.xpath("//ul[@class=\"top-menu mobile\"]"))  ;
    //  List<WebElement> listOfCategories=driver.findElements(By.className("top-menu"));
      for (WebElement webElement: listOfCategories){
          if(webElement.getText().contains("Books")){
              webElement.click();
              break;
          }
      }
    //  Thread.sleep(3000);

       /* Select navList= new Select(get_navBarList());
        Random randNum=new Random();
        int listCount=driver.findElements(By.className("top-menu")).size();
        int x=randNum.nextInt(listCount);

        navList.selectByIndex(x);
        Thread.sleep(3000);
*/
    }
    public void clickOnProduct(String prodName){
        get_ProductByName(prodName).click();
    }
    public void clickOnAddToCart(){
        get_addToCartBtn().click();
    }
    public void clickOnAddToWishlist(){
        get_addToWishlistBtn().click();
    }
    public void clickOnAddToComparelist(){
        get_addToComparelistBtn().click();
    }

}
