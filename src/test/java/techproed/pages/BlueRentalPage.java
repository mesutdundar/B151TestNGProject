package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class BlueRentalPage {
    public BlueRentalPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "(//a[@role='button'])[1]")
    public WebElement login ;
    @FindBy(id = "formBasicEmail")
    public WebElement email;
    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginVerify;
    @FindBy(xpath = "//*[@role='alert']")
    public WebElement negativeLoginVerify;
    @FindBy(id = "dropdown-basic-button")
    public WebElement profilNameDdm;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[2]")
    public WebElement profilButtonVerify;
    @FindBy(xpath = "(//a[@class='dropdown-item'])[3]")
    public WebElement logOut;
    @FindBy(xpath = "//button[@class='ajs-button ajs-ok']")
    public WebElement logOutOKButton;

}
