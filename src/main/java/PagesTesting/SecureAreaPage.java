package com.qaprosoft.carina.demo.gui.pages.TAU;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SecureAreaPage extends AbstractPage {

    @FindBy(xpath = "//div[@id='flash']")
    private ExtendedWebElement messageAlert2;

    public SecureAreaPage(WebDriver driver){
        super(driver);
    }

    public String getAlertText(){
        return messageAlert2.getText();
    }

}
