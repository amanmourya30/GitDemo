package package1;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.Set;
public class ClarityCode {
	private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = initializeWebDriver();
		navigateToClarityPage(driver);
		try {
			loginToClarity(driver);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// Open a new tab
		openNewTab(driver);
		// Switch to the new tab
		switchToNewTab(driver);
		// Navigate to a new URL in the new tab
		navigateToNewURL(driver,
				"https://clarity.microsoft.com/projects/view/dfnq4f54z0/impressions?date=Custom&end=1706898540000&start=1706812200000");
		Thread.sleep(2000L);
		
		// Perform actions in the loop
		for (int index = 1; index <= 1000; index++) {
			clickFavoriteButtonByIndex(driver, index);
		}
		// Close the browser
		driver.quit();
	}
	private static WebDriver initializeWebDriver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT);
		return driver;
	}
	private static void navigateToClarityPage(WebDriver driver) {
		driver.get("https://clarity.microsoft.com/");
	}
	private static void loginToClarity(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("id__85")).click();
		driver.findElement(By.cssSelector("#googleSignIn")).click();
		driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("aman@xtenav.com"); //Enter email
		driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click(); //clicks on Next
		driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Aman@1995"); //Enter password
		driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();  //clicks on Next
		Thread.sleep(2000L);
	}
	private static void openNewTab(WebDriver driver) {
		((JavascriptExecutor) driver).executeScript("window.open();");
	}
	private static void switchToNewTab(WebDriver driver) {
		Set<String> windowHandles = driver.getWindowHandles();
		for (String handle : windowHandles) {
			driver.switchTo().window(handle);
		}
	}
	private static void navigateToNewURL(WebDriver driver, String url) {
		driver.get(url);
	}
	private static void clickFavoriteButtonByIndex(WebDriver driver, int index) {
	    WebElement outerElement = driver.findElement(By.xpath("(//div[contains(@role,'article')])[" + index + "]"));
	    boolean innerElementFound = false;
	    int maxScrollAttempts = 3;
	    int currentAttempt = 0;
	    WebElement tableToScroll= driver.findElement(By.xpath("//div[@role='feed']"));
	    while (!innerElementFound && currentAttempt < maxScrollAttempts) {
	        try {
	            // Attempt to find the inner element
	            WebElement innerElement = outerElement.findElement(By.cssSelector("div button[data-clarity-id$='Favorite_Off']"));
	           
	            // If found, click the inner element and set the flag
	            innerElement.click();
	            innerElementFound = true;
	        } catch (NoSuchElementException e) {
	            // If inner element is not found, scroll the outer element into view
	            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollTop += 500", tableToScroll);
	            currentAttempt++;
	        }
	    }
	    // Optionally handle the case when inner element is not found after max attempts
	    if (!innerElementFound) {
	        System.out.println("Inner element not found after scrolling attempts.");
	    }
	}
}