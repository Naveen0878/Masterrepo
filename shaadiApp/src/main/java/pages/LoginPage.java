package pages;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class LoginPage {
	private final AppiumDriver driver;
	
	
	 @FindBy(xpath = "//android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout//android.widget.TextView[contains(@text, 'My Shaadi')]")
	 WebElement myShaadi;
	 
	 @FindBy(xpath = "//android.widget.RelativeLayout//android.widget.TextView[contains(@text, 'My Shaadi')]")
	 WebElement myShaadiTop;
	 
	 @FindBy(xpath = "//android.widget.FrameLayout//android.widget.TextView[contains(@text, 'Premium Matches')]")
	 WebElement premiumMatches;
	 
	 @FindBy(xpath = "//android.widget.FrameLayout//android.widget.TextView[contains(@text, 'New Matches')]")
	 WebElement newMatches;
	 
	 org.openqa.selenium.Dimension dims;
	 
	 public static final String clickConnectNow = "//android.widget.TextView[contains(@text, '%s')]/../..//android.widget.TextView[contains(@text, 'Connect Now')]";
	 
	 public LoginPage(AppiumDriver driver) {

	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	 }
	 

	public void navigaeToMyShaadi() throws InterruptedException
	 {
		Thread.sleep(10000);
		myShaadi.click();
	 }
	
	public boolean verifyPremiumMatchesWidgets()
	 {
		 boolean status = false;
		 if(premiumMatches.isDisplayed())
		 {
			 status = true;
		 }
		 return status;
	 }
	public boolean verifyNewMatchesWidgets()
	 {
		 boolean status = false;
		 if(newMatches.isDisplayed())
		 {
			 status = true;
		 }
		 return status;
	 }
	public void clickConnect(String name)
	 {
		 driver.findElement(By.xpath(String.format(clickConnectNow, name))).click();
	 }
	 
	 public void swipeUp()
	 {
		   dims = driver.manage().window().getSize();
		   PointOption pointOptionStart,pointOptionEnd;
		   pointOptionStart = PointOption.point(dims.width/2, dims.height/2);
		   pointOptionEnd = PointOption.point(dims.width/2, dims.height/2 - 10);
		   new TouchActions(driver).longPress(premiumMatches).moveToElement(myShaadiTop).perform();
	 }

}
