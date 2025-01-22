package Educatorr;

import static org.junit.Assert.*;

import java.time.Duration;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class adminpost {

	
	 private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/removeposts");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    
    @Test
    public void testTitle() {
        
        driver.get("http://localhost:3000/removeposts");

       
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        boolean titleIsCorrect = wait.until(ExpectedConditions.titleIs("React App"));

        
        assertTrue("The page title should match", titleIsCorrect);
    }
@Test
public void testh2Title() {
    
    driver.get("http://localhost:3000/removeposts");

  
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    boolean titleIsCorrect = wait.until(ExpectedConditions.titleIs("React App"));

    
    assertTrue("The page title should match", titleIsCorrect);
}
@Test
public void testEmailField() {
    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement emailField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/ul/li[1]/p[1]"))); // Update XPath

  
    assertNotNull("Email input field should be present", emailField);

  
    assertFalse("Email input field should be displayed", emailField.isDisplayed());

    // Enter text into the email field
//    emailField.sendKeys("raman@example.com");
}
@Test
public void postedbyField() {
  
    driver.get("http://localhost:3000/suspendstudent");

  
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    boolean titleIsCorrect = wait.until(ExpectedConditions.titleIs("React App"));
    
   
    assertTrue("The page title should match", titleIsCorrect);

  
    WebElement statusField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/ul/li[1]/p[2]")));

    
    assertNotNull("The status field should be present", statusField);
    assertFalse("The status field should be displayed", statusField.isDisplayed());

   
    String statusText = statusField.getText().trim();
    System.out.println("Status field text: " + statusText);
}
@Test
public void testDeletepostButton() {
    
    driver.get("http://localhost:3000/suspendstudent");

    
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    WebElement suspendButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/ul/li[1]/button")));

  
    assertNotNull("Suspend button should be present", suspendButton);

 
    assertTrue("Suspend button should be displayed", suspendButton.isDisplayed());


    String buttonText = suspendButton.getText().trim();
    assertEquals("Button text should be 'Sign Up'", "Sign Up", buttonText);
}}




