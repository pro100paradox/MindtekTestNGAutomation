package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.awt.print.PageFormat;

public class BlazedemoHomePage {

    // @FindBy annotation

    public BlazedemoHomePage(){
        WebDriver driver= Driver.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//input[@value='Find Flights']")
    public WebElement findFlightsButton;

    @FindBy(name = "fromPort")
    public WebElement fromCityDropdown;

    @FindBy(name = "toPort")
    public WebElement toCityDropdown;



}
