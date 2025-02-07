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

class educatormanagediscussion {
	private WebDriver driver;
	   private WebDriverWait wait;

	    @BeforeEach
	    void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }


	


	 @Test
	    void testsidebardiscussion() {
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
	            

	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[4]/a")));
	            sidebarLink.click();

	        } catch (Exception e) {
	            e.printStackTrace();
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
	            

	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[4]/a")));
	            sidebarLink.click();
	            
	            WebElement header = driver.findElement(By.xpath("/html/body/div/div/header/h1"));
		         boolean checking = header.isSelected();
		         Assert.assertNotNull(header);
		        
	            
	        } catch (Exception e) {
	            e.printStackTrace();
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
	    	            

	    	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[4]/a")));
	    	            sidebarLink.click();
	    	            
	    	           
	            
	            WebElement Description = driver.findElement(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/p"));
		         boolean checking = Description .isSelected();
		         Assert.assertNotNull(Description );
		        
	            
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
	    	            

	    	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[4]/a")));
	    	            sidebarLink.click();
	    	            
	    	           
	            

	    	            WebElement paragraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[2]/div[1]/div[1]/p"))); // Update based on actual paragraph
	    	            String actualText = paragraph.getText().trim();
	    	            String expectedText = "student"; 
	    	            Assert.assertEquals(actualText, expectedText, "Paragraph content does not match.");
	    	            System.out.println("Test passed: Paragraph content matches.");
	    	            
		        
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to unexpected exception: " + e.getMessage());
	        }

	    }
	    @Test
	    void testwrongheading() {
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
	            

	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[4]/a")));
	            sidebarLink.click();
	            
	            WebElement heading = driver.findElement(By.xpath("/html/body/div/div/div[2]/h2"));
	    		String expectedHeading = "About";
	    		String actualHeading = heading.getText();
	    		assertEquals(expectedHeading, actualHeading, "The heading should match");
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    @Test
	    void testpostcommentbutton() {
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
	            

	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[4]/a")));
	            sidebarLink.click();
	            
	            WebElement sidebar1Link = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div[2]/div[1]/button[1]")));
	            sidebar1Link.click();


	          
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	    @Test
	    void testpostquestionbutton() {
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
	            

	            WebElement sidebarLink = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[1]/ul/li[4]/a")));
	            sidebarLink.click();
	            
	            WebElement sidebar2Link = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/div[2]/div[2]/button")));
	            sidebar2Link.click();


	          
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    @Test
	    void testselectcourse() {
	        driver.get("http://localhost:3000/educator");

	        // Perform Login
	        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
	        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
	        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

	        emailInput.sendKeys("educator1@gmail.com");
	        passwordInput.sendKeys("123456789");
	        loginButton.click();

	        // Handle Alert (if exists)
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            System.out.println("Alert accepted.");
	        } catch (TimeoutException e) {
	            System.out.println("No alert present.");
	        }

	        // Verify Redirect to Create Course Page
	        wait.until(ExpectedConditions.urlContains("/create-course"));
	        assertTrue(driver.getCurrentUrl().contains("/create-course"), "Login failed: Expected to be redirected to create-course page.");

	        // Navigate to Discussion Page
	        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/postquestion')]")));
	        sidebarLink.click();

	        wait.until(ExpectedConditions.urlContains("/postquestion"));

	        // Select First Course
	        WebElement firstCourse = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".course-card-post")));
	        firstCourse.click();

	       

	      
	    }
	
	
	    @Test
	    void testPostQuestionDiscussion() {
	        driver.get("http://localhost:3000/educator");

	        // Perform Login
	        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
	        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
	        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

	        emailInput.sendKeys("educator1@gmail.com");
	        passwordInput.sendKeys("123456789");
	        loginButton.click();

	        // Handle Alert (if exists)
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            System.out.println("Alert accepted.");
	        } catch (TimeoutException e) {
	            System.out.println("No alert present.");
	        }

	        // Verify Redirect to Create Course Page
	        wait.until(ExpectedConditions.urlContains("/create-course"));
	        assertTrue(driver.getCurrentUrl().contains("/create-course"), "Login failed: Expected to be redirected to create-course page.");

	        // Navigate to Discussion Page
	        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/postquestion')]")));
	        sidebarLink.click();

	        wait.until(ExpectedConditions.urlContains("/postquestion"));

	        // Select First Course
	        WebElement firstCourse = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".course-card-post")));
	        firstCourse.click();

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".question-form-post")));

	        // Post a Question
	        WebElement questionTextarea = driver.findElement(By.cssSelector(".question-form-post textarea"));
	        questionTextarea.sendKeys("What is the deadline for the next assignment?");

	        WebElement postQuestionButton = driver.findElement(By.cssSelector(".question-form-post button"));
	        postQuestionButton.click();

	      
	    }

	    @Test
	    void testPostComments() {
	        driver.get("http://localhost:3000/educator");

	        // Perform Login
	        WebElement emailInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='email']")));
	        WebElement passwordInput = driver.findElement(By.cssSelector("input[type='password']"));
	        WebElement loginButton = driver.findElement(By.cssSelector("button[type='submit']"));

	        emailInput.sendKeys("educator1@gmail.com");
	        passwordInput.sendKeys("123456789");
	        loginButton.click();

	        // Handle Alert (if exists)
	        try {
	            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	            alert.accept();
	            System.out.println("Alert accepted.");
	        } catch (TimeoutException e) {
	            System.out.println("No alert present.");
	        }

	        // Verify Redirect to Create Course Page
	        wait.until(ExpectedConditions.urlContains("/create-course"));
	        assertTrue(driver.getCurrentUrl().contains("/create-course"), "Login failed: Expected to be redirected to create-course page.");

	        // Navigate to Discussion Page
	        WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@href, '/postquestion')]")));
	        sidebarLink.click();

	        wait.until(ExpectedConditions.urlContains("/postquestion"));

	        // Select First Course
	        WebElement firstCourse = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".course-card-post")));
	        firstCourse.click();

	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".question-form-post")));

	        // Locate first question and post a comment
	        WebElement firstQuestion = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".question-card-post")));
	        WebElement commentTextarea = firstQuestion.findElement(By.cssSelector("textarea"));
	        commentTextarea.sendKeys("The deadline is next Friday.");

	        WebElement postCommentButton = firstQuestion.findElement(By.cssSelector("button:nth-of-type(1)"));
	        postCommentButton.click();

	        // Validate Comment is Posted
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'comment')]//p[contains(text(), 'The deadline is next Friday.')]")));
	        System.out.println("Comment posted successfully.");
	    }

	    @AfterEach
	    void tearDown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	
