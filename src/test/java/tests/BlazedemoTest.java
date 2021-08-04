package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BlazedemoFlightsPage;
import pages.BlazedemoHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

import java.util.List;

public class BlazedemoTest extends TestBase {



    @Test(groups = {"regression"})
    public void test1() {
        BlazedemoHomePage blazeDemoHomePage = new BlazedemoHomePage();
        BlazedemoFlightsPage blazedemoFlightsPage = new BlazedemoFlightsPage();
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));
        blazeDemoHomePage.findFlightsButton.click();
        List<WebElement> FlightsPrices = blazedemoFlightsPage.FlightsPrices;

        for (WebElement element : FlightsPrices) {
            String priceStr = element.getText(); // $472.56 == String -> int == Integer.parseInt(String); -> int
            priceStr = priceStr.substring(1);
            double priceDouble = Double.parseDouble(priceStr);

            Assert.assertTrue(priceDouble < 1000);
        }
    }
        @Test(groups = {"regression"})
                public void test2(){
            BlazedemoHomePage blazeDemoHomePage = new BlazedemoHomePage();
            BlazedemoFlightsPage blazedemoFlightsPage = new BlazedemoFlightsPage();
        driver.get(ConfigReader.getProperty("BlazeDemoURL"));

            Select select = new Select(blazeDemoHomePage.fromCityDropdown);
            select.selectByValue("Boston");
            select = new Select(blazeDemoHomePage.toCityDropdown);
            select.selectByValue("London");
            blazeDemoHomePage.findFlightsButton.click();
            String actualText = blazedemoFlightsPage.flightsHeaderText.getText();
            String expectedText = "Flights from Boston to London:";

            Assert.assertEquals(actualText,expectedText);

















        }




    }
