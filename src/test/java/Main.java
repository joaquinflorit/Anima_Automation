import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        WebElement barraDeBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        barraDeBusqueda.sendKeys("Uruguay");
        //barraDeBusqueda.sendKeys(Keys.ENTER);
        WebElement botonDeBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@class,'nav-input nav-progressive-attribute')])[last()]")));
        botonDeBusqueda.click();
        driver.quit();
    }


}
