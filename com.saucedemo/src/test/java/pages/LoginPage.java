package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import operations.Operations;

public class LoginPage extends Operations {

	//Login page locators
	    @FindBy(id="inventory_filter_container")
	    public WebElement lblProducts;
	    @FindBy(id="user-name")
	    public WebElement txtUsername;
	    @FindBy(id="password") 
	    public WebElement txtPassword;
	    @FindBy(id="login-button")
	    public WebElement btnLogin;
	    @FindBy(id="logout_sidebar_link")
	    public WebElement linkLogout;
	    @FindBy(id="menu_button_container")
	    public WebElement btnHamburger;
	    @FindBy(xpath = "//button[contains(text(),'Close Menu')]")
	    WebElement eXitBtnHamburger	;
	    @FindBy(xpath = "//h3[@data-test='error']")
	    public WebElement loginErrorMsg;
	   

	    //Constructor
	    public LoginPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	    }
	    

	    //Test Steps
	    public Boolean loginWithValidCreds(String username, String password) throws InterruptedException {
	        txtUsername.clear();
	        txtPassword.clear();
	        txtUsername.sendKeys(username);
	        Thread.sleep(1000);
	        txtPassword.sendKeys(password);
	        btnLogin.click();
	        Thread.sleep(1000);
	        return lblProducts.isDisplayed();
	    }

	    public String loginWithInvalidCreds(String username, String password) throws InterruptedException {
	    	txtUsername.clear();
	        txtPassword.clear();
	    	txtUsername.sendKeys(username);
	        Thread.sleep(1000);
	        txtPassword.sendKeys(password);
	        btnLogin.click();
	        Thread.sleep(1000);
	        return loginErrorMsg.getText();
	    }

	    public String loginWithblankUsername(String username, String password) throws InterruptedException {
	        txtUsername.clear();
	        Thread.sleep(1000);
	        txtPassword.clear();
	        txtPassword.sendKeys(password);
	        btnLogin.click();
	        Thread.sleep(3000);
	        return loginErrorMsg.getText();
	    }

	    public String loginWithblankPassword(String username, String password) throws InterruptedException {
	        txtUsername.clear();
	        txtPassword.clear();
	        txtUsername.sendKeys(username);
	        Thread.sleep(1500);
	        btnLogin.click();
	        Thread.sleep(3000);
	        return loginErrorMsg.getText();
	    }

	    public String loginWithInvalidUsername(String username, String password) throws InterruptedException {
	        txtUsername.clear();
	        txtPassword.clear();
	        txtUsername.sendKeys(username);
	        Thread.sleep(1000);
	        txtPassword.sendKeys(password);
	        btnLogin.click();
	        return loginErrorMsg.getText();
	    }

}
