package com.solvd.laba.web.products.components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import lombok.Getter;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


@Getter
public class SecondHeaderContainer extends AbstractUIObject {

    @FindBy(xpath = ".//*[@class = 'product_sort_container']")
    private ExtendedWebElement sortSelect;


    public SecondHeaderContainer(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void setSortSelect(String  value) {
        Select select = new Select(sortSelect.getElement());
        select.selectByValue(value);
    }
}
