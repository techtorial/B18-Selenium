package com.test.saucelab.tests;

import org.testng.annotations.DataProvider;

public class SauceAllData {

    @DataProvider(name = "positiveLogin")
    public Object[][] getDataPositiveLogin(){
        return new Object[][]{
                {"standard_user","secret_sauce","https://www.saucedemo.com/inventory.html","Swag Labs"},
                {"problem_user","secret_sauce","https://www.saucedemo.com/inventory.html","Swag Labs"},
                {"performance_glitch_user","secret_sauce","https://www.saucedemo.com/inventory.html","Swag Labs"},
                {"error_user","secret_sauce","https://www.saucedemo.com/inventory.html","Swag Labs"},
                {"visual_user","secret_sauce","https://www.saucedemo.com/inventory.html","Swag Labs"}
        };
    }
}
