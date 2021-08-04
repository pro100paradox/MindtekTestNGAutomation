package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.StoreAppCreateAcc;
import pages.StoreAppHomePage;
import pages.StoreAppLoginPage;
import pages.StoreAppMyAccPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

import java.util.Random;

public class StoreRegisterFunctionalityTests extends TestBase {

    // Data Driven Testing - testing functionality with different sets of data.

    @DataProvider(name = "signUpDataProvider")
    public static Object[][] testData(){
        Object[][] data = new Object[][]{
                {"John", "Doe", "12341324",DataUtils.generateRandomNumber(30)+"","1","2021","123 Clark St.", "Chicago", "13","12345","21","123412451"}, // Set 1
                {"Kim","Yi","asdff","1","12","1980","2 MyRoad st."," New York","32","52351","21","412351553"},// Set 2
                {"Patel","Harsh","as234dff","1","12","2000","2 MyRoad st."," New York","32","52351","21","412351553"} // Set 3
        };
return data;
    }

    @Test(dataProvider = "signUpDataProvider", groups = {"regression","smoke"})
    public void test1(String firstName, String lastName, String password, String day, String month, String year, String address,
                      String city, String state, String zipCode, String country, String phoneNumber) {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppLoginPage storeAppLoginPage = new StoreAppLoginPage();
        StoreAppCreateAcc storeAppCreateAcc = new StoreAppCreateAcc();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        storeAppHomePage.loginButton.click();
        storeAppLoginPage.emailBox.sendKeys(DataUtils.generateEmail());
        storeAppLoginPage.submitButtom.click();
        storeAppCreateAcc.TitleBox.click();
        storeAppCreateAcc.FirstNameBox.sendKeys(firstName); //Kim
        storeAppCreateAcc.LastNameBox.sendKeys(lastName); // Yi

        storeAppCreateAcc.PasswordBox.sendKeys(password);// adsfadsfad, asdf12341234


        BrowserUtils.selectByValue(storeAppCreateAcc.daysBox, day);
        BrowserUtils.selectByValue(storeAppCreateAcc.monthsBox, month);
        BrowserUtils.selectByValue(storeAppCreateAcc.yearsBox, year);

        storeAppCreateAcc.address1Box.sendKeys(address);

        storeAppCreateAcc.cityBox.sendKeys(city);
        BrowserUtils.selectByValue(storeAppCreateAcc.stateBox, state);
        storeAppCreateAcc.postcodeBox.sendKeys(zipCode);
        BrowserUtils.selectByValue(storeAppCreateAcc.countryBox, country);
        storeAppCreateAcc.phoneMobileBox.sendKeys(phoneNumber);
        storeAppCreateAcc.RegisterButton.click();

        StoreAppMyAccPage storeAppMyAccPage = new StoreAppMyAccPage();

        String actualHeading = storeAppMyAccPage.HeadingMessage.getText();
        String expectedHeading = "MY ACCOUNT";

        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualHeading, expectedHeading, "Actual Heading " + actualHeading + " didn't match with Expected Heading " + expectedHeading);
        Assert.assertTrue(actualTitle.contains("My account - My Store"));


    }


}
