package automation.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage {

    @FindBy(name = "username")
    public WebElement username;

    @FindBy(name = "password")
    public WebElement password;

    @FindBy(css = "button[type = 'submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//h6[text()='Dashboard']")
    public WebElement dashboardPage;

}
