package stepDefinitions;

import Pages.*;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class loggedUserSD {
    public static WebDriver driver=null;
    loggedUserPage loggedUser;
    searchPage search;
    loginPage login;
    selectTagPage tag;
    selectCategoryPage category;
    makeOrderPage makeOrder;
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
        loggedUser= new loggedUserPage(driver);
        tag=new selectTagPage(driver);
        category=new selectCategoryPage(driver);
        makeOrder=new makeOrderPage(driver);

        addProduct.driver=driver;
        addProduct.loggedUser=loggedUser;

        selectTag.driver=driver;
        selectTag.myTag=tag;

        selectCategory.driver=driver;
        selectCategory.myCategory=category;

        Hooks.driver=driver;
        makeOrderSD.driver=driver;
        makeOrderSD.makeOrder=makeOrder;

        driver.navigate().to("https://demo.nopcommerce.com/");
    }

    @And("user navigates to the login page")
    public void navigateToLoginPage(){

        By LoginBtn=By.className("ico-login");
        WebElement LoginBtnEle=driver.findElement(LoginBtn);
        LoginBtnEle.click();

    }

    @And("^user enter \"(.*)\" and \"(.*)\" then click on login btn$")
    public void loginWithValidUsernameAndPassword(String userName, String pass) throws InterruptedException {
        login.loginSteps(userName, pass);

    }
    @Then("user logged in successfully to the home page")
    public void successLogin_goToHomePage(){
        Assert.assertEquals(driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"),true);
        Assert.assertEquals(driver.findElement(By.className("ico-logout")).getText().contains("Log out"),true);
    }

    @When ("^user enter \"(.*)\" in search box$")
    public void enterSearchWord(String word){
        search.searchWord(word);
    }
    @Then("search results shall appear")
    public void validateSearchResult() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(driver.findElement(By.className("product-title")).getText().contains("Pride and Prejudice"));
    }

    @When ("user click on Currency dropdown list and choose Euro currency")
    public void toEuroCurrency() throws InterruptedException{
        Thread.sleep(3000);
        loggedUser.changeCurrency("Euro");
    }
    @Then ("validate dealing with Euro currency")
    public void validateEurochange() throws InterruptedException {
        Thread.sleep(3000);
        Assert.assertTrue(loggedUser.validateCurrChange("€"));
    }

    @And ("user click on Currency dropdown list and choose US currency")
    public void toUSCurrency() throws InterruptedException {
        loggedUser.changeCurrency("US Dollar");
    }
    @Then ("validate dealing with US currency")
     public void validateUSchange(){
        Assert.assertTrue(loggedUser.validateCurrChange("$"));
    }
    @And("user click on random category")
    public void clickRandomCategory() throws InterruptedException {
        loggedUser.chooseRandomCategory();
    }

   // @When("^user enter \"(.*)\" and \"(.*)\" then click on login button$")
   /* @When("^user click on product \"(.*)\"$")
    public void clickOnProduct(String prodName){
        loggedUser.clickOnProduct(prodName);
    }
    @And("user click on add to cart button")
    public void clickOnAddToCartBtn() throws InterruptedException {
        loggedUser.clickOnAddToCart();
        Thread.sleep(3000);
    }
    @Then("^product \"(.*)\" shall be added to cart$")
    public void validateProductAddedToCart(String Name) throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.className("content")).getText().contains("The product has been added to your "));
        Thread.sleep(3000);
        driver.findElement(By.className("cart-label")).click();
        //1. get no of rows
        //2. get no of cols
        //3. iterate over rows and cols
        //4. get text

      List<WebElement> rowElements= driver.findElements(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr"));
      int rowsCount=rowElements.size();
     // System.out.println(rowsCount);

      List<WebElement> colElements= driver.findElements(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr[1]/td"));
      int colCount=colElements.size();

        //no of rows--//*[@id="shopping-cart-form"]/div[1]/table/tbody/tr
        //no of cols==//*[@id="shopping-cart-form"]/div[1]/table/tbody/tr[1]/td
       int j=3;
        for(int i=1; i<=rowsCount; i++){
            String productName=driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr["+ i +"]/td["+ j +"]")).getText();
           if(productName.contains(Name)){
               Assert.assertTrue(productName.contains(Name));
           }
        }

        /*
        for(int i=1; i<=rowsCount; i++){
            for(int j=1; j<=colCount;j++){
                String productName=driver.findElement(By.xpath("//*[@id=\\\"shopping-cart-form\\\"]/div[1]/table/tbody/tr[\"+ i +\"]/td[\"+ j +\"]")).getText();
                System.out.println(driver.findElement(By.xpath("//*[@id=\"shopping-cart-form\"]/div[1]/table/tbody/tr["+ i +"]/td["+ j +"]")).getText());
            }
        }*/

/**********
    }
    @When("user click on add to wishlist button")
    public void clickOnAddToWishlist() throws InterruptedException {
        loggedUser.clickOnAddToWishlist();
        Thread.sleep(3000);
    }
    @And("^product \"(.*)\" shall be added to wishlist$")
    public void validateProductAddedToWishlist(String Name) throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//p//a[@href=\"/wishlist\"]")).getText().contains("wishlist"));
        Thread.sleep(3000);
        driver.findElement(By.className("ico-wishlist")).click();

    //no of rows: /html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr
    // no of cols:  /html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr[1]/td
        List<WebElement> rowElements= driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr"));
        int rowsCount=rowElements.size();
        // System.out.println(rowsCount);

        List<WebElement> colElements= driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr[1]/td"));
        int colCount=colElements.size();

        int j=3;
        for(int i=1; i<=rowsCount; i++){
            String productName=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div/div/div[2]/div[1]/form/div[1]/table/tbody/tr["+i+"]/td[4]")).getText();
            if(productName.contains(Name)){
                Assert.assertTrue(productName.contains(Name));
            }
        }
    }

    @When("user click on add to compareList button")
    public void clickOnAddToComparelist() throws InterruptedException {
        loggedUser.clickOnAddToComparelist();
        Thread.sleep(3000);
    }

    @And("^product \"(.*)\" shall be added to compareList$")
    public void validateProductAddedToComparelist(String Name) throws InterruptedException {
        Assert.assertTrue(driver.findElement(By.xpath("//p//a[@href=\"/compareproducts\"]")).getText().contains("product comparison"));
        driver.findElement(By.xpath("/html/body/div[6]/div[4]/div[1]/div[2]/ul/li[5]/a")).click();

        Thread.sleep(3000);
        //no of rows:/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr
        //no of cols: /html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td

        List<WebElement> rowElements= driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr"));
        int rowsCount=rowElements.size();
         System.out.println("no of rows : "+rowsCount);

        List<WebElement> colElements= driver.findElements(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[1]/td"));
        int colCount=colElements.size();
        System.out.println("no of cols : "+colCount);

        int j=3;
        for(int i=1; i<=colCount; i++){
            String productName=driver.findElement(By.xpath("/html/body/div[6]/div[3]/div/div[2]/div/div[2]/div/table/tbody/tr[3]/td["+i+"]")).getText();
            if(productName.contains(Name)){
                Assert.assertTrue(productName.contains(Name));
                System.out.println(productName);
            }
        }
    }*/
}
