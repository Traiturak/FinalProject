package pl.coders.zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShopPage {
    private WebDriver driver;

    @FindBy(css = "[class='checkout cart-detailed-actions card-block']")
    private WebElement proceedToCheckOutButton;

    public ShopPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void clickToButtonProceedToCheckOut (){
        proceedToCheckOutButton.click();
    }
}
