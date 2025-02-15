package yourStoreWeb.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static yourStoreWeb.userinterfaces.HomePage.*;
import static yourStoreWeb.userinterfaces.LoginPage.*;

public class Login implements Task {
    private String email, password;

    public Login(String email, String password) {
        this.email = email;
        this.password = password;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        YOUR_STORE_TITLE.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);
        MY_ACCOUNT.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);
        actor.attemptsTo(Click.on(MY_ACCOUNT),
                Click.on(LOGIN)
        );

        RETURNING_CUSTOMER_TITLE.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);

        actor.attemptsTo(
                Enter.theValue(email).into(EMAIL),
                Enter.theValue(password).into(PASSWORD),
                Click.on(LOGIN_BUTTON));

    }

    public static Login account(String email, String password) {
        return instrumented(Login.class, email, password);
    }

}
