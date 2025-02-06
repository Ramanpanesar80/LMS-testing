package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.List;

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

class profile {
	   private WebDriver driver;
	   private WebDriverWait wait;

	    @BeforeEach
	    void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }


	@AfterEach
	void tearDown() throws Exception {
	}

    private void loadHomePage() {
        driver.get("http://localhost:3000/ViewProfile");
    }


    @Test
    public void teststudentprofilebutton() {
        driver.get("http://localhost:3000/student");

        try {
         
            WebElement emailInput = driver.findElement(By.id("email1"));
            WebElement passwordInput = driver.findElement(By.id("password1"));
            WebElement loginButton = driver.findElement(By.className("login-button1"));

            emailInput.sendKeys("happy1234@gmail.com");
            passwordInput.sendKeys("123456789");
            loginButton.click();

           
            try {
                Alert alert = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.alertIsPresent());
                alert.accept();
                System.out.println("Alert accepted.");
            } catch (Exception e) {
                System.out.println("No alert present.");
            }

          
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login failed: Expected to be redirected to student dashboard, but found " + currentUrl,
                    currentUrl.contains("/studentdash"));

            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
            sidebarLink.click();

          

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Student Login Test encountered an exception but will not fail.");
        }
    }
    @Test
    void testupdateProfilebutton() {
        driver.get("http://localhost:3000/student");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

         
            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
            sidebarLink.click();

         
            WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/button[1]")));
            assertNotNull(updateProfileButton, "Update Profile button is missing.");
            updateProfileButton.click();

            System.out.println("Update Profile functionality works as expected.");
        } catch (Exception e) {
            fail("Test failed due to unexpected exception: " + e.getMessage());
        }
    }

    @Test
    void testnamefield() {
        driver.get("http://localhost:3000/student");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

          WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
          sidebarLink.click();

        
        
       
              WebElement nameInput = driver.findElement(By.id("name"));
              nameInput.sendKeys("test name");
              assertEquals("test name", nameInput.getAttribute("value"), "Name input should contain 'test name'");
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testemailfield() {
        driver.get("http://localhost:3000/student");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

    
          WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
          sidebarLink.click();

       
          WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/button[1]")));
          assertNotNull(updateProfileButton, "Update Profile button is missing.");
          updateProfileButton.click();

            
              WebElement emailInput1 = driver.findElement(By.xpath("/html/body/div/div/input[2]"));
              emailInput1.sendKeys("happy@gmail.com");
              assertEquals("happy@gmail.com", emailInput1.getAttribute("value"), "Email input should contain 'test email'");
          
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    @Test
    void testaddressfield() {
        driver.get("http://localhost:3000/student");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

         
          WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
          sidebarLink.click();

         
          WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/button[1]")));
          assertNotNull(updateProfileButton, "Update Profile button is missing.");
          updateProfileButton.click();

              
              WebElement addressInput = driver.findElement(By.xpath("/html/body/div/div/input[3]"));
              addressInput.sendKeys("nxcv");
              assertEquals("bhgh", addressInput.getAttribute("value"), "Email input should contain 'test email'");
          
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testPhonefield() {
        driver.get("http://localhost:3000/student");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

        
          WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
          sidebarLink.click();

          WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/button[1]")));
          assertNotNull(updateProfileButton, "Update Profile button is missing.");
          updateProfileButton.click();

          WebElement phoneInput = driver.findElement(By.xpath("/html/body/div/div/input[5]"));
          phoneInput.sendKeys("23553");
          assertEquals("353533", phoneInput.getAttribute("value"), "Email input should contain 'test email'");
          
          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testbackbutton1field() {
        driver.get("http://localhost:3000/student");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

      
          WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
          sidebarLink.click();

         
          
          WebElement backButton1 = driver.findElement(By.xpath("/html/body/div/div/button[3]"));
          assertNotNull(backButton1, "Update Profile button is missing.");
          backButton1.click();

          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    void testbackbuttonfield() {
        driver.get("http://localhost:3000/student");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

        
          WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
          sidebarLink.click();

    
          WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/button[1]")));
          assertNotNull(updateProfileButton, "Update Profile button is missing.");
          updateProfileButton.click();

          
          WebElement backButton = driver.findElement(By.xpath("/html/body/div/div/button[3]"));
          assertNotNull(backButton, "Update Profile button is missing.");
          backButton.click();

          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Test
    void testdateofbirthfield() {
        driver.get("http://localhost:3000/student");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

        
          WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
          sidebarLink.click();

      
          WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/button[1]")));
          assertNotNull(updateProfileButton, "Update Profile button is missing.");
          updateProfileButton.click();
          
          WebElement dateofbirthInput = driver.findElement(By.xpath("/html/body/div/div/button[3]"));
          dateofbirthInput.sendKeys("2025-05-20");
          assertEquals("2025-05-20",  dateofbirthInput.getAttribute("value"), "Email input should contain 'test email'");
      

          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     @Test
    void testheading() {
        driver.get("http://localhost:3000/student");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

        
          WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
          sidebarLink.click();

      
          WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/button[1]")));
          assertNotNull(updateProfileButton, "Update Profile button is missing.");
          updateProfileButton.click();
          
          WebElement header = driver.findElement(By.xpath("/html/body/div/div/div/h1"));
	         boolean checking = header.isSelected();
	         Assert.assertNotNull(header);
	        

          
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     @Test
     void testwrongheading() {
         driver.get("http://localhost:3000/student");
         wait = new WebDriverWait(driver, Duration.ofSeconds(10));

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

         
           WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
           sidebarLink.click();

       

           
           WebElement heading = driver.findElement(By.xpath("/html/body/div/div/h1"));
   		String expectedHeading = "About";
   		String actualHeading = heading.getText();
   		assertEquals(expectedHeading, actualHeading, "The heading should match");
 	        

           
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
     
 }
    

    

    
    

    

    

    

		



    


