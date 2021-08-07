package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TruliaAppHomePage;
import pages.TruliaSearchPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
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

    @Test
    public void test3() throws InterruptedException {
        TruliaAppHomePage truliaAppHomePage = new TruliaAppHomePage();
        TruliaSearchPage truliaSearchPage = new TruliaSearchPage();
        driver.get("https://www.trulia.com/");
        truliaAppHomePage.topBuyButton.click();
        truliaSearchPage.topSearchBox.click();
        truliaSearchPage.topSearchBox.sendKeys("$$$$$$$$$$$$$$$$$$$$$$$$$"+Keys.ENTER);
        Thread.sleep(3000);
        String actualHeadingMessage = truliaSearchPage.serverIssueHeader.getText();
        System.out.println(actualHeadingMessage);
        String expectedHeadingMessage = "Our servers had an issue with your request.";
        Assert.assertEquals(actualHeadingMessage, expectedHeadingMessage, "Actual Heading doesn't mach to the requirements");
    }

    @Test
    public void test4() throws InterruptedException {
        TruliaAppHomePage truliaAppHomePage = new TruliaAppHomePage();
        TruliaSearchPage truliaSearchPage = new TruliaSearchPage();
        driver.get("https://www.trulia.com/");
        truliaAppHomePage.topBuyButton.click();
        truliaSearchPage.topSearchBox.click();
        truliaSearchPage.topSearchBox.sendKeys("asdfhjwkeutoaigjhetagjtksjto195893jghabgnfhdjroqptkgn245jghajgktlfjahl"+Keys.ENTER);
        Thread.sleep(3000);
        String actualHeadingMessage = truliaSearchPage.serverIssueHeader.getText();
        System.out.println(actualHeadingMessage);
        String expectedHeadingMessage = "Our servers had an issue with your request.";
        Assert.assertEquals(actualHeadingMessage, expectedHeadingMessage, "Actual Heading doesn't mach to the requirements");

    }

}
