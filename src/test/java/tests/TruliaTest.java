package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TruliaAppHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

public class TruliaTest extends TestBase {

    @Test
    public void test1() {
        TruliaAppHomePage truliaAppHomePage = new TruliaAppHomePage();
        driver.get("https://www.trulia.com/");
        truliaAppHomePage.buyButton.click();
        truliaAppHomePage.searchBox.click();
        truliaAppHomePage.searchBox.sendKeys("Chicago, IL" + Keys.ENTER);

        String actualHeading = driver.findElement(By.xpath("//*[@id='resultsColumn']/div[1]/div/h1/div")).getText();
        String expectedHeading = "Chicago, IL Homes For Sale & Real Estate";

        Assert.assertEquals(actualHeading, expectedHeading);

    }

    @Test
    public void test2() {
        TruliaAppHomePage truliaAppHomePage = new TruliaAppHomePage();
        driver.get("https://www.trulia.com/");
        truliaAppHomePage.rentButton.click();
        truliaAppHomePage.searchBox.click();
        truliaAppHomePage.searchBox.sendKeys("60641" + Keys.ENTER);
        String actualRenting = driver.findElement(By.xpath("//*[@id='resultsColumn']/div[1]/div/h1/div")).getText();
        String expected = "Apartments For Rent in 60641";

        Assert.assertEquals(actualRenting, expected);


    }

    public void test3() {
        TruliaAppHomePage truliaAppHomePage = new TruliaAppHomePage();
        driver.get("https://www.trulia.com/");
        truliaAppHomePage.buyButton.click();
        truliaAppHomePage.searchBox.click();
        truliaAppHomePage.searchBox.sendKeys("$$$$$$$$$$$$$$$$$$" + Keys.ENTER);


    }
}
