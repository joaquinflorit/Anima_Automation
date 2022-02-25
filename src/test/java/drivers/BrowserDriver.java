package drivers;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserDriver {

    private WebDriver driver = null;
    private WebDriverWait wait;
    private static BrowserDriver instance = null;

    public static BrowserDriver getInstance(){
        if(instance == null){
            instance = new BrowserDriver();
        }
        return instance;
    }

    private BrowserDriver(){
        WebDriverManager.chromedriver().setup();
        initDriverChrome();
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    private void initDriverChrome(){
        driver = new ChromeDriver();
    }

    public WebDriver getBrowserDriver(){
        return driver;
    }

    public WebDriverWait getWait(){
        return wait;
    }

    public void closeDriver() {
        driver.close();
    }

}
