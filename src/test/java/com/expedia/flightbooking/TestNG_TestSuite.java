package com.expedia.flightbooking;

import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageclass.SearchPageFlightTab;

public class TestNG_TestSuite {

	private WebDriver driver;
	private String baseUrl;
	private static final Logger log = LogManager.getLogger(TestNG_TestSuite.class.getName());
    SearchPageFlightTab sp;
    
	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.gecko.driver", "/Users/hoanghien/drivers/geckodriver");
		driver = new FirefoxDriver();
		baseUrl = "https://www.expedia.com/";
        sp = new SearchPageFlightTab(driver);
		// Maximize the browser's window
		driver.manage().window().setSize(new Dimension(1920, 1080));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(baseUrl);
		log.info("Start url!");
	}

	@AfterClass
	public void tearDown() throws InterruptedException {
	    Thread.sleep(5000);
	    driver.close();
	}

	@Test
	public void searchExpedia() throws Exception {
       sp.navigateToFlightTab();
       
       sp.selectRoundTripTab();
       
       sp.inputOrigineLocation("Hồ");
       sp.selectSuggestedOrigineLocation();
       
       sp.inputDestinationLocation("Hà");
       sp.selectSuggestedDestinationLocation();

       sp.insertArrivalDate();
       sp.insertDepartureDate();
 
       sp.search();
       
       sp.assertSearchResult("Hanoi");
	}

	
}
