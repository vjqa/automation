package verifyreport;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class VerifyReports extends BasetestScript {
	
  @Test(priority = 1)
  public void BoneDatewiseReport() throws IOException,InterruptedException {
	  
	  Actions action = new Actions(driver);
	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver);
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[1]/span/samp/span")).click();
	  
	  
	 /* driver.getWindowHandle(); // get the current window handle
	  driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[1]/span/samp/span")).click(); // click some link that opens a new window
	  
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);*/
		
		
		WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
			
		/*Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0")));*/
			
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0")).click();
		System.out.println("Date element Find");
		Thread.sleep(1000);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath(".//*[@id='lnkReport']")));
			
		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[@id='lnkReport']")).click();
		driver.findElement(By.linkText("View Report")).click();
		//driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnDownloadLink']")).click();
		System.out.println("Bone View report link found");
		Thread.sleep(5000);
		
		
		
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\ViewReports\\View_Bone_reports.jpeg"),true);
	}
  
  public void verifiereport(String Calcium) throws InterruptedException
	{
		if(Calcium.equalsIgnoreCase((driver.findElement(By.xpath("//*[@id='PrintData']/table/tbody/tr[4]/td[2]/label))")).getText())))
		{
			Assert.assertTrue(true);
		}
		else{
			 Assert.assertTrue(false);
		}
	
	}
  
  @Test(priority = 2)
  public void GlucoseDatewiseReport() throws IOException,InterruptedException {
	  
	  Actions action = new Actions(driver);
	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver);
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[1]/span/samp/span")).click();
	  
	  
	 /* driver.getWindowHandle(); // get the current window handle
	  driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[1]/span/samp/span")).click(); // click some link that opens a new window
	  
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);*/
		
		
		WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
			
		/*Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0")));*/
			
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0")).click();
		System.out.println("Date element Find");
		Thread.sleep(1000);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath(".//*[@id='lnkReport']")));
			
		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[@id='lnkReport']")).click();
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptrPatientdetailsDateWise']/table/tbody/tr[3]/td[5]")).click();
		//driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnDownloadLink']")).click();
		System.out.println("Glucose View report link found");
		Thread.sleep(5000);
		
		 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\ViewReports\\View_Glucose_reports.jpeg"),true);
  }
  
  @Test(priority = 3)
  public void BloodDatewiseReport() throws IOException,InterruptedException {
	  
	  Actions action = new Actions(driver);
	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver);
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	  driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[1]/span/samp/span")).click();
	  
	  
	 /* driver.getWindowHandle(); // get the current window handle
	  driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[1]/span/samp/span")).click(); // click some link that opens a new window
	  
		for (String winHandle : driver.getWindowHandles()) {
		    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);*/
		
		
		WebElement element = driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();
			
		/*Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0")));*/
			
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0")).click();
		System.out.println("Date element Find");
		Thread.sleep(1000);
		
		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By.xpath(".//*[@id='lnkReport']")));
			
		Thread.sleep(1000);
		//driver.findElement(By.xpath(".//*[@id='lnkReport']")).click();
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptrPatientdetailsDateWise']/table/tbody/tr[4]/td[5]")).click();
		//driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnDownloadLink']")).click();
		System.out.println("Glucose View report link found");
		Thread.sleep(5000);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\ViewReports\\View_Blood_reports.jpeg"),true);
  }
  
}

