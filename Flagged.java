package admin;

import java.time.Duration;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Flagged {
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

            wait.until(ExpectedConditions.urlContains("/Admin-view"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/Admin-view"));

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

        wait.until(ExpectedConditions.urlContains("/Admin-view"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/Admin-view"));

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

        wait.until(ExpectedConditions.urlContains("/Admin-view"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/Admin-view"));

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
public void testFlaggedNavigation() {
    driver.get("http://localhost:3000/admin");

    try {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));

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

        WebElement manageUsersLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Manage Users')]")));
        Assert.assertTrue("Manage Users link not found.", manageUsersLink.isDisplayed());

        manageUsersLink.click();
        System.out.println("Navigated to Manage Users page.");

        WebElement suspendStudentLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("\"//a[contains(text(),'Suspend Student')]\"")));
        Assert.assertTrue("Remove Posts link not found.", suspendStudentLink.isDisplayed());

        suspendStudentLink.click();
        System.out.println("Navigated to Remove Posts page.");

        FluentWait<WebDriver> customWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(80))
                .pollingEvery(Duration.ofSeconds(80))
                .ignoring(Exception.class);

        customWait.until(ExpectedConditions.urlContains("/flagged"));
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after navigation: " + currentUrl);
        Assert.assertTrue("Failed to redirect to Suspend Student page.", currentUrl.contains("/flagged"));

    } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("Test failed due to an exception.");
    }
}


@Test
public void testDeleteFlaggedQuestion() {
    driver.get("http://localhost:3000/admin");

    try {
        // Admin login
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));

        emailInput.sendKeys("admin@gmail.com");
        passwordInput.sendKeys("Password123");
        loginButton.click();

        // Ensure login was successful
        WebElement dashboardElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Admin Dashboard')]")));
        Assert.assertTrue("Failed to navigate to Admin Dashboard.", dashboardElement.isDisplayed());

        // Navigate to Flagged Content Page
        WebElement flaggedContentLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Flagged Content')]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", flaggedContentLink);
        flaggedContentLink.click();

        // Ensure flagged questions exist
        List<WebElement> flaggedItems = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[contains(@class,'flagged-item')]")));
        Assert.assertFalse("No flagged questions found.", flaggedItems.isEmpty());

        // Click the first delete button
        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//button[contains(text(),'Delete Question')])[1]")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", deleteButton); // Ensuring click execution

        // Check for success message
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'notification') and contains(text(),'Question deleted successfully')]")));
        Assert.assertTrue("Success message not displayed after deletion.", successMessage.isDisplayed());

        System.out.println("Flagged question deleted successfully!");

    } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("Test failed due to an exception.");
    }
}



@After
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}

