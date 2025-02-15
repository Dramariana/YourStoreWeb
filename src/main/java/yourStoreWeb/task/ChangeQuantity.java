package yourStoreWeb.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import org.openqa.selenium.By;


import static net.serenitybdd.screenplay.Tasks.instrumented;

import net.serenitybdd.screenplay.actions.Enter;

public class ChangeQuantity implements Task {

    private String newQuantity, product;

    public ChangeQuantity(String newQuantity, String product) {
        this.newQuantity = newQuantity;
        this.product = product;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        String xpathToQuantity = "//tr[.//a[contains(text(),'" + product + "')]]//input[contains(@class, 'form-control')]";
        String dynamicXpath = "//tr[.//a[contains(text(),'" + product + "')]]//button[contains(@class, 'btn-primary') and .//i[contains(@class, 'fa-refresh')]]";

        actor.attemptsTo(
                Enter.theValue(newQuantity).into(By.xpath(xpathToQuantity)),
                Click.on(By.xpath(dynamicXpath))
        );

    }

    public static ChangeQuantity product(String newQuantity, String product) {

        return instrumented(ChangeQuantity.class, newQuantity, product);
    }
}
