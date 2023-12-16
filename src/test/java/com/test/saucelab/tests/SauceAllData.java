package com.test.saucelab.tests;

import org.testng.annotations.DataProvider;

public class SauceAllData {

    @DataProvider(name = "positiveLogin")
    public Object[][] getDataPositiveLogin() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html", "Swag Labs"},
                {"problem_user", "secret_sauce", "https://www.saucedemo.com/inventory.html", "Swag Labs"},
                {"performance_glitch_user", "secret_sauce", "https://www.saucedemo.com/inventory.html", "Swag Labs"},
                {"error_user", "secret_sauce", "https://www.saucedemo.com/inventory.html", "Swag Labs"},
                {"visual_user", "secret_sauce", "https://www.saucedemo.com/inventory.html", "Swag Labs"}
        };
    }

    @DataProvider(name = "negativeLogin")
    public Object[][] getDataNegativeLogin() {
        return new Object[][]{
                {"wrongusername", "secret_sauce", "Epic sadface: Username and password do not match any user in this service"},
                {"", "wrongpassword", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"},
                {"", "", "Epic sadface: Username is required"},
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
        };
    }

    @DataProvider(name = "productinformation")
    public Object[][] getDataProductInformation() {
        return new Object[][]{
                {"Sauce Labs Backpack","Sly Pack","$29.99"},
                {"Sauce Labs Bike Light","3 lighting modes","$9.99"},
        };
    }
}






