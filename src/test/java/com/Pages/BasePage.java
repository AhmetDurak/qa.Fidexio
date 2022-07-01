package com.Pages;

import com.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(name = "login")
    public WebElement email;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(css = "button[type='submit']")
    public WebElement login;

    @FindBy(css = "a.btn.btn-link")
    public WebElement resetPassword;

    @FindBy(css = ".oe_topbar_name")
    public WebElement user_id;

    @FindBy (css = "p.alert")
    public WebElement wrongLoginPassword;






    /**
     * This method will enter username and password
     * This method accepts only one parameter
     * @param credentials
     */
    private String usernameCheck = "";
    private String passwordCheck = "";
    public void sendUsernameAndPassword(Map<String,String> credentials){
        List<String> listCredentials = new ArrayList<>();

        for (String keys: credentials.keySet()){
            listCredentials.add(keys);
            usernameCheck = keys;
            listCredentials.add(credentials.get(keys));
            passwordCheck = credentials.get(keys);
        }

        this.email.sendKeys(listCredentials.get(0));
        this.password.sendKeys(listCredentials.get(1));
    }

    /**
     * This method will return  password
     */
    public String getUsernameCheck(){
        return usernameCheck;
    }
    /**
     * This method will return password
     */
    public String getPasswordCheck(){
        return passwordCheck;
    }

}
