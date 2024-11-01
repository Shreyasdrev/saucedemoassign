package operations;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import io.qameta.allure.Allure;

public class Operations {
	
	public WebDriver driver = null;
	
	//Declare log msg strings
		private final String msgClickSuccess = "Successfully Clicked On ";
		private final String msgClickFailure = "Unable To Click On ";
		private final String msgTypeSuccess = "Successfully Typed On '";
		private final String msgTypeFailure = "Unable To Type On '";
		public Operations() {

		}
	/**
	 *  Purpose: To Click
	 *  Inputs: By locator and locator name
	 *  Output: click status as boolean
	 *  Author/Date: Shreyas Revankar /31-11-2024
	 **/
	public boolean click(By locator, String locatorName) throws Exception {
		boolean status = false;
		try {            
			WebElement ele = this.driver.findElement(locator);
			if (ele.isDisplayed() && ele.isEnabled()) {
				ele.click();
				status = true;
				Assert.assertEquals(Status.PASS,  this.msgClickSuccess + "'" + locatorName + "'");
				Allure.description( this.msgClickSuccess + "'" + locatorName + "'");
			}
		} catch (Exception e) {
			status = false;
			Assert.assertEquals(Status.FAIL,  this.msgClickFailure + "'" + locatorName + "'");
			Allure.description( this.msgClickFailure + "'" + locatorName + "'");
			throw e;
		}
		return status;
	}
	
	/**
	 *  Purpose: To type
	 *  Inputs: locator, test data and locator name
	 *  Output: type status
	 * Author/Date: Shreyas Revankar /31-11-2024
	 **/
	public boolean type(By locator, String testdata, String locatorName) {
		boolean status = false;
		try {
			WebElement ele = driver.findElement(locator);
			ele.clear();
			ele.sendKeys(testdata);
			String strActValue = ele.getAttribute("value").trim(); 
			if (strActValue.equals(testdata)) {
				status = true;
				Assert.assertEquals(Status.PASS,  "Entered '" + testdata + "' into " + "'" + locatorName + "'");
				Allure.description( this.msgTypeSuccess + "'" + locatorName + "'");
			}
		} catch (Exception e) {
			status = false;
			Assert.assertEquals(Status.FAIL,  "Unable to type due to excpetion occurred : " + e.getMessage());
			Allure.description( this.msgTypeFailure + locatorName);
		}
		return status;
	}
	
	
	

	
	

}
