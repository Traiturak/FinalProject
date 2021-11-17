package pl.coders.zadania.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coders.zadania.pages.*;

import java.util.concurrent.TimeUnit;

public class MystoreZad2 {
    private WebDriver driver;
    private AddNewAddressPage addNewAddressPage;

    @Given("user login in my-store-testlab.coderslab.pl/")
    public void loginUser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/");
        addNewAddressPage = new AddNewAddressPage(driver);

    }

    @When("user click in SignIn Button to login")
    public void clickInSignInButtonOnMainPage() {
        LoginPage loginInShopPage = new LoginPage(driver);
        LoginPage.GoToPage();
    }

    @When("^user login on my-store-testlab.coderslab.pl with email:(.*) and password: (.*)$")
    public void enterloginDetailTOpenPage(String email, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.insertDataToLogin(email, password);
        loginPage.confirmEmailAndPassword();
    }

    @When("user go back to main page")
    public void goBackToMainPage() {
        LoginPage loginInShopPage = new LoginPage(driver);
        LoginPage.clickToGoBackToMainPage();
    }

    @When("^user search the product: (.*)$")
    public void searchTheProductToBuy(String productName) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.findTheProduct(productName);
    }

    @When("user choose my product from results")
    public void chooseAndClickInProductFromSearchResult() {
        SearchPage searchPage = new SearchPage(driver);
        searchPage.openWebsiteOfProduct();
    }

    @When("^user choose the size: (.*) and quantity which is equal (.*) of product and I add to cart$")
    public void addingTheProductToCart(String size, String numberOfProducts) {
        ProductPage productPage = new ProductPage(driver);
        productPage.chooseYourSize(size);
        productPage.choosePreferedQuantity(numberOfProducts);
        productPage.buttonAddChosenProductToCart();
    }

    @When("user proceed to checkout")
    public void pressButtonToCheckOut() {
        SheetPage sheetPage = new SheetPage(driver);
        sheetPage.goTocheckOut();

    }

    @When("user make doublecheck in my order and click proceed to checkout")
    public void confirminAndPressTheProceedButton() {
        ShopPage shopPage = new ShopPage(driver);
        shopPage.clickToButtonProceedToCheckOut();
    }

    @When("user Confirm address")
    public void confirmationAdresses() {
        Order orderPage = new Order(driver);
        orderPage.confirmationAddress();
    }

    @When("user choose pick up method as PrestaShop \"pick up in store\"")
    public void openShippingMethodPage() {
        Order orderDetailsPage = new Order(driver);
        orderDetailsPage.openShippingMethods();
        orderDetailsPage.choosePrestaShopShipping();
        orderDetailsPage.confirmChosenShipping();
    }

    @When("user choose payment method: Pay by check")
    public void choosingPaymentMethod() {
        Order orderDetailsPage = new Order(driver);
        orderDetailsPage.choosePreferredPaymentMethod();
        orderDetailsPage.acceptAgreementsOfShopTerms();
        orderDetailsPage.confirmPaymentMethod();

    }

    @Then("user make screen shot")
    public void makeScreenShoot() throws Exception {
        Screen screen = new Screen(driver);
        screen.takeShot();

    }
}