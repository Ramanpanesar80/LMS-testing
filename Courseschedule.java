package testing;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.dataloader.impl.Assertions;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class CourseSchedule {

	 private WebDriver driver;
	 private WebDriverWait wait;

	    @BeforeEach
	    void setUp() throws Exception {
	        
	        driver = new ChromeDriver(); 
	    }

	    @AfterEach
	    void tearDown() {
	        if (driver != null) {
	            driver.quit(); 
	            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        }
	    }

	    private void loadHomePage() {
	        driver.get("http://localhost:3000/schedule"); 
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
	    void testYearSelector() {
	        loadHomePage();
	        
	        try {
	           
	            Thread.sleep(2000); 

	            WebElement yearSelector = driver.findElement(By.id("year1"));
	            
	           
	            WebElement option2025 = yearSelector.findElement(By.xpath("//option[@value='2025']"));
	            WebElement option2024 = yearSelector.findElement(By.xpath("//option[@value='2024']"));
	            WebElement option2023 = yearSelector.findElement(By.xpath("//option[@value='2023']"));

	            assertNotNull(option2025);
	            assertNotNull(option2024);
	            assertNotNull(option2023);

	            
	            option2024.click();
	            assertEquals("2024", yearSelector.getAttribute("value"));

	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to an exception: " + e.getMessage());
	        }
	    }

	    @Test
	    void testSchedulesDisplayed() {
	        loadHomePage();

	        try {
	           
	            Thread.sleep(2000); 

	           
	            WebElement scheduleTable = driver.findElement(By.cssSelector(".schedule-table2 table"));
	            
	           
	            WebElement firstRow = scheduleTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
	            WebElement secondRow = scheduleTable.findElement(By.xpath(".//tbody/tr[2]/td[1]"));
	            
	            assertEquals("Schedule1.pdf", firstRow.getText());
	            assertEquals("Schedule2.pdf", secondRow.getText());

	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to an exception: " + e.getMessage());
	        }
	    }

	    @Test
	    void testDownloadButton() {
	        loadHomePage();

	        try {
	           
	            Thread.sleep(2000); 

	           
	            WebElement downloadButton = driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]/a/button"));
	            
	            assertNotNull(downloadButton);

	           
	            downloadButton.click();

	           assertTrue(downloadButton.isEnabled());

	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to an exception: " + e.getMessage());
	        }
	    }


	    @Test
	    void testSignOut() {
	        loadHomePage();

	        try {
	            
	            WebElement signOutButton = wait.until(ExpectedConditions.elementToBeClickable(By.className("logout1")));
	            assertNotNull(signOutButton, "Sign-out button should be present.");

	            
	            signOutButton.click();

	            
	            wait.until(ExpectedConditions.urlToBe("http://localhost:3000/"));

	            
	            assertEquals("http://localhost:3000/", driver.getCurrentUrl(), "The user was not redirected to the homepage.");

	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to an exception: " + e.getMessage());
	        }
	    }
	
	    @Test
	    void testSelectYear() {
	        loadHomePage();

	        try {
	            
	            Thread.sleep(2000); 
              WebElement yearSelector = driver.findElement(By.id("year1"));
	            assertNotNull(yearSelector, "Year selector dropdown not found!");

	            
	            String initialSelectedYear = yearSelector.getAttribute("value");
	            assertEquals("2025", initialSelectedYear, "Initial year selection should be 2025.");

	            
	            WebElement option2024 = yearSelector.findElement(By.xpath("//option[@value='2024']"));
	            option2024.click();

	         
	            String updatedYear = yearSelector.getAttribute("value");
	            assertEquals("2024", updatedYear, "Year selection did not update to 2024.");

	         
	            WebElement option2023 = yearSelector.findElement(By.xpath("//option[@value='2023']"));
	            option2023.click();

	            
	            String finalYear = yearSelector.getAttribute("value");
	            assertEquals("2023", finalYear, "Year selection did not update to 2023.");

	        } catch (Exception e) {
	            e.printStackTrace();
	            fail("Test failed due to an exception: " + e.getMessage());
	        }
	    }
	   
	}
	
	
