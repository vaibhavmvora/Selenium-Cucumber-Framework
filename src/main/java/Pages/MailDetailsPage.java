package Pages;

import Utility.FrameworkActions;
import Utility.FrameworkVerifications;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MailDetailsPage {

    WebDriver driver;

    public MailDetailsPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//td//h3/span")
    private WebElement lbl_From;

    @FindBy(how = How.XPATH, using = "//td//h2")
    private WebElement lbl_Subject;

    @FindBy(how = How.XPATH, using = "//div[@role='list']//div[@dir='ltr']")
    private WebElement lbl_Body;

    @FindBy(how = How.XPATH, using = "//div[@aria-label='Delete']")
    private WebElement btn_Delete;

    public void verifyMailDetails(String from, String subject, String body)
    {
        FrameworkVerifications verifications = new FrameworkVerifications(driver);
        verifications.verifyText(lbl_From,from);
        verifications.verifyText(lbl_Subject,subject);
        verifications.verifyText(lbl_Body,body);
    }

    public void deleteEmail()
    {
        FrameworkActions actions = new FrameworkActions(driver);
        actions.click(btn_Delete);
    }
}
