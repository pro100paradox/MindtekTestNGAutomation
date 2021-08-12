package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.StoreAppContactUsPage;
import pages.StoreAppHomePage;
import utilities.ConfigReader;
import utilities.TestBase;

public class StoreTests extends TestBase {


    @Test(groups = {"regression", "smoke"})
    public void test1() {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppContactUsPage storeAppContactUsPage = new StoreAppContactUsPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.contactUsButton.click();
        Select select = new Select(storeAppContactUsPage.subjectheadingDropdown);
        select.selectByValue("2");
        storeAppContactUsPage.email.sendKeys(ConfigReader.getProperty("userGuru99"));
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        storeAppContactUsPage.fileUpload.sendKeys(projectPath + "/src/test/resources/testdata/bk13.jpeg");

        storeAppContactUsPage.message.sendKeys("Hello World");
        storeAppContactUsPage.submitButton.click();

        String actualSuccessMessage = storeAppContactUsPage.successMessage.getText();
        String expectedSuccessMessage = "Your message has been successfully sent to our team.";

        Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage);

        // Negative scenario for contact us
    }

    @Test(groups = {"regression", "smoke"})
    public void test2() {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppContactUsPage storeAppContactUsPage = new StoreAppContactUsPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.contactUsButton.click();
        Select select = new Select(storeAppContactUsPage.subjectheadingDropdown);
        select.selectByValue("2");
        storeAppContactUsPage.email.sendKeys(ConfigReader.getProperty("userGuru99"));
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        storeAppContactUsPage.fileUpload.sendKeys(projectPath + "/src/test/resources/testdata/bk13.jpeg");

        storeAppContactUsPage.submitButton.click();

        String actual = storeAppContactUsPage.errorMessage.getText();
        String expected = "The message cannot be blank.";

        Assert.assertEquals(actual, expected);
    }

    public void contactUs() {

    }
}
