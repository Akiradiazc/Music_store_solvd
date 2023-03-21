package com.qaprosoft.carina.demo.gui.pages.TAU;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePageTwo extends AbstractPage {

    @FindBy(xpath = "//a[text()='Form Authentication']")
    private ExtendedWebElement LoginLink;
    @FindBy(xpath = "//a[text()='Dropdown']")
    private ExtendedWebElement DropdownLink;
    @FindBy(xpath = "//a[text()='Hovers']")
    private ExtendedWebElement HoversLink;

    public HomePageTwo(WebDriver driver){
        super(driver);
    }

    public LoginPage clickLoginLink(){
        LoginLink.click();
        return new LoginPage(driver);
    }
    public DropdownPage clickDropdown(){
        DropdownLink.click();
        return new DropdownPage(driver);
    }
    public HoverPage clickHoverPage(){
        HoversLink.click();
        return new HoverPage(driver);
    }
}
