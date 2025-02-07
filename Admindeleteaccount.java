package admin;

import static org.junit.Assert.assertTrue;

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
import org.openqa.selenium.support.ui.FluentWait;

public class Permission {
    WebDriver driver;
    FluentWait<WebDriver> wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        // Improved wait strategy
        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
    }

    @Test
    public void testEmailField() {
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

            wait.until(ExpectedConditions.urlContains("/permission"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/permission"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Test
    public void testPasswordField() {
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

            wait.until(ExpectedConditions.urlContains("/permission"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/permission"));

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }

    @Test
    public void testPermissionPageNavigation() {
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

            WebElement suspendStudentLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(),'Suspend Student')]")));
            Assert.assertTrue("Remove Posts link not found.", suspendStudentLink.isDisplayed());

            suspendStudentLink.click();
            System.out.println("Navigated to Remove Posts page.");

            FluentWait<WebDriver> customWait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(80))
                    .pollingEvery(Duration.ofSeconds(80))
                    .ignoring(Exception.class);

            customWait.until(ExpectedConditions.urlContains("/permission"));
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL after navigation: " + currentUrl);
            Assert.assertTrue("Failed to redirect to Suspend Student page.", currentUrl.contains("/permission"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Test failed due to an exception.");
        }
    }

    @Test
    public void testGrandPermissionButton() {
        driver.get("http://localhost:3000/permission");

        try {
            // Step 1: Wait until the Suspend button is clickable
            WebElement deletepostButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Suspend')]")));
            Assert.assertTrue("Suspend button not found.", deletepostButton.isDisplayed());

            // Step 2: Click the Suspend button
            deletepostButton.click();
            System.out.println("Delete button clicked.");

            // Step 3: Handle any confirmation (alert or modal)
            try {
                // Wait for a confirmation alert if it's a JavaScript alert
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Remove confirmation alert accepted.");
            } catch (TimeoutException e) {
                // If no alert appears, print a message (maybe check for a modal or toast message instead)
                System.out.println("No confirmation alert present.");
            }

            // Step 4: Wait for the page to update (e.g., URL change, content change, etc.)
            wait.until(ExpectedConditions.urlContains("permission"));

            // Step 5: Check if the page URL has changed after the suspend action (or any other verification)
            String currentUrl = driver.getCurrentUrl();
            System.out.println("Current URL after Suspend action: " + currentUrl);
            Assert.assertTrue("Remove action failed or page not updated.", currentUrl.contains("/permission"));

            // Optional: Check for any success message or change in page content
            // Example: Check for a success message or notification
            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Suspension successful')]")));
            Assert.assertTrue("Remove action failed: Success message not found.", successMessage.isDisplayed());

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Remove button test failed due to an exception.");
        }
    }

    @Test
    public void testSignOut() {
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

            // Click the sign-out button
            WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Sign Out')]")));
            signOutButton.click();
            System.out.println("Sign out button clicked.");

            // Check if we're redirected to the login page or a logout confirmation
            wait.until(ExpectedConditions.urlContains("/login"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Sign-out failed or did not redirect to login page.", currentUrl.contains("/login"));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Sign out test failed due to an exception.");
        }
    }
//    @Test
//    void testRemovepostsNavigation() {
//        driver.get("http://localhost:3000/admin");
//
//        try {
//            // Locate elements using relative XPaths
//            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
//            WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
//            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
//
//            // Perform login
//            emailInput.sendKeys("admin@gmail.com");
//            passwordInput.sendKeys("Password123");
//            loginButton.click();
//
//            // Handle potential alert popup
//            try {
//                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//                alert.accept();
//                System.out.println("Alert accepted.");
//            } catch (org.openqa.selenium.TimeoutException e) {
//                System.out.println("No alert present.");
//            }
//
//            // Wait for admin dashboard to load
//            wait.until(ExpectedConditions.urlContains("/manage-users"));
//            Assert.assertSame(driver.getCurrentUrl().contains("/manage-users"), "Login failed: Expected to be redirected to admin dashboard.");
//
//            // Click the "Suspend Student" section in the sidebar
//            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//nav//ul//li[3]/a")));
//            sidebarLink.click();
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
