package yourStoreWeb.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static yourStoreWeb.userinterfaces.HomePage.*;

public class LaptopsAndNotebook implements Task {


    public LaptopsAndNotebook() {

    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(Click.on(LAPTOPS_AND_NOTEBOOKS)
        );
        SHOW_ALL_LAPTOPS_AND_NOTEBOOKS.waitingForNoMoreThan(Duration.ofSeconds(5)).isVisibleFor(actor);
        actor.attemptsTo(
                Click.on(SHOW_ALL_LAPTOPS_AND_NOTEBOOKS)
        );


    }

    public static LaptopsAndNotebook go() {
        return instrumented(LaptopsAndNotebook.class);
    }
}
