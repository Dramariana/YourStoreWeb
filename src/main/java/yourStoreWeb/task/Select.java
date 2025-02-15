package yourStoreWeb.task;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static yourStoreWeb.userinterfaces.ProductsPage.CART_BUTTON;
import static yourStoreWeb.userinterfaces.ProductsPage.REFINE_SEARCH;

public class Select implements Task {

    private String productName;

    public Select(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        REFINE_SEARCH.waitingForNoMoreThan(Duration.ofSeconds(5)).isVisibleFor(actor);
        String dynamicXpath = "//h4/a[contains(text(),'" + productName + "')]";
        actor.attemptsTo(
                Scroll.to(By.xpath(dynamicXpath)),
                Click.on(By.xpath(dynamicXpath)),
                Click.on(CART_BUTTON)
        );


    }

    public static Select product(String productName) {
        return instrumented(Select.class, productName);
    }
}
