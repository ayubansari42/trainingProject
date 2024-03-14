package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPageStepDefinitions {

    String offerPageProductName;
    PageObjectManager pageObjectManager;

    TestContextSetup testContextSetup;
    public OfferPageStepDefinitions(TestContextSetup testContextSetup){
        this.testContextSetup=testContextSetup;
    }

    @Then("^user searched for (.+) shortname in offers page to check if product exist with the same name$")
    public void user_searched_for_same_shortname_in_offers_page_to_check_if_product_exist(String Shortname) throws InterruptedException {
        switchToOffersPage();

        OffersPage offersPage=testContextSetup.pageObjectManager.getOffersPage();
        offersPage.searchItem(Shortname);


        //testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Shortname);
        Thread.sleep(3000);
        offerPageProductName=offersPage.getProductName();
    }
public void switchToOffersPage(){

    OffersPage offersPage=testContextSetup.pageObjectManager.getOffersPage();
    offersPage.topDealsPage();
    testContextSetup.genericUtils.switchWindowToChild();
       // OffersPage offersPage=new OffersPage(testContextSetup.driver);
      //  offersPage.topDealsPage();
    //testContextSetup.driver.findElement(By.linkText("Top Deals")).click();

}
    @Then("validate product name in offers page Matches with Landing Page")
    public void validate_product_name(){
        Assert.assertEquals(testContextSetup.landingPageproductName, offerPageProductName);


    }


}
