package pl.coders.zadania.pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Screen {
    private WebDriver driver;

    @FindBy(css = "[class='page-content page-order-confirmation card']")
    private WebElement confirmationOrderItem;

    @FindBy(tagName = "h1 card-title")
    private WebElement yourOrderIsConfirmed;


    public Screen(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void takeShot() throws Exception {
        File screenshot = ((TakeShot) driver).getScreenshotAs(OutputType.FILE);
        BufferedImage fullImg = ImageIO.read(screenshot);

// Get the location of element on the page
        Point point = confirmationOrderItem.getLocation();
        File screenshotLocation = new File(".\\PrintScreen\\_screenshot.png");
        FileUtils.copyFile(screenshot, screenshotLocation);

    }
}
