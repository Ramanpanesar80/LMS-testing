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

class manageaccount {

	 private WebDriver driver;
	   private WebDriverWait wait;

	    @BeforeEach
	    void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	    @Test
	    void testnamefield() {
	        driver.get("http://localhost:3000/admin");
        try {
	       
	        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
	        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

	        emailInput.sendKeys("Admin@gmail.com");
	        passwordInput.sendKeys("Password123");
	        loginButton.click();

	    
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            System.out.println("Alert accepted.");
	        } catch (TimeoutException e) {
	            System.out.println("No alert present.");
	        }

	        
	        wait.until(ExpectedConditions.urlContains("/admin"));
	        String currentUrl = driver.getCurrentUrl();
	        assertTrue(currentUrl.contains("/admin"), "Login failed: Expected to be redirected to admin dashboard.");
            
	        WebElement nameInput = driver.findElement(By.xpath("/html/body/div/div/main/div/div[1]/input[1]"));
            nameInput.sendKeys("test name");
            assertEquals("test name", nameInput.getAttribute("value"), "Name input should contain 'test name'");
        
	     
}catch (Exception e) {
    e.printStackTrace();
}finally {
	 if (driver != null) {
         driver.quit();
     }
}
	    }
        
        @Test
	    void testpasswordfield() {
	        driver.get("http://localhost:3000/admin");
        try {
	      
	        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
	        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

	        emailInput.sendKeys("Admin@gmail.com");
	        passwordInput.sendKeys("Password123");
	        loginButton.click();

	    
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            System.out.println("Alert accepted.");
	        } catch (TimeoutException e) {
	            System.out.println("No alert present.");
	        }

	        
	        wait.until(ExpectedConditions.urlContains("/admin"));
	        String currentUrl = driver.getCurrentUrl();
	        assertTrue(currentUrl.contains("/admin"), "Login failed: Expected to be redirected to admin dashboard.");
            
	        WebElement passwordInput1 = driver.findElement(By.xpath("/html/body/div/div/main/div/div[1]/input[3]"));
            passwordInput1.sendKeys("test name");
            assertEquals("test name", passwordInput1.getAttribute("value"), "Name input should contain 'test name'");
        
	     
}catch (Exception e) {
    e.printStackTrace();
}finally {
	 if (driver != null) {
         driver.quit();
     }
}
       
	    }
        @Test
        void testnamefieldformatinnumber() {
            driver.get("http://localhost:3000/admin");

            try {
              
                WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
                WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
                WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

                emailInput.sendKeys("Admin@gmail.com");
                passwordInput.sendKeys("Password123");
                loginButton.click();

               
                try {
                    Alert alert = wait.until(ExpectedConditions.alertIsPresent());
                    alert.accept();
                    System.out.println("Alert accepted.");
                } catch (TimeoutException e) {
                    System.out.println("No alert present.");
                }

                
                wait.until(ExpectedConditions.urlContains("/admin"));
                String currentUrl = driver.getCurrentUrl();
                assertTrue(currentUrl.contains("/admin"), "Login failed: Expected to be redirected to admin dashboard.");

              
                WebElement nameInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/input[1]")));
                
              
                nameInput.sendKeys("test name");
                
                
                assertEquals("test name", nameInput.getAttribute("value"), "Name input should contain 'test name'");

                
                String initialNameValue = nameInput.getAttribute("value");
                nameInput.sendKeys(" additional text");
                String modifiedNameValue = nameInput.getAttribute("value");

                if (!modifiedNameValue.equals(initialNameValue + " additional text")) {
                    fail("Test failed: Name field value was unexpectedly modified.");
                }
                
            } catch (Exception e) {
                e.printStackTrace();
                fail("Test failed due to exception: " + e.getMessage());
            } finally {
                if (driver != null) {
                    driver.quit();
                }
            }
        }

        @Test
	    void testemailfield() {
	        driver.get("http://localhost:3000/admin");
        try {
	        
	        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
	        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

	        emailInput.sendKeys("Admin@gmail.com");
	        passwordInput.sendKeys("Password123");
	        loginButton.click();

	    
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            System.out.println("Alert accepted.");
	        } catch (TimeoutException e) {
	            System.out.println("No alert present.");
	        }

	        
	        wait.until(ExpectedConditions.urlContains("/admin"));
	        String currentUrl = driver.getCurrentUrl();
	        assertTrue(currentUrl.contains("/admin"), "Login failed: Expected to be redirected to admin dashboard.");
            
	        WebElement  emailInput1 = driver.findElement(By.xpath("/html/body/div/div/main/div/div[1]/input[2]"));
            emailInput1.sendKeys("test@gmail.com");
            assertEquals("test name", emailInput1.getAttribute("value"), "Name input should contain 'test name'");
        
	     
}catch (Exception e) {
    e.printStackTrace();
}   
        }
        
        @Test
	    void testaddbuttonfield() {
	        driver.get("http://localhost:3000/admin");
        try {
	        
	        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
	        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

	        emailInput.sendKeys("Admin@gmail.com");
	        passwordInput.sendKeys("Password123");
	        loginButton.click();

	    
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            System.out.println("Alert accepted.");
	        } catch (TimeoutException e) {
	            System.out.println("No alert present.");
	        }

	        
	        wait.until(ExpectedConditions.urlContains("/admin"));
	        String currentUrl = driver.getCurrentUrl();
	        assertTrue(currentUrl.contains("/admin"), "Login failed: Expected to be redirected to admin dashboard.");
            
            WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/main/div/div[1]/button")));
            assertNotNull(addButton, "Update Profile button is missing.");
            addButton.click();
	     
}catch (Exception e) {
    e.printStackTrace();
}
        }
        @Test
	    void testheading() {
	        driver.get("http://localhost:3000/admin");
        try {
	       
	        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
	        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

	        emailInput.sendKeys("Admin@gmail.com");
	        passwordInput.sendKeys("Password123");
	        loginButton.click();

	    
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            System.out.println("Alert accepted.");
	        } catch (TimeoutException e) {
	            System.out.println("No alert present.");
	        }

	        
	        wait.until(ExpectedConditions.urlContains("/admin"));
	        String currentUrl = driver.getCurrentUrl();
	        assertTrue(currentUrl.contains("/admin"), "Login failed: Expected to be redirected to admin dashboard.");
            
	        WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[3]/a")));
            sidebarLink.click();
	        
	        WebElement header = driver.findElement(By.xpath("/html/body/div/div/main/h2"));
            boolean checking = header.isSelected();
            Assert.assertNotNull(header);

	     
}catch (Exception e) {
    e.printStackTrace();
}
        }
        
        @Test
  	    void testwrongheading() {
  	        driver.get("http://localhost:3000/admin");
          try {
  	       
  	        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
  	        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
  	        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

  	        emailInput.sendKeys("Admin@gmail.com");
  	        passwordInput.sendKeys("Password123");
  	        loginButton.click();

  	    
  	        try {
  	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
  	            alert.accept();
  	            System.out.println("Alert accepted.");
  	        } catch (TimeoutException e) {
  	            System.out.println("No alert present.");
  	        }

  	        
  	        wait.until(ExpectedConditions.urlContains("/admin"));
  	        String currentUrl = driver.getCurrentUrl();
  	        assertTrue(currentUrl.contains("/admin"), "Login failed: Expected to be redirected to admin dashboard.");
              
  	        WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[3]/a")));
              sidebarLink.click();
  	        
              WebElement heading = driver.findElement(By.xpath("/html/body/div/div/main/h2"));
	    		String expectedHeading = "About";
	    		String actualHeading = heading.getText();
	    		assertEquals(expectedHeading, actualHeading, "The heading should match");
	            

  	     
  }catch (Exception e) {
      e.printStackTrace();
      Assert.fail("Test failed due to an exception: " + e.getMessage());
  }
          }
   
          
        @Test
	    void testdeletebutton() {
	        driver.get("http://localhost:3000/admin");
        try {
	       
	        WebElement emailInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/input"));
	        WebElement passwordInput = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/input"));
	        WebElement loginButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));

	        emailInput.sendKeys("Admin@gmail.com");
	        passwordInput.sendKeys("Password123");
	        loginButton.click();

	    
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            System.out.println("Alert accepted.");
	        } catch (TimeoutException e) {
	            System.out.println("No alert present.");
	        }

	        
	        wait.until(ExpectedConditions.urlContains("/admin"));
	        String currentUrl = driver.getCurrentUrl();
	        assertTrue(currentUrl.contains("/admin"), "Login failed: Expected to be redirected to admin dashboard.");
            
	        WebElement deleteButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/main/div/div[2]/div[1]/button")));
            assertNotNull(deleteButton, "Update Profile button is missing.");
            deleteButton.click();

	     
}catch (Exception e) {
    e.printStackTrace();

        }
        }
        @AfterEach
	    void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}



