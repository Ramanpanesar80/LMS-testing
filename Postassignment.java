package testing;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Assignments {
private WebDriver driver;

		 @BeforeEach
		    void setUp() throws Exception {
		        
		        driver = new ChromeDriver(); 
		    }

		    @AfterEach
		    void tearDown() {
		        if (driver != null) {
		            driver.quit(); 
		        }
		    }

		    private void loadHomePage() {
		        driver.get("http://localhost:3000/assignments"); 
		    }
		    @Test
		    public void testCoursesList() {
		    	loadHomePage();

		        try {
		            
		            Thread.sleep(2000);

		           
		            WebElement courseList = driver.findElement(By.className("courses-list"));
		            assertNotNull(courseList, "Courses list is not displayed.");
		        } catch (Exception e) {
		            fail("Test failed: " + e.getMessage());
		        }
		    }
		    @Test
		    public void testCourseSelection() {
		    	loadHomePage();

		        try {
		            
		            Thread.sleep(2000);

		          
		            WebElement courseCard = driver.findElement(By.className("course-card"));
		            courseCard.click();

		          
		            WebElement assignmentsForm = driver.findElement(By.className("assignments-form"));
		            assertNotNull(assignmentsForm, "Assignments form is not displayed after selecting a course.");
		        } catch (Exception e) {
		            fail("Test failed: " + e.getMessage());
		        }
		    }
		    @Test
		    public void testAddAssignmentbutton() {
		    	loadHomePage();

		        try {
		            
		            Thread.sleep(2000);

		          
		            WebElement courseCard = driver.findElement(By.className("course-card"));
		            courseCard.click();

		          
		            WebElement titleInput = driver.findElement(By.xpath("//input[@placeholder='Enter assignment title']"));
		            titleInput.sendKeys("Test Assignment");
                   WebElement submitButton = driver.findElement(By.xpath("//button[text()='Add Assignment']"));
		            submitButton.click();

		            
		            WebElement assignment = driver.findElement(By.xpath("//p[text()='Test Assignment']"));
		            assertNotNull(assignment, "Assignment was not added successfully.");
		        } catch (Exception e) {
		            fail("Test failed: " + e.getMessage());
		        }
		    }
		    @Test
		    public void testLoadingIndicator() {
		    	loadHomePage();

		        try {
		           
		            Thread.sleep(2000);
		            WebElement loadingMessage = driver.findElement(By.xpath("//p[text()='Loading courses...']"));
		            assertNotNull(loadingMessage, "Loading message is not displayed.");
		        } catch (Exception e) {
		            fail("Test failed: " + e.getMessage());
		        }
		    }

		    @Test
		    public void testErrorMessageOnFailedCourseLoad() {
		        try {
		            loadHomePage();  
		            WebElement errorMessage = driver.findElement(By.className("error-message"));
		            assertNotNull("Error message should be displayed when the courses fail to load.", errorMessage);

		            String errorText = errorMessage.getText();
		            assertEquals("Failed to load courses. Please try again later.", errorText);
		        } catch (Exception e) {
		            fail("Test failed: " + e.getMessage());
		        }
		    }

		 
		        @Test
		        void testheading() {
		         loadHomePage();
		         WebElement header = driver.findElement(By.xpath("/html/body/div/div/div[2]/h2"));
		         boolean checking = header.isSelected();
		         Assert.assertNotNull(header);
		        }

		        @Test
		        void testwrongHeading() {
		         loadHomePage();
		         WebElement heading = driver.findElement(By.xpath("/html/body/div/div/div[2]/h2"));
		        	String expectedHeading = "About";
		        	String actualHeading = heading.getText();
		        	assertEquals(expectedHeading, actualHeading, "The heading should match");
		        }
		    }
		


