package yourStoreWeb.task;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.serenitybdd.screenplay.questions.WebElementQuestion;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static yourStoreWeb.userinterfaces.ShoppingCartPage.*;

public class Complete implements Task {

    private String firstName, lastName, address = "Cr 33#88", postCode = "3578", city = "city";

    public Complete(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(CHECKOUT_BUTTON),
                Click.on(CHECKOUT_BUTTON),
                Switch.toDefaultContext(),
                Enter.theValue(firstName).into(FIRST_NAME),
                Enter.theValue(lastName).into(LAST_NAME),
                Enter.theValue(address).into(ADDRESS_1),
                Enter.theValue(city).into(CITY),
                Enter.theValue(postCode).into(POST_CODE),
                Scroll.to(COUNTRY),
                Click.on(REGION)
        );


        WebElement selectElement = (WebElement) WebElementQuestion.the(REGION).answeredBy(actor);
        List<WebElement> options = selectElement.findElements(By.tagName("option"));

        options = options.subList(1, options.size());

        Random random = new Random();
        WebElement randomOption = options.get(random.nextInt(options.size()));
        randomOption.click();
        actor.attemptsTo(
                Click.on(CONTINUE_BUTTON),
                Click.on(CONTINUE_BUTTON_2),
                Click.on(CONTINUE_BUTTON_3),
                Click.on(TERM_AND_CODITIONS),
                Click.on(CONTINUE_BUTTON_4),
                Click.on(COMFIRM_BUTTON)
        );

    }


    public static Complete order(String firstName, String lastName) {
        return instrumented(Complete.class, firstName, lastName);
    }
}
