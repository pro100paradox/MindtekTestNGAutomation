package tests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.SauceDemoHomePage;
import pages.SauceDemoLoginPage;
import utilities.ConfigReader;
import utilities.TestBase;

public class SauceDemoTests extends TestBase {

    @Test(groups = {"regression","smoke"})
    public void loginTest(){
        SauceDemoLoginPage sauceDemoLoginPage = new SauceDemoLoginPage();
        SauceDemoHomePage sauceDemoHomePage = new SauceDemoHomePage();
        driver.get(ConfigReader.getProperty("SauceDemoURL"));
        sauceDemoLoginPage.username.sendKeys(ConfigReader.getProperty("SauceDemoUser"));
        sauceDemoLoginPage.password.sendKeys(ConfigReader.getProperty("SauceDemoPassword"));
        sauceDemoLoginPage.loginButton.click();

        String actualPageTitle = sauceDemoHomePage.pageTitle.getText();
        String expectedPageTitle = "PRODUCTS";

        Assert.assertEquals(actualPageTitle,expectedPageTitle);





    }
}
