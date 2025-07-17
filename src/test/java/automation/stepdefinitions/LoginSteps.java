package automation.stepdefinitions;

import automation.pageactions.LoginPageActions;
import io.cucumber.java.en.*;
import automation.hooks.Hooks;
import org.openqa.selenium.bidi.log.Log;

import java.util.List;
import java.util.Map;

public class LoginSteps {

    LoginPageActions loginPageActions = new LoginPageActions(Hooks.webDriver);

//    public void user_logs_in_to_Client_home_page_with_valid_credentials(List<Map<String, String>> records) throws Throwable {
//        String client = null, userName = null, password = null, credential = null;
//        for (Map<String, String> map : records) {
//            credential = map.get("Credentials");
//        }


    @Given("user enters credentials for login")
    public void user_enters_credentials_for_login (List<Map<String, String>> records) {
        //Creating LoginPageActions object to call performLogic method in that class
        String username = null, password = null;
        for (Map<String, String> map: records) {
            username = map.get("username");
            password = map.get("password");
        }
        loginPageActions.loginDetails(username, password);
    }

    @When("user clicks on the login button")
    public void user_clicks_on_the_login_button () {
        //Clicks on the login button
        loginPageActions.clickLogin();
    }

    @Then("user should be redirected to the dashboard")
    public void user_should_be_redirected_to_the_dashboard() {
        //Performing login page verification
        try {
            String dashboardTitle = loginPageActions.verifyPage();
            if (dashboardTitle.equals("Dashboard")) {
                System.out.println("Successfully logged in");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
