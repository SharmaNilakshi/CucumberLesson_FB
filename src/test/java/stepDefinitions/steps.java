package stepDefinitions;

import Utils.GroupPage;
import Utils.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class steps
{

    LoginPage lpObj;
    GroupPage gpObj;
    WebDriver driver;

    @Given("Launch chrome browser")
    public void Launch_chrome_browser()
    {
        lpObj = new LoginPage(driver);
        lpObj.LaunchBrowser();
    }

    @When("Open facebook login page")
    public void Open_facebook_login_page()
    {
        lpObj.OpenURL();
    }

    @Then ("Login with valid userId and password")
    public void login_with_valid_userId_passWord() throws InterruptedException {
        lpObj.Login("nilakshipattanayak@gmail.com", "^KochE$88");
    }

    @And("Logout from facebook")
    public void logout_from_facebook() throws InterruptedException {

        lpObj.Logout();
    }

    @Then ("Close Browser")
    public void close_browser()
    {
        lpObj.QuitBrowser();
    }

    @Then("Login with invalid userId and valid password")
    public void login_with_invalid_user_id_and_valid_password() throws InterruptedException {

        {
            lpObj.Login("nppn@tmall.com", "^KochE$88");
        }
    }
    @Then("Verify message for invalid userId")
    public void verify_message_for_invalid_userid()
    {
        lpObj.Messages("The email you entered isn’t connected to an account. ");

    }

    @Then("Login with valid userId and invalid password")
    public void Login_with_valid_userId_and_invalid_password() throws InterruptedException {

        {
            lpObj.Login("nilakshipattanayak@gmail.com", "dfgh567");
        }
    }
    @Then("Verify message for invalid password")
    public void verify_message_for_invalid_password()
    {
        lpObj.Messages("The password you’ve entered is incorrect. ");
    }


    //New Group Creation

    @And("Go to Groups menu")
    public void go_to_groups_menu() throws InterruptedException {
        Thread.sleep(3000);
        gpObj = new GroupPage(driver);
        gpObj.menuGroups();
    }
    @Then("Create a new group with group name and privacy as private")
    public void create_a_new_group() throws InterruptedException {

        Thread.sleep(3000);
        gpObj.newGroupAdd("abc");
    }
}
