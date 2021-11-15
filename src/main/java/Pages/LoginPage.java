package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import Utility.FrameworkActions;
import Utility.FrameworkConstants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage{

        WebDriver driver;

        public LoginPage(WebDriver driver) {
            this.driver=driver;
            PageFactory.initElements(driver, this);
        }

        @FindBy(how = How.ID, using = "identifierId")
        private WebElement txt_Email;

        @FindBy(how = How.ID, using = "identifierNext")
        private WebElement btn_Next;

        @FindBy(how = How.NAME, using = "password")
        private WebElement txt_Password;

        @FindBy(how = How.ID, using = "passwordNext")
        private WebElement btn_PwdNext;

        public void doLogin(String username, String password)
        {
                FrameworkActions actions = new FrameworkActions(driver);
                actions.sendKeys(txt_Email,username);
                actions.click(btn_Next);
                actions.sendKeys(txt_Password,password);
                actions.click(btn_PwdNext);
        }





}
