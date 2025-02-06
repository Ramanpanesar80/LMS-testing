package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

class Educatorresetpassword {
	private WebDriver driver;
	   private WebDriverWait wait;

	    @BeforeEach
	    void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }


	    @Test
	    void testForgotPasswordFunctionality() {
	        driver.get("http://localhost:3000/forgot-password");

	        WebElement emailInput = driver.findElement(By.id("email"));
	        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Send Reset Email']"));

	        emailInput.sendKeys("happyhk1097@gmail.com");
	        submitButton.click();

	     
	        try {
	            wait.until(ExpectedConditions.alertIsPresent());
	            Alert alert = driver.switchTo().alert();
	            String alertText = alert.getText();
	            alert.accept();
	            
	          
	            assertTrue(alertText.contains("Password reset email sent to happyhk1097@gmail.com"), "The password reset email alert was not triggered as expected.");
	        } catch (TimeoutException e) {
	            System.out.println("No alert appeared, checking for alternative success message.");
	            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Password reset email sent to happyhk1097@gmail.com']")));
	            assertTrue(successMessage.isDisplayed(), "Success message not found.");
	        }
	    }
	    @Test
	    void testForgotPasswordField() {
	        driver.get("http://localhost:3000/forgot-password");

	        try {
	           
	            WebElement emailInput = driver.findElement(By.id("email"));

	           
	            emailInput.sendKeys("test@gmail.com");

	          

	         
	            
	        } catch (NoAlertPresentException e) {
	            System.out.println("No alert appeared, checking for alternative success message.");
	        }
	    }

	    
	    @Test
	    void testsendemailbutton() {
	    	 driver.get("http://localhost:3000/forgot-password");
	    	 
	    	 	     
	    	 	        WebElement emailInput = driver.findElement(By.id("email"));
	    	 	        WebElement submitButton = driver.findElement(By.xpath("//button[text()='Send Reset Email']"));
	    	 
	    	 	      
	    	 	        emailInput.sendKeys("happyhk@gmail.com");
	    	 	        submitButton.click();
	    	 
	    	 	        try {
	    	 	            wait.until(ExpectedConditions.alertIsPresent());
	    	 	            Alert alert = driver.switchTo().alert();
	    	 	            String alertText = alert.getText();
	    	 	            alert.accept();
	    	 	            
	    	 	          
	    	 	            assertTrue(alertText.contains("Password reset email sent to happyhk@gmail.com"), "The password reset email alert was not triggered as expected.");
	    	 	        } catch (TimeoutException e) {
	    	 	            System.out.println("No alert appeared, checking for alternative success message.");
	    	 	            WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()='Password reset email sent to happyhk1097@gmail.com']")));
	    	 	            assertTrue(successMessage.isDisplayed(), "Success message not found.");
	    	 	        }
	    	 	    }	


	        
	    

	    @AfterEach
	    void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
   
}

