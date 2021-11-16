package StepDefinition;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.MailDetailsPage;
import Pages.NewMessagePage;
import Utility.FrameworkConstants;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StepDefinition {

    public static WebDriver driver;

    @Given("User opens Chrome and launch the application")
    public void open_chrome_launch_application() {

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(FrameworkConstants.URL);
        driver.manage().window().maximize();
    }

    @Given("User closes the browser")
    public void close_browser() {

        driver.quit();
    }


    @Given("User logs in with {string} and {string}")
    public void user_logs_in_to_application(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.doLogin(username, password);
    }

    @When("User clicks on Compose")
    public void user_clicks_compose() {
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCompose();
    }

    @When("Send email with subject {string} and body {string} to {string}")
    public void send_email(String subject, String body, String to) {
        NewMessagePage newMessagePage = new NewMessagePage(driver);
        HomePage homePage = new HomePage(driver);
        homePage.clickOnCompose();
        newMessagePage.sendMail(subject, body, to);
    }

    @When("User logs out")
    public void user_logs_out() {
        HomePage homePage = new HomePage(driver);
        homePage.signOut();
    }

    @Then("Verify that last received email is from {string} and has subject {string} and body {string}")
    public void verifyLatestEmail(String from, String subject, String body) {
        HomePage homePage = new HomePage(driver);
        MailDetailsPage mailDetailsPage = new MailDetailsPage(driver);
        homePage.openLastEmail();
        mailDetailsPage.verifyMailDetails(from, subject, body);
    }

    @When("Refreshes the mail list")
    public void refreshMail() {
        HomePage homePage = new HomePage(driver);
        homePage.openLastEmail();
    }

    @Then("Delete the opened mail")
    public void deleteMail() {
        MailDetailsPage mailDetailsPage = new MailDetailsPage(driver);
        mailDetailsPage.deleteEmail();
    }

}
