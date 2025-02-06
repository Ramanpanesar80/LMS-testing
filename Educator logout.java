package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

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

class Educatorlogout {

	private WebDriver driver;
	   private WebDriverWait wait;

	    @BeforeEach
	    void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }


	


	 @Test
	    void testsignoutbutton() {
	        driver.get("http://localhost:3000/educator");

	        try {
	        	WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
	            WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
	            WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));


	            emailInput.sendKeys("educator1@gmail.com");
	            passwordInput.sendKeys("123456789");
	            loginButton.click();

	          
	            try {
	                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	                alert.accept();
	                System.out.println("Alert accepted.");
	            } catch (TimeoutException e) {
	                System.out.println("No alert present.");
	            }

	            wait.until(ExpectedConditions.urlContains("/create-course"));
	            String currentUrl = driver.getCurrentUrl();
	            assertTrue(currentUrl.contains("/create-course"), "Login failed: Expected to be redirected to student dashboard.");
	            

	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button")));
	            sidebarLink.click();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 @Test
	    void testsignoutbuttonisvisible() {
	        driver.get("http://localhost:3000/educator");

	        try {
	        	WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
	            WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
	            WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));


	            emailInput.sendKeys("educator1@gmail.com");
	            passwordInput.sendKeys("123456789");
	            loginButton.click();

	          
	            try {
	                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	                alert.accept();
	                System.out.println("Alert accepted.");
	            } catch (TimeoutException e) {
	                System.out.println("No alert present.");
	            }

	            wait.until(ExpectedConditions.urlContains("/create-course"));
	            String currentUrl = driver.getCurrentUrl();
	            assertTrue(currentUrl.contains("/create-course"), "Login failed: Expected to be redirected to student dashboard.");
	            


	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}

