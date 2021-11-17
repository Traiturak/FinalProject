package pl.coders.zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SheetPage {
    private WebDriver driver;


    @FindBy(xpath = "//*[@id='blockcart-modal']/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckOut;


    public SheetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }


    public void goTocheckOut(){
        proceedToCheckOut.click();
    }
}
