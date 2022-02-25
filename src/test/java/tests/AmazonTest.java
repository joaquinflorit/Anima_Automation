package tests;

import drivers.BrowserDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AmazonHome;
import pages.AmazonResultados;

public class AmazonTest {

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

    }

    @BeforeMethod
    public void beforeMethod() {
        BrowserDriver.getInstance().getBrowserDriver().get("https://www.amazon.com/");
    }


    @Test(dataProvider = "paises")
    public void testAmazonPageObject(String pais) {
        AmazonHome amazonHome = new AmazonHome();
        AmazonResultados amazonResultados =amazonHome.realizarBusqueda(pais);
        String resultado = amazonResultados.obtenerResultado(3).getText();
        System.out.println(resultado);
        Assert.assertTrue(resultado.contains(pais), "el titulo del primer resultado no contiene la palabra " + pais);
    }

    @Test
    public void testAmazonPageObjectSinDP() {
        AmazonHome amazonHome = new AmazonHome();
        AmazonResultados amazonResultados =amazonHome.realizarBusqueda("Brasil");
        String resultado = amazonResultados.obtenerResultado(3).getText();
        Assert.assertTrue(resultado.contains("Brasil"), "el titulo del primer resultado no contiene la palabra " + "Brasil");
        amazonResultados = amazonResultados.realizarBusqueda("Uruguay");
        amazonResultados = amazonResultados.realizarBusqueda("Chile");
        amazonResultados.realizarBusqueda("Argentina");
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("@AfterMethod");
    }

    @AfterClass
    public void afterClass() {
        BrowserDriver.getInstance().closeDriver();
    }


}
