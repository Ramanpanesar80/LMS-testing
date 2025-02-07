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

public class CourseDocuments {

    WebDriver driver;
    private FluentWait<WebDriver> wait;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("http://localhost:3000/educator");

        wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(Exception.class);
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

            wait.until(ExpectedConditions.urlContains("http://localhost:3000/upload-documents"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("http://localhost:3000/upload-documents"));

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

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/upload-documents"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("http://localhost:3000/upload-documents"));

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

        FluentWait<WebDriver> wait = null;
		try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        wait.until(ExpectedConditions.urlContains("http://localhost:3000/upload-documents"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("http://localhost:3000/upload-documents"));

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
public void testUploadDocumentPage() {
    driver.manage().deleteAllCookies();
    driver.get("http://localhost:3000/upload-documents");
    try {
        // ✅ Locate login fields
        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

        // ✅ Perform login
        emailInput.sendKeys("ramann@gmail.com");
        passwordInput.sendKeys("123456789");
        loginButton.click();

        // ✅ Wait for the page to load (ensure the page is fully loaded)
        Thread.sleep(2000); // Wait for 2 seconds before verifying the URL

        // You can also use an explicit wait to check for an element that should be visible after successful login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("http://localhost:3000/upload-documents")));

        // Check the current URL
        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL after login: " + currentUrl);

        // ✅ Assert that we are on the correct page
        Assert.assertTrue("Expected to be redirected to /upload-documents, but got: " + "/http://localhost:3000",
                currentUrl.contains("/http://localhost:3000"));

        // ✅ Verify page elements are loaded correctly
        WebElement pageHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/h1")));
        WebElement courseTableInput = driver.findElement(By.xpath("/html/body/div/div/div[2]/table"));
        WebElement courseadddocumentInput = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[2]/button"));
        WebElement courseuploadeddocumentButton = driver.findElement(By.xpath("/html/body/div/div/div[2]/table/tbody/tr[1]/td[3]/div[1]/div/button[1]"));

        // ✅ Assert page elements are present
        Assert.assertTrue("Header is not visible", pageHeader.isDisplayed());
        Assert.assertTrue("Course table is not visible", courseTableInput.isDisplayed());
        Assert.assertTrue("Add document button is not visible", courseadddocumentInput.isDisplayed());
        Assert.assertTrue("Uploaded document button is not visible", courseuploadeddocumentButton.isDisplayed());

        System.out.println("✅ Successfully logged in and loaded Upload Document page.");

    } catch (Exception e) {
        e.printStackTrace();
        Assert.fail("Test failed due to an exception.");
    }
}






//@Test
//public void testCourseTitleField() {
//    try {
//        // ✅ Login first (assuming login is required)
//        loginAsEducator();
//
//        // ✅ Ensure the page loads
//        wait.until(ExpectedConditions.urlContains("/create-course"));
//        System.out.println("✅ Successfully redirected to Create Course page.");
//
//        // ✅ Wait for Course Title input to be visible
//        WebElement courseTitleInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='courseTitle']")));
//
//        // ✅ Enter course title
//        String expectedTitle = "Introduction to Java";
//        courseTitleInput.sendKeys(expectedTitle);
//
//        // ✅ Verify that the text is correctly entered
//        Assert.assertEquals("Course title input mismatch", expectedTitle, courseTitleInput.getAttribute("value"));
//
//        System.out.println("✅ Course Title field accepts input correctly.");
//
//    } catch (Exception e) {
//        e.printStackTrace();
//        Assert.fail("Test failed due to an exception.");
//    }
//}
//
//
//
//
//





@After
public void tearDown() {
    if (driver != null) {
        driver.quit();
    }
}
}
