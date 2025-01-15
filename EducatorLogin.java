package testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class EducatorLogin {
	private WebDriver driver;

	@BeforeEach
    void setUp() {
		  driver = new ChromeDriver();
	}
	
	@AfterEach
    void tearDown() {
        // Cleanup after each test
        if (driver != null) {
            driver.quit();
        }
	}
	 private void loadHomePage() {
	        driver.get("http://localhost:3000/educator");  
	 }
	 
		@Test
	public void testEmailField() {

	 loadHomePage();
	 try {
          WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
         WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
         WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
         emailField.sendKeys("teacher@example.com");
         passwordField.sendKeys("password");
         loginButton.click();
         Thread.sleep(2000);
          String currentUrl = driver.getCurrentUrl();
         assertTrue("Should navigate to create-course page", currentUrl.contains("/create-course"));

         System.out.println("Test Passed: Login was successful.");
     } catch (Exception e) {
         System.out.println("Test Failed: " + e.getMessage());
     } finally {
        
         driver.quit();
     }
 }
@Test
		    public void testForgetPasswordField() {
		    	 loadHomePage();

		         try {
		             
		             WebElement forgotPasswordLink = driver.findElement(By.xpath("//a[text()='Forgot password?']"));
                     assertNotNull("Forgot password link should be present", forgotPasswordLink);
		             assertTrue("Forgot password link should be displayed", forgotPasswordLink.isDisplayed());
		             forgotPasswordLink.click();
                     String expectedUrl = "http://localhost:3000/forgot-password"; 
		             Thread.sleep(2000); 
		             String actualUrl = driver.getCurrentUrl();
		             assertEquals("User should be navigated to the Forgot Password page", expectedUrl, actualUrl);

		         } catch (Exception e) {
		             e.printStackTrace();
		         } finally {
		             
		             if (driver != null) {
		                 driver.quit();
		             }
		         }
		     }
		 

@Test
	void testalert() {
	    loadHomePage();
	 try {
         
         WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
         emailField.sendKeys("teacher@example.com");
         WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
         passwordField.sendKeys("password");
         WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
         loginButton.click();
        Alert alert = driver.switchTo().alert();
         String alertText = alert.getText();
         assertEquals("Login successful!", alertText);
         alert.accept();

         System.out.println("Alert button test passed: " + alertText);

     } catch (Exception e) {
         e.printStackTrace();
     } finally {
         
         if (driver != null) {
             driver.quit();
         }
     }
 }
	@Test
	void testButtonType() {
	    loadHomePage();
	    WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));
	    String buttonType = submitButton.getAttribute("type");
	    assertEquals("submit", buttonType, "The button type should be 'submit'");
	}
	@Test
	void testTitle() {
	 loadHomePage();
	 String expectedTitle = "React App";
	 String actualTitle = driver.getTitle();
	 assertEquals(expectedTitle, actualTitle, "The page title should match");
	}

	@Test
	void testwrongTitle() {
	 loadHomePage();
	 String expectedTitle = "Hospital";
	 String actualTitle = driver.getTitle();
	 assertEquals(expectedTitle, actualTitle, "The page title should match");
	}
	@Test
	void testheading() {
	 loadHomePage();
	 WebElement header = driver.findElement(By.xpath("/html/body/div/div/div/h2"));
	 boolean checking = header.isSelected();
	 Assert.assertNotNull(header);
	}

	@Test
	void testwrongHeading() {
	 loadHomePage();
	 WebElement heading = driver.findElement(By.xpath("/html/body/div/div/div/h2"));
		String expectedHeading = "About";
		String actualHeading = heading.getText();
		assertEquals(expectedHeading, actualHeading, "The heading should match");
	}
	
	@Test
	void testnextpage() {
	 loadHomePage();
    try {
        
        driver.get("http://localhost:3000"); 
         WebElement emailField = driver.findElement(By.xpath("//input[@type='email']"));
        emailField.sendKeys("teacher@example.com");
         WebElement passwordField = driver.findElement(By.xpath("//input[@type='password']"));
        passwordField.sendKeys("password");
         WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertEquals("Login successful!", alertText);
          alert.accept();
        String expectedUrl = "http://localhost:3000/create-course"; 
        Thread.sleep(2000); 
        String actualUrl = driver.getCurrentUrl();
        assertEquals("User should navigate to the Create Course page", expectedUrl, actualUrl);

        System.out.println("Alert navigation test passed.");

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        
        if (driver != null) {
            driver.quit();
        }
    }
}
	@Test
	void testButtonok() {
	    loadHomePage();
	    try {
            WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
            String buttonType = loginButton.getAttribute("type");
            assertEquals("submit", buttonType);
        } finally {
            
            driver.quit();
        }
    }
	@Test
    public void testButtonNavigation() {
		loadHomePage();
		 try {

     WebElement emailInput = driver.findElement(By.cssSelector("input[type='email']"));
     emailInput.sendKeys("teacher@example.com");
     WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
     passwordInput.sendKeys("password");
     WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
     loginButton.click();
     Thread.sleep(2000); 
     String currentUrl = driver.getCurrentUrl();
     assertEquals("http://localhost:3000/create-course", currentUrl); 
 } catch (Exception e) {
     e.printStackTrace();
 } finally {
   driver.quit();
 }
}
}






