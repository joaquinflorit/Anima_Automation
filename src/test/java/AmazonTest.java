import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

public class AmazonTest {


    private WebDriver driver;
    private WebDriverWait wait;

    @DataProvider(name = "paises")
    public Object[][] dataProviderDePaises() {
        return new Object[][] { {"Brasil"}, {"Uruguay"}, {"Chile"}, {"Argentina"} };
    }

    @DataProvider(name = "authentication")
    public Object[][] dataProviderAuth() {
        return new Object[][] { {"usuario1", "pass1"}, {"usuario2", "pass2"}, {"usuario3", "pass3"} };
    }

    @BeforeClass
    public void beforeClass() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://www.amazon.com/");
    }

    @Test(dataProvider = "paises")
    public void testAmazonBrasil(String pais) {
        WebElement barraDeBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        barraDeBusqueda.sendKeys(pais);
        //barraDeBusqueda.sendKeys(Keys.ENTER);
        WebElement botonDeBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@class,'nav-input nav-progressive-attribute')])[last()]")));
        botonDeBusqueda.click();
        WebElement primerResultado = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//h2[contains(@class,'a-size-mini')]//span)[1]")));
        String tituloDelPrimerResultado = primerResultado.getText();
        System.out.println(tituloDelPrimerResultado);
        Assert.assertTrue(tituloDelPrimerResultado.contains(pais), "el titulo del primer resultado no contiene la palabra " + pais);
    }

    /*@Test(dataProvider = "authentication")
    public void testAuth(String usuario, String pass) {
        System.out.println(usuario + " " + pass);
    }*/

    /*@Test(priority = 1)
    public void testAmazonUruguay() {
        WebElement barraDeBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        barraDeBusqueda.sendKeys("Uruguay");
        //barraDeBusqueda.sendKeys(Keys.ENTER);
        WebElement botonDeBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@class,'nav-input nav-progressive-attribute')])[last()]")));
        botonDeBusqueda.click();
    }

    @Test(priority = 2)
    public void testAmazonChile() {
        WebElement barraDeBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        barraDeBusqueda.sendKeys("Chile");
        //barraDeBusqueda.sendKeys(Keys.ENTER);
        WebElement botonDeBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@class,'nav-input nav-progressive-attribute')])[last()]")));
        botonDeBusqueda.click();
    }

    @Test(priority = 3)
    public void testAmazonArgentina() {
        WebElement barraDeBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.id("twotabsearchtextbox")));
        barraDeBusqueda.sendKeys("Argentina");
        //barraDeBusqueda.sendKeys(Keys.ENTER);
        WebElement botonDeBusqueda = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@class,'nav-input nav-progressive-attribute')])[last()]")));
        botonDeBusqueda.click();
    }*/

    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod");
    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }


}
