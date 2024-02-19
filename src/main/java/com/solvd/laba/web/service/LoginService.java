package com.solvd.laba.web.service;

import com.solvd.laba.web.login.LogPage;
import com.solvd.laba.web.products.ProductsPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.IDriverPool;

public class LoginService implements IDriverPool {

    private final LogPage logPage;

    public LoginService() {
        this.logPage = new LogPage(getDriver());
    }

    public ProductsPage successfulLogin() {
        LogPage logPage = new LogPage(getDriver());
        logPage.open();
        logPage.pageLogin(R.TESTDATA.get("correct_user"), R.TESTDATA.get("correct_password"));
        return new ProductsPage(getDriver());
    }
}
