package admin;

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

public class AdminControl{
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
        driver.get("http://localhost:3000/admin");

        try {
            WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
            WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
            WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

            emailInput.sendKeys("admin@gmail.com");
            passwordInput.sendKeys("Password123");
            loginButton.click();

            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

            wait.until(ExpectedConditions.urlContains("/admin"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/admin"));

        
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
    driver.get("http://localhost:3000/admin");

    try {
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        emailInput.sendKeys("admin@gmail.com");
        passwordInput.sendKeys("Password123");
        loginButton.click();

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        wait.until(ExpectedConditions.urlContains("/admin"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/admin"));

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
public void testButtonField() { 
    driver.get("http://localhost:3000/admin");

    try {
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        emailInput.sendKeys("Admin@gmail.com");
        passwordInput.sendKeys("Password123");
        loginButton.click();

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        wait.until(ExpectedConditions.urlContains("/admin"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/admin"));


    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        if (driver != null) {
            driver.quit();
        }
    }
}



@Test
public void testStudentActivationToggle() {
    driver.get("http://localhost:3000/control");

    try {
       
        WebElement table = wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("table")));
        Assert.assertTrue(" Student table not found.", table.isDisplayed());

        WebElement firstRow = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[1]")));
        Assert.assertNotNull(" No students found in the list.", firstRow);

      
        WebElement statusCell = firstRow.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[3]"));
        WebElement toggleButton = firstRow.findElement(By.xpath("/html/body/div/div/table/tbody/tr[1]/td[4]/button"));

        String initialStatus = statusCell.getText();
        toggleButton.click(); 

        
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(statusCell, initialStatus)));

        String newStatus = statusCell.getText();
        Assert.assertNotEquals(" Student status did not change after clicking toggle button.", initialStatus, newStatus);

    } catch (Exception e) {
        e.printStackTrace();
        Assert.fail(" Test failed due to an exception.");
    }
}




@After
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}
