package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FrameworkActions{

    private static WebDriver driver;

    public FrameworkActions(WebDriver driver)
    {
        this.driver=driver;
    }

    public void click(WebElement element)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.click();
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }

    public void sendKeys(WebElement element, String text)
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver,30);
            wait.until(ExpectedConditions.visibilityOf(element));
            element.sendKeys(text);
        }
        catch (Exception e)
        {
            System.out.println(e.toString());
        }

    }
}
