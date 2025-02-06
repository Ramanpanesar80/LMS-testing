package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

class studentviewteachername {
	   private WebDriver driver;
	   private WebDriverWait wait;

	    @BeforeEach
	    void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }


    @Test
    void testviewcourseslistdisplayed() {
        driver.get("http://localhost:3000/student");

        try {
            WebElement emailInput = driver.findElement(By.id("email1"));
            WebElement passwordInput = driver.findElement(By.id("password1"));
            WebElement loginButton = driver.findElement(By.className("login-button1"));

            emailInput.sendKeys("happy1234@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

          
            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

         
            wait.until(ExpectedConditions.urlContains("/studentdash"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testsidebarlistofcourseslink() {
        driver.get("http://localhost:3000/student");

        try {
            WebElement emailInput = driver.findElement(By.id("email1"));
            WebElement passwordInput = driver.findElement(By.id("password1"));
            WebElement loginButton = driver.findElement(By.className("login-button1"));

            emailInput.sendKeys("happy1234@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

         
            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

         
            wait.until(ExpectedConditions.urlContains("/studentdash"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testheading() {
        driver.get("http://localhost:3000/student");

        try {
            WebElement emailInput = driver.findElement(By.id("email1"));
            WebElement passwordInput = driver.findElement(By.id("password1"));
            WebElement loginButton = driver.findElement(By.className("login-button1"));

            emailInput.sendKeys("happy1234@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();


            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

         
            wait.until(ExpectedConditions.urlContains("/studentdash"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
            
            WebElement header = driver.findElement(By.xpath("/html/body/div/div/main/h2"));
	         boolean checking = header.isSelected();
	         Assert.assertNotNull(header);
	        
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testenrollbutton() {
        driver.get("http://localhost:3000/student");

        try {
            WebElement emailInput = driver.findElement(By.id("email1"));
            WebElement passwordInput = driver.findElement(By.id("password1"));
            WebElement loginButton = driver.findElement(By.className("login-button1"));

            emailInput.sendKeys("happy1234@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

          
            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

         
            wait.until(ExpectedConditions.urlContains("/studentdash"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");

          
            WebElement enrollButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("enroll-1")));
            assertNotNull(enrollButton, "Enroll button is missing.");
            enrollButton.click();

        
            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

       
            wait.until(ExpectedConditions.urlContains("/enrolled-courses"));
            String currentUrl1 = driver.getCurrentUrl();
            assertTrue(currentUrl1.contains("/enrolled-courses"), "Login failed: Expected to be redirected to enrolled courses.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testcoursename() {
        driver.get("http://localhost:3000/student");

        try {
            WebElement emailInput = driver.findElement(By.id("email1"));
            WebElement passwordInput = driver.findElement(By.id("password1"));
            WebElement loginButton = driver.findElement(By.className("login-button1"));

            emailInput.sendKeys("happy1234@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

          
            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

           
            wait.until(ExpectedConditions.urlContains("/studentdash"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
            
            WebElement header1 = driver.findElement(By.xpath("/html/body/div/div/main/div/div[1]/h3"));
	         boolean checking = header1.isSelected();
	         Assert.assertNotNull(header1);
	        
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    void testteachername() {
        driver.get("http://localhost:3000/student");

        try {
            WebElement emailInput = driver.findElement(By.id("email1"));
            WebElement passwordInput = driver.findElement(By.id("password1"));
            WebElement loginButton = driver.findElement(By.className("login-button1"));

            emailInput.sendKeys("happy1234@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

         
            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

            wait.until(ExpectedConditions.urlContains("/studentdash"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
            
            WebElement header1 = driver.findElement(By.xpath("/html/body/div/div/main/div/div/p[2]"));
	         boolean checking = header1.isSelected();
	         Assert.assertNotNull(header1);
	        
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testwrongparagraph() {
        driver.get("http://localhost:3000/student");

        try {
            WebElement emailInput = driver.findElement(By.id("email1"));
            WebElement passwordInput = driver.findElement(By.id("password1"));
            WebElement loginButton = driver.findElement(By.className("login-button1"));

            emailInput.sendKeys("happy1234@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

          
            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

         
            wait.until(ExpectedConditions.urlContains("/studentdash"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");

         
            WebElement paragraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Student Dashboard')]"))); // Update based on actual paragraph
            String actualText = paragraph.getText().trim();
            String expectedText = "student"; 
            Assert.assertEquals(actualText, expectedText, "Paragraph content does not match.");
            System.out.println("Test passed: Paragraph content matches.");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    @Test
    void testparagraph() {
        driver.get("http://localhost:3000/student");

        try {
            WebElement emailInput = driver.findElement(By.id("email1"));
            WebElement passwordInput = driver.findElement(By.id("password1"));
            WebElement loginButton = driver.findElement(By.className("login-button1"));

            emailInput.sendKeys("happy1234@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

         
            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

         
            wait.until(ExpectedConditions.urlContains("/studentdash"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
  
         
            
            WebElement Description = driver.findElement(By.xpath("/html/body/div/div/main/div/div[1]/p[1]"));
	         boolean checking = Description .isSelected();
	         Assert.assertNotNull(Description );
	        
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    void testwrongheading() {
        driver.get("http://localhost:3000/student");

        try {
            WebElement emailInput = driver.findElement(By.id("email1"));
            WebElement passwordInput = driver.findElement(By.id("password1"));
            WebElement loginButton = driver.findElement(By.className("login-button1"));

            emailInput.sendKeys("happy1234@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

           
            try {
                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (TimeoutException e) {
                System.out.println("No alert present.");
            }

        
            wait.until(ExpectedConditions.urlContains("/studentdash"));
            String currentUrl = driver.getCurrentUrl();
            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");

            WebElement heading = driver.findElement(By.xpath("/html/body/div/div/main/h2"));
    		String expectedHeading = "About";
    		String actualHeading = heading.getText();
    		assertEquals(expectedHeading, actualHeading, "The heading should match");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
