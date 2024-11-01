package tests;

import org.junit.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import pages.LoginPage;
import pages.ProductsPage;
import setup.Setup;
import utils.Utils;

public class ProductsPageTest extends Setup{

	    LoginPage loginPage;
	    ProductsPage productsPage;
	    Utils utils=new Utils();
	    @Test(priority=1,description = "User will verify all products are displayed after logging in")
	    public void verifyAllProductsIsDisplayedOnProductsPg() throws Throwable {
	    	loginPage=new LoginPage(driver);
	    	productsPage=new ProductsPage(driver);
	        utils=new Utils();
	        utils.getUserCreds(0);
	        driver.get("https://www.saucedemo.com/v1/index.html");
	        loginPage.loginWithValidCreds(utils.getUsername(), utils.getPassword());
	        boolean islblProductFound=productsPage.verifyAllProductsIsDisplayedOnProductsPage();
	        Assert.assertEquals(islblProductFound,true);
	        Allure.description("After loging in , user will be able to see all the products " +
	                "and verify all the products are displayed");
	    }
	    @Test(priority = 2,description = "User will Add product to cart and verify for 'Remove' button and product added to cart")
	    public void verifyRemoveBtnAndUpdatedInCartIsDisplayedOnProductsPage() throws Throwable {
	        loginPage=new LoginPage(driver);
	        utils.getUserCreds(0);
	        driver.get("https://www.saucedemo.com/v1/index.html");
	        loginPage.loginWithValidCreds(utils.getUsername(), utils.getPassword());
	        boolean isProductUpdatedInCart=productsPage.verifyRemoveBtnAndUpdatedInCartIsDisplayedOnProductsPage();
	        Assert.assertEquals(isProductUpdatedInCart,true);
	        Allure.description("User will add the back pack to cart and verify if the product is updated in the cart");
	    }
	   
	}
