package emc;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class EmergencyCardDetails extends BasetestScript {
	 private boolean acceptNextAlert = true;
  
	 @Test(priority=1)
	 public void View() throws IOException,InterruptedException
	 {
		 Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
	  	
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		  driver.getWindowHandle(); // get the current window handle
		  driver.findElement(By.xpath("//form[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[2]/span/samp/span")).click(); // click some link that opens a new window
		  
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
			
	            
	      File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
			 FileUtils.copyFile(scrFile,new File("D:\\temp\\EMC\\EMR_View.jpeg"),true);
	 }
  
  @Test(priority=2)
  public void Share() throws IOException,InterruptedException
  {
	  try{
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  String parentHandle = driver.getWindowHandle(); // get the current window handle
	  driver.findElement(By.xpath("//form[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[2]/span/samp/span")).click(); // click some link that opens a new window
	  
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
      // ERROR: Caught exception [ERROR: Unsupported command [captureEntirePageScreenshot | d:\temp\EMR.png | ]]
	
		
	// Clicking on Share button
	Actions action = new Actions(driver);
	WebElement EMR = driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShareView"));
	action.moveToElement(EMR).build().perform();
	
	driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnShareView")).click();
	
	//View share pop-up windows	
	driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divShare']/table"));
	
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmail")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmail")).sendKeys("testuser@mailnesia.com");
    //Thread.sleep(2000);
    driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnShare']"));
    System.out.println("Share button element found");
      
    driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnShare']")).click();
    Thread.sleep(5000);
   
    File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
    FileUtils.copyFile(scrFile1,new File("D:\\temp\\EMC\\EMR_Share_sucsess.jpeg"),true);
  
	  }
	  catch(Exception e)
	  {
		  System.out.println("Error message" + e);		  
	  }
	  
	 Thread.sleep(2000);
	 driver.switchTo().alert().accept();
  
   /* //Do some click action to render alert.
    //statement to wait for an alert.
    WebDriverWait wait = new WebDriverWait(driver,10);
    wait.until(ExpectedConditions.alertIsPresent());
   //accepting the alert
   driver.switchTo().alert().accept();
   
   Alert alert = driver.switchTo().alert();
	System.out.println(alert.getText());*/
    
    //File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
    //FileUtils.copyFile(scrFile,new File("D:\\temp\\EMR_Share_screen.jpeg"),true);
    
    /*Actions sharebutton = new Actions(driver);
	sharebutton.moveToElement(driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnShare']")));
	
	driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnShare']")).click();
	System.out.println("Click to share");
	
	String alertText = "";
	WebDriverWait wait = new WebDriverWait(driver, 5);
	// This will wait for a maximum of 5 seconds, everytime wait is used

	driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnShare']")).click();//causes page to alert() something

	wait.until(ExpectedConditions.alertIsPresent());
	// Before you try to switch to the so given alert, he needs to be present.

	Alert alert = driver.switchTo().alert();
	alertText = alert.getText();
	alert.accept();
			
	driver.switchTo().window(parentHandle);*/
	    
    //assertEquals(isAlertPresent(), "Mail Send Successfully");
    
     // driver.close(); // close newly opened window when done with it
     //driver.switchTo().window(parentHandle); // switch back to the original window
    }
  
  @Test(priority=3)
  public void Print() throws IOException,InterruptedException, AWTException
  {
	  Actions action = new Actions(driver);
	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver);
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	//Open link in new windows and after coming back to the parent

	  String parentHandle = driver.getWindowHandle(); // get the current window handle
	  driver.findElement(By.xpath("//form[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[2]/span/samp/span")).click(); // click some link that opens a new window

	  for (String winHandle : driver.getWindowHandles()) {
	      driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	  }

	  driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnPrint")).click(); //Click to Edit 
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	  Thread.sleep(2000);
	  
	  System.out.println("URL is: " + driver.getCurrentUrl());
	  
	  String currenturl = driver.getCurrentUrl();
	  
	  driver.get(currenturl);
	  driver.getWindowHandle();
	  
	  Robot r = new Robot();
	  r.keyPress(KeyEvent.VK_ESCAPE);
	  r.keyRelease(KeyEvent.VK_ESCAPE);
	  
	  File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
	    FileUtils.copyFile(scrFile1,new File("D:\\temp\\EMC\\EMR_Print.jpeg"),true);
	  
	    /*//Take screenshot of Contact information
	    File contactinfo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(contactinfo,new File("D:\\temp\\Print_EMC.jpeg"),true);
		
		//click on save
	    WebElement profile = driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave"));
		action.moveToElement(profile).build().perform();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		assertEquals(isAlertPresent(), "Personal Profile Updated Successfully .");     
		System.out.println("Error" + isAlertPresent());
				
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile1,new File("D:\\temp\\Print_Success.jpeg"),true);
	    
	  //code to do something on new window

	  driver.close(); // close newly opened window when done with it
	  driver.switchTo().window(parentHandle); // switch back to the original window
*/
  }
  
  @Test(priority=4)
  public void Edit() throws IOException,InterruptedException
  {
	  Actions action = new Actions(driver);
	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver);
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	//Open link in new windows and after coming back to the parent

	  String parentHandle = driver.getWindowHandle(); // get the current window handle
	  driver.findElement(By.xpath("//form[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[2]/span/samp/span")).click(); // click some link that opens a new window

	  for (String winHandle : driver.getWindowHandles()) {
	      driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
	  }

	  Thread.sleep(2000);
	  screenshot.setCaptureScreenShot(driver);
	  
	  driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnEdit")).click(); //Click to Edit 
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("i.healthsummary")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnEdit")).click();
		//personal information
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).sendKeys("update");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).sendKeys("data");
	  
	    //Take screenshot of Personal information
	    File personalinfo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(personalinfo,new File("D:\\temp\\EMC\\EMC_Edit_personal_information.jpeg"),true);
		
	    //Contact information
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.findElement(By.linkText("2Contact Information")).click();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobile")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobile")).sendKeys("9016836027");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress")).sendKeys("Ashram road");
	    
	    //Take screenshot of Contact information
	    File contactinfo = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(contactinfo,new File("D:\\temp\\EMC\\EMC_Edit_contact_information.jpeg"),true);
		
		//click on save
	    WebElement profile = driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave"));
		action.moveToElement(profile).build().perform();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave")).click();
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave")).click();//causes page to alert() something

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();
						
		/*assertEquals(isAlertPresent(), "Personal Profile Updated Successfully .");     
		System.out.println("Error" + isAlertPresent());*/
				
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile1,new File("D:\\temp\\EMC\\EMC_Edit_success_information.jpeg"),true);
		
		driver.switchTo().window(parentHandle);
	}
  
    
  private boolean isElementPresent(By by) {
      try {
        driver.findElement(by);
        return true;
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    
  private boolean isAlertPresent() {
      try {
        driver.switchTo().alert();
        return true;
      } catch (NoAlertPresentException e) {
        return false;
      }
    }

    
  private String closeAlertAndGetItsText() {
      try {
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        if (acceptNextAlert) {
          alert.accept();
        } else {
          alert.dismiss();
        }
        return alertText;
      } finally {
        acceptNextAlert = true;
      }
    }

}
