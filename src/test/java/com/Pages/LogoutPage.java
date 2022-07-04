package com.Pages;

import com.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage extends BasePage{
    public LogoutPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(css = ".modal-title")
    public WebElement getAlert;
}
