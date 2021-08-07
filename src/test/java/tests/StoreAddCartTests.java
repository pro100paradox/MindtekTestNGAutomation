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
    public void addCartFunctionalityTest() throws Exception {
        StoreAppHomePage storeAppHomePage = new StoreAppHomePage();
        StoreAppShoppingCartPage storeAppShoppingCartPage = new StoreAppShoppingCartPage();
        driver.get(ConfigReader.getProperty("StoreAppURL"));
        String itemPrice = storeAppHomePage.prices.get(1).getText();

        BrowserUtils.hoverOver(storeAppHomePage.itemWindow1);
        storeAppHomePage.addToCartItem1.click();


        String actualSuccessMessageText =  BrowserUtils.waitElementToBeVisible(storeAppHomePage.actualSuccessMessage).getText();
        System.out.println(actualSuccessMessageText);
        String expectedSuccessMessageText = "Product successfully added to your shopping cart";

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(actualSuccessMessageText,expectedSuccessMessageText);

        String quantity = storeAppHomePage.productQuantity.getText();
        String total = storeAppHomePage.productTotalPrice.getText();


        double itemPriceDouble = DataUtils.remove$AndConvertToDouble(itemPrice);
        double quantityDouble = Double.parseDouble(quantity);

        double totalDouble = DataUtils.remove$AndConvertToDouble(total);

        double expectedPrice = itemPriceDouble*quantityDouble;
        double actualPrice = totalDouble;

        softAssert.assertEquals(actualPrice,expectedPrice);

        storeAppHomePage.proceedToCheckout.click();

       String totalProduct = storeAppShoppingCartPage.totalProduct.getText();
       double totalProductDouble = DataUtils.remove$AndConvertToDouble(totalProduct);
       Assert.assertEquals(actualPrice,totalProductDouble);

       String shippingAmount = storeAppShoppingCartPage.totalShipping.getText();
       double shippingAmountDouble = DataUtils.remove$AndConvertToDouble(shippingAmount);

       String taxAmount = storeAppShoppingCartPage.tax.getText();
       double taxAmountDouble = DataUtils.remove$AndConvertToDouble(taxAmount);

       String actualTotal = storeAppShoppingCartPage.totalPrice.getText();
       double actualTotalDouble = DataUtils.remove$AndConvertToDouble(actualTotal);

       double expectedTotal = totalProductDouble+shippingAmountDouble+taxAmountDouble;

       softAssert.assertEquals(actualTotalDouble,expectedTotal);

       softAssert.assertAll();







    }




}
