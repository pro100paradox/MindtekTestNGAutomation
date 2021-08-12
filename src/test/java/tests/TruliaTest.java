package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TruliaAppHomePage;
import pages.TruliaAppSearchResultPage;
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

    @Test
    public void test3() throws InterruptedException {
        TruliaAppHomePage truliaAppHomePage = new TruliaAppHomePage();
        TruliaAppSearchResultPage truliaAppSearchResultPage = new TruliaAppSearchResultPage();
        driver.get("https://www.trulia.com/");
        truliaAppHomePage.topBuyButton.click();
        truliaAppSearchResultPage.topSearchBox.click();
        truliaAppSearchResultPage.topSearchBox.sendKeys("$$$$$$$$$$$$$$$$$$$$$$$$$" + Keys.ENTER);
        Thread.sleep(3000);
        String actualHeadingMessage = truliaAppSearchResultPage.serverIssueHeader.getText();
        System.out.println(actualHeadingMessage);
        String expectedHeadingMessage = "Our servers had an issue with your request.";
        Assert.assertEquals(actualHeadingMessage, expectedHeadingMessage, "Actual Heading doesn't mach to the requirements");
    }

    @Test
    public void test4() throws InterruptedException {
        TruliaAppHomePage truliaAppHomePage = new TruliaAppHomePage();
        TruliaAppSearchResultPage truliaAppSearchResultPage = new TruliaAppSearchResultPage();
        driver.get("https://www.trulia.com/");
        truliaAppHomePage.topBuyButton.click();
        truliaAppSearchResultPage.topSearchBox.click();
        truliaAppSearchResultPage.topSearchBox.sendKeys("asdfhjwkeutoaigjhetagjtksjto195893jghabgnfhdjroqptkgn245jghajgktlfjahlsdfasdfagfjkgasd;glkjfdlgkddslkfjfjglksajfadkjfsdgka" + Keys.ENTER);
        Thread.sleep(3000);
        String actualHeadingMessage = truliaAppSearchResultPage.serverIssueHeader.getText();
        System.out.println(actualHeadingMessage);
        String expectedHeadingMessage = "Our servers had an issue with your request.";
        Assert.assertEquals(actualHeadingMessage, expectedHeadingMessage, "Actual Heading doesn't mach to the requirements");
    }

    @Test
    public void test5() throws InterruptedException {

        //1.    Navigate to the webpage
        TruliaAppHomePage truliaAppHomePage = new TruliaAppHomePage();
        TruliaAppSearchResultPage truliaAppSearchResultPage = new TruliaAppSearchResultPage();
        driver.get(ConfigReader.getProperty("TruliaURL"));
        //2. User provides more than 5 numbers as a zipcode for search box
        truliaAppHomePage.searchBox.click();
        truliaAppHomePage.searchBox.sendKeys("112145" + Keys.ENTER);
        truliaAppSearchResultPage.searchBox2.click();
        Thread.sleep(3000);
        truliaAppSearchResultPage.searchBox2.sendKeys("112145" + Keys.ENTER);
        String actualMessage = driver.findElement(By.xpath("//div[contains(text(), 'Our servers had an issue with your request.')]")).getText();
        String expectedMessage = "Our servers had an issue with your request.";
        Assert.assertEquals(actualMessage, expectedMessage);

    }
}
