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

class Syllabus {
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
        driver.get("http://localhost:3000/syllabus"); 
    }

    @Test
    void testTitle() {
     loadHomePage();
     String expectedTitle = "React App";
     String actualTitle = driver.getTitle();
     assertEquals(expectedTitle, actualTitle, "The page title should match");
    }

    @Test
    void testwrongTitle() {
     loadHomePage();
     String expectedTitle = "Hospital";
     String actualTitle = driver.getTitle();
     assertEquals(expectedTitle, actualTitle, "The page title should match");
    }
    @Test
    void testheading() {
     loadHomePage();
     WebElement header = driver.findElement(By.xpath("/html/body/div/div/div/main/h1"));
     boolean checking = header.isSelected();
     Assert.assertNotNull(header);
    }

    @Test
    void testwrongHeading() {
     loadHomePage();
     WebElement heading = driver.findElement(By.xpath("/html/body/div/div/div/main/h1"));
    	String expectedHeading = "About";
    	String actualHeading = heading.getText();
    	assertEquals(expectedHeading, actualHeading, "The heading should match");
    }
    @Test
    public void testStudentProfileButtonField() {
       
    	 loadHomePage();
        WebElement studentProfileButtonField = driver.findElement(By.xpath("//button[contains(@class, 'btn') and .//a[text()='Student Profile']]"));
         assertNotNull("Student Profile button should be present", studentProfileButtonField);
          assertTrue("Student Profile button should be displayed", studentProfileButtonField.isDisplayed());
         String buttonText = studentProfileButtonField.getText().trim();
        assertEquals("Button text should be 'Student Profile'", "Student Profile", buttonText);
    }
    @Test
    public void testbutton() {
       
    	 loadHomePage();  

        
        WebElement studentProfileButton = driver.findElement(By.xpath("//button[contains(@class, 'btn') and .//a[text()='Student Profile']]"));
        assertNotNull("Student Profile button should be present", studentProfileButton);
        assertTrue("Student Profile button should be displayed", studentProfileButton.isDisplayed());
        assertEquals("Button text should be 'Student Profile'", "Student Profile", studentProfileButton.getText());
          WebElement syllabusTable = driver.findElement(By.className("syllabus-tableu"));
        assertNotNull("Syllabus table should be present", syllabusTable);

      WebElement firstRow = syllabusTable.findElement(By.tagName("tr"));
        assertTrue("Syllabus table should have at least one row", firstRow.isDisplayed());

       WebElement downloadButton = syllabusTable.findElement(By.xpath("//button[contains(@class, 'btn2')]"));
        assertNotNull("Download button should be available for syllabus file", downloadButton);

      assertTrue("Download button should be clickable", downloadButton.isEnabled());
        WebElement signOutButton = driver.findElement(By.xpath("//button[contains(@class, 'logout1')]"));
        assertNotNull("Sign Out button should be present", signOutButton);
        assertTrue("Sign Out button should be displayed", signOutButton.isDisplayed());
         signOutButton.click();
         assertTrue("After sign out, user should be redirected to the homepage", driver.getCurrentUrl().contains("http://localhost:3000"));
    }
}
    
    
