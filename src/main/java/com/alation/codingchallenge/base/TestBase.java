package com.alation.codingchallenge.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.alation.codingchallenge.util.TestUtil;
import com.alation.codingchallenge.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	static Logger log = Logger.getLogger(TestBase.class);
	
	public TestBase() {
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("./src/main/java/com/alation/codingchallenge/config/config.properties");
			prop.load(ip);
		
	} catch(FileNotFoundException e) {
		e.printStackTrace();
	} catch(IOException e) {
		e.printStackTrace();
	}

}
	
	public static void initialization() throws MalformedURLException {
		String browserName = prop.getProperty("browser");
		/*if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "/Users/ramana/Downloads/chromedriver");
			driver = new ChromeDriver();
			log.info("Chrome driver initialised");
		} else 		if(browserName.equals("FF")) {
			System.setProperty("webdriver.gecko.driver", "/Users/ramana/Downloads/geckodriver");
			driver = new FirefoxDriver();
			log.info("FF driver initialised");
		} */
		
		//String host = "localhost";
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		
		/*if(System.getProperty("BROWSER") != null && 
				System.getProperty("BROWSER").equalsIgnoreCase("chrome"))
			dc = DesiredCapabilities.chrome();
		
		if (System.getProperty("HUB_HOST") != null)
			host=System.getProperty("HUB_HOST");
		
		String completeUrl = "http://" + host + ":4444/wd/hub"; */
		driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), dc);
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		e_driver.register(eventListener);
		driver = e_driver;
		
		
		//driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}

}