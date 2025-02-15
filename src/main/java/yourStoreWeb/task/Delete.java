package yourStoreWeb.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;


import static net.serenitybdd.screenplay.Tasks.instrumented;

import org.openqa.selenium.By;

public class Delete implements Task {

    private String productName;

    public Delete(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String dynamicXpath = "//tr[.//a[contains(text(),'" + productName + "')]]//button[contains(@class, 'btn-danger') and .//i[contains(@class, 'fa-times-circle')]]";
        actor.attemptsTo(
                Click.on(By.xpath(dynamicXpath))
        );

    }

    public static Delete product(String productName) {

        return instrumented(Delete.class, productName);
    }
}
