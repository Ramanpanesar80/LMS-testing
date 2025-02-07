package admin;

import static org.junit.Assert.*;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentSignup {

	
	 private WebDriver driver;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/signup");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testFullNameField() {
        WebElement fullNameField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[1]"));
        fullNameField.sendKeys("Simran Kaur");
        assertNotNull("Full Name input field should be present", fullNameField);
        assertTrue("Full Name input field should be displayed", fullNameField.isDisplayed());
    }
    @Test
    public void testEmailField() {
        WebElement emailField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[2]"));
        emailField.sendKeys("SimranKaurb@example.com");
        assertNotNull("Email input field should be present", emailField);
        assertTrue("Email input field should be displayed", emailField.isDisplayed());
    }
    @Test
    public void testPasswordField() {
        WebElement passwordField = driver.findElement(By.xpath("/html/body/div/div/div/form/div[2]/div[1]/input"));
        passwordField.sendKeys("Pargolposhtareh098");
        assertNotNull("Password input field should be present", passwordField);
        assertTrue("Password input field should be displayed", passwordField.isDisplayed());
    }

@Test
public void testAddressField() {
    WebElement addressField = driver.findElement(By.xpath("/html/body/div/div/div/form/input[3]"));
    addressField.sendKeys("1645boulevard");
    assertNotNull("Address input field should be present", addressField);
    assertTrue("Address input field should be displayed", addressField.isDisplayed());
}
@Test
public void testMobileField() {
    WebElement addressField = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/div[2]/input"));
    addressField.sendKeys("4383088227");
    assertNotNull("Address input field should be present", addressField);
    assertTrue("Address input field should be displayed", addressField.isDisplayed());
}
@Test
public void testConfirmField() {
    WebElement confirmField = driver.findElement(By.xpath("/html/body/div/div/div/form/div[1]/div[2]/input"));
    confirmField.sendKeys("Pargolposhtareh098");
    assertNotNull("Address input field should be present", confirmField);
    assertTrue("Address input field should be displayed", confirmField.isDisplayed());
}

@Test
public void testCreateaccount() {
    WebElement CreateButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button")); 
    assertNotNull("Log In button should be present", CreateButton);
    assertTrue("Log In button should be displayed", CreateButton.isDisplayed());
    assertEquals("Button text should be 'Sign In'", "Sign In", CreateButton.getText());
}

}




//       
//    }
//    @Test
//    public void testSignUpButton() {
//        WebElement signUpButton = driver.findElement(By.xpath("/html/body/div/div/div/form/button"));
//        assertNotNull("Sign Up button should be present", signUpButton);
//        assertTrue("Sign Up button should be displayed", signUpButton.isDisplayed());
//        assertEquals("Button text should be 'Sign Up'", "Sign Up", signUpButton.getText());
//    }
//	
//	
//@Test 
//public void testaboutLinks() {
//WebElement termsLink = driver.findElement(By.xpath("/html/body/div/div/footer/div/ul/li[1]/a"));
//assertNotNull("About Us link should exist", termsLink);
//}
//      
//    
//      @Test
//      public void testPrivacypolicy() {  
//      WebElement termsLink = driver.findElement(By.xpath("/html/body/div/div/footer/div/ul/li[2]/a"));
//      assertNotNull("Terms and Conditions link should exist", termsLink);
//     
//  }
//
//@Test
//public void testtermsandconditions() {  
//WebElement termsLink = driver.findElement(By.xpath("/html/body/div/div/footer/div/ul/li[3]/a"));
//assertNotNull("Terms and Conditions link should exist", termsLink);
//
//}
//
//  @Test
//  public void testFooterText() {
//      
//      WebElement footerText = driver.findElement(By.xpath("/html/body/div/div/footer/div/p"));
//      assertNotNull("Footer text should be present", footerText);
//      assertTrue("Footer should contain the correct copyright text", footerText.getText().contains("© 2024 Medical Appointment System. All Rights Reserved."));
//  }
//
//
//}
//
//
