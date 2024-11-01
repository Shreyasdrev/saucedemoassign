package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import operations.Operations;

public class ProductsPage extends Operations {

	//Products page locators
	    @FindBy(id="item_4_title_link")
	    public WebElement lblProductBackPack;
	    @FindBy(id="item_0_title_link")
	    public WebElement lblProductBikeLight;
	    @FindBy(id="item_1_title_link") //
	    public WebElement lblProductBoltTshirt;
	    @FindBy(id="item_5_title_link")
	    public WebElement lblProductFleeceJacket;
	    @FindBy(id="item_2_title_link")
	    public WebElement lblProductOnesie;
	    @FindBy(id="item_3_title_link")
	    public WebElement lblProductTshirtRed;
	    @FindBy(xpath = "//button[contains(text(),'Close Menu')]")
	    public WebElement eXitBtnHamburger	;
	    @FindBy(xpath = "//*[@id='item_4_title_link']/../..//button[contains(text(), 'ADD TO CART')]")
	    public WebElement btnATCBackPack;
	    @FindBy(xpath = "//*[@id='item_0_title_link']/../..//button[contains(text(), 'ADD TO CART')]")
	    public WebElement btnATCBikeLight;
	    @FindBy(xpath = "//*[@id='item_1_title_link']/../..//button[contains(text(), 'ADD TO CART')]")
	    public WebElement btnATCBoltTshirt;
	    @FindBy(xpath = "//*[@id='item_5_title_link']/../..//button[contains(text(), 'ADD TO CART')]")
	    public WebElement btnATCFleeceJacket;
	    @FindBy(xpath = "//*[@id='item_2_title_link']/../..//button[contains(text(), 'ADD TO CART')]")
	    public WebElement btnATCOneSie;
	    @FindBy(xpath = "//*[@id='item_3_title_link']/../..//button[contains(text(), 'ADD TO CART')]")
	    public WebElement btnATCTShirtRed;
	    @FindBy(xpath = "//*[@id='item_4_title_link']/../..//button[contains(text(), 'REMOVE')]")
	    public WebElement btnRemoveBackPack;
	    @FindBy(xpath = "//*[@id='item_0_title_link']/../..//button[contains(text(), 'REMOVE')]")
	    public WebElement btnRemoveBikeLight;
	    @FindBy(xpath = "//*[@id='item_1_title_link']/../..//button[contains(text(), 'REMOVE')]")
	    public WebElement btnRemoveBoltTshirt;
	    @FindBy(xpath = "//*[@id='item_5_title_link']/../..//button[contains(text(), 'REMOVE')]")
	    public WebElement btnRemoveFleeceJacket;
	    @FindBy(xpath = "//*[@id='item_2_title_link']/../..//button[contains(text(), 'REMOVE')]")
	    public WebElement btnRemoveOneSie;
	    @FindBy(xpath = "//*[@id='item_3_title_link']/../..//button[contains(text(), 'REMOVE')]")
	    public WebElement btnRemoveTShirtRed;
	    @FindBy(xpath = "//*[@id='shopping_cart_container']//span[contains(text(), '1')]")
	    public WebElement crtUpdatedOneProduct;
	   
	    //Constructor
	    public ProductsPage(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);

	    }

	    //Test Steps
	    public boolean verifyAllProductsIsDisplayedOnProductsPage() throws Throwable {
	    	
	    	//All Products
	    	lblProductBackPack.isDisplayed();
	    	lblProductBikeLight.isDisplayed();
	    	lblProductBoltTshirt.isDisplayed();
	    	lblProductFleeceJacket.isDisplayed();
	    	lblProductOnesie.isDisplayed();
	    	lblProductTshirtRed.isDisplayed();
	    	
	    	//Add To Cart button of the products
	    	btnATCBackPack.isDisplayed();
	    	btnATCBikeLight.isDisplayed();
	    	btnATCBoltTshirt.isDisplayed();
	    	btnATCFleeceJacket.isDisplayed();
	    	btnATCOneSie.isDisplayed();
	    	btnATCTShirtRed.isDisplayed();
	    	return true;
			
		}
	
 public boolean verifyRemoveBtnAndUpdatedInCartIsDisplayedOnProductsPage() throws Throwable {
	    	
	        btnATCBackPack.click();// click on Add to Cart Button
	    	btnRemoveBackPack.isDisplayed(); //Remove button is displayed
	    	crtUpdatedOneProduct.isDisplayed(); // Cart is updated with one product
	    	
	    	//Products displayed
	    	lblProductBikeLight.isDisplayed();
	    	lblProductBoltTshirt.isDisplayed();
	    	lblProductFleeceJacket.isDisplayed();
	    	lblProductOnesie.isDisplayed();
	    	lblProductTshirtRed.isDisplayed();
	    	
	    	//Add To Cart button of remaining products
	    	btnATCBikeLight.isDisplayed();
	    	btnATCBoltTshirt.isDisplayed();
	    	btnATCFleeceJacket.isDisplayed();
	    	btnATCOneSie.isDisplayed();
	    	btnATCTShirtRed.isDisplayed();
	    	return true;
			
		}
	

}
