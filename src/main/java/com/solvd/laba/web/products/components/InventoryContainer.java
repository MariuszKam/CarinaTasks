package com.solvd.laba.web.products.components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class InventoryContainer extends AbstractUIObject {

    @FindBy(className = "inventory_item")
    private List<Product> products;
    public InventoryContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean areProductsDisplayed() {
        return !products.isEmpty();
    }

    public List<Double> getProductPrices() {
        return products.stream()
                .map(Product::getPriceInDouble)
                .collect(Collectors.toList());
    }

    public boolean checkPriceAsc(List<Double> prices) {
        for (int i = 0; i < prices.size() - 1; i++) {
            double currentPrice = prices.get(i);
            double nextPrice = prices.get(i + 1);
            if (currentPrice > nextPrice) {
                return false;
            }
        }
        return true;
    }

    public void buyAll() {
        products.forEach(Product::clickBuyButton);
    }

    public boolean checkAddButtonDisplay() {
        return products.stream().allMatch(Product::isAddButtonDisplayed);
    }

    public boolean checkRemoveButtonDisplay() {
        return products.stream().allMatch(Product::isRemoveButtonDisplayed);
    }
}
