package yourStoreWeb.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static yourStoreWeb.userinterfaces.HomePage.*;
import static yourStoreWeb.userinterfaces.RegisterPage.*;

import net.serenitybdd.screenplay.actions.Enter;
import yourStoreWeb.utils.User;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Register implements Task {

    private String firstName, lastName, email, telephone, password, confirmPasssword;
    User user;


    public Register(String firstName, String lastName, String email, String telephone, String password, String confirmPasssword, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.password = password;
        this.confirmPasssword = confirmPasssword;
        this.user = user;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        YOUR_STORE_TITLE.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);
        MY_ACCOUNT.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);

        actor.attemptsTo(Click.on(MY_ACCOUNT),
                Click.on(REGISTER)
        );
        ACCOUNT_TITLE.waitingForNoMoreThan(Duration.ofSeconds(10)).isVisibleFor(actor);

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setTelephone(telephone);
        user.setPassword(password);

        actor.attemptsTo(

                Enter.theValue(firstName).into(FIRST_NAME),
                Enter.theValue(lastName).into(LAST_NAME),
                Enter.theValue(email).into(EMAIL),
                Enter.theValue(telephone).into(TELEPHONE),
                Enter.theValue(password).into(PASSWORD),
                Enter.theValue(confirmPasssword).into(PASSWORD_CONFIRM),
                Click.on(YES_OPTION),
                Click.on(PRIVACY_POLICY),
                Click.on(CONTINUE_BUTTOM));

    }

    public static Register user(String firstName, String lastName, String email, String telephone, String password, String confirmPasssword,User user) {
        return instrumented(Register.class,firstName,lastName,email,telephone,password,confirmPasssword,user);
    }


}
