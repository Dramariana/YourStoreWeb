package yourStoreWeb.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;


import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static yourStoreWeb.userinterfaces.HomePage.*;
import static yourStoreWeb.userinterfaces.MyAccountPage.*;

public class Password implements Task {
    String newPassword;
    public Password(String newPassword) {
        this.newPassword=newPassword;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        MY_ACCOUNT.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);

        actor.attemptsTo(Click.on(CHANGE_PASSWORD)
        );
        PASSWORD.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);

        actor.attemptsTo(
                Enter.theValue(newPassword).into(PASSWORD),
                Enter.theValue(newPassword).into(PASSWORD_CONFIRM),
                Click.on(CONTINUE_BUTTOM));

    }

    public static Password change(String newPassword) {
        return instrumented(Password.class,  newPassword);
    }

}
