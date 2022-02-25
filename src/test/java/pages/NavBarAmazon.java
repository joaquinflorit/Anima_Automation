package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavBarAmazon extends BasePage{

    @FindBy(id = "twotabsearchtextbox")
    private WebElement barraDeBusqueda;

    @FindBy(xpath = "(//input[contains(@class,'nav-input nav-progressive-attribute')])[last()]")
    private WebElement botonDeBusqueda;

    public AmazonResultados realizarBusqueda(String terminoDeBusqueda) {
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.barraDeBusqueda)).clear();
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.barraDeBusqueda)).sendKeys(terminoDeBusqueda);
        this.getWait().until(ExpectedConditions.elementToBeClickable(this.botonDeBusqueda)).click();
        return new AmazonResultados();
    }

}
