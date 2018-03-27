package pageclass;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchPageFlightTab {

	private static Logger log = LogManager.getLogger(SearchPageFlightTab.class.getName());
	WebDriver driver;
	JavascriptExecutor js;

	@FindBy(id = "tab-flight-tab-hp")
	WebElement flighTab;

	@FindBy(id = "flight-type-roundtrip-hp-flight")
	WebElement roundTrip;

	@FindBy(id = "flight-type-one-way-label-hp-flight")
	WebElement oneWay;

	@FindBy(id = "flight-type-multi-dest-label-hp-flight")
	WebElement multiCity;

	@FindBy(id = "flight-origin-hp-flight")
	WebElement origineLocation;

	@FindBy(id = "flight-destination-hp-flight")
	WebElement destinationLocation;

	@FindBy(xpath = "//ul[@id='typeaheadDataPlain']/div/li/a[contains(@data-value,'Ho Chi Minh City')]")
	WebElement origineSuggestedPlace;

	@FindBy(xpath = "//ul[@id='typeaheadDataPlain']/div/li/a[contains(@data-value,'Hanoi')]")
	WebElement destinationSuggestedPlace;

	@FindBy(id = "flight-departing-hp-flight")
	WebElement checkInDate;

	@FindBy(id = "flight-returning-hp-flight")
	WebElement checkOutDate;

	@FindBy(xpath = "(//button[@class='btn-primary btn-action gcw-submit'])[1]")
	WebElement searchButton;

	@FindBy(xpath = "//h1/div/span[1]")
	WebElement searchResult;

	public SearchPageFlightTab(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;

		PageFactory.initElements(driver, this);
	}

	public void navigateToFlightTab() {
		try {
			flighTab.click();
			log.info("Click on Flights tab!");
		} catch (NoSuchElementException ne) {
			System.out.println("Please recheck your locator");
		}

	}

	public void selectRoundTripTab() {
		try {
			js.executeScript("arguments[0].click();", roundTrip);
			Thread.sleep(5000);
			log.info("Click on Roundtrip tab!");
		} catch (NoSuchElementException ne) {
			System.out.println("Please recheck your locator");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void doubleClickOnElement(WebElement el) {
		Actions action = new Actions(driver);
		action.doubleClick(el).build().perform();
	}

	public void inputOrigineLocation(String location) {
		try {
			origineLocation.sendKeys(location);
			log.info("Insert word for origine location to check suggestion!");
		} catch (NoSuchElementException ne) {
			System.out.println("Please recheck your locator");
		}
	}

	public void selectSuggestedOrigineLocation() {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(origineSuggestedPlace));
			log.info("Select suggested origine location!");
		} catch (NoSuchElementException ne) {
			System.out.println("Please recheck your locator");
		}
		doubleClickOnElement(origineSuggestedPlace);

	}

	public void inputDestinationLocation(String location) {
		try {
			destinationLocation.sendKeys(location);
			log.info("Insert word for destination location to check suggestion!");
		} catch (NoSuchElementException ne) {
			System.out.println("Please recheck your locator");
		}
	}

	public void selectSuggestedDestinationLocation() {
		try {
			new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(destinationSuggestedPlace));
			log.info("Select suggested destination location!");
		} catch (NoSuchElementException ne) {
			System.out.println("Please recheck your locator");
		}
		doubleClickOnElement(destinationSuggestedPlace);

	}

	public DateTimeFormatter getFormatDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		return formatter;
	}

	public ZonedDateTime getCurrentDate() {
		ZonedDateTime now = ZonedDateTime.now();
		return now;
	}

	public ZonedDateTime getDateWithInterval(int interval) {
		ZonedDateTime ckOutDate = getCurrentDate().plus(interval, ChronoUnit.DAYS);
		return ckOutDate;
	}

	public void insertArrivalDate() {
		try {
			checkInDate.clear();
			Thread.sleep(3000);
			checkInDate.sendKeys(getDateWithInterval(1).format(getFormatDate()));
			log.info("Insert checkin date as " + getDateWithInterval(1).format(getFormatDate()));
		} catch (NoSuchElementException ne) {
			System.out.println("Please recheck your locator");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void insertDepartureDate() {
		try {
			checkOutDate.clear();
			Thread.sleep(3000);
			checkOutDate.sendKeys(getDateWithInterval(3).format(getFormatDate()));
			log.info("Insert checkin date as " + getDateWithInterval(3).format(getFormatDate()));
		} catch (NoSuchElementException ne) {
			System.out.println("Please recheck your locator");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void search() {
		try {
			searchButton.click();
			log.info("Click on button Search!");
		} catch (NoSuchElementException ne) {
			System.out.println("Please recheck your locator");
		}
	}

	public void assertSearchResult(String value) {
		try {
			new WebDriverWait(driver, 15).
			until(ExpectedConditions.
					visibilityOf(searchResult));
		} catch (NoSuchElementException e) {
			System.out.println("Please recheck your locator");
		}

		boolean isExist = false;
		if (searchResult.getText().contains(value)) {
			isExist = true;
		}
		Assert.assertTrue(isExist);
	}

}
