package stepDefinitions;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pageObjects.LandingPage;
import utils.TestContextSetup;


import java.util.Iterator;
import java.util.Set;

public class LandingPageStepDefinitions {

    LandingPage landingPage;
    TestContextSetup testContextSetup;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup){

        this.testContextSetup=testContextSetup;
        landingPage=testContextSetup.pageObjectManager.getLandingPage();
    }
    @Given("User is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
    Assert.assertTrue(landingPage.getTitlePage().contains("GreenKart"));
    }
    @When("^user searched with shortname (.+) and extracted actual name of product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortname) throws InterruptedException {

        landingPage.searchItem(shortname);
       // testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortname);
          Thread.sleep(2000);
        testContextSetup.landingPageproductName=landingPage.getProductName().split("-")[0].trim();
          System.out.println(testContextSetup.landingPageproductName+ " is extracted from Home page");

    }

  @When("Added {string} for selected items to the cart")
    public void items_added_to_cart(String quantity){
  landingPage.incrementQuantity(Integer.parseInt(quantity));
  landingPage.addToCart();
  }

}
