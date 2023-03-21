package com.qaprosoft.carina.demo.gui.pages.TAU;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    @FindBy(xpath = "//button[@class='radius']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//input[@name='username']")
    private ExtendedWebElement usernameBox;

    @FindBy(xpath = "//input[@name='password']")
    private ExtendedWebElement passwordBox;

    public LoginPage (WebDriver driver){
        super(driver);
    }

    public void setUsername(String username){
       usernameBox.type(username);
    }

    public void setPassword(String password){
        passwordBox.type(password);
    }

    public SecureAreaPage clickButton(){
        loginButton.click();
        return new SecureAreaPage(driver);
    }
}
