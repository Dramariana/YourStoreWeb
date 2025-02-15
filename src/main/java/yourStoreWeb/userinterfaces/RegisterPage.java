package yourStoreWeb.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPage extends PageObject {

    public static final Target ACCOUNT_TITLE = Target.the("Account title").located(By.xpath("//h1[contains(text(),'Account')]"));
    public static final Target FIRST_NAME = Target.the("First Name").located(By.id("input-firstname"));
    public static final Target LAST_NAME = Target.the("Last Name").located(By.id("input-lastname"));
    public static final Target EMAIL = Target.the("E-Mail").located(By.id("input-email"));
    public static final Target TELEPHONE = Target.the("Telephone").located(By.id("input-telephone"));
    public static final Target PASSWORD = Target.the("Password").located(By.id("input-password"));
    public static final Target PASSWORD_CONFIRM = Target.the("Password Confirm").located(By.id("input-confirm"));
    public static final Target YES_OPTION = Target.the("yes Option").located(By.xpath("//*/div[@class='col-sm-10']/label[1]"));
    public static final Target NO_OPTION = Target.the("no Option").located(By.xpath("//*/div[@class='col-sm-10']/label[2]"));
    public static final Target PRIVACY_POLICY = Target.the("privacy policy").located(By.xpath("//input[@type='checkbox']"));
    public static final Target CONTINUE_BUTTOM = Target.the("continue button").located(By.xpath("//input[@type='submit']"));
    public static final Target MESSAGE_REGISTER = Target.the("message register").located(By.xpath("//p[contains(text(),'Congratulations! Your new account has been success')]"));

}
