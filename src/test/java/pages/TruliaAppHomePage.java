package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class TruliaAppHomePage {
    public TruliaAppHomePage() {

        WebDriver driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

        @FindBy(xpath = "//button/div[contains(text(),'Buy')]")
        public WebElement buyButton;

    @FindBy(id = "banner-search")
    public WebElement searchBox;

    @FindBy(xpath = "//button/div[contains(text(),'Rent')]")
    public WebElement rentButton;

    @FindBy(xpath= "//*[@id='__next']/div[2]/header/nav/ul/li[1]/a")
    public WebElement topBuyButton;



    }
