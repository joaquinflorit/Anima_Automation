import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");

        WebElement barraDeBusqueda = driver.findElement(By.id("twotabsearchtextbox"));
        barraDeBusqueda.sendKeys("Uruguay");
        barraDeBusqueda.sendKeys(Keys.ENTER);



        //WebElement searchBar = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        //searchBar.sendKeys("Chile");
        //WebElement searchButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='nav-input nav-progressive-attribute'])[last()]")));

        // FIRST OPT
        //searchButton.click();

        //SECOND OPT
        //searchBar.sendKeys(Keys.ENTER);


        driver.quit();


    }


}
