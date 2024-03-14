package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    public WebDriver driver;
    public LandingPage(WebDriver driver){
        this.driver=driver;
    }
    By search=By.xpath("//input[@type='search']");
    By productName=By.cssSelector("h4.product-name");
    By incrementQuantity=By.cssSelector("a.increment");
    By addToCart=By.xpath("//div[@class='product-action']/button");

    public void searchItem(String name){
        driver.findElement(search).sendKeys(name);
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }
    public String getTitlePage(){

        return driver.getTitle();
    }

    public void incrementQuantity(int quantity)
    {
        int i=quantity-1;
        while(i>0){
            driver.findElement(incrementQuantity).click();
            i--;
        }
    }
    public void addToCart(){
        driver.findElement(addToCart).click();
    }
}
