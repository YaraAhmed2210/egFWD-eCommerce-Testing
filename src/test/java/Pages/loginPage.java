package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class loginPage {
    WebDriver driver;

    public loginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement get_UsernameEle(){
        By username=By.id("Email");
        WebElement userNameEle=driver.findElement(username);
        return userNameEle;
    }
    public WebElement get_PasswordEle(){
        By password=By.id("Password");
        WebElement passwordEle=driver.findElement(password);
        return passwordEle;
    }
    public WebElement get_LoginBtnEle(){
        By loginBtn=By.className("login-button");
      //  By loginBtn=By.linkText("Log in");
        WebElement loginBtnEle=driver.findElement(loginBtn);

        return loginBtnEle;
    }


    public void loginSteps(String username, String password) throws InterruptedException {
        get_UsernameEle().clear();
        get_UsernameEle().sendKeys(username);
        get_PasswordEle().sendKeys(password);

        get_LoginBtnEle().click();
        Thread.sleep(3000);
    }

    public void resetPassword(String email){
        get_UsernameEle().sendKeys(email);

    }
}
