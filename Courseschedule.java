package testing;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.netty.handler.timeout.TimeoutException;

class StudentSchedule {

	  private WebDriver driver;
	   private WebDriverWait wait;

	    @BeforeEach
	    void setUp() {
	        driver = new ChromeDriver();
	        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	    }
	    
	    @Test
	    void testsidebarschedule() {
            driver.get("http://localhost:3000/student");

	        try {
	            WebElement emailInput = driver.findElement(By.id("email1"));
	            WebElement passwordInput = driver.findElement(By.id("password1"));
	            WebElement loginButton = driver.findElement(By.className("login-button1"));

	            emailInput.sendKeys("happy1234@gmail.com");
	            passwordInput.sendKeys("123456789");
	            loginButton.click();

	          
	            try {
	                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	                alert.accept();
	                System.out.println("Alert accepted.");
	            } catch (TimeoutException e) {
	                System.out.println("No alert present.");
	            }

	            wait.until(ExpectedConditions.urlContains("/studentdash"));
	            String currentUrl = driver.getCurrentUrl();
	            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
	        
	            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[4]/a")));
	            sidebarLink.click();
	            
	            
	           
	        } catch (Exception e) {
	            e.printStackTrace();
	        
	        }
        }
	 @Test
	    void testheading() {
	        driver.get("http://localhost:3000/student");

	        try {
	            WebElement emailInput = driver.findElement(By.id("email1"));
	            WebElement passwordInput = driver.findElement(By.id("password1"));
	            WebElement loginButton = driver.findElement(By.className("login-button1"));

	            emailInput.sendKeys("happy1234@gmail.com");
	            passwordInput.sendKeys("123456789");
	            loginButton.click();

	          
	            try {
	                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
	                alert.accept();
	                System.out.println("Alert accepted.");
	            } catch (TimeoutException e) {
	                System.out.println("No alert present.");
	            }

	            wait.until(ExpectedConditions.urlContains("/studentdash"));
	            String currentUrl = driver.getCurrentUrl();
	            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
	        
	            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[4]/a")));
	            sidebarLink.click();
	            

	            WebElement header = driver.findElement(By.xpath("/html/body/div/div/div/h2"));
	            boolean checking = header.isSelected();
	            Assert.assertNotNull(header);
	            
	            

	        } catch (Exception e) {
	        	 e.printStackTrace();
	        }
	    }
	    
	
	        @Test
		    void testwrongheading() {
	            driver.get("http://localhost:3000/student");

		        try {
		            WebElement emailInput = driver.findElement(By.id("email1"));
		            WebElement passwordInput = driver.findElement(By.id("password1"));
		            WebElement loginButton = driver.findElement(By.className("login-button1"));

		            emailInput.sendKeys("happy1234@gmail.com");
		            passwordInput.sendKeys("123456789");
		            loginButton.click();

		          
		            try {
		                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		                alert.accept();
		                System.out.println("Alert accepted.");
		            } catch (TimeoutException e) {
		                System.out.println("No alert present.");
		            }

		            wait.until(ExpectedConditions.urlContains("/studentdash"));
		            String currentUrl = driver.getCurrentUrl();
		            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
		        
		            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[4]/a")));
		            sidebarLink.click();
		            

		         
		            WebElement heading = driver.findElement(By.xpath("/html/body/div/div/div/h2"));
		    		String expectedHeading = "About";
		    		String actualHeading = heading.getText();
		    		assertEquals(expectedHeading, actualHeading, "The heading should match");
		            
		           
		        } catch (Exception e) {
		            e.printStackTrace();
		            Assert.fail("Test failed due to an exception: " + e.getMessage());
		        }
	        }
			    @Test
			    void testDownloadbutton() {
			        driver.get("http://localhost:3000/student");

			        try {
			            WebElement emailInput = driver.findElement(By.id("email1"));
			            WebElement passwordInput = driver.findElement(By.id("password1"));
			            WebElement loginButton = driver.findElement(By.className("login-button1"));

			            emailInput.sendKeys("happy1234@gmail.com");
			            passwordInput.sendKeys("123456789");
			            loginButton.click();

			          
			            try {
			                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			                alert.accept();
			                System.out.println("Alert accepted.");
			            } catch (TimeoutException e) {
			                System.out.println("No alert present.");
			            }

			            wait.until(ExpectedConditions.urlContains("/studentdash"));
			            String currentUrl = driver.getCurrentUrl();
			            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
			        
			            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[4]/a")));
			            sidebarLink.click();
			            
			            
			            WebElement submitButton = driver.findElement(By.xpath("/html/body/div/div/div/div[2]/table/tbody/tr/td[2]/a/button"));
			            submitButton.click();
			            
			            

			        } catch (Exception e) {
			        	 e.printStackTrace();
			        	 
			        }

		}
			    @Test
			    void testtitle() {
			        driver.get("http://localhost:3000/student");

			        try {
			            WebElement emailInput = driver.findElement(By.id("email1"));
			            WebElement passwordInput = driver.findElement(By.id("password1"));
			            WebElement loginButton = driver.findElement(By.className("login-button1"));

			            emailInput.sendKeys("happy1234@gmail.com");
			            passwordInput.sendKeys("123456789");
			            loginButton.click();

			          
			            try {
			                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			                alert.accept();
			                System.out.println("Alert accepted.");
			            } catch (TimeoutException e) {
			                System.out.println("No alert present.");
			            }

			            wait.until(ExpectedConditions.urlContains("/studentdash"));
			            String currentUrl = driver.getCurrentUrl();
			            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
			        
			            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[4]/a")));
			            sidebarLink.click();
			            
			            
			            String expectedTitle = "React App";
			            String actualTitle = driver.getTitle();
			            assertEquals(expectedTitle, actualTitle, "The page title should match");
			            
			            

			        } catch (Exception e) {
			        	 e.printStackTrace();
			        	 
			        }

		

	    }
			    @Test
			    void testwrongtitle() {
			        driver.get("http://localhost:3000/student");

			        try {
			            WebElement emailInput = driver.findElement(By.id("email1"));
			            WebElement passwordInput = driver.findElement(By.id("password1"));
			            WebElement loginButton = driver.findElement(By.className("login-button1"));

			            emailInput.sendKeys("happy1234@gmail.com");
			            passwordInput.sendKeys("123456789");
			            loginButton.click();

			          
			            try {
			                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			                alert.accept();
			                System.out.println("Alert accepted.");
			            } catch (TimeoutException e) {
			                System.out.println("No alert present.");
			            }

			            wait.until(ExpectedConditions.urlContains("/studentdash"));
			            String currentUrl = driver.getCurrentUrl();
			            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
			        
			            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[4]/a")));
			            sidebarLink.click();
			            
			            
			            String expectedTitle = "company website";
			            String actualTitle = driver.getTitle();
			            assertEquals(expectedTitle, actualTitle, "The page title should match");
			            
			            

			        } catch (Exception e) {
			        	 e.printStackTrace();
			        	 
			        }
}
			    @Test
			    void testselectyear() {
			        driver.get("http://localhost:3000/student");

			        try {
			            WebElement emailInput = driver.findElement(By.id("email1"));
			            WebElement passwordInput = driver.findElement(By.id("password1"));
			            WebElement loginButton = driver.findElement(By.className("login-button1"));

			            emailInput.sendKeys("happy1234@gmail.com");
			            passwordInput.sendKeys("123456789");
			            loginButton.click();

			          
			            try {
			                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			                alert.accept();
			                System.out.println("Alert accepted.");
			            } catch (TimeoutException e) {
			                System.out.println("No alert present.");
			            }

			            wait.until(ExpectedConditions.urlContains("/studentdash"));
			            String currentUrl = driver.getCurrentUrl();
			            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
			        
			            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[4]/a")));
			            sidebarLink.click();
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

				        }
			     
				   
				 } catch (Exception e) {
			        	 e.printStackTrace();
			        	 
			        }
}
			    @Test
			    void testSchedulesDisplayed(){
			        driver.get("http://localhost:3000/student");

			        try {
			            WebElement emailInput = driver.findElement(By.id("email1"));
			            WebElement passwordInput = driver.findElement(By.id("password1"));
			            WebElement loginButton = driver.findElement(By.className("login-button1"));

			            emailInput.sendKeys("happy1234@gmail.com");
			            passwordInput.sendKeys("123456789");
			            loginButton.click();

			          
			            try {
			                Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			                alert.accept();
			                System.out.println("Alert accepted.");
			            } catch (TimeoutException e) {
			                System.out.println("No alert present.");
			            }

			            wait.until(ExpectedConditions.urlContains("/studentdash"));
			            String currentUrl = driver.getCurrentUrl();
			            assertTrue(currentUrl.contains("/studentdash"), "Login failed: Expected to be redirected to student dashboard.");
			        
			            WebElement sidebarLink = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div/nav/ul/li[4]/a")));
			            sidebarLink.click();
			            try {
			 	           
				            Thread.sleep(2000); 

				           
				            WebElement scheduleTable = driver.findElement(By.cssSelector(".schedule-table2 table"));
				            
				           
				            WebElement firstRow = scheduleTable.findElement(By.xpath(".//tbody/tr[1]/td[1]"));
				            WebElement secondRow = scheduleTable.findElement(By.xpath(".//tbody/tr[2]/td[1]"));
				            
				            assertEquals("Schedule1.pdf", firstRow.getText());
				            assertEquals("Schedule2.pdf", secondRow.getText());

				        } catch (Exception e) {
				            e.printStackTrace();
				           
				        }
				    
			           
				        } catch (Exception e) {
				            e.printStackTrace();

				        }
			     
				   
				
}
}
