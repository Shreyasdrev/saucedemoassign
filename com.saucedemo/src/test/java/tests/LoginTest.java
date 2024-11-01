package tests;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.qameta.allure.Allure;
import pages.LoginPage;
import setup.Setup;
import utils.Utils;

public class LoginTest extends Setup{

	
	    LoginPage loginPage;
	    Utils utils=new Utils();
	    @Test(priority=3,description = "User gives valid credentials and login is successful")
	    public void loginWithValidCreds() throws IOException, ParseException, InterruptedException {
	        loginPage=new LoginPage(driver);
	        utils=new Utils();
	        utils.getUserCreds(0);
	        driver.get("https://www.saucedemo.com/v1/index.html");
	        boolean islblProductFound=loginPage.loginWithValidCreds(utils.getUsername(), utils.getPassword());
	        Assert.assertEquals(islblProductFound,true);
	        Allure.description("After giving valid credintials of the user, user will be able to successfully login " +
	                "and after login Products page will be displayed");
	    }
	    @Test(priority = 4,description = "Registered Username but incorrect Password Given")
	    public void loginWithInvalidCreds() throws IOException, ParseException, InterruptedException {
	        loginPage=new LoginPage(driver);
	        utils.getUserCreds(1);
	        driver.get("https://www.saucedemo.com/v1/index.html");
	        String validationMessage=loginPage.loginWithInvalidCreds(utils.getUsername(), utils.getPassword());
	        Assert.assertTrue(validationMessage.contains("Username and password do not match any user in this service"));
	        Allure.description("User has given registered username but incorrect password");
	    }
	    @Test(priority = 1,description = "User tries to login with blank username")
	    public void loginWithblankEmail() throws IOException, ParseException, InterruptedException {
	        loginPage=new LoginPage(driver);
	        utils.getUserCreds(3);
	        driver.get("https://www.saucedemo.com/v1/index.html");
	        String validationMessage=loginPage.loginWithblankUsername("", utils.getPassword());
	        Assert.assertTrue(validationMessage.contains("Epic sadface: Username is required"));
	        Allure.description("User has given valid password but no username is given,the username field is kept blank.Should give 'Username is required' ");
	    }
	    @Test(priority = 2,description = "User tries to login with blank password")
	    public void loginWithblankPass() throws IOException, ParseException, InterruptedException {
	        loginPage=new LoginPage(driver);
	        utils.getUserCreds(4);
	        driver.get("https://www.saucedemo.com/v1/index.html");
	        String validationMessage=loginPage.loginWithblankPassword(utils.getUsername(), "");
	        Assert.assertTrue(validationMessage.contains("Epic sadface: Password is required"));
	        Allure.description("User has given valid username but the password is kept as blank," +
	                "Should give 'Password is required' Message");
	    }
	    @Test(priority=5,description = "User tries to login with invalid username")
	    public void loginWithInvalidEmail() throws IOException, ParseException, InterruptedException {
	        loginPage=new LoginPage(driver);
	        utils.getUserCreds(2);
	        driver.get("https://www.saucedemo.com/v1/index.html");
	        String validationMessage=loginPage.loginWithInvalidCreds(utils.getUsername(), utils.getPassword());
		    Assert.assertTrue(validationMessage.contains("Username and password do not match any user in this service"));
	        Allure.description("If user does some mistake inputting username e.g: an initial extra space in between the username, " +
	                "then the user will be prompted as 'Username and password do not match any user in this service' message");
	    }
	 	   

	}
