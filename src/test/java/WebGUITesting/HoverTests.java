package com.qaprosoft.carina.demo.TAUtests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.gui.pages.TAU.HomePageTwo;
import com.qaprosoft.carina.demo.gui.pages.TAU.HoverPage;
import com.zebrunner.agent.core.annotation.TestLabel;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.core.registrar.tag.Priority;
import com.zebrunner.carina.core.registrar.tag.TestPriority;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HoverTests implements IAbstractTest {
    @Test()
    @MethodOwner(owner = "gg")
    @TestPriority(Priority.P3)
    @TestLabel(name = "Hover", value = {"web", "regression"})
    public void hoverTest(){
        HomePageTwo homePageTwo = new HomePageTwo(getDriver());
        homePageTwo.open();
        HoverPage hoverPage = homePageTwo.clickHoverPage();
        var caption = hoverPage.hoverToElement(0);

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(caption.isCaptionDisplayed());
        softAssert.assertEquals(caption.getTitle(), "name: user2", "F");
        softAssert.assertEquals(caption.getLinkText(), "View profile", "F");
        softAssert.assertTrue(caption.getLink().endsWith("/users/1"), "F");
    }
}
