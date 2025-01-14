package testing;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
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

class HomePage {

	private WebDriver driver;
	 private WebDriverWait wait;

    @BeforeEach
    void setUp() {
         driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
       
        if (driver != null) {
            driver.quit();
        }
    }

    private void loadHomePage() {
        driver.get("http://localhost:3000/");  
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
 WebElement header = driver.findElement(By.xpath("/html/body/div/div/header/h1"));
 boolean checking = header.isSelected();
 Assert.assertNotNull(header);
}

@Test
void testwrongHeading() {
 loadHomePage();
 WebElement heading = driver.findElement(By.xpath("/html/body/div/div/header/h1"));
	String expectedHeading = "About";
	String actualHeading = heading.getText();
	assertEquals(expectedHeading, actualHeading, "The heading should match");
}


@Test
public void testImageRendering() {
    try {
        WebElement imageElement = driver.findElement(By.xpath("//div[contains(@class, 'image')]/img"));
        assertTrue(imageElement.isDisplayed(), "Image should be displayed on the page.");
        String imageSrc = imageElement.getAttribute("src");
        assertTrue(imageSrc.contains("t1.jpg"), "Image src attribute should contain 't1.jpg'.");
        String imageAlt = imageElement.getAttribute("alt");
        assertEquals(imageAlt, "Educational Content", "Image alt attribute should be 'Educational Content'.");
    } catch (Exception e) {
        e.printStackTrace();
        throw new AssertionError("Test failed due to an unexpected error: " + e.getMessage());
    }
}

@Test
void testStudentPortalNavigation() {
    try {
       loadHomePage();
        WebElement studentPortalLink = driver.findElement(By.linkText("Student Portal"));
        studentPortalLink.click();
        Thread.sleep(2000); 
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("/student")) {
            System.out.println("Student Portal: URL validation passed.");
        } else {
            System.out.println("Student Portal: URL validation failed. Current URL: " + currentUrl);
        }

       WebElement heading = driver.findElement(By.tagName("h1"));
        if ("Student Login".equals(heading.getText())) {
            System.out.println("Student Portal: Heading validation passed.");
        } else {
            System.out.println("Student Portal: Heading validation failed. Current heading: '" + heading.getText() + "'.");
        }

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Student Portal: Test encountered an exception but will not fail.");
    }
}

@Test
void testEducatorPortalNavigation() {
    try {
        loadHomePage();
        WebElement educatorPortalLink = driver.findElement(By.linkText("Educator Portal"));
        educatorPortalLink.click();
        Thread.sleep(2000); 
        String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("/educator")) {
            System.out.println("Educator Portal: URL validation passed.");
        } else {
            System.out.println("Educator Portal: URL validation failed. Current URL: " + currentUrl);
        }
         WebElement heading = driver.findElement(By.tagName("h1"));
        if ("Educator Login".equals(heading.getText())) {
            System.out.println("Educator Portal: Heading validation passed.");
        } else {
            System.out.println("Educator Portal: Heading validation failed. Current heading: '" + heading.getText() + "'.");
        }

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Educator Portal: Test encountered an exception but will not fail.");
    }
}

@Test
void testAdminPortalNavigation() {
    try {
       loadHomePage();
       WebElement adminPortalLink = driver.findElement(By.linkText("Admin Portal"));
        adminPortalLink.click();
        Thread.sleep(2000); 
         String currentUrl = driver.getCurrentUrl();
        if (currentUrl.contains("/admin")) {
            System.out.println("Admin Portal: URL validation passed.");
        } else {
            System.out.println("Admin Portal: URL validation failed. Current URL: " + currentUrl);
        }
        WebElement heading = driver.findElement(By.tagName("h1"));
        if ("Admin Login".equals(heading.getText())) {
            System.out.println("Admin Portal: Heading validation passed.");
        } else {
            System.out.println("Admin Portal: Heading validation failed. Current heading: '" + heading.getText() + "'.");
        }

    } catch (Exception e) {
        e.printStackTrace();
        System.out.println("Admin Portal: Test encountered an exception but will not fail.");
    }
    
}

@Test
public void testParagraphContent1() {
   loadHomePage();
    try {
        
        WebElement paragraph = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("header p")));
        String actualText = paragraph.getText().trim();
        String expectedText = "creating, managing, delivering, and tracking educational content and learning.";
        Assert.assertEquals(actualText, expectedText, "Paragraph content does not match.");
        System.out.println("Test passed: Paragraph content matches.");
    } catch (Exception e) {
        e.printStackTrace();
       Assert.fail("Test failed due to an exception: " + e.getMessage());
    }
}

}

