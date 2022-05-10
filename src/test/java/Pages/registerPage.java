package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class registerPage {
    WebDriver driver;

    public registerPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement get_genderRadioBtn(){
        By gender=By.id("gender-female");
        WebElement genderEle=driver.findElement(gender);
        return genderEle;
    }

    public WebElement get_firstNameEle(){
        By firstName=By.id("FirstName");
        WebElement firstNameEle=driver.findElement(firstName);
        return firstNameEle;
    }
    public WebElement get_lastNameEle(){
        By lastName=By.id("LastName");
        WebElement lastNameEle=driver.findElement(lastName);
        return lastNameEle;
    }

    public WebElement get_dayBirthEle(){
        By day=By.name("DateOfBirthDay");
        WebElement dayEle=driver.findElement(day);
        return dayEle;
    }

    public WebElement get_monthBirthEle(){
        By month=By.name("DateOfBirthMonth");
        WebElement monthEle=driver.findElement(month);
        return monthEle;
    }
    public WebElement get_yearBirthEle(){
        By year=By.name("DateOfBirthYear");
        WebElement yearEle=driver.findElement(year);
        return yearEle;
    }

    public WebElement get_emailEle(){
        By mail=By.id("Email");
        WebElement mailEle=driver.findElement(mail);
        return mailEle;
    }


    public WebElement get_pass1Ele(){
        By pass1=By.id("Password");
        WebElement pass1Ele=driver.findElement(pass1);
        return pass1Ele;
    }

    public WebElement get_pass2Ele(){
        By pass2=By.id("ConfirmPassword");
        WebElement pass2Ele=driver.findElement(pass2);
        return pass2Ele;
    }

    public void registerData(String firstName, String lastName,String day, String month, String year, String email, String pass, String confirmPass){
        get_genderRadioBtn().click();
        get_firstNameEle().sendKeys(firstName);
        get_lastNameEle().sendKeys(lastName);

        Select drpDay= new Select(get_dayBirthEle());
        Select drpMonth= new Select(get_monthBirthEle());
        Select drpYear= new Select(get_yearBirthEle());

        drpDay.selectByValue(day);
        drpMonth.selectByValue(month);
        drpYear.selectByValue(year);

        get_emailEle().sendKeys(email);
        get_pass1Ele().sendKeys(pass);
        get_pass2Ele().sendKeys(confirmPass);

        driver.findElement(By.id("register-button")).click();
    }




}
