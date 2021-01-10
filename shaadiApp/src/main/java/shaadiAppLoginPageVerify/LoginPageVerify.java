package shaadiAppLoginPageVerify;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import pages.LoginPage;
import utils.PropertyReader;

public class LoginPageVerify {
	AppiumDriver driver;
	private static PropertyReader prop = new PropertyReader("config.properties");
	String platformName = prop.getProperty("platformName");
	String deviceName = prop.getProperty("deviceName");
	boolean noReset = true; 
	String appPackage = prop.getProperty("appPackage");
	String appActivity = prop.getProperty("appActivity");
	String premiumMatchName = prop.getProperty("premiumMatchName");
	String newMatchName = prop.getProperty("newMatchName");
	
	
	@BeforeTest
	public void setUp() throws MalformedURLException{
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", platformName);
		capabilities.setCapability("deviceName", deviceName); 
		capabilities.setCapability("noReset", noReset);
		capabilities.setCapability("appPackage",appPackage);
		capabilities.setCapability("appActivity",appActivity);
	    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
	}
	@Test
	public void verifyShaadiApp() throws InterruptedException
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.navigaeToMyShaadi();
		Assert.assertTrue(loginPage.verifyPremiumMatchesWidgets(), "Premium matches widget is available");
		loginPage.clickConnect(premiumMatchName);
		loginPage.swipeUp();
		Assert.assertTrue(loginPage.verifyNewMatchesWidgets(), "New matches widget is available");
		loginPage.clickConnect(newMatchName);
		
	}

}
