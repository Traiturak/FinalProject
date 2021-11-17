package pl.coders.zadania.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    private final WebDriver driver;

    @FindBy(name = "email")
    private WebElement enterEmail;

    @FindBy(css = "[title='Log in to your customer account']")
    private WebElement mainPageSignInButton;

    @FindBy(name = "password")
    private WebElement enterPassword;

    @FindBy(id = "submit-login")
    private WebElement confrimDataByClickingSignIn;

    @FindBy(id = "_desktop_logo")
    private WebElement comeBackToMainPage;

    @FindBy(className = "ui-autocomplete-input")
    private WebElement insertTheNameOfProduct;


    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void GoToPage() {
        mainPageSignInButton.click();
    }

    public void insertDataToLogin(String email, String password) {
        enterEmail.clear();
        enterEmail.sendKeys(email);
        enterPassword.clear();
        enterPassword.sendKeys(password);
    }

    public void confirmEmailAndPassword() {
        confrimDataByClickingSignIn.click();
    }
    public static void clickToGoBackToMainPage(){
        comeBackToMainPage.click();
    }
    public void findTheProduct(String nameOfProduct){
        insertTheNameOfProduct.click();
        insertTheNameOfProduct.clear();
        insertTheNameOfProduct.click();
        insertTheNameOfProduct.sendKeys(nameOfProduct);
        insertTheNameOfProduct.sendKeys(Keys.ENTER);

    }
}