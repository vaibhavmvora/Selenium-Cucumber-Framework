package Utility;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameworkVerifications {

    private static WebDriver driver;

    public FrameworkVerifications(WebDriver driver)
    {
        this.driver=driver;
    }

    public void verifyText(WebElement element,String expectedText)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOf(element));
            Assert.assertEquals(expectedText,element.getText());
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }
    }
}
