package com.qaprosoft.carina.demo.TAUtests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.TAU.DropdownPage;
import com.qaprosoft.carina.demo.gui.pages.TAU.HomePageTwo;
import com.qaprosoft.carina.demo.gui.pages.TAU.LoginPage;
import com.qaprosoft.carina.demo.gui.pages.TAU.SecureAreaPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DropdownTests implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "gg")
    @TestPriority(Priority.P3)
    @TestLabel(name = "Dropdown", value = {"web", "regression"})
    public void testDropdownPage(){
        HomePageTwo homePage = new HomePageTwo(getDriver());
        homePage.open();
        DropdownPage dropdownPage = homePage.clickDropdown();
        String option = "Option 1";
        dropdownPage.selectFromDropdown(option);
        var selectedOptions = dropdownPage.getSelectedOptions();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(selectedOptions.size(), 1, "F");
        softAssert.assertTrue(selectedOptions.contains(option), "F");
    }
}
