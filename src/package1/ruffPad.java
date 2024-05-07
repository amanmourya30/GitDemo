package package1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ruffPad {
	    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(10);
		private static final FluentWait<WebDriver> wait = null;
		public static void main(String[] args) throws InterruptedException {
			WebDriver driver = initializeWebDriver();
			navigateToDataDogPage(driver);
			try {
				loginToDataDog(driver);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			String url = "https://us5.datadoghq.com/rum/sessions?query=%40type%3Asession%20%40session.has_replay%3Atrue%20%40session.time_spent%3A%3E100s%20-%40usr.email%3A%2Axtenav%2A&cols=&fromUser=true&sort_by=%40session.time_spent&sort_order=desc&from_ts=1707762600000&to_ts=1707848940000&live=false";
			driver.navigate().to(url);
			Thread.sleep(3000);

			List<WebElement> playIcons = driver.findElements(By.xpath("(//table)[1]/tbody/tr/td[1]"));
			if (!playIcons.isEmpty()) {
			    for (WebElement playIcon : playIcons) { 
					    playIcon.click();
					    // Switch to the new window
					    Set<String> windowHandles = driver.getWindowHandles();
					    List<String> windowHandlesList = new ArrayList<>(windowHandles);
					    String parentWindowHandle = windowHandlesList.get(0);
					    String newWindowHandle = windowHandlesList.get(1);
					    // Switch to the new window
					    driver.switchTo().window(newWindowHandle);
					    // Re-find elements in the new window
					    WebElement checkbox = driver.findElement(By.xpath("//span[@class='druids_typography_text druids_typography_text--md druids_typography_text--default druids_typography_text--normal druids_typography_text--left druids_form_checkbox']"));
					    checkbox.click();
					    // Close the new window
					    driver.close();
					    // Switch back to the parent window
					    driver.switchTo().window(parentWindowHandle);
					}
			    
			} 
			else 
			{
			    System.out.println("No play icons found.");
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			     // Scroll down by 500 pixels vertically
			    js.executeScript("window.scrollBy(0, 500)");
			    
			    for (WebElement playIcon : playIcons) { 
				    playIcon.click();
				    // Switch to the new window
				    Set<String> windowHandles = driver.getWindowHandles();
				    List<String> windowHandlesList = new ArrayList<>(windowHandles);
				    String parentWindowHandle = windowHandlesList.get(0);
				    String newWindowHandle = windowHandlesList.get(1);
				    // Switch to the new window
				    driver.switchTo().window(newWindowHandle);
				    // Re-find elements in the new window
				    WebElement checkbox = driver.findElement(By.xpath("//span[@class='druids_typography_text druids_typography_text--md druids_typography_text--default druids_typography_text--normal druids_typography_text--left druids_form_checkbox']"));
				    checkbox.click();
				    // Close the new window
				    driver.close();
				    // Switch back to the parent window
				    driver.switchTo().window(parentWindowHandle);
				}
			}       
	}
		
		private static WebDriver initializeWebDriver() {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(WAIT_TIMEOUT);
			return driver;
		}
		private static void navigateToDataDogPage(WebDriver driver) {
			driver.get("https://us5.datadoghq.com/rum/sessions?query=%40type%3Asession&cols=&fromUser=false&from_ts=1709635272606&to_ts=1709721672606&live=true");
		}
		private static void loginToDataDog(WebDriver driver) throws InterruptedException {
			driver.findElement(By.xpath("//button[@title='Sign in with Google']")).click(); //click on sign in with gmail
			driver.findElement(By.xpath("//input[@autocomplete='username']")).sendKeys("aman@xtenav.com"); //Enter email
			driver.findElement(By.xpath("//*[@id=\"identifierNext\"]/div/button/span")).click(); //clicks on Next
			Thread.sleep(1000L);
			driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input")).sendKeys("Aman@1995"); //Enter password
			driver.findElement(By.xpath("//*[@id=\"passwordNext\"]/div/button/span")).click();  //clicks on Next
			Thread.sleep(2000L);
		}
		public static void waitForElementToAppear(WebDriver driver, WebElement webElement ) 
		{
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(25));
			wait.until(ExpectedConditions.visibilityOf(webElement));
		}
		
}
