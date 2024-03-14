package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CheckoutPage;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinitions {

CheckoutPage checkoutPage;
    TestContextSetup testContextSetup;

    public CheckoutPageStepDefinitions(TestContextSetup testContextSetup){
        this.checkoutPage= testContextSetup.pageObjectManager.getCheckoutPage();
        this.testContextSetup=testContextSetup;
    }

   @Then("Verify user has ability to enter promo code and place the order")
    public void Verify_user_place_the_order(){

       Assert.assertTrue(checkoutPage.verifyPromoBtn());
       Assert.assertTrue(checkoutPage.verifyPlaceOrder());

   }

   @Then("^user proceeds to checkout and validate the (.+) items in checkout page$")
    public void User_validate_Checkout_Page(String name) throws InterruptedException {
      checkoutPage.checkoutItem();

   }


    }




