package yourStoreWeb.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ShoppingCartPage extends PageObject {
    public static final Target CHECKOUT_BUTTON = Target.the("checkout button").located(By.xpath("//a[@class='btn btn-primary']"));
    public static final Target FIRST_NAME = Target.the("First Name").located(By.id("input-payment-firstname"));
    public static final Target LAST_NAME = Target.the("Last Name").located(By.id("input-payment-lastname"));
    public static final Target ADDRESS_1 = Target.the("address").located(By.id("input-payment-address-1"));
    public static final Target CITY = Target.the("city").located(By.id("input-payment-city"));
    public static final Target POST_CODE = Target.the("post code").located(By.id("input-payment-postcode"));
    public static final Target COUNTRY = Target.the("country").located(By.id("input-payment-country"));
    public static final Target REGION = Target.the("region").located(By.id("input-payment-zone"));
    public static final Target CONTINUE_BUTTON = Target.the("continue button").located(By.id("button-payment-address"));
    public static final Target CONTINUE_BUTTON_2 = Target.the("continue button").located(By.id("button-shipping-address"));
    public static final Target CONTINUE_BUTTON_3 = Target.the("continue button").located(By.id("button-shipping-method"));
    public static final Target TERM_AND_CODITIONS = Target.the("term and conditions").located(By.xpath("//input[@type='checkbox']"));
    public static final Target CONTINUE_BUTTON_4 = Target.the("continue button").located(By.id("button-payment-method"));
    public static final Target COMFIRM_BUTTON = Target.the("confirm button").located(By.id("button-confirm"));
    public static final Target MESSAGE_ORDER = Target.the("message order").located(By.xpath("//p[contains(text(),'Your order has been successfully processed!')]"));

}
