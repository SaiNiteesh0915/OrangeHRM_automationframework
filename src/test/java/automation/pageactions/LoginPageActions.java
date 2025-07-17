package automation.pageactions;

import automation.pageobjects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class LoginPageActions {
    WebDriver driver;
    LoginPage loginPage;

    public LoginPageActions (WebDriver driver) {
        this.driver = driver;
        loginPage = new LoginPage();
        PageFactory.initElements(driver, loginPage);
    }

    public void enterUsername(String username) {
        loginPage.username.sendKeys(username);
    }

    public void enterPassword(String password) {
        loginPage.password.sendKeys(password);
    }

    public void clickLoginButton() {
        loginPage.submitButton.click();
    }

    public void loginDetails(String username, String password) {
        enterUsername(username);
        enterPassword(password);
    }

    public void clickLogin() {
        clickLoginButton();
    }

    public String verifyPage () {
        return loginPage.dashboardPage.getText();
    }
}
