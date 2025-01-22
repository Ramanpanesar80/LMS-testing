package testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Enrolledcouses {

	private WebDriver driver;

	@BeforeEach
    void setUp() {
		  driver = new ChromeDriver();
	}
	
	@AfterEach
    void tearDown() {
        
        if (driver != null) {
            driver.quit();
        }
	}
	 private void loadHomePage() {
	        driver.get("http://localhost:3000/enrolled-courses");  
	 }
	 @Test
	    public void testEnrolledCoursesDisplayed() {
	        try {
	            loadHomePage();  

	            
	            List<WebElement> courseCards = driver.findElements(By.className("course-card"));
                  assertTrue("No enrolled courses found.", courseCards.size() > 0);
                 WebElement firstCourse = courseCards.get(0);
	            assertNotNull("Course title should be displayed.", firstCourse.findElement(By.tagName("h3")));
	            assertNotNull("Course teacher should be displayed.", firstCourse.findElement(By.tagName("p")));
	            assertNotNull("Course description should be displayed.", firstCourse.findElement(By.tagName("p")));
	        } catch (Exception e) {
	            fail("Test failed: " + e.getMessage());
	        }
	    }
	    @Test
	    public void testNoCoursesEnrolledMessage() {
	        try {
	            loadHomePage();  

	           
	            WebElement noCoursesMessage = driver.findElement(By.xpath("//p[text()='No courses enrolled yet.']"));

	           
	            assertNotNull("No courses enrolled message should be displayed.", noCoursesMessage);
	            assertTrue("No courses enrolled message should be visible.", noCoursesMessage.isDisplayed());
	        } catch (Exception e) {
	            fail("Test failed: " + e.getMessage());
	        }
	    }
	  

	    @Test
	    public void testWithdrawCourse() {
	        try {
	            loadHomePage();  
                WebElement withdrawButton = driver.findElement(By.xpath("//button[contains(@class, 'withdraw')]"));
	            assertNotNull("Withdraw button should be present.", withdrawButton);
	            withdrawButton.click();
	            Thread.sleep(2000);  
	            WebElement noCoursesMessage = driver.findElement(By.xpath("//p[text()='No courses enrolled yet.']"));
	            assertTrue("No courses enrolled message should be displayed.", noCoursesMessage.isDisplayed());
	        } catch (Exception e) {
	            fail("Test failed: " + e.getMessage());
	        }
	    }
	    @Test
	    public void testWithdrawButtonIsClickable() {
	        try {
	            loadHomePage();  

	            WebElement withdrawButton = driver.findElement(By.xpath("//button[contains(@class, 'withdraw')]"));
	           assertNotNull("Withdraw button should be present.", withdrawButton);
	            assertTrue("Withdraw button should be clickable.", withdrawButton.isEnabled());
                 withdrawButton.click();
                  List<WebElement> courseCards = driver.findElements(By.className("course-card"));
	            assertTrue("Course should be removed after withdrawal.", courseCards.isEmpty());
                  WebElement noCoursesMessage = driver.findElement(By.xpath("//p[text()='No courses enrolled yet.']"));
	            assertTrue("No courses enrolled message should be displayed after withdrawal.", noCoursesMessage.isDisplayed());
	            
	        } catch (Exception e) {
	            fail("Test failed: " + e.getMessage());
	        }
	    }
	    

	    }
	


