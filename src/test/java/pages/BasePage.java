package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(this.driver, 20);
    }

    public WebDriverWait getWait() {
        return this.wait;
    }

    public WebDriver getDriver() {
        return this.driver;
    }

}
