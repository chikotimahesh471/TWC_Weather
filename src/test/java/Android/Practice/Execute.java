package Android.Practice;

import org.testng.annotations.Test;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Execute {
	@BeforeTest
	public static void beforeTest() {
		System.out.println("========================================");
	}
  @Test
  public void function() throws Exception {

		// TODO Auto-generated method stub

	DesiredCapabilities caps=new DesiredCapabilities();
	
	caps.setCapability("deviceName", "Samsung");
	caps.setCapability("platformName", "Android");
	caps.setCapability("platformVersion", "8.0.0");
	caps.setCapability("appPackage", "com.weather.Weather");
	caps.setCapability("appActivity","com.weather.Weather.app.SplashScreenActivity");
	//caps.setCapability("appActivity", "com.weather.TWC");
	caps.setCapability("app","/Users/apple/Downloads/app_google_universal_release_812010105.apk");
	caps.setCapability("noReset", "true");
	caps.setCapability("automationName","UiAutomator2");
	
	AppiumDriver d=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
	Thread.sleep(15000);
	d.manage().timeouts().implicitlyWait(1000, TimeUnit.MICROSECONDS);
	
	try
	{
	//Scrolling down
		System.out.println("Scroll the app");
		
		org.openqa.selenium.Dimension dimensions = d.manage().window().getSize();
		Double screenHeightStart = dimensions.getHeight() * 0.5;
		int scrollStart = screenHeightStart.intValue();
		Double screenHeightEnd = dimensions.getHeight() * 0.2;
		int scrollEnd = screenHeightEnd.intValue();
		
		MobileElement module = null;
		MobileElement home = null;
		for(int i=1;i<=100;i++)
		{
	
		d.swipe(0,scrollStart,0,scrollEnd,3000);
		//lastmodule=d.findElementById("com.weather.Weather:id/air_quality_module_header").getText();
		try {
			
			WebDriverWait wait0 = new WebDriverWait(d, 10);
			wait0.until(ExpectedConditions.visibilityOf(d.findElementById("com.weather.Weather:id/air_quality_module_header")));
			module = (MobileElement)d.findElementById("com.weather.Weather:id/air_quality_module_header");
			
			
		} catch (Exception e) {
			// System.out.println(e);
		}
	
		if (module != null && module.isDisplayed())
break;
		System.out.println("scrolling");  
		}
	
	Thread.sleep(10000);
	
	System.out.println("Successfully scrolled");
	Thread.sleep(2000);
	// Scrolling up 
	System.out.println("Scroll up");
	
	
	org.openqa.selenium.Dimension size = d.manage().window().getSize();
	// Find swipe start and end point from screen’s with and height.
	// Find start y point which is at bottom side of screen.
	int starty = (int) (size.height * 0.80);
	// Find end y point which is at top side of screen.
	int endy = (int) (size.height * 0.20);
	// Find horizontal point where you wants to swipe. It is in middle of
	// screen width.
	int startx = size.width / 2;

		// Swipe from Bottom to Top.
	
		Thread.sleep(2000);
	
	
	
	for(int j=1;j<=100;j++)
	{

		d.swipe(0, endy, startx,0, 3000);
	try {
		
	WebDriverWait wait0 = new WebDriverWait(d, 10);
		wait0.until(ExpectedConditions.visibilityOf(d.findElementById("com.weather.Weather:id/current_weather_layout")));
		home = (MobileElement)d.findElementById("com.weather.Weather:id/current_weather_layout");
		
		
		
	} catch (Exception e) {
		// System.out.println(e);
	}

	if (home != null && home.isDisplayed())
break;
	System.out.println("scrolling up");
	}
	
	}
	catch(Exception e)
	{
		System.out.println("failed");
	}
	Thread.sleep(2000);
d.close();	
System.out.println("driver closed");
	
  }
}
