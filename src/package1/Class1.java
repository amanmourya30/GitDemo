package package1;

import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.List;
import org.testng.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Class1 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        String weekday = "friday";
        driver.get("https://testautomationpractice.blogspot.com/");
        
        
        System.out.println("PostJira");
        System.out.println("PostJira2");
        System.out.println("PostJira3");
        System.out.println("PostJira4");
        System.out.println("PostJira5");
        
        /*driver.findElement(By.cssSelector("#name")).sendKeys("Aman Mourya");
        driver.findElement(By.cssSelector("#email")).sendKeys("aman@email.com");
        driver.findElement(By.cssSelector("#phone")).sendKeys("1234567890");
        driver.findElement(By.id("textarea")).sendKeys("Jhansi");
        driver.findElement(By.cssSelector("input.form-check-input#male")).click();
        driver.findElement(By.xpath("(//input[@id='" + weekday + "'])[1]")).click();

        // Select country dropdown
        WebElement staticDropdpwn = driver.findElement(By.id("country"));
        Select dropdown = new Select(staticDropdpwn);
        dropdown.selectByVisibleText("Japan");
        System.out.println(dropdown.getFirstSelectedOption().getText());
//        Thread.sleep(1500L);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
//        Thread.sleep(1500L);
        dropdown.selectByValue("china");
        System.out.println(dropdown.getFirstSelectedOption().getText());
//        Thread.sleep(1500L);

        // Select colors dropdown
        WebElement scrollDropdown = driver.findElement(By.id("colors"));
        Select dropdown2 = new Select(scrollDropdown);
        dropdown2.selectByIndex(4);
        System.out.println(dropdown2.getFirstSelectedOption().getText());

        // Select date from calendar and then print date
        WebElement calender = driver.findElement(By.id("datepicker"));
        calender.click();
        driver.findElement(By.cssSelector(".ui-datepicker-today")).click();
        Thread.sleep(1500);
        System.out.println(calender.getAttribute("value"));

        // XPath for calendar dates //table[@class='ui-datepicker-calendar']//tr//td

        try {
            // Click on the "open cart" link
            driver.findElement(By.linkText("open cart")).click();

            // Get text from the element with id "challenge-running"
            System.out.println(driver.findElement(By.id("challenge-running")).getText());

        } catch (org.openqa.selenium.NoSuchElementException e) {
            // Handle the exception if the element is not found
            System.out.println("Element not found. Skipping interaction.");
        }
        driver.navigate().back();

        List<WebElement> values = driver.findElements(By.cssSelector("table[name='BookTable'] td:nth-child(4)"));
        int sum = 0;
        for (int i = 0; i < values.size(); i++) {
            sum = sum + Integer.parseInt(values.get(i).getText());
        }
        int a = 7100;
        System.out.println(sum);
        Assert.assertEquals(sum, a);*/
        
        List<WebElement> productsList = driver.findElements(By.cssSelector("table[id$='productTable'] td:nth-child(2)"));
        driver.findElement(By.xpath("//button[text()='Alert']")).click();
        Alert simpleAlert = driver.switchTo().alert();
        System.out.println(simpleAlert.getText());
        Thread.sleep(2000L);
        simpleAlert.accept();
     
        driver.findElement(By.xpath("//button[text()='Confirm Box']")).click();
        Alert confirmAlert=driver.switchTo().alert();
        System.out.println(confirmAlert.getText());
        Thread.sleep(2000L);
        confirmAlert.accept();
        
        driver.findElement(By.xpath("//button[text()='Prompt']")).click();
        Alert promptAlert=driver.switchTo().alert();
        String sentName = "Aman mourya";
        promptAlert.sendKeys(sentName);
        Thread.sleep(2000L);
        promptAlert.accept();
        
        String cnfrmMsg = driver.findElement(By.xpath("//p[@id='demo']")).getText().split("Hello")[1].trim().split("!")[0].trim();
        Assert.assertEquals(cnfrmMsg, sentName);
        System.out.println(cnfrmMsg);
        driver.close();

    }
}
