package admin;

import java.time.Duration;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Adminview {
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


//@Test
//public void testAdminViewPage() {
//    driver.get("http://localhost:3000/admin");
//
//    try {
//        // Perform login
//        WebElement emailInput = driver.findElement(By.xpath("//input[@type='email']"));
//        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
//        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
//
//        emailInput.sendKeys("admin@gmail.com");
//        passwordInput.sendKeys("Password123");
//        loginButton.click();
//
//        // Handle potential alert
//        try {
//            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//            alert.accept();
//            System.out.println("Alert accepted.");
//        } catch (TimeoutException e) {
//            System.out.println("No alert present.");
//        }
//
//        // Wait until redirected to Admin Dashboard
//        wait.until(ExpectedConditions.urlContains("/Admin-view"));
//        String currentUrl = driver.getCurrentUrl();
//        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/Admin-view"));
//
//        // Verify title is displayed
//        WebElement titleElement = driver.findElement(By.xpath("//h1[contains(text(),'Admin Dashboard')]"));
//        Assert.assertTrue("Admin Dashboard title is not displayed.", titleElement.isDisplayed());
//
//        // Verify table exists
//        WebElement table = driver.findElement(By.xpath("//table[@class='documents-t']"));
//        Assert.assertTrue("Table is not present in Admin View.", table.isDisplayed());
//
//        // Check if there are rows inside the table (excluding headers)
//        List<WebElement> tableRows = table.findElements(By.xpath(".//tbody/tr"));
//        Assert.assertFalse("No records found in the table.", tableRows.isEmpty());
//
//        // Verify delete button is present
//        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(text(),'Delete')]"));
//        Assert.assertTrue("Delete button is not displayed.", deleteButton.isDisplayed());
//
//    } catch (Exception e) {
//        e.printStackTrace();
//        Assert.fail("Test failed due to an exception: " + e.getMessage());
//    } finally {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
//}
//}
@Test
public void testAdminViewPageNavigation() {
    driver.get("http://localhost:3000/Admin-view");

    try {
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[contains(text(),'Login')]"));

        emailInput.sendKeys("admin@gmail.com");
        passwordInput.sendKeys("Password123");
        loginButton.click();

        // Handle alert if present
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        // Wait for the page to navigate to Admin-view
        wait.until(ExpectedConditions.urlContains("/Admin-view"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Failed to redirect to Admin-view page.", currentUrl.contains("/Admin-view"));

        // Navigate to Manage Users page
        WebElement manageUsersLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Manage Users')]")));
        manageUsersLink.click();
        wait.until(ExpectedConditions.urlContains("/manage-users"));

        // Navigate back to Admin View
        WebElement adminViewLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Admin View')]")));
        adminViewLink.click();
        wait.until(ExpectedConditions.urlContains("/Admin-view"));

        System.out.println("Successfully navigated to Admin-view page after login.");
    } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("Test failed due to an exception.");
    }
}


@Test
public void testAdminViewButton() {
    driver.get("http://localhost:3000/Admin-view");

    try {
        // Step 1: Wait until the Suspend button is clickable
        WebElement deletepostButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/main/h2")));
        Assert.assertTrue("Manage button not found.", deletepostButton.isDisplayed());

        // Step 2: Click the Suspend button
        deletepostButton.click();
        System.out.println("Delete button clicked.");

        // Step 3: Handle any confirmation (alert or modal)
        try {
            // Wait for a confirmation alert if it's a JavaScript alert
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("View confirmation alert accepted.");
        } catch (TimeoutException e) {
            // If no alert appears, print a message (maybe check for a modal or toast message instead)
            System.out.println("No confirmation alert present.");
        }

        // Step 4: Wait for the page to update (e.g., URL change, content change, etc.)
        wait.until(ExpectedConditions.urlContains("Admin-view"));

        // Step 5: Check if the page URL has changed after the suspend action (or any other verification)
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after Suspend action: " + currentUrl);
        Assert.assertTrue("Remove action failed or page not updated.", currentUrl.contains("/Admin-view"));

        // Optional: Check for any success message or change in page content
        // Example: Check for a success message or notification
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Suspension successful')]")));
        Assert.assertTrue("View action failed: Success message not found.", successMessage.isDisplayed());

    } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("Delete button test failed due to an exception.");
    }
}


@After
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}
