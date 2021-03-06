package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TruliaAppSearchResultPage {

    public TruliaAppSearchResultPage() {

        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@type='text']")
    public WebElement searchBox2;

    @FindBy(xpath = "//*[@id='resultsColumn']/div[1]/div[1]")
    public WebElement serverIssueHeader;

    @FindBy(id = "locationInputs")
    public WebElement topSearchBox;
}
