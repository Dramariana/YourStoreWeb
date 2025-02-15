package yourStoreWeb.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class LoginPage extends PageObject {
    public static final Target RETURNING_CUSTOMER_TITLE = Target.the("Returning Customer").located(By.xpath("//h2[contains(text(),'Returning Customer')]"));
    public static final Target EMAIL = Target.the("email").located(By.id("input-email"));
    public static final Target PASSWORD = Target.the("password").located(By.id("input-password"));
    public static final Target FORGOTTEN_PASSWORD = Target.the("Forgotten Password").located(By.xpath("//div[@class='form-group']//a[contains(text(),'Forgotten Password')]"));
    public static final Target LOGIN_BUTTON = Target.the("login button").located(By.xpath("//input[@type='submit']"));


}
