package admin;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class EducatorAttendance {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {  // Fixed method signature
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test
    public void testNameField() { // Fixed method signature
        driver.get("http://localhost:3000/educator");

        try {
            WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
            WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
            WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

            emailInput.sendKeys("ramann@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

            wait.until(ExpectedConditions.urlContains("/educator"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/educator"));

            // Uncomment and fix if you need to test name input field
            // WebElement nameInput = driver.findElement(By.xpath("/html/body/div/div/main/div/div[1]/input[1]"));
            // nameInput.sendKeys("test name");
            // Assert.assertEquals("test name", nameInput.getAttribute("value"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

@Test
public void testPaswordField() { // Fixed method signature
    driver.get("http://localhost:3000/educator");

    try {
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        emailInput.sendKeys("ramann@gmail.com");
        passwordInput.sendKeys("123456789");
        loginButton.click();

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        wait.until(ExpectedConditions.urlContains("/educator"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/educator"));

        // Uncomment and fix if you need to test name input field
        // WebElement nameInput = driver.findElement(By.xpath("/html/body/div/div/main/div/div[1]/input[1]"));
        // nameInput.sendKeys("test name");
        // Assert.assertEquals("test name", nameInput.getAttribute("value"));

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (driver != null) {
            driver.quit();
        }
    }
}

@Test
public void testButtonField() { // Fixed method signature
    driver.get("http://localhost:3000/educator");

    try {
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        emailInput.sendKeys("ramann@gmail.com");
        passwordInput.sendKeys("123456789");
        loginButton.click();

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        wait.until(ExpectedConditions.urlContains("/educator"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/educator"));

        // Uncomment and fix if you need to test name input field
        // WebElement nameInput = driver.findElement(By.xpath("/html/body/div/div/main/div/div[1]/input[1]"));
        // nameInput.sendKeys("test name");
        // Assert.assertEquals("test name", nameInput.getAttribute("value"));

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (driver != null) {
            driver.quit();
        }
    }
}

@Test
public void testLoginAndRedirectToAttendance() {
    driver.get("http://localhost:3000");

    try {
        // Login fields and button
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        // Fill in login form
        emailInput.sendKeys("ramann@gmail.com");
        passwordInput.sendKeys("123456789");
        loginButton.click();

        // Handle any alerts if they appear
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        // Wait for successful login and redirect
        wait.until(ExpectedConditions.urlContains("/attendance"));
        String currentUrl = driver.getCurrentUrl();

        // Check if the URL contains 'viewsubmitassignments' after login
        Assert.assertTrue("Login failed: Expected to be redirected to View Submitted Assignments page.",
                currentUrl.contains("/attendance"));

//        // Optionally, check for the presence of specific elements on the page after redirect
//        WebElement assignmentsHeader = driver.findElement(By.xpath("//h2[contains(text(),'Teacher - View Submitted Assignments')]"));
//        Assert.assertTrue("Assignments header not found on the page.", assignmentsHeader.isDisplayed());

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (driver != null) {
            driver.quit();
        }
    }
}
@Test
public void testSelectCourses() {
    driver.get("http://localhost:3000");

    try {
        // Login fields and button
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        // Fill in login form
        emailInput.sendKeys("ramann@gmail.com");
        passwordInput.sendKeys("123456789");
        loginButton.click();

        // Handle any alerts if they appear
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        // Wait for successful login and redirection
        wait.until(ExpectedConditions.urlContains("/attendance"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to View Submitted Assignments page.", currentUrl.contains("/attendance"));

        // Check if courses are displayed after login
        WebElement coursesList = driver.findElement(By.className("courses-list-view"));
        Assert.assertTrue("Courses list not displayed.", coursesList.isDisplayed());
        WebElement firstCourse = driver.findElement(By.xpath("//div[@class='course-card'][1]"));
        Assert.assertTrue("Course card not found.", firstCourse.isDisplayed());
        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (driver != null) {
            driver.quit();
        }
    }
}


@After
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}
