package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.StoreAppHomePage;
import pages.StoreAppShoppingCartPage;
import utilities.BrowserUtils;
import utilities.ConfigReader;
import utilities.DataUtils;
import utilities.TestBase;

public class StoreAddCartTests extends TestBase {

    @Test(groups = {"regression"})
    public void addCartFunctionalityTest1() throws Exception {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppShoppingCartPage storeAppShoppingCartPage = new StoreAppShoppingCartPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        String itemPrice = storeAppHomePage.prices1.get(0).getText();

        BrowserUtils.hoverOver(storeAppHomePage.itemWindow1);
        storeAppHomePage.addToCartItem1.click();


        String actualSuccessMessageText = BrowserUtils.waitElementToBeVisible(storeAppHomePage.actualSuccessMessage).getText();
        System.out.println(actualSuccessMessageText);
        String expectedSuccessMessageText = "Product successfully added to your shopping cart";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualSuccessMessageText, expectedSuccessMessageText);

        String quantity = storeAppHomePage.productQuantity.getText();
        String total = storeAppHomePage.productTotalPrice.getText();


        double itemPriceDouble = DataUtils.remove$AndConvertToDouble(itemPrice);
        double quantityDouble = Double.parseDouble(quantity);

        double totalDouble = DataUtils.remove$AndConvertToDouble(total);

        double expectedPrice = itemPriceDouble * quantityDouble;
        double actualPrice = totalDouble;

        softAssert.assertEquals(actualPrice, expectedPrice);

        storeAppHomePage.proceedToCheckout.click();

        String totalProduct = storeAppShoppingCartPage.totalProduct.getText();
        double totalProductDouble = DataUtils.remove$AndConvertToDouble(totalProduct);
        Assert.assertEquals(actualPrice, totalProductDouble);

        String shippingAmount = storeAppShoppingCartPage.totalShipping.getText();
        double shippingAmountDouble = DataUtils.remove$AndConvertToDouble(shippingAmount);

        String taxAmount = storeAppShoppingCartPage.tax.getText();
        double taxAmountDouble = DataUtils.remove$AndConvertToDouble(taxAmount);

        String actualTotal = storeAppShoppingCartPage.totalPrice.getText();
        double actualTotalDouble = DataUtils.remove$AndConvertToDouble(actualTotal);

        double expectedTotal = totalProductDouble + shippingAmountDouble + taxAmountDouble;

        softAssert.assertEquals(actualTotalDouble, expectedTotal);

        softAssert.assertAll();
    }

 //   @Test(groups = {"regression"})
    public void addCartFunctionalityTest2() throws Exception {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppShoppingCartPage storeAppShoppingCartPage = new StoreAppShoppingCartPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        String itemPrice1 = storeAppHomePage.prices1.get(0).getText();
        String itemPrice2 = storeAppHomePage.prices2.get(0).getText();
        double itemPriceDouble1 = DataUtils.remove$AndConvertToDouble(itemPrice1);
        double itemPriceDouble2 = DataUtils.remove$AndConvertToDouble(itemPrice2);
        double totalPriceOfItems = itemPriceDouble1+itemPriceDouble2;

        BrowserUtils.hoverOver(storeAppHomePage.itemWindow1);
        storeAppHomePage.addToCartItem1.click();

        storeAppHomePage.continueShoppingButton.click();
        BrowserUtils.hoverOver(storeAppHomePage.itemWindow2);
        storeAppHomePage.addToCartItem2.click();

        String actualNumberOfItemsAdded = BrowserUtils.waitElementToBeVisible(storeAppHomePage.numberOfItemsAdded).getText();
        String expectedNumberOfItemsAdded = "There are 2 items in your cart.";

        Assert.assertEquals(actualNumberOfItemsAdded,expectedNumberOfItemsAdded);

        String totalProductsValue = storeAppHomePage.productTotalPrice.getText();
        double totalDoubleProductsValue = DataUtils.remove$AndConvertToDouble(totalProductsValue);

        Assert.assertEquals(totalPriceOfItems,totalDoubleProductsValue);

    }
}
