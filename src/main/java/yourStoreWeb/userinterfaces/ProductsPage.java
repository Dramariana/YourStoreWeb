package yourStoreWeb.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPage extends PageObject {
    public static final Target CART_BUTTON = Target.the("button cart").located(By.id("button-cart"));
    public static final Target REFINE_SEARCH = Target.the("refine search").located(By.xpath("//h3[contains(text(),'Refine Search')]"));

}
