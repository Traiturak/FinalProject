package pl.coders.zadania.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddressPage {
    private WebDriver driver;

    @FindBy(css = "[class='address']")
    private List<WebElement> adresses;

    public AddressPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement findAddressWithAlias(String alias) {
        for (WebElement address : adresses) {
            if (doesElementHaveAlias(address, alias)) {
                return address;
            }
        }
        return null;
    }

    public boolean doesElementHaveAlias(WebElement address, String alias) {
        WebElement aliasElement = address.findElement(By.tagName("h4"));
        return aliasElement.getText().equals(alias);
    }

}