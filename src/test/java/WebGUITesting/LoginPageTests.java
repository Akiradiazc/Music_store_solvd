package com.qaprosoft.carina.demo.TAUtests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.TAU.HomePageTwo;
import com.qaprosoft.carina.demo.gui.pages.TAU.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.TAU.SecureAreaPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class LoginPageTests implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "gg")
    @TestPriority(Priority.P3)
    @TestLabel(name = "Login", value = {"web", "regression"})
    public void testLoginPage(){
        HomePageTwo homePage = new HomePageTwo(getDriver());
        homePage.open();
        LoginPage loginPage = homePage.clickLoginLink();
        loginPage.setUsername("tomsmith");
        loginPage.setPassword("SuperSecretPassword!");
        SecureAreaPage secureAreaPage = loginPage.clickButton();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(secureAreaPage.getAlertText().contains("You logged into a secure area!"), "F");
    }

    @Test()
    @MethodOwner(owner = "gg")
    @TestPriority(Priority.P3)
    @TestLabel(name = "Open Page", value = {"web", "regression"})
    public void testPageIsOpen(){
        HomePageTwo homePage = new HomePageTwo(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened");
    }
}
