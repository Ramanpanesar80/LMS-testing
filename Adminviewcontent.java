package testing;

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

class Admincontentview {

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
	        driver.get("http://localhost:3000/adminview"); 
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
	    public void testDeleteDocument() {
	        try {
	            
	            WebElement deleteButton = driver.findElement(By.className("delete-button"));
              WebElement firstDocumentRow = driver.findElement(By.xpath("//table[@class='document-table']//tr[2]"));
	            String titleBeforeDeletion = firstDocumentRow.findElement(By.xpath("//td[2]")).getText();
            deleteButton.click();
           WebElement table = driver.findElement(By.className("document-table"));
	            boolean isDocumentDeleted = !table.getText().contains(titleBeforeDeletion);
	            assertTrue("The document should be deleted from the table", isDocumentDeleted);

	        } catch (Exception e) {
	            
	            System.out.println("Error during the deletion test: " + e.getMessage());
	            fail("Test failed due to an exception: " + e.getMessage());
	        }
	    }
	  
}
	    

