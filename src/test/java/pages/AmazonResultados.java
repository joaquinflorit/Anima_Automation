package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AmazonResultados extends NavBarAmazon{

    public WebElement obtenerResultado(int index) {
        String xpath = "(//h2[contains(@class,'a-size-mini')]//span)[" + index + "]";
        return this.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
    }


}
