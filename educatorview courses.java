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

class educatorviewcourses {
	private WebDriver driver;
	   private WebDriverWait wait;

	    @BeforeEach
	    void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }

	@Test
    void testsidebarviewcourses() {
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
            

            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[6]/a")));
            sidebarLink.click();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	 @Test
	    void tetwrongheading() {
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
	            

	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[6]/a")));
	            sidebarLink.click();
	            
	          
	            WebElement heading = driver.findElement(By.xpath("/html/body/div/div/main/div/h2"));
	    		String expectedHeading = "About";
	    		String actualHeading = heading.getText();
	    		assertEquals(expectedHeading, actualHeading, "The heading should match");
	            

	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to unexpected error: " + e.getMessage());
	        }
     }

	 @Test
	    void testheading() {
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
	            

	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[6]/a")));
	            sidebarLink.click();
	          
	           
	            WebElement header = driver.findElement(By.xpath("/html/body/div/div/main/div/h2"));
	            boolean checking = header.isSelected();
	            Assert.assertNotNull(header);


	        } catch (Exception e) {
	            e.printStackTrace();
	        }
     }
	 @Test
	    void testdeletebutton() {
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
	            

	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[6]/a")));
	            sidebarLink.click();
	          
	            WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/main/div/div[1]/button[1]")));
	            assertNotNull(editButton, "Update Profile button is missing.");
	            editButton.click();


	        } catch (Exception e) {
	            e.printStackTrace();
	        }
  }    
	 @Test
	    void testfinishbutton() {
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
	            

	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[6]/a")));
	            sidebarLink.click();
	          
	            WebElement editButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/main/div/div[1]/button[2]")));
	            assertNotNull(editButton, "Update Profile button is missing.");
	            editButton.click();


	        } catch (Exception e) {
	            e.printStackTrace();
	        }
}   
	 @Test
	    void testwrongtitle() {
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
	            


	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[6]/a")));
	            sidebarLink.click();
	            
	            String expectedTitle = "Company Website";
	            String actualTitle = driver.getTitle();
	            assertEquals(expectedTitle, actualTitle, "The page title should match");
	          
	           

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
     }

     @Test
	    void testtitle() {
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
	            


	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[6]/a")));
	            sidebarLink.click();
	            
	            String expectedTitle = "React App";
	            String actualTitle = driver.getTitle();
	            assertEquals(expectedTitle, actualTitle, "The page title should match");
	          
	           

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

}
     @Test
	    void testwrongparagraph() {
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
	            


	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[6]/a")));
	            sidebarLink.click();
	            
	            WebElement paragraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/main/div/div[1]/p"))); // Update based on actual paragraph
	            String actualText = paragraph.getText().trim();
	            String expectedText = "student"; // Update based on actual content
	            Assert.assertEquals(actualText, expectedText, "Paragraph content does not match.");
	            System.out.println("Test passed: Paragraph content matches.");
	          
	           

	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to unexpected error: " + e.getMessage());
	        }

}
     @Test
	    void testparagraph() {
	    	  
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
	    	            
	    	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[6]/a")));
	    	            sidebarLink.click();
	    	         
	    	           
	            
	            WebElement Description = driver.findElement(By.xpath("/html/body/div/div/main/div/div[1]/p"));
		         boolean checking = Description .isSelected();
		         Assert.assertNotNull(Description );
		        
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	    
} 

