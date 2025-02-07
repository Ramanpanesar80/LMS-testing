package admin;

import java.time.Duration;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.TimeoutException;

public class Login {
    private WebDriver driver;
    private WebDriverWait wait;

    @Before
    public void setUp() {  // Fixed method signature
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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

            wait.until(ExpectedConditions.urlContains("/educator"));
            String currentUrl = driver.getCurrentUrl();
            Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/educator"));

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

        wait.until(ExpectedConditions.urlContains("/educator"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/educator"));

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

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
            System.out.println("Alert accepted.");
        } catch (TimeoutException e) {
            System.out.println("No alert present.");
        }

        wait.until(ExpectedConditions.urlContains("/educator"));
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("Login failed: Expected to be redirected to admin dashboard.", currentUrl.contains("/educator"));

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
}


	
//          String currentUrl = driver.getCurrentUrl();
//          org.junit.Assert.assertTrue("Login failed: Expected to be redirected to student dashboard, but found " + currentUrl,
//                  currentUrl.contains("/manage-users"));
//      }}

//          WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10))
//              .until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
//          sidebarLink.click();

        

//      } catch (Exception e) {
//          e.printStackTrace();
////          fail("Student Login Test encountered an exception but will not fail.");
//      }
//  }}
//  @Test
//  void testupdateProfile() {
//      driver.get("http://localhost:3000/student");
//      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//      try {
//        
//          WebElement emailInput = driver.findElement(By.id("email1"));
//          WebElement passwordInput = driver.findElement(By.id("password1"));
//          WebElement loginButton = driver.findElement(By.className("login-button1"));
//
//          emailInput.sendKeys("happy22@gmail.com");
//          passwordInput.sendKeys("123456789");
//          loginButton.click();
//
//      
//          try {
//              Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//              alert.accept();
//              System.out.println("Alert accepted.");
//          } catch (TimeoutException e) {
//              System.out.println("No alert present.");
//          }
//
//          
//          wait.until(ExpectedConditions.urlContains("/studentdash"));
//          String currentUrl = driver.getCurrentUrl();
//          assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
//
//       
//          WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
//          sidebarLink.click();
//
//       
//          WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/button[1]")));
//          assertNotNull(updateProfileButton, "Update Profile button is missing.");
//          updateProfileButton.click();
//
//          System.out.println("Update Profile functionality works as expected.");
//      } catch (Exception e) {
//          fail("Test failed due to unexpected exception: " + e.getMessage());
//      }
//  }
//
//  private void assertNotNull(WebElement updateProfileButton, String string) {
//	// TODO Auto-generated method stub
//	
//}
//
//
//private void assertTrue(boolean contains, String string) {
//	// TODO Auto-generated method stub
//	
//}
//
//
//@Test
//  void testnamefield() {
//      driver.get("http://localhost:3000/student");
//      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//      try {
//        
//          WebElement emailInput = driver.findElement(By.id("email1"));
//          WebElement passwordInput = driver.findElement(By.id("password1"));
//          WebElement loginButton = driver.findElement(By.className("login-button1"));
//
//          emailInput.sendKeys("happy22@gmail.com");
//          passwordInput.sendKeys("123456789");
//          loginButton.click();
//
//       
//          try {
//              Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//              alert.accept();
//              System.out.println("Alert accepted.");
//          } catch (TimeoutException e) {
//              System.out.println("No alert present.");
//          }
//
//      
//        wait.until(ExpectedConditions.urlContains("/studentdash"));
//        String currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
//
//        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
//        sidebarLink.click();
//
//      
//        WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/button[1]")));
//        assertNotNull(updateProfileButton, "Update Profile button is missing.");
//        updateProfileButton.click();
//
//     
//            WebElement nameInput = driver.findElement(By.id("name"));
//            nameInput.sendKeys("test name");
//            assertEquals("test name", nameInput.getAttribute("value"), "Name input should contain 'test name'");
//        
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//  }
//  @Test
//  void testemailfield() {
//      driver.get("http://localhost:3000/student");
//      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//      try {
//         
//          WebElement emailInput = driver.findElement(By.id("email1"));
//          WebElement passwordInput = driver.findElement(By.id("password1"));
//          WebElement loginButton = driver.findElement(By.className("login-button1"));
//
//          emailInput.sendKeys("happy22@gmail.com");
//          passwordInput.sendKeys("123456789");
//          loginButton.click();
//
//         
//          try {
//              Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//              alert.accept();
//              System.out.println("Alert accepted.");
//          } catch (TimeoutException e) {
//              System.out.println("No alert present.");
//          }
//
//        
//        wait.until(ExpectedConditions.urlContains("/studentdash"));
//        String currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
//
//  
//        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
//        sidebarLink.click();
//
//     
//        WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/button[1]")));
//        assertNotNull(updateProfileButton, "Update Profile button is missing.");
//        updateProfileButton.click();
//
//          
//            WebElement emailInput1 = driver.findElement(By.xpath("/html/body/div/div/div/input[2]"));
//            emailInput1.sendKeys("preet@gmail.com");
//            assertEquals("preet@gmail.com", emailInput1.getAttribute("value"), "Email input should contain 'test email'");
//        
//        
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//  }
//  
//  
//  @Test
//  void testaddressfield() {
//      driver.get("http://localhost:3000/student");
//      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//      try {
//        
//          WebElement emailInput = driver.findElement(By.id("email1"));
//          WebElement passwordInput = driver.findElement(By.id("password1"));
//          WebElement loginButton = driver.findElement(By.className("login-button1"));
//
//          emailInput.sendKeys("happy22@gmail.com");
//          passwordInput.sendKeys("123456789");
//          loginButton.click();
//
//       
//          try {
//              Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//              alert.accept();
//              System.out.println("Alert accepted.");
//          } catch (TimeoutException e) {
//              System.out.println("No alert present.");
//          }
//
//       
//        wait.until(ExpectedConditions.urlContains("/studentdash"));
//        String currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
//
//       
//        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
//        sidebarLink.click();
//
//       
//        WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/button[1]")));
//        assertNotNull(updateProfileButton, "Update Profile button is missing.");
//        updateProfileButton.click();
//
//            
//            WebElement addressInput = driver.findElement(By.xpath("/html/body/div/div/div/input[3]"));
//            addressInput.sendKeys("");
//            assertEquals("", addressInput.getAttribute("value"), "Email input should contain 'test email'");
//        
//        
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//  }
//  @Test
//  void testPhonefield() {
//      driver.get("http://localhost:3000/student");
//      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//      try {
//         
//          WebElement emailInput = driver.findElement(By.id("email1"));
//          WebElement passwordInput = driver.findElement(By.id("password1"));
//          WebElement loginButton = driver.findElement(By.className("login-button1"));
//
//          emailInput.sendKeys("happy22@gmail.com");
//          passwordInput.sendKeys("123456789");
//          loginButton.click();
//
//          try {
//              Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//              alert.accept();
//              System.out.println("Alert accepted.");
//          } catch (TimeoutException e) {
//              System.out.println("No alert present.");
//          }
//
//        wait.until(ExpectedConditions.urlContains("/studentdash"));
//        String currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
//
//      
//        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
//        sidebarLink.click();
//
//        WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/button[1]")));
//        assertNotNull(updateProfileButton, "Update Profile button is missing.");
//        updateProfileButton.click();
//
//        WebElement phoneInput = driver.findElement(By.xpath("/html/body/div/div/div/input[5]"));
//        phoneInput.sendKeys("");
//        assertEquals("", phoneInput.getAttribute("value"), "Email input should contain 'test email'");
//        
//        
////      } catch (Exception e) {
////          e.printStackTrace();
////      }
////  }
//  @Test
//  void testbackbutton1field() {
//      driver.get("http://localhost:3000/student");
//      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//      try {
//          
//          WebElement emailInput = driver.findElement(By.id("email1"));
//          WebElement passwordInput = driver.findElement(By.id("password1"));
//          WebElement loginButton = driver.findElement(By.className("login-button1"));
//
//          emailInput.sendKeys("happy22@gmail.com");
//          passwordInput.sendKeys("123456789");
//          loginButton.click();
//
//        
//          try {
//              Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//              alert.accept();
//              System.out.println("Alert accepted.");
//          } catch (TimeoutException e) {
//              System.out.println("No alert present.");
//          }
//
//    
//        wait.until(ExpectedConditions.urlContains("/studentdash"));
//        String currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
//
//    
//        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
//        sidebarLink.click();
//
//       
//        
//        WebElement backButton1 = driver.findElement(By.xpath("/html/body/div/div/div[2]/button[2]"));
//        assertNotNull(backButton1, "Update Profile button is missing.");
//        backButton1.click();// Navigate to profile update page
//
//        
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//  }
//  @Test
//  void testbackbuttonfield() {
//      driver.get("http://localhost:3000/student");
//      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//      try {
//        
//          WebElement emailInput = driver.findElement(By.id("email1"));
//          WebElement passwordInput = driver.findElement(By.id("password1"));
//          WebElement loginButton = driver.findElement(By.className("login-button1"));
//
//          emailInput.sendKeys("happy22@gmail.com");
//          passwordInput.sendKeys("123456789");
//          loginButton.click();
//
//      
//          try {
//              Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//              alert.accept();
//              System.out.println("Alert accepted.");
//          } catch (TimeoutException e) {
//              System.out.println("No alert present.");
//          }
//
//         
//        wait.until(ExpectedConditions.urlContains("/studentdash"));
//        String currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
//
//      
//        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
//        sidebarLink.click();
//
//  
//        WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/button[1]")));
//        assertNotNull(updateProfileButton, "Update Profile button is missing.");
//        updateProfileButton.click();
//
//        
//        WebElement backButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/button[2]"));
//        assertNotNull(backButton, "Update Profile button is missing.");
//        backButton.click();
//
//        
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//  }}
  
//  @Test
//  void testdateofbirthfield() {
//      driver.get("http://localhost:3000/student");
//      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//      try {
//        
//          WebElement emailInput = driver.findElement(By.id("email1"));
//          WebElement passwordInput = driver.findElement(By.id("password1"));
//          WebElement loginButton = driver.findElement(By.className("login-button1"));
//
//          emailInput.sendKeys("happy22@gmail.com");
//          passwordInput.sendKeys("123456789");
//          loginButton.click();
//
//     
//          try {
//              Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//              alert.accept();
//              System.out.println("Alert accepted.");
//          } catch (TimeoutException e) {
//              System.out.println("No alert present.");
//          }
//
//       
//        wait.until(ExpectedConditions.urlContains("/studentdash"));
//        String currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
//
//      
//        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
//        sidebarLink.click();
//
//    
//        WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/button[1]")));
//        assertNotNull(updateProfileButton, "Update Profile button is missing.");
//        updateProfileButton.click();
//        
//        WebElement dateofbirthInput = driver.findElement(By.xpath("/html/body/div/div/div/input[4]"));
//        dateofbirthInput.sendKeys("2025-05-20");
//        assertEquals("2025-05-20",  dateofbirthInput.getAttribute("value"), "Email input should contain 'test email'");
//    
//
//        
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//  }
//  
//   @Test
//  void testheading() {
//      driver.get("http://localhost:3000/student");
//      wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//      try {
//        
//          WebElement emailInput = driver.findElement(By.id("email1"));
//          WebElement passwordInput = driver.findElement(By.id("password1"));
//          WebElement loginButton = driver.findElement(By.className("login-button1"));
//
//          emailInput.sendKeys("happy22@gmail.com");
//          passwordInput.sendKeys("123456789");
//          loginButton.click();
//
//     
//          try {
//              Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//              alert.accept();
//              System.out.println("Alert accepted.");
//          } catch (TimeoutException e) {
//              System.out.println("No alert present.");
//          }
//
//       
//        wait.until(ExpectedConditions.urlContains("/studentdash"));
//        String currentUrl = driver.getCurrentUrl();
//        assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
//
//      
//        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/header/div/button[1]/a")));
//        sidebarLink.click();
//
//    
//        WebElement updateProfileButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/button[1]")));
//        assertNotNull(updateProfileButton, "Update Profile button is missing.");
//        updateProfileButton.click();
//        
//        WebElement header = driver.findElement(By.xpath("/html/body/div/div/div/h1"));
//	         boolean checking = header.isSelected();
//	         Assert.assertNotNull(header);
//	        
//
//        
//      } catch (Exception e) {
//          e.printStackTrace();
//      }
//  }
//  
//}
