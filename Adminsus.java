package Educatorr;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.NoSuchElementException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class adminsuspend {

    private WebDriver driver;

    @Before
    public void setUp() {
        // Ensure you have the ChromeDriver executable in your system path
        driver = new ChromeDriver();
        driver.get("http://localhost:3000/admin-suspend"); // Update this URL if needed
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Navbar Tests
    @Test
    public void testNavbarLinks() {
        WebElement dashboardLink = driver.findElement(By.xpath("/html/body/div/div/nav/div/ul/li[1]/a"));
        assertNotNull("Dashboard link should exist", dashboardLink);
        assertTrue("Dashboard link should be displayed", dashboardLink.isDisplayed());
    }
    @Test
    public void testManageStudentsLinkExists() {
        WebElement manageStudentsLink = driver.findElement(By.xpath("/html/body/div/div/nav/div/ul/li[2]/a"));
        assertNotNull("Manage Students link should exist", manageStudentsLink);
        assertTrue("Manage Students link should be displayed", manageStudentsLink.isDisplayed());
    }

//    @Test
//    public void testManageEventsLinkDoesNotExist() {
//        try {
//            WebElement manageEventsLink = driver.findElement(By.xpath("/html/body/div/div/nav/div/ul/li[3]/a"));
//            fail("Manage Events link should not exist");
//        } catch (NoSuchElementException e) {
//            assertTrue("Manage Events link does not exist, as expected", true);
//        }
//    }


//      WebElement manageEventsLink = driver.findElement(By.xpath("/html/body/div/div/nav/div/ul/li[3]/a"));
////      assertNotNull("Manage Events link should exist", manageEventsLink);
////       assertTrue("Manage Events link should be displayed", manageEventsLink.isDisplayed());
//  }
//
    @Test
    public void testLogoutButton() {
        WebElement logoutButton = driver.findElement(By.className("/html/body/div/div/nav/div/div/button"));
        assertNotNull("Logout button should exist", logoutButton);
        assertTrue("Logout button should be displayed", logoutButton.isDisplayed());
        assertEquals("Button text should be 'Log Out'", "Log Out", logoutButton.getText());
    }

    // Suspended Students Table Tests
    @Test
    public void testSuspendedStudentsTable() {
        WebElement suspendedStudentsTable = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/table/tbody"));
        assertNotNull("Suspended Students table should exist", suspendedStudentsTable);}

    @Test
    public void testStudentEmailExists() {
        WebElement studentEmail = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/table/tbody/tr[1]/td[1]"));
        assertNotNull("Student email should exist in the table", studentEmail);
        assertTrue("Student email should be displayed in the table", studentEmail.isDisplayed());
        assertEquals("student1@university.com", studentEmail.getText());
    }
    @Test
    public void testReactivateAndDeleteButtons() {
        try {
            WebElement reactivateButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/table/tbody/tr[1]/td[2]/button[1]"));
            assertNotNull("Reactivate button for student1 should exist", reactivateButton);
            assertTrue("Reactivate button for student1 should be displayed", reactivateButton.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Reactivate button for student1 does not exist");
        }

        try {
            WebElement deleteButton = driver.findElement(By.xpath("/html/body/div/div/div/div[1]/table/tbody/tr[1]/td[2]/button[2]"));
            assertNotNull("Delete button for student1 should exist", deleteButton);
            assertTrue("Delete button for student1 should be displayed", deleteButton.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Delete button for student1 does not exist");
        }
    }



  

    // Events Table Tests
    @Test
    public void testEventsTable() {
//        WebElement eventsTable = driver.findElement("/html/body/div/div/div/div[2]/table/tbody"));
//        assertNotNull("Library Events table should exist", eventsTable);
//
        WebElement eventName = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[1]/td[1]"));
        assertNotNull("Event name should exist in the table", eventName);}

    @Test
    public void testDeleteButtonForEvent() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10); // Wait for up to 10 seconds
            WebElement deleteButton = wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr[1]/td[2]/button")
            ));
            assertNotNull("Delete button for 'Book Donation Drive' should exist", deleteButton);
            assertTrue("Delete button for 'Book Donation Drive' should be displayed", deleteButton.isDisplayed());
        } catch (NoSuchElementException e) {
            fail("Delete button for 'Book Donation Drive' does not exist");
        }
    }

//
//    // Footer Tests
    @Test
    public void testFooterLinks() {
        WebElement aboutLink = driver.findElement(By.xpath("/html/body/div/div/footer/p"));
        assertNotNull("About link should exist in the footer", aboutLink);
    }

//        WebElement privacyPolicyLink = driver.findElement(By.xpath("//footer//a[contains(text(), 'Privacy Policy')]"));
//        assertNotNull("Privacy Policy link should exist in the footer", privacyPolicyLink);

//        WebElement termsAndConditionsLink = driver.findElement(By.xpath("//footer//a[contains(text(), 'Terms and Conditions')]"));
//        assertNotNull("Terms and Conditions link should exist in the footer", termsAndConditionsLink);

        WebElement contactUsLink = driver.findElement(By.xpath("//footer//a[contains(text(), 'Contact Us')]"));
        assertNotNull("Contact Us link should exist in the footer", contactUsLink);
    }}
//
//    @Test
//    public void testFooterText() {
//        WebElement footerText = driver.findElement(By.tagName("footer"));
//        assertNotNull("Footer text should be present", footerText);
//        assertTrue("Footer should contain the correct text", footerText.getText().contains("About | Privacy Policy | Terms and Conditions | Contact Us"));
//    }
//}
