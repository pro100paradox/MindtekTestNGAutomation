package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tests.SauceDemoTests;
import utilities.Driver;

public class SauceDemoHomePage {

    public SauceDemoHomePage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//span[@class='title']")
    public WebElement pageTitle;

}
