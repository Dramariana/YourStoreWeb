package yourStoreWeb.stepdefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.thucydides.core.annotations.Managed;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import yourStoreWeb.task.*;
import yourStoreWeb.userinterfaces.HomePage;
import yourStoreWeb.utils.User;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static yourStoreWeb.userinterfaces.MyAccountPage.MY_ACCOUNT_TITLE;
import static yourStoreWeb.userinterfaces.RegisterPage.MESSAGE_REGISTER;
import static yourStoreWeb.userinterfaces.ShoppingCartPage.MESSAGE_ORDER;

public class YourStoreWebStepdefinitions {

    User user;
    private HomePage homePage;

    @Managed(driver = "firefox", uniqueSession = true)
    public WebDriver hisBrowser;
    private final Actor actor = Actor.named("Mariana");

    @Before
    public void actorCanBrowseTheWeb() {
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        hisBrowser = new FirefoxDriver(options);
        actor.can(BrowseTheWeb.with(hisBrowser));
        hisBrowser.manage().window().maximize();
    }


    @Given("I fill in the registration form with first name {string}, last name {string}, email {string}, telephone {string}, password {string}, confirm password {string} and save the register")
    public void iFillInTheRegistrationFormWithFirstNameLastNameEmailTelephonePasswordConfirmPasswordAndSaveTheRegister(String firstName, String lastName, String email, String telephone, String password, String confirmPasssword) {
        user = new User();
        actor.wasAbleTo(Open.browserOn().the(homePage));
        actor.attemptsTo(Register.user(firstName, lastName, email, telephone, password, confirmPasssword, user));

    }

    @When("The user validates the login")
    public void theUserValidatesTheLogin() {
        String mensajeObtenido = MESSAGE_REGISTER.resolveFor(actor).getTextContent();
        assertThat(mensajeObtenido).isEqualTo("Congratulations! Your new account has been successfully created!");

    }

    @And("The user resets the password {string}")
    public void theUserResetsThePassword(String newPassword) {
        actor.attemptsTo(Password.change(newPassword));
    }

    @And("The user navigates to the Laptops & Notebooks section and selects the Show all laptops & notebooks option")
    public void theUserNavigatesToTheLaptopsNotebooksSectionAndSelectsTheShowAllLaptopsNotebooksOption() {
        actor.attemptsTo(LaptopsAndNotebook.go());
    }

    @And("The user adds a {string} to the shopping cart")
    public void theUserAddsAToTheShoppingCart(String addProduct) {
        actor.attemptsTo(Select.product(addProduct));
    }

    @And("The user uses the search bar to find a {string} and adds it to the cart")
    public void theUserUsesTheSearchBarToFindAAndAddsItToTheCart(String searchProduct) {
        actor.attemptsTo(Search.product(searchProduct));
    }


    @And("The user removes {string} from the cart")
    public void theUserRemovesFromTheCart(String product) {
        actor.attemptsTo(
                ShoppingCart.view(),
                Delete.product(product));

    }

    @And("The user adds another unit of {string} to the cart")
    public void theUserAddsAnotherUnitOfToTheCart(String product) {
        actor.attemptsTo(ChangeQuantity.product("2", product));
    }

    @And("The user completes the purchase process up to the order confirmation")
    public void theUserCompletesThePurchaseProcessUpToTheOrderConfirmation() {
        actor.attemptsTo(Complete.order(user.getFirstName(), user.getLastName()));

    }

    @Then("The user should see the order confirmation")
    public void theUserShouldSeeTheOrderConfirmation() {
        String mensajeObtenido = MESSAGE_ORDER.resolveFor(actor).getTextContent();
        assertThat(mensajeObtenido).isEqualTo("Your order has been successfully processed!");

    }
}
