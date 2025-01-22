package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Coursedocuments {

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
	        driver.get("http://localhost:3000/course-documents"); 
	    }
	    @Test
	    public void testwrongTitle() {
	        loadHomePage();
	        String expectedTitle = "React App";
	        String actualTitle = driver.getTitle();
	        assertEquals("The page title should match", expectedTitle, actualTitle);
	    }

	    @Test
	    public void testTitle() {
	        loadHomePage();
	        String expectedTitle = "Hospital";
	        String actualTitle = driver.getTitle();
	        assertNotEquals("The page title should not match", expectedTitle, actualTitle);
	    }
	    @Test
	    void testCourseSelectionAndDocumentListing() {
	        loadHomePage();

	        try {
	          
	            Thread.sleep(2000);
                WebElement courseTable = driver.findElement(By.tagName("table"));
	            assertNotNull(courseTable, "Course table not found!");
              WebElement courseLink = driver.findElement(By.xpath("//td[text()='Introduction to Cybersecurity']"));
	            courseLink.click();
              Thread.sleep(2000);
              WebElement documentTable = driver.findElement(By.tagName("table"));
	            assertNotNull(documentTable, "Document table for selected course not found!");
              WebElement downloadButton = driver.findElement(By.xpath("//button[text()='Download']"));
	            assertNotNull(downloadButton, "Download button not found for documents!");

	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            fail("Test failed due to interruption: " + e.getMessage());
	        } catch (NoSuchElementException e) {
	            fail("Test failed due to missing element: " + e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to an unexpected exception: " + e.getMessage());
	        }
	    }

	    @Test
	    void testFileUploadAndDownload() {
	        loadHomePage();

	        try {
	          
	            Thread.sleep(2000);
              WebElement courseLink = driver.findElement(By.xpath("//td[text()='Cloud Security']"));
	            courseLink.click();
              Thread.sleep(2000);
              WebElement fileInput = driver.findElement(By.id("fileInput"));
	            assertNotNull(fileInput, "File input not found!");
              File file = new File("path/to/your/file.pdf"); 
	            fileInput.sendKeys(file.getAbsolutePath());
                Thread.sleep(2000);
               WebElement successMessage = driver.findElement(By.xpath("//p[contains(text(),'File uploaded successfully')]"));
	            assertNotNull(successMessage, "File upload failed!");
                WebElement downloadButton = driver.findElement(By.xpath("//button[text()='Download']"));
	            assertNotNull(downloadButton, "Download button not found after file upload!");

	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	           fail("Test failed due to interruption: " + e.getMessage());
	        } catch (NoSuchElementException e) {
	            fail("Test failed due to missing element: " + e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to an unexpected exception: " + e.getMessage());
	        }
	    }

	    @Test
	    void testSignOut() {
	        loadHomePage();

	        try {
	          Thread.sleep(2000);
             WebElement signOutButton = driver.findElement(By.className("logout1"));
	            assertNotNull(signOutButton, "Sign Out button not found!");
              signOutButton.click();
              Thread.sleep(2000);
               assertEquals("http://localhost:3000/", driver.getCurrentUrl(), "Sign-out did not redirect to the correct URL");

	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            fail("Test failed due to interruption: " + e.getMessage());
	        } catch (NoSuchElementException e) {
	            fail("Test failed due to missing element: " + e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to an unexpected exception: " + e.getMessage());
	        }
	    }
	    @Test
	    void testCourseListDisplay() {
	        loadHomePage();

	        try {
	           
	            Thread.sleep(2000);
              WebElement courseTable = driver.findElement(By.tagName("table"));
	            assertNotNull(courseTable, "Course list table is not displayed!");
              WebElement firstCourseRow = driver.findElement(By.xpath("//tr[1]/td[1]"));
	            assertTrue(firstCourseRow.isDisplayed(), "First course row is not displayed");

	            WebElement secondCourseRow = driver.findElement(By.xpath("//tr[2]/td[1]"));
	            assertTrue(secondCourseRow.isDisplayed(), "Second course row is not displayed");

	        } catch (InterruptedException e) {
	            Thread.currentThread().interrupt();
	            fail("Test failed due to interruption: " + e.getMessage());
	        } catch (NoSuchElementException e) {
	            fail("Test failed due to missing element: " + e.getMessage());
	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to an unexpected exception: " + e.getMessage());
	        }
	    }
	        @Test
	        void testNoDocumentsMessage() {
	            loadHomePage();

	            try {
	               
	                Thread.sleep(2000);
                   WebElement courseNameLink = driver.findElement(By.xpath("//td[text()='Operating System Security']"));
	                courseNameLink.click();
                  Thread.sleep(2000);
                  WebElement noDocumentsMessage = driver.findElement(By.xpath("//p[contains(text(), 'No documents available')]"));
	                assertTrue(noDocumentsMessage.isDisplayed(), "No documents message is not displayed!");

	            } catch (Exception e) {
	                e.printStackTrace();
	                fail("Test failed: " + e.getMessage());
	            }
	    }
	        @Test
	        void testDocumentDownload() {
	            loadHomePage();

	            try {
	               
	                Thread.sleep(2000);
                   WebElement courseNameLink = driver.findElement(By.xpath("//td[text()='Network Security']"));
	                courseNameLink.click();
                  Thread.sleep(2000);
                  WebElement downloadButton = driver.findElement(By.xpath("//tr[1]//button[text()='Download']"));
	                assertNotNull(downloadButton, "Download button not found!");
                   downloadButton.click();
                  WebElement downloadLink = driver.findElement(By.xpath("//a[@href]"));
	                assertNotNull(downloadLink, "Download link is missing!");

	            } catch (Exception e) {
	                e.printStackTrace();
	                fail("Test failed: " + e.getMessage());
	            }
	        }

	}

	    

	   


