package Pages;

import Utility.FrameworkActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Compose')]")
    private WebElement btn_Compose;

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Google Account')]")
    private WebElement btn_UserProfile;

    @FindBy(how = How.XPATH, using = "//*[contains(@href,'Logout')]")
    private WebElement btn_SignOut;

    @FindBy(how = How.XPATH, using = "//*[contains(@aria-label,'Refresh')]")
    private WebElement btn_Refresh;


    public void clickOnCompose() {
        FrameworkActions actions = new FrameworkActions(driver);
        actions.click(btn_Compose);
    }

    public void signOut() {
        FrameworkActions actions = new FrameworkActions(driver);
        actions.click(btn_UserProfile);
        actions.click(btn_SignOut);
    }

    public void openLastEmail() {
        FrameworkActions actions = new FrameworkActions(driver);
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='UI']//table/tbody/tr"));
        actions.click(rows.get(0));
    }

    public void refresh() {
        FrameworkActions actions = new FrameworkActions(driver);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        actions.click(btn_Refresh);
    }
}
