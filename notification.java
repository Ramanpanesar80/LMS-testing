package Educatorr;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class notificationn {

	
	 private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/notifications");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void StudentProfileButtonField() {
        WebElement StudentProfileButtonField = driver.findElement(By.xpath("/html/body/div/div/header/div[2]/button[1]"));
        assertNotNull("Sign Up button should be present", StudentProfileButtonField);
      assertTrue("Sign Up button should be displayed", StudentProfileButtonField.isDisplayed());
//      assertEquals("Button text should be 'Sign Up'", "Sign Up", StudentProfileButtonField.getText());
  }
    @Test
    public void testSignoutField() {
        WebElement SignoutField = driver.findElement(By.xpath("/html/body/div/div/header/div[2]/button[2]"));
//        SignoutField.sendKeys("SimranKaurb@example.com");
        assertNotNull("Email input field should be present", SignoutField);
        assertTrue("Email input field should be displayed", SignoutField.isDisplayed());
    }
    @Test
    public void testNewGradeField() {
        WebElement testNewGradeField = driver.findElement(By.xpath("/html/body/div/div/main/div/table/tbody/tr[1]/td[1]"));

        assertNotNull("Sign Up button should be present", testNewGradeField);
        assertTrue("Sign Up button should be displayed", testNewGradeField.isDisplayed());
//        assertEquals("Button text should be 'Sign Up'", "Sign Up", ViewButtonField.getText());
    }
//
@Test
public void testViewField() {
    WebElement ViewField = driver.findElement(By.xpath("/html/body/div/div/main/div/table/tbody/tr[1]/td[2]/button"));
//    ViewField.sendKeys("1645boulevard");
    assertNotNull("Address input field should be present", ViewField);
    assertTrue("Address input field should be displayed", ViewField.isDisplayed());
}}
