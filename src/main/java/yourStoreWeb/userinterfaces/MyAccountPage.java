package yourStoreWeb.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class MyAccountPage extends PageObject {
    public static final Target MY_ACCOUNT_TITLE = Target.the("my account title").located(By.xpath("//h2[contains(text(),'My Account')]"));
    public static final Target CHANGE_PASSWORD = Target.the("password").located(By.xpath("//a[contains(text(),'Password')]"));
    public static final Target PASSWORD = Target.the("Password").located(By.id("input-password"));
    public static final Target PASSWORD_CONFIRM = Target.the("Password Confirm").located(By.id("input-confirm"));
    public static final Target CONTINUE_BUTTOM = Target.the("continue button").located(By.xpath("//input[@type='submit']"));


}
