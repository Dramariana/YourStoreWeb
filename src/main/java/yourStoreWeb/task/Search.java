package yourStoreWeb.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static yourStoreWeb.userinterfaces.HomePage.*;

public class Search implements Task {

    private String productName;

    public Search(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        SEARCH.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);
        actor.attemptsTo(
                Enter.theValue(productName).into(SEARCH),
                Click.on(SEARCH_BUTTOM));

        actor.attemptsTo(Select.product(productName));

    }

    public static Search product(String productName) {
        return instrumented(Search.class, productName);
    }
}
