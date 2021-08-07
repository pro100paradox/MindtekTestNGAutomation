package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TruliaSearchPage {

    public TruliaSearchPage(){
        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//*[@id='resultsColumn']/div[1]/div[1]")
    public WebElement serverIssueHeader;

    @FindBy(id = "locationInputs")
    public WebElement topSearchBox;

}
