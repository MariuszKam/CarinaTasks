package com.solvd.laba;

import com.solvd.laba.web.cart.CartPage;
import com.solvd.laba.web.cart.components.CartItem;
import com.solvd.laba.web.checkout.CheckoutCompletePage;
import com.solvd.laba.web.checkout.CheckoutInformationPage;
import com.solvd.laba.web.checkout.CheckoutOverviewPage;
import com.solvd.laba.web.login.LogPage;
import com.solvd.laba.web.products.ProductsPage;
import com.solvd.laba.web.login.components.LogPanel;
import com.solvd.laba.web.products.components.InventoryContainer;
import com.solvd.laba.web.products.components.PrimaryHeaderContainer;
import com.solvd.laba.web.products.components.SecondHeaderContainer;
import com.zebrunner.carina.core.AbstractTest;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTest extends AbstractTest {

    /**First test
     *Testing login with valid credential
     * Steps:
     * 1. Open login page
     * 2. Fill user and password with correct data, and press login button
     * 3. Check if url is correct with products page(means login was successful
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    public void logTestCorrect() {
        LogPage logPage = new LogPage(getDriver());
        logPage.open();
        LogPanel logPanel = logPage.getLogBody().getLogPanel();
        logPanel.pageLogin(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        Assert.assertEquals(getDriver().getCurrentUrl(), R.TESTDATA.get("products_page_url"));
    }

    /**Second test
     *Testing login with invalid credential
     * Steps:
     * 1. Open login page
     * 2. Fill user and password with incorrect data, and press login button
     * 3. Check if url is correct, and error displayed
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    public void logTestIncorrect() {
        LogPage logPage = new LogPage(getDriver());
        logPage.open();
        LogPanel logPanel = logPage.getLogBody().getLogPanel();
        logPanel.pageLogin(R.TESTDATA.get("incorrect_user"), R.TESTDATA.get("incorrect_password"));
        Assert.assertTrue(logPanel.isErrorOutputVisible(), "Error isn't visible");
        Assert.assertEquals(getDriver().getCurrentUrl(), R.TESTDATA.get("home_url"));
    }

    /**Third test
     *Sorting products
     * Steps:
     * Log in to the site using correct data
     * Navigate to the Products page
     * Verify that the products are displayed
     * Sort the products by price (lowest->highest) criteria.
     * Check if display change.
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    public void sortAscPriceTest() {
        logTestCorrect();
        ProductsPage productsPage = new ProductsPage(getDriver());
        InventoryContainer inventoryContainer = productsPage.getProductsBody().getInventoryContainer();
        Assert.assertTrue(inventoryContainer.areProductsDisplayed(), "Products are not displayed");
        List<Double> startPrices = inventoryContainer.getProductPrices();
        SecondHeaderContainer secondHeaderContainer = productsPage.getProductsBody().getSecondHeaderContainer();
        secondHeaderContainer.setSortSelect(R.TESTDATA.get("product_selector"));
        List<Double> endPrices = inventoryContainer.getProductPrices();
        Assert.assertNotEquals(startPrices, endPrices);
        Assert.assertTrue(inventoryContainer.checkPriceAsc(endPrices), "Prices are not in ascending order");
    }

    /**Fourth test
     *Add items to cart
     * Steps:
     * Log in(as always)
     * Navigate to the Products page
     * Verify that the products are displayed.
     * Verify if button are "Add to Cart"
     * Click buy button for each product
     * Verify if button are "Remove"
     * Navigate to cart
     * Check if cart has same number of products
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    public void testCart() {
        logTestCorrect();
        ProductsPage productsPage = new ProductsPage(getDriver());
        InventoryContainer inventoryContainer = productsPage.getProductsBody().getInventoryContainer();
        Assert.assertTrue(inventoryContainer.areProductsDisplayed(), "Products are not displayed");
        Assert.assertTrue(inventoryContainer.checkAddButtonDisplay(), "Add buttons are not displayed");
        inventoryContainer.buyAll();
        Assert.assertTrue(inventoryContainer.checkRemoveButtonDisplay(), "Buttons didn't change!");
        int products = inventoryContainer.getProducts().size();
        PrimaryHeaderContainer primaryHeaderContainer = productsPage.getProductsBody().getPrimaryHeaderContainer();
        CartPage cartPage = primaryHeaderContainer.clickCartButton();
        List<CartItem> cartProducts = cartPage.getCartItems();
        Assert.assertTrue(cartPage.sameSizeAsPicked(products, cartProducts.size()), "Picked products does not match cart item size");
    }

    /**Fifth test
     *Test checkout
     * Steps:
     * Log in(as always)
     * Navigate to the Products page
     * Click buy button for each product
     * Navigate to cart
     * Process checkout - Fill up information and press continue, finish, check if page accepted order
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    public void testCheckout() {
        logTestCorrect();
        ProductsPage productsPage = new ProductsPage(getDriver());
        InventoryContainer inventoryContainer = productsPage.getProductsBody().getInventoryContainer();
        inventoryContainer.buyAll();
        PrimaryHeaderContainer primaryHeaderContainer = productsPage.getProductsBody().getPrimaryHeaderContainer();
        CartPage cartPage = primaryHeaderContainer.clickCartButton();
        CheckoutInformationPage checkoutInformationPage = cartPage.clickCheckout();
        CheckoutOverviewPage checkoutOverviewPage = checkoutInformationPage.checkout(R.TESTDATA.get("first_name"),
                R.TESTDATA.get("last_name"),
                R.TESTDATA.get("postal_code"));
        CheckoutCompletePage checkoutCompletePage = checkoutOverviewPage.clickFinishButton();
        Assert.assertTrue(checkoutCompletePage.isCompletedDisplay(), "It does not display transaction completed");
    }

    /**Sixth test
     *Test logout
     * Steps:
     * Log in(as always)
     * Open menu and just logout
     * Check if url is homepage
     */
    @Test
    @MethodOwner(owner = "Mariusz")
    public void testLogout() {
        logTestCorrect();
        ProductsPage productsPage = new ProductsPage(getDriver());
        LogPage logPage = productsPage.getProductsBody().getPrimaryHeaderContainer().clickLogOut();
        Assert.assertEquals(logPage.getCurrentUrl(), R.TESTDATA.get("home_url"), "Did not logout!");
    }





}
