package yourStoreWeb.userinterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;

@DefaultUrl("http://opencart.abstracta.us/index.php?route=common/home")
public class HomePage extends PageObject {
    public static final Target YOUR_STORE_TITLE = Target.the("my your store title").located(By.xpath("//a[contains(text(),'Your Store')]"));
    public static final Target MY_ACCOUNT = Target.the("my account").located(By.xpath("//span[contains(text(),'My Account')]"));
    public static final Target REGISTER = Target.the("register").located(By.xpath("//a[contains(text(),'Register')]"));
    public static final Target LOGIN = Target.the("login").located(By.xpath("//a[contains(text(),'Login')]"));
    public static final Target LAPTOPS_AND_NOTEBOOKS = Target.the("Laptops & Notebooks").located(By.xpath("//a[@class='dropdown-toggle'][contains(text(),'Laptops & Notebooks')]"));
    public static final Target SHOW_ALL_LAPTOPS_AND_NOTEBOOKS = Target.the("Show All Laptops & Notebooks").located(By.xpath("//a[contains(text(),'Show All Laptops & Notebooks')]"));
    public static final Target SEARCH = Target.the("Search").located(By.xpath("//div[@id='search']//input[@type='text']"));
    public static final Target SEARCH_BUTTOM = Target.the("seacrh button").located(By.xpath("//span[@class='input-group-btn']//button[@type='button']"));
    public static final Target SHOPPING_CART = Target.the("shopping cart").located(By.xpath("//span[contains(text(),'Shopping Cart')]"));

}
