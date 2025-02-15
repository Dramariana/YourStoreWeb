package yourStoreWeb.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static yourStoreWeb.userinterfaces.HomePage.*;

public class ShoppingCart implements Task {

    private String productName;

    public ShoppingCart() {

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SEARCH.waitingForNoMoreThan(Duration.ofSeconds(5)).isVisibleFor(actor);
        actor.attemptsTo(
                Click.on(SHOPPING_CART));


    }

    public static ShoppingCart view() {

        return instrumented(ShoppingCart.class);
    }
}
