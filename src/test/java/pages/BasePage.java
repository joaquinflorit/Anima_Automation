package pages;

import drivers.BrowserDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage() {
        this.driver = BrowserDriver.getInstance().getBrowserDriver();
        this.wait = BrowserDriver.getInstance().getWait();
        PageFactory.initElements(driver,this);
    }

    public WebDriverWait getWait() {
        return this.wait;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
