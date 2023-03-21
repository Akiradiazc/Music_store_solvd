package com.qaprosoft.carina.demo.gui.pages.TAU;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;


import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage extends AbstractPage {

    @FindBy(id = "dropdown")
    private ExtendedWebElement dropdown;

    public DropdownPage (WebDriver driver){
        super(driver);
    }

    public void selectFromDropdown(String option){
        findDropdownElement().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements = findDropdownElement().getAllSelectedOptions();
        return selectedElements
                .stream()
                .map(e->e.getText())
                .collect(Collectors.toList());
    }

    private Select findDropdownElement(){
        return new Select(driver.findElement(dropdown.getBy()));
        //return new Select((WebElement) dropdown);
    }
}
