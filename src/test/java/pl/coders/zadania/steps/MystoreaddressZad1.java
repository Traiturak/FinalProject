package pl.coders.zadania.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.coders.zadania.pages.AddNewAddressPage;
import pl.coders.zadania.pages.LoginPage;

import java.util.concurrent.TimeUnit;

public class MystoreaddressZad1 {
    private WebDriver driver;
    private AddNewAddressPage addNewAddressPage;

    @Given("user logged on My store")
    public void userIsLoggedInToCodersLabShop() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://mystore-testlab.coderslab.pl/index.php?controller=authentication");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAs("lawfrankgroup@gmail.com", "5555555555");
    }

    @When("user click in Addresses")
    public void clickAddressesTile() {
        addNewAddressPage.chooseAndClickAddresses();

    }

    @When("user choose the option to create new address.")
    public void clickInButtonCreateNewAddress() {
        addNewAddressPage.clickInButtonToCreateNewAddress();

    }

    @When("^user create new address with alias:(.*), address:(.*), city:(.*), zip code:(.*), phone number:(.*)$")
    public void fillAddressForm(String alias, String address, String city, String zipCode, String phoneNumber) {
        addNewAddressPage.transmitAlias(alias);
        addNewAddressPage.inputAddress(address);
        addNewAddressPage.inputCity(city);
        addNewAddressPage.enterZipCode(zipCode);
        addNewAddressPage.enterPhoneNumber(phoneNumber);
    }

    @When("user save the data")
    public void saveEnteredData() {
        addNewAddressPage.saveImplementedData();

    }

    @Then("^user sees \"Information successfully updated\"$")
    public void checkCorrectness(String alias, String address, String city, String zipCode, String phoneNumber) {
        AddressPage addressesPage = new AddressPage(driver);
        WebElement addressWithAlias = addressesPage.findAddressWithAlias(alias);

        Assert.assertNotNull(addressWithAlias);
        String addressText = addressWithAlias.getText();
        String[] splittedAddresses = addressText.split("\\n");
        Assert.assertEquals(alias, splittedAddresses[0]);
        Assert.assertEquals(address, splittedAddresses[2]);
        Assert.assertEquals(city, splittedAddresses[3]);
        Assert.assertEquals(zipCode, splittedAddresses[4]);
        Assert.assertEquals(phoneNumber, splittedAddresses[6]);

    }

}