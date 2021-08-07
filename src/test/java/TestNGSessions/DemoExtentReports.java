package TestNGSessions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class DemoExtentReports {

ExtentReports extent;
ExtentSparkReporter sparkReporter;


    @BeforeSuite
    public void BeforeSuite() {
        extent = new ExtentReports();
        sparkReporter = new ExtentSparkReporter("report.html");
        extent.attachReporter(sparkReporter);
    }

    @AfterSuite
    public void AfterSuite() {
        extent.flush();
    }



    @Test
    public void DemoExtentReports(){

        ExtentTest test = extent.createTest("TC1_DemoExtentReports");
        System.setProperty("webdriver.chrome.driver", "C://selenium jars and drivers/drivers/chrome/chromedriver.exe");
        test.log(Status.INFO, "Launching the Chrome browser!");
        WebDriver driver = new ChromeDriver();
        test.info("Opening the URL on the browser: " + "http://www.stackoverflow.com");
        driver.get("http://www.stackoverflow.com");
        test.info("Clicking on the Login button!");
        driver.findElement(By.linkText("Log in")).click();
        test.pass("We have successfully clicked on the Login button");
        test.info("Closing the browser!");
        test.info("Disposing Selenium Sessions.");
        driver.close();
        driver.quit();
    }
    @Test
    public void DemoExtentReports2(){

        ExtentTest test = extent.createTest("TC2_DemoExtentReports");
        System.setProperty("webdriver.chrome.driver", "C://selenium jars and drivers/drivers/chrome/chromedriver.exe");
        test.log(Status.INFO, "Launching the Chrome browser!");
        WebDriver driver = new ChromeDriver();
        test.info("Opening the URLon the browser: " + "http://www.stackoverflow.com");
        driver.get("http://www.stackoverflow.com");
        test.info("Clicking on the Login button!");
        try {
            driver.findElement(By.linkText("BHog")).click();
        }
        catch (NoSuchElementException e) {
            test.fail("Unable to find the login button");
        }
        test.pass("We have successfully clicked on the Login button");
        test.info("Closing the browser!");
        test.info("Disposing Selenium Sessions.");
        driver.close();
        driver.quit();
    }

}

