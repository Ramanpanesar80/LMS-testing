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
import org.openqa.selenium.support.ui.FluentWait;

public class Studentresetpassword {

    WebDriver driver;
    private FluentWait<WebDriver> wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:3000/forgot-password");

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
    }

  
    
    @Test
    public void testNameField() { // Fixed method signature
        driver.get("http://localhost:3000/forgot-password");

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

            wait.until(ExpectedConditions.urlContains("http://localhost:3000/forgot-password"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("http://localhost:3000/forgot-password"));

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
    driver.get("http://localhost:3000/forgot-password");

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

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/forgot-password"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("http://localhost:3000/forgot-password"));

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
    driver.get("http://localhost:3000/forgot-password");

    try {
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        emailInput.sendKeys("simrankaurb@gmail.com");
        passwordInput.sendKeys("123456789");
        loginButton.click();

        FluentWait<WebDriver> wait = null;
		try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/forgot-password"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("http://localhost:3000/forgot-password"));

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



//    @Test
//    public void testPageLoadSuccessfully() {
//        WebElement header = driver.findElement(By.xpath("/html/body/div/div/header/h1"));
//        assertEquals("Add Course", header.getText());
//    }

//    @Test
//    public void testEmptyTitleField() {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//        
//        WebElement titleField = driver.findElement(By.name("title"));  // ✅ Fixed input field
//        titleField.sendKeys("");
//
//        WebElement signoutButton = driver.findElement(By.xpath("/html/body/div/div/header/div/button"));
//        signoutButton.click();
//
//        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//        String alertText = alert.getText();
//        assertEquals("Please fill in all fields.", alertText);
//        alert.accept();
//    }
    
@Test
public void testForgotPasswordPage() {
	 driver.get("http://localhost:3000/forgot-password");
    try {
        // ✅ Locate login fields on the login page
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        // ✅ Perform login with valid credentials
        emailInput.sendKeys("simrankaurb@gmail.com");
        passwordInput.sendKeys("123456789");
        loginButton.click();

        // ✅ Wait for the redirect to the forgot-password page
        wait.until(ExpectedConditions.urlContains("/forgot-password"));

        String currentUrl = driver.getCurrentUrl();

        // ✅ Assert that the URL is correct
        Assert.assertTrue("Expected to be redirected to /forgot-password, but got: " + currentUrl,
                currentUrl.contains("http://localhost:3000/forgot-password"));

        // ✅ Verify elements on the Forgot Password page: Email input and "Send Reset Email" button
        WebElement emailInputOnForgotPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div/form/div/input")));
        WebElement sendResetEmailButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        // ✅ Assert the visibility of the elements
        Assert.assertTrue("Email input on Forgot Password page not found", emailInputOnForgotPassword.isDisplayed());
        Assert.assertTrue("'Send Reset Email' button not found", sendResetEmailButton.isDisplayed());

        System.out.println("✅ Successfully logged in and redirected to the Forgot Password page with email and reset button visible.");

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
