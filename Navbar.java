package testing;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class Navbar {

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
        driver.get("http://localhost:3000/educator");  
 }

	
	@Test
	void testTelephoneLink() {
	    loadHomePage();
	   WebElement telephoneLink = driver.findElement(By.cssSelector(".navbar-link"));
	    String expectedHref = "tel:+12340000000";
	    String actualHref = telephoneLink.getAttribute("href");
	    assertEquals(expectedHref, actualHref, "Telephone link href should be 'tel:+12340000000'");
	}
	 @Test
	    void testLogoPresenceAndAttributes() {
		 loadHomePage();
	         WebElement logo = driver.findElement(By.cssSelector(".logo"));
              assertTrue(logo.isDisplayed(), "The logo should be visible");
               String expectedSrc = "http://localhost:3000/path/to/images/t2.jpg"; 
	        String actualSrc = logo.getAttribute("src");
	        assertEquals(expectedSrc, actualSrc, "The logo src attribute should match");
            String expectedAlt = "Logo";
	        String actualAlt = logo.getAttribute("alt");
	        assertEquals(expectedAlt, actualAlt, "The logo alt attribute should match");
	    }
	}
	    
	
	


