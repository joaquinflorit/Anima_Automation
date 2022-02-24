package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonHome extends BasePage{

    @FindBy(id = "twotabsearchtextbox")
    private WebElement barraDeBusqueda;

    @FindBy(xpath = "(//input[contains(@class,'nav-input nav-progressive-attribute')])[last()]")
    private WebElement botonDeBusqueda;

    public AmazonHome(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.getDriver(), this);
    }


    public AmazonResultados realizarBusqueda(String terminoDeBusqueda) {
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.barraDeBusqueda)).sendKeys(terminoDeBusqueda);
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.botonDeBusqueda)).click();
        return new AmazonResultados(this.getDriver());
    }


}
