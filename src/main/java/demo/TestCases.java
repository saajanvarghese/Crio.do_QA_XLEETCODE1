package demo;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.logging.Level;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");

        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        LoggingPreferences logs = new LoggingPreferences();

        // Set log level and type
        logs.enable(LogType.BROWSER, Level.ALL);
        logs.enable(LogType.DRIVER, Level.ALL);
        options.setCapability("goog:loggingPrefs", logs);

        // Set path for log file
        System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "chromedriver.log");

        driver = new ChromeDriver(options);

        // Set browser to maximize and wait
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    
    public  void testCase01(){
            System.out.println("Start Test case: testCase01");
            String url=("https://leetcode.com/ ");
            String currentUrl;
    
            driver.get(url);
            currentUrl=driver.getCurrentUrl();
    
           //Verify that the URL contains "leetcode"
    
        if(currentUrl.contains("leetcode")){
            System.out.println("url of the page contains leetcode");
        }
        else{
    
            System.out.println("url of the page does not contain leetcode");
    
    
            System.out.println("end Test case: testCase01");
        }
    }

   public  void testCase02() throws InterruptedException{

    System.out.println("Start Test case: testCase02");

    // Click on the "Questions" link on the Leetcode homepage.

    WebElement Quest_link=driver.findElement(By.xpath("//p[text()='View Questions ']"));

    Quest_link.click();


   // Verify that you are on the problem set page, by checking the URL contains "problemset".

   String verify_link = driver.getCurrentUrl();

   if(verify_link.contains("problemset")){
    System.out.println("url contains problemset");
   }
   else{
     System.out.println("url does not contain problemset");
   }


   Thread.sleep(2000);

   for(int i=2;i<=6;i++){
    WebElement cell=driver.findElement(By.xpath("((//div[@role='rowgroup'])[2]//div[@role='row']//div[2])["+i+"]"));
    
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(cell));
    System.out.println(cell.getText());

    if(cell.getText().contains("Two Sum")){
        System.out.println("The URL of the problem contains \"two-sum\"");
    }
    else{
        System.out.println("The URL of the problem does not contain \"two-sum\"");
    }
    
   }

   System.out.println("end Test case: testCase02");

    }
public  void testCase03() throws InterruptedException{

    System.out.println("Start Test case: testCase03");

    //click on question 

    WebElement questionClick = driver.findElement(By.xpath("//*[@id=\"__next\"]/div[1]/div[2]/div[2]/div[1]/div[4]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div/a"));

    questionClick.click();

    Thread.sleep(2000);

    String currentlink = driver.getCurrentUrl();

    //validation of url

    if(currentlink.contains("two-sum")){
        System.out.println("The URL of the problem contains \"two-sum\"");
    }
    else{
        System.out.println("The URL of the problem does not contain \"two-sum\"");
    }

    System.out.println("end Test case: testCase03");

}

public  void testCase04() throws InterruptedException{

    System.out.println("Start Test case: testCase04");

    //click on Submission tab

    WebElement clickSubmissions = driver.findElement(By.xpath("//*[@id='qd-content']/div[1]/div/div/div/div[1]/div/div/a[4]"));

    clickSubmissions.click();

    WebElement Registerbtn = driver.findElement(By.xpath("//*[@id='qd-content']/div[1]/div/div/div/div[2]/div/div/a"));

    // retrieve the text of button using gettext();
    String Registerbtn_getText = Registerbtn.getText();

    //validation of Register or Sign IN button

    if(Registerbtn_getText.contains("Register or Sign In")){
        System.out.println("The message \"Register or Sign In\" is displayed when you click on the submissions tab");
    }
    else{
        System.out.println("The message \"Register or Sign In\" is not displayed when you click on the submissions tab");
    }
System.out.println("end Test case: testCase04");

}
}



