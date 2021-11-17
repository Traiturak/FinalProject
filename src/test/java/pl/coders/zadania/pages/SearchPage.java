package pl.coders.zadania.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//*[@id='js-product-list']/div[1]/article[1]/div/div[1]/h2/a")
    private WebElement serchedProduct;


    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openWebsiteOfProduct() {
        serchedProduct.click();
    }
}
