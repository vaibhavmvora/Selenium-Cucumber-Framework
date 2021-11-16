package Pages;

import Utility.FrameworkActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class NewMessagePage {

    WebDriver driver;

    public NewMessagePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//textarea[@aria-label='To']")
    private WebElement txt_To;

    @FindBy(how = How.XPATH, using = "//input[@aria-label='Subject']")
    private WebElement txt_Subject;

    @FindBy(how = How.XPATH, using = "//div[@aria-label='Message Body']")
    private WebElement txt_Body;

    @FindBy(how = How.XPATH, using = "//table//*[contains(text(),'Send')]")
    private WebElement btn_Send;


    public void sendMail(String subject, String body, String To) {
        FrameworkActions actions = new FrameworkActions(driver);
        actions.sendKeys(txt_To, To);
        actions.sendKeys(txt_Subject, subject);
        actions.sendKeys(txt_Body, body);
        actions.click(btn_Send);
    }

}
