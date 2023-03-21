package com.qaprosoft.carina.demo.gui.pages.TAU;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HoverPage extends AbstractPage {

    @FindBy(className = "figure")
    private List<ExtendedWebElement> figures;
    @FindBy(className = "figcaption")
    private ExtendedWebElement figCaption;
    public HoverPage (WebDriver driver){
        super(driver);
    }

    public FigureCaption hoverToElement(int index){
        ExtendedWebElement figToHover = figures.get(index);
        figToHover.hover();
        return new FigureCaption(figToHover.findExtendedWebElement(figCaption.getBy()));
    }
    public class FigureCaption{
        private ExtendedWebElement caption;
        public FigureCaption(ExtendedWebElement caption){
            this.caption = caption;
        }
        public boolean isCaptionDisplayed(){
            return caption.isVisible();
        }
        public String getTitle(){
            return caption.findExtendedWebElement(By.tagName("h5")).getText();
        }
        public String getLinkText(){
            return caption.findExtendedWebElement(By.tagName("a")).getText();
        }
        public String getLink(){
            return caption.findExtendedWebElement(By.tagName("a")).getAttribute("href");
        }
    }
}
