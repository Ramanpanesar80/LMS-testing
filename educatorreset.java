package Educatorr;

import static org.junit.Assert.*;

import java.time.Duration;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class educatorreset {
	private WebDriver driver;

    @Before
    public void setUp() {
       
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/forgot-password");  
    }
    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit(); 
        }
    }
	
    @Test
    public void testEmailField() {
        WebElement emailField = driver.findElement(By.xpath
        	("/html/body/div/div/div/form/div/input"));
        emailField.sendKeys("teacher@example.com");
        
        assertNotNull("Email input field should be present", emailField);
        assertTrue("Email input field should be displayed", emailField.isDisplayed());
        
    }
//    @Test
//    public void testPasswordField() {
//        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]"));
//        passwordField.sendKeys("Pargol12345");
//        assertNotNull("Password input field should be present", passwordField);
//        assertTrue("Password input field should be displayed", passwordField.isDisplayed());
//    }
//    @Test
//    public void testForgetPasswordField() {
//        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/p1/a"));
//        passwordField.sendKeys("Pargol12345");
//        assertNotNull("Password input field should be present", passwordField);
//        assertTrue("Password input field should be displayed", passwordField.isDisplayed());
//    }
//    @Test
//    public void testSelectRole() {
//        WebElement roleDropdown = driver.findElement(By.xpath("/html/body/div/div/div/form/select")); 
//        assertNotNull("Select Role dropdown should be present", roleDropdown);
//        assertTrue("Select Role dropdown should be displayed", roleDropdown.isDisplayed());
//        
//    }
    @Test
    public void testSendresetemail() {
        WebElement Sendreset = driver.findElement(By.xpath("/html/body/div/div/div/form/button")); 
        assertNotNull("Log In button should be present", Sendreset);
        assertTrue("Log In button should be displayed", Sendreset.isDisplayed());
        assertEquals("Button text should be 'Log In'", "Log In", Sendreset.getText());
    }
}

//    @Test
//    public void testSignUpLink() {
//       WebElement signUpLink = driver.findElement(By.xpath("/html/body/div/div/div/p/a")); 
//        signUpLink.click();
//        
//        String expectedUrl = "http://localhost:3000/signup"; 
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.urlToBe(expectedUrl));
//        
//        assertNotEquals("Clicking Sign Up should redirect to the signup page", expectedUrl, driver.getCurrentUrl());
//    }
//}
//@Test
//public void testAboutUs() {
//
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//    // Wait for the 'About Us' link to be clickable and then click it
//    WebElement aboutUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/footer/div/ul/li[1]/a")));
//    aboutUsLink.click();
//
//    // Wait for the expected URL and assert redirection
//    String expectedUrl = "http://localhost:3000/about"; 
//    wait.until(ExpectedConditions.urlToBe(expectedUrl));
//
//    // Verify that the URL is correct after the click
//    assertNotEquals(expectedUrl, driver.getCurrentUrl(), "Redirection to 'About Us' page failed from Doctor Dashboard.");
//}
//
//@Test
//public void testprivacypolicy() {
//
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//// Wait for the 'About Us' link to be clickable and then click it
//WebElement aboutUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/footer/div/ul/li[2]/a")));
//aboutUsLink.click();
//
//// Wait for the expected URL and assert redirection
//String expectedUrl = "http://localhost:3000/privacy-policy"; 
//wait.until(ExpectedConditions.urlToBe(expectedUrl));
//
//// Verify that the URL is correct after the click
//assertNotEquals(expectedUrl, driver.getCurrentUrl(), "Redirection to 'About Us' page failed from Doctor Dashboard.");
//}
//@Test
//public void testTermsandConditions() {
//
//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//// Wait for the 'About Us' link to be clickable and then click it
//WebElement aboutUsLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/footer/div/ul/li[3]/a")));
//aboutUsLink.click();
//
//// Wait for the expected URL and assert redirection
//String expectedUrl = "http://localhost:3000/terms-and-conditions"; 
//wait.until(ExpectedConditions.urlToBe(expectedUrl));
//
//// Verify that the URL is correct after the click
//assertNotEquals(expectedUrl, driver.getCurrentUrl(), "Redirection to 'About Us' page failed from Doctor Dashboard.");
//}
//
//  @Test
//  public void testFooterText() {
//      
//      WebElement footerText = driver.findElement(By.xpath("/html/body/div/div/footer/div/p"));
//      assertNotNull("Footer text should be present", footerText);
//      assertTrue("Footer should contain the correct copyright text", footerText.getText().contains("© 2024 Medical Appointment System. All Rights Reserved."));
//  }
//
//
//}
//
//
//
