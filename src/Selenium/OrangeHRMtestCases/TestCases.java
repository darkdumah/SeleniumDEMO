package Selenium.OrangeHRMtestCases;

import Selenium.OrangeHRMtestScenario;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCases extends OrangeHRMtestScenario{

    //CREATE NEW ChromeDriver and OPEN BROWSER AT baseURL
    @Test(priority = 1)
    void openBrowser() {

        driver = new ChromeDriver();
        driver.get(baseURL);
        System.out.println("Successfully opened browser");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    // CHECK TO SEE IF EXPECTED PAGE TITLE IS ACTUAL TITLE
    @Test(priority = 2)
    public void testPageTitle() throws InterruptedException {
        String expectedTitle = "OrangeHRM";
        String actualTitle = driver.getTitle();
        System.out.println("The title of the application is " + actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
        Thread.sleep(3000);
    }

    // LOGIN USING USERNAME AND PASSWORD, PRESS LOGIN BUTTON, CHECK IF LOGIN SUCCESSFUL
    @Test(priority = 3)
    public void loginAction() throws InterruptedException {
        driver.findElement(By.cssSelector("input[placeholder='Username']")).sendKeys("Admin");
        driver.findElement(By.cssSelector("input[placeholder='Password']")).sendKeys("admin123");
        driver.findElement(By.cssSelector("button[type='submit']")).click();
        Thread.sleep(3000);
        String dashboardPage = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
        if(baseURL == dashboardPage){
            System.out.println("Login failed");
        }else System.out.println("Login Successful");
    }

    // CLOSE BROWSER APPLICATION AFTER ALL TESTS HAVE EXECUTED
    @AfterTest
    void tearDown() throws InterruptedException {
        Thread.sleep(1500);
        System.out.println("All test cases have executed closing browser.");
        driver.close();
    }
}
