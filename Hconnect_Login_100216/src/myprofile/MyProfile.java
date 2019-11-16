package myprofile;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class MyProfile extends BasetestScript{
	private boolean acceptNextAlert = true;
	
	@Test(priority = 1)
	public void AddPersonalInformation() throws IOException,InterruptedException
	{	
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		//driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("i.healthsummary")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnEdit")).click();
		//personal information
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).sendKeys("vrajesh");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).sendKeys("tilva");
	    
	    File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\personal_information.jpeg"),true);
		 
	    //Contact information
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    driver.findElement(By.linkText("2Contact Information")).click();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobile")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobile")).sendKeys("9016836027");
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress")).sendKeys("Ashram road,ahmedabad");
	    
	    //System.out.println("clicking on save");
	    Thread.sleep(2000);
	    //driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);   
	    
	    WebElement profile = driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave"));
		action.moveToElement(profile).build().perform();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave")).click();
		/*assertEquals(closeAlertAndGetItsText(), "Personal Profile Updated Successfully .");     
		System.out.println("Error" + closeAlertAndGetItsText());*/
	    
		
		File scrFile1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile1,new File("D:\\temp\\contact_information.jpeg"),true);
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
	
	public boolean isAlertPresent() {

		  boolean presentFlag = false;

		  try {

		   // Check the presence of alert
		   Alert alert = driver.switchTo().alert();
		   // Alert present; set the flag
		   presentFlag = true;
		   // if present consume the alert
		   alert.accept();

		  } catch (NoAlertPresentException ex) {
		   // Alert not present
		   ex.printStackTrace();
		  }

		  return presentFlag;

		 }
}
