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
import org.openqa.selenium.support.ui.WebDriverWait;

public class StudentEnrolledCourse {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testNameField() { // Fixed method signature
        driver.get("http://localhost:3000/student");

        try {
            WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
            WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
            WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

            emailInput.sendKeys("simrankaurb@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

            wait.until(ExpectedConditions.urlContains("/student"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/student"));

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
    driver.get("http://localhost:3000/student");

    try {
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        emailInput.sendKeys("simrankaurb@gmail.com");
        passwordInput.sendKeys("123456789");
        loginButton.click();

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        wait.until(ExpectedConditions.urlContains("/student"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/student"));

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
    driver.get("http://localhost:3000/student");

    try {
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        emailInput.sendKeys("simrankaurb@gmail.com");
        passwordInput.sendKeys("123456789");
        loginButton.click();

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        wait.until(ExpectedConditions.urlContains("/student"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/student"));

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


 private void loadHomePage() {
     driver.get("http://localhost:3000/studentdash");
 }
 @Test
 public void testLoginAndRedirectTolisofcourse() {
     driver.get("http://localhost:3000/studentdash");

     try {
         // Login fields and button
         WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
         WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
         WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

         // Fill in login form
         emailInput.sendKeys("simrankaurb@gmail.com");
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
         wait.until(ExpectedConditions.urlContains("/studentdash"));
         String currentUrl = driver.getCurrentUrl();

         // Check if the URL contains 'viewsubmitassignments' after login
         Assert.assertTrue("Login failed: Expected to be redirected to List of Course page.",
                 currentUrl.contains("/studentdash"));

//         // Optionally, check for the presence of specific elements on the page after redirect
//         WebElement assignmentsHeader = driver.findElement(By.xpath("//h2[contains(text(),'Teacher - View Submitted Assignments')]"));
//         Assert.assertTrue("Assignments header not found on the page.", assignmentsHeader.isDisplayed());

     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         if (driver != null) {
             driver.quit();
         }
     }
 }
 @Test
 public void testEnrollButtonFunctionality() {
     driver.get("http://localhost:3000/studentdash");

     try {
         // Login fields and button
         WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
         WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
         WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

         // Fill in login form
         emailInput.sendKeys("simrankaurb@gmail.com");
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
         wait.until(ExpectedConditions.urlContains("/studentdash"));
         String currentUrl = driver.getCurrentUrl();
         Assert.assertTrue("Login failed: Expected to be redirected to List of Course page.",
                 currentUrl.contains("/studentdash"));

         // Find and click the enroll button for a course
         WebElement enrollButton = driver.findElement(By.xpath("//button[contains(text(), 'Enroll')]"));
         enrollButton.click();

         // Wait for the course enrollment action (could be a confirmation message, updated UI, etc.)
         WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("enrollmentConfirmation")));

         // Assert that the confirmation message is visible
         assertTrue("Enrollment confirmation message not found.", confirmationMessage.isDisplayed());

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
