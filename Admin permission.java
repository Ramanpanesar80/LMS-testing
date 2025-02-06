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

class adminpermission {

	 private WebDriver driver;
	    private WebDriverWait wait;

	    @BeforeEach
	    void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	    @AfterEach
	    void tearDown() {
//	        if (driver != null) {
//	            driver.quit();
//	        }
	    }


	    @Test
	    void testSidebaradminpermissionlink() {
	        driver.get("http://localhost:3000/admin");

	        try {
	         
	            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
	            WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
	            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

	            emailInput.sendKeys("Admin@gmail.com");
	            passwordInput.sendKeys("Password123");
	            loginButton.click();

	          
	            try {
	                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	                alert.accept();
	                System.out.println("Alert accepted.");
	            } catch (org.openqa.selenium.TimeoutException e) {
	                System.out.println("No alert present.");
	            }

	            wait.until(ExpectedConditions.urlContains("/manage-users"));
	            assertTrue(driver.getCurrentUrl().contains("/manage-users"), "Login failed: Expected to be redirected to admin dashboard.");

	            
	            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[7]/a")));
	            sidebarLink.click();


	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    void testheading() {
	        driver.get("http://localhost:3000/admin");

	        try {
	         
	            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
	            WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
	            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

	            emailInput.sendKeys("Admin@gmail.com");
	            passwordInput.sendKeys("Password123");
	            loginButton.click();

	          
	            try {
	                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	                alert.accept();
	                System.out.println("Alert accepted.");
	            } catch (org.openqa.selenium.TimeoutException e) {
	                System.out.println("No alert present.");
	            }

	            wait.until(ExpectedConditions.urlContains("/manage-users"));
	            assertTrue(driver.getCurrentUrl().contains("/manage-users"), "Login failed: Expected to be redirected to admin dashboard.");

	            
	            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[7]/a")));
	            sidebarLink.click();
	            
	            WebElement Description = driver.findElement(By.xpath("/html/body/div/div/header/h1"));
		         boolean checking = Description .isSelected();
		         Assert.assertNotNull(Description );


	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    @Test
	    void testwrongheading() {
	        driver.get("http://localhost:3000/admin");

	        try {
	         
	            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
	            WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
	            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

	            emailInput.sendKeys("Admin@gmail.com");
	            passwordInput.sendKeys("Password123");
	            loginButton.click();

	          
	            try {
	                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	                alert.accept();
	                System.out.println("Alert accepted.");
	            } catch (org.openqa.selenium.TimeoutException e) {
	                System.out.println("No alert present.");
	            }

	            wait.until(ExpectedConditions.urlContains("/manage-users"));
	            assertTrue(driver.getCurrentUrl().contains("/manage-users"), "Login failed: Expected to be redirected to admin dashboard.");

	            
	            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[7]/a")));
	            sidebarLink.click();
	            
	            WebElement heading = driver.findElement(By.xpath("/html/body/div/div/header/h1"));
	    		String expectedHeading = "About";
	    		String actualHeading = heading.getText();
	    		assertEquals(expectedHeading, actualHeading, "The heading should match");


	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    @Test
	    void testpermissionbutton() {
	        driver.get("http://localhost:3000/admin");

	        try {
	         
	            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
	            WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
	            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

	            emailInput.sendKeys("Admin@gmail.com");
	            passwordInput.sendKeys("Password123");
	            loginButton.click();

	          
	            try {
	                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	                alert.accept();
	                System.out.println("Alert accepted.");
	            } catch (org.openqa.selenium.TimeoutException e) {
	                System.out.println("No alert present.");
	            }

	            wait.until(ExpectedConditions.urlContains("/manage-users"));
	            assertTrue(driver.getCurrentUrl().contains("/manage-users"), "Login failed: Expected to be redirected to admin dashboard.");

	            
	            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[7]/a")));
	            sidebarLink.click();
	            
	            WebElement sidebarLink1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/table/tbody/tr[1]/td[3]/button")));
	            sidebarLink1.click();
	           


	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    @Test
	    void testtitle() {
	        driver.get("http://localhost:3000/admin");

	        try {
	         
	            WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
	            WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
	            WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

	            emailInput.sendKeys("Admin@gmail.com");
	            passwordInput.sendKeys("Password123");
	            loginButton.click();

	          
	            try {
	                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	                alert.accept();
	                System.out.println("Alert accepted.");
	            } catch (org.openqa.selenium.TimeoutException e) {
	                System.out.println("No alert present.");
	            }

	            wait.until(ExpectedConditions.urlContains("/manage-users"));
	            assertTrue(driver.getCurrentUrl().contains("/manage-users"), "Login failed: Expected to be redirected to admin dashboard.");

	            
	            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[7]/a")));
	            sidebarLink.click();
	            
	            WebElement sidebarLink1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/table/tbody/tr[1]/td[3]/button")));
	            sidebarLink1.click();
	            String expectedTitle = "React App";
	       	 String actualTitle = driver.getTitle();
	       	 assertEquals(expectedTitle, actualTitle, "The page title should match");


	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
@Test
void testwrongtitle() {
    driver.get("http://localhost:3000/admin");

    try {
     
        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='email']")));
        WebElement passwordInput = driver.findElement(By.xpath("//input[@type='password']"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));

        emailInput.sendKeys("Admin@gmail.com");
        passwordInput.sendKeys("Password123");
        loginButton.click();

      
        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (org.openqa.selenium.TimeoutException e) {
            System.out.println("No alert present.");
        }

        wait.until(ExpectedConditions.urlContains("/manage-users"));
        assertTrue(driver.getCurrentUrl().contains("/manage-users"), "Login failed: Expected to be redirected to admin dashboard.");

        
        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[7]/a")));
        sidebarLink.click();
        
        WebElement sidebarLink1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div/table/tbody/tr[1]/td[3]/button")));
        sidebarLink1.click();
        String expectedTitle = "React";
   	 String actualTitle = driver.getTitle();
   	 assertEquals(expectedTitle, actualTitle, "The page title should match");


    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
	
	
