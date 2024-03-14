package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
    public WebDriver driver;

    public OffersPage(WebDriver driver) {
        this.driver=driver;
    }



    private By search=By.xpath("//input[@type='search']");
    private By productName=By.cssSelector("tr td:nth-child(1)");
    By topDeals= By.linkText("Top Deals");

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public void topDealsPage(){
        driver.findElement(topDeals).click();
    }
}
