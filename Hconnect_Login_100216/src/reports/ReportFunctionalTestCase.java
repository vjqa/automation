package reports;

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
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class ReportFunctionalTestCase extends BasetestScript {
	private boolean acceptNextAlert = true;
	@Test(priority = 1)
	public void AddBloodReports() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Enter User Credential");
		
		 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		 String parentHandle = driver.getWindowHandle(); // get the current window handle
		  driver.findElement(By.id("A1")).click(); // click some link that opens a new window
		  
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
			
		//driver.get("https://www.hconnect.in:8091/Display/CreateTemplate?MHxJZA==&MjU4MnxISWQ=&");
		
		BLOOD("13", "15", "500", "55", "66", "4566", "456", "retest");
		System.out.println("Input Blood sucess");
		
		
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\AddReports\\Add_Blood_Report.jpeg"),true);
		
		Actions Blood = new Actions(driver);
		Blood.moveToElement(driver.findElement(By.xpath(".//*[@id='btnSavePatient']")));
		
		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		System.out.println("Click on SavePatient");
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();//causes page to alert() something

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();
		
		System.out.println("Blood : " + alertText);
		driver.switchTo().window(parentHandle);

		/*System.out.println("wait for opening popup");
		Thread.sleep(3000);
		
		System.out.println("Click on ok");
		driver.switchTo().alert().accept();*/
		
		/*System.out.println("driver closed");
		driver.close();*/
	}
	
	@Test(priority = 2)
	public void AddBoneReports() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Success Login");	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		 String parentHandle = driver.getWindowHandle(); // get the current window handle
		  driver.findElement(By.id("A1")).click(); // click some link that opens a new window
		  
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
		
		Actions Bone = new Actions(driver);
		Bone.moveToElement(driver.findElement(By.xpath(".//*[@id='Service_1216']/p")));
			
		driver.findElement(By.xpath(".//*[@id='Service_1216']/p")).click();
		System.out.println("Click on Bone Template");
		Thread.sleep(1000);
			
		BONE("25", "30", "bonedata");
		System.out.println("Success Input Bone");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\AddReports\\Add_Bone_Report.jpeg"),true);
		
		Actions savebutton = new Actions(driver);
		savebutton.moveToElement(driver.findElement(By.xpath(".//*[@id='btnSavePatient']")));
		
		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		System.out.println("Click on SavePatient");
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();//causes page to alert() something

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();
		
		System.out.println("Bone : " + alertText);
		driver.switchTo().window(parentHandle);
	}
		
	@Test(priority = 3)
	public void AddGlucoseReports() throws IOException,InterruptedException
	{				
		
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Success Login");	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		  driver.findElement(By.id("A1")).click(); // click some link that opens a new window
		  
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
		
		Actions Glucose = new Actions(driver);
		Glucose.moveToElement(driver.findElement(By.xpath(".//*[@id='Service_1222']/p")));
			
		driver.findElement(By.xpath(".//*[@id='Service_1222']/p")).click();
		System.out.println("Click on Glucose Template");
		Thread.sleep(1000);
			
		GLUCOSE("21", "20", "56", "12", "23", "Glucose");
		System.out.println("Success Input Glucose");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\AddReports\\Add_Glucose_Report.jpeg"),true);
		
		Actions savebutton = new Actions(driver);
		savebutton.moveToElement(driver.findElement(By.xpath(".//*[@id='btnSavePatient']")));
		
		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		System.out.println("Click on SavePatient");
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();//causes page to alert() something

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();
		
		System.out.println("Glucose : " + alertText);
		driver.switchTo().window(parentHandle);
		
	}
	
	@Test(priority = 4)
	public void AddKidneyReports() throws IOException,InterruptedException
	{				
		
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Success Login");	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		  driver.findElement(By.id("A1")).click(); // click some link that opens a new window
		  
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
		
		Actions Kidney = new Actions(driver);
		Kidney.moveToElement(driver.findElement(By.xpath(".//*[@id='Service_1218']/p")));
			
		driver.findElement(By.xpath(".//*[@id='Service_1218']/p")).click();
		System.out.println("Click on Kidney Template");
		Thread.sleep(1000);
		
		KIDNEY("13", "45", "54", "65", "48", "30", "32", "15", "180", "68", "Kidneydata");
		System.out.println("Success Input Kidney");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\AddReports\\Add_Kidney_Report.jpeg"),true);
		
		Actions savebutton = new Actions(driver);
		savebutton.moveToElement(driver.findElement(By.xpath(".//*[@id='btnSavePatient']")));
		
		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		System.out.println("Click on SavePatient");
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();//causes page to alert() something

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();
		
		System.out.println("Kidney : " + alertText);
		driver.switchTo().window(parentHandle);
		
	}
	
	@Test(priority = 5)
	public void AddLipidReports() throws IOException,InterruptedException,NoAlertPresentException
	{				
		
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Success Login");	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		  driver.findElement(By.id("A1")).click(); // click some link that opens a new window
		  
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
		
		Actions Lipid = new Actions(driver);
		Lipid.moveToElement(driver.findElement(By.xpath(".//*[@id='Service_1215']/p")));
			
		driver.findElement(By.xpath(".//*[@id='Service_1215']/p")).click();
		System.out.println("Click on Kidney Template");
		Thread.sleep(1000);
		
		LIPID("16", "49", "24", "58", "80","Lipiddata");
		System.out.println("Success Input Lipid");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\AddReports\\Add_Lipid_Report.jpeg"),true);
		
		Actions savebutton = new Actions(driver);
		savebutton.moveToElement(driver.findElement(By.xpath(".//*[@id='btnSavePatient']")));
		
		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		System.out.println("Click on SavePatient");
		
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();//causes page to alert() something
		System.out.println("Click on SavePatient");

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();
		
		System.out.println("Lipid : " + alertText);
		driver.switchTo().window(parentHandle);
}
			
	@Test(priority = 6)
	public void AddLiverReports() throws IOException,InterruptedException,NoAlertPresentException
	{				
		
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Success Login");	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		  driver.findElement(By.id("A1")).click(); // click some link that opens a new window
		  
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
		
		Actions Liver = new Actions(driver);
		Liver.moveToElement(driver.findElement(By.xpath(".//*[@id='Service_1217']/p")));
			
		driver.findElement(By.xpath(".//*[@id='Service_1217']/p")).click();
		System.out.println("Click on Liver Template");
		Thread.sleep(1000);
		
		LIVER("13", "23", "18", "25", "45", "65", "55", "Liverdata");
		System.out.println("Success Input Liver");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\AddReports\\Add_Liver_Report.jpeg"),true);
		
		Actions savebutton = new Actions(driver);
		savebutton.moveToElement(driver.findElement(By.xpath(".//*[@id='btnSavePatient']")));
		
		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		System.out.println("Click on SavePatient");
		
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();//causes page to alert() something
		System.out.println("Click on SavePatient");

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();
		
		System.out.println("Liver : " + alertText);
		driver.switchTo().window(parentHandle);
}
	
	@Test(priority = 7)
	public void AddPregnancyDetailsReports() throws IOException,InterruptedException,NoAlertPresentException
	{				
		
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Success Login");	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		  driver.findElement(By.id("A1")).click(); // click some link that opens a new window
		  
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
		
		Actions Liver = new Actions(driver);
		Liver.moveToElement(driver.findElement(By.xpath(".//*[@id='Service_1228']/p")));
			
		driver.findElement(By.xpath(".//*[@id='Service_1228']/p")).click();
		System.out.println("Click on PregnancyDetails Template");
		Thread.sleep(1000);
		
		PREGNANCYDETAILS("24", "05", "History", "Sonographydetails", "PregnancyData");
		System.out.println("Success Input Liver");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\AddReports\\Add_PregnancyDetails_Report.jpeg"),true);
		
		Actions savebutton = new Actions(driver);
		savebutton.moveToElement(driver.findElement(By.xpath(".//*[@id='btnSavePatient']")));
		
		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		System.out.println("Click on SavePatient");
		
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();//causes page to alert() something
		System.out.println("Click on SavePatient");

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();
		
		System.out.println("PregnancyDetails : " + alertText);
		driver.switchTo().window(parentHandle);
}
	
	@Test(priority = 8)
	public void AddThyroidReports() throws IOException,InterruptedException,NoAlertPresentException
	{				
		
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Success Login");	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		  driver.findElement(By.id("A1")).click(); // click some link that opens a new window
		  
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
		
		Actions Liver = new Actions(driver);
		Liver.moveToElement(driver.findElement(By.xpath(".//*[@id='Service_1212']/p")));
			
		driver.findElement(By.xpath(".//*[@id='Service_1212']/p")).click();
		System.out.println("Click on Thyroid Template");
		Thread.sleep(1000);
		
		THYROID("23", "43", "65", "76", "435", "ThyroidNote");
		System.out.println("Success Input Thyroid");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\AddReports\\Add_Thyroid_Report.jpeg"),true);
		
		Actions savebutton = new Actions(driver);
		savebutton.moveToElement(driver.findElement(By.xpath(".//*[@id='btnSavePatient']")));
		
		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		System.out.println("Click on SavePatient");
		
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();//causes page to alert() something
		System.out.println("Click on SavePatient");

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();
		
		System.out.println("Thyroid : " + alertText);
		driver.switchTo().window(parentHandle);
}
	
	@Test(priority = 8)
	public void AddVitaminReports() throws IOException,InterruptedException,NoAlertPresentException
	{				
		
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Success Login");	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		  
		String parentHandle = driver.getWindowHandle(); // get the current window handle
		  driver.findElement(By.id("A1")).click(); // click some link that opens a new window
		  
			for (String winHandle : driver.getWindowHandles()) {
			    driver.switchTo().window(winHandle); // switch focus of WebDriver to the next found window handle (that's your newly opened window)
			}
		
		Actions Liver = new Actions(driver);
		Liver.moveToElement(driver.findElement(By.xpath(".//*[@id='Service_1227']/p")));
			
		driver.findElement(By.xpath(".//*[@id='Service_1227']/p")).click();
		System.out.println("Click on Vitamin Template");
		Thread.sleep(1000);
		
		VITAMIN("25", "65", "Vitamindata");
		System.out.println("Success Input Vitamin");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(scrFile,new File("D:\\temp\\AddReports\\Add_Vitamin_Report.jpeg"),true);
		
		Actions savebutton = new Actions(driver);
		savebutton.moveToElement(driver.findElement(By.xpath(".//*[@id='btnSavePatient']")));
		
		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		System.out.println("Click on SavePatient");
		
		
		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();//causes page to alert() something
		System.out.println("Click on SavePatient");

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();
		
		System.out.println("Vitamin : " + alertText);
		driver.switchTo().window(parentHandle);
}
		
	public void BLOOD(String Haemoglobin,String TotalRedbloodCells,String TotalWhitebloodCells,String PlateletCount,String ErythrocyteSedimentationRate,String CReactiveProtein,String INR,String Note) throws InterruptedException
	{
		/*WebElement gettext = driver.findElement(By.xpath(".//*[@id='304']"));
		gettext.sendKeys(Haemoglobin);
		gettext.getText();
		System.out.println("First Text : " + gettext);
		
		driver.findElement(By.xpath(".//*[@id='304']")).sendKeys();
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath(".//*[@id='305']")).sendKeys(TotalRedbloodCells);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='306']")).sendKeys(TotalWhitebloodCells);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='322']")).sendKeys(PlateletCount);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='2418']")).sendKeys(ErythrocyteSedimentationRate);
		Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='1108']")).sendKeys(CReactiveProtein);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='2498']")).sendKeys(INR);
	    Thread.sleep(1000);
	    driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
	    Thread.sleep(1000);
	    //driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
	    //driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
*/	    
	    driver.findElement(By.xpath(".//*[@id='304']")).sendKeys(Haemoglobin);
		WebElement TxtBoxContent = driver.findElement(By.xpath(".//*[@id='304']"));
		System.out.println(TxtBoxContent.getAttribute("Name") + "Value is : " + TxtBoxContent.getAttribute("value"));
		Thread.sleep(1000);		
		
		driver.findElement(By.xpath(".//*[@id='305']")).sendKeys(TotalRedbloodCells);
		WebElement TxtBoxContent1 = driver.findElement(By.xpath(".//*[@id='305']"));
		System.out.println(TxtBoxContent1.getAttribute("Name") + "Value is : " + TxtBoxContent1.getAttribute("value"));
		Thread.sleep(1000);
		
		
		driver.findElement(By.xpath(".//*[@id='306']")).sendKeys(TotalWhitebloodCells);
		WebElement TxtBoxContent2 = driver.findElement(By.xpath(".//*[@id='306']"));
		System.out.println(TxtBoxContent2.getAttribute("Name") + "Value is : " + TxtBoxContent2.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='322']")).sendKeys(PlateletCount);
		WebElement TxtBoxContent3 = driver.findElement(By.xpath(".//*[@id='322']"));
		System.out.println(TxtBoxContent3.getAttribute("Name") + "Value is : " + TxtBoxContent3.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='2418']")).sendKeys(ErythrocyteSedimentationRate);
		WebElement TxtBoxContent4 = driver.findElement(By.xpath(".//*[@id='2418']"));
		System.out.println(TxtBoxContent4.getAttribute("Name") + "Value is : " + TxtBoxContent4.getAttribute("value"));
		Thread.sleep(1000);
		
	    driver.findElement(By.xpath(".//*[@id='1108']")).sendKeys(CReactiveProtein);
	    WebElement TxtBoxContent5 = driver.findElement(By.xpath(".//*[@id='1108']"));
		System.out.println(TxtBoxContent5.getAttribute("Name") + "Value is : " + TxtBoxContent5.getAttribute("value"));
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath(".//*[@id='2498']")).sendKeys(INR);
	    WebElement TxtBoxContent6 = driver.findElement(By.xpath(".//*[@id='2498']"));
		System.out.println(TxtBoxContent6.getAttribute("Name") + "Value is : " + TxtBoxContent6.getAttribute("value"));
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
	    WebElement TxtBoxContent7 = driver.findElement(By.xpath(".//*[@id='304']"));
		System.out.println(TxtBoxContent7.getAttribute("Name") + "Value is : " + TxtBoxContent7.getAttribute("value"));
	    Thread.sleep(1000);
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
	
	public void BONE(String Calcium,String Phosphorus,String Note) throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='1013']")).sendKeys(Calcium);
		WebElement TxtBoxContent1 = driver.findElement(By.xpath(".//*[@id='1013']"));
		System.out.println(TxtBoxContent1.getAttribute("Name") + "Value is : " + TxtBoxContent1.getAttribute("value"));
		Thread.sleep(1000);		
		
		driver.findElement(By.xpath(".//*[@id='1918']")).sendKeys(Phosphorus);
		WebElement TxtBoxContent2 = driver.findElement(By.xpath(".//*[@id='1918']"));
		System.out.println(TxtBoxContent2.getAttribute("Name") + "Value is : " + TxtBoxContent2.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
		WebElement TxtBoxContent3 = driver.findElement(By.xpath(".//*[@id='1075']"));
		System.out.println(TxtBoxContent3.getAttribute("Name") + "Value is : " + TxtBoxContent3.getAttribute("value"));
		Thread.sleep(1000);
		
		//driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
	    //driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
	

	public void GLUCOSE(String FastingBloodSugar,String MeanPlasmaGlucose,String PostLunchBloodSugar,String RandomBloodSugar,String GlycosylatedHemoglobinHbA1c,String Note) throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='2177']")).sendKeys(FastingBloodSugar);
		WebElement TxtBoxContent1 = driver.findElement(By.xpath(".//*[@id='2177']"));
		System.out.println(TxtBoxContent1.getAttribute("Name") + "Value is : " + TxtBoxContent1.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1114']")).sendKeys(MeanPlasmaGlucose);
		WebElement TxtBoxContent2 = driver.findElement(By.xpath(".//*[@id='1114']"));
		System.out.println(TxtBoxContent2.getAttribute("Name") + "Value is : " + TxtBoxContent2.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='2342']")).sendKeys(PostLunchBloodSugar);
		WebElement TxtBoxContent3 = driver.findElement(By.xpath(".//*[@id='2342']"));
		System.out.println(TxtBoxContent3.getAttribute("Name") + "Value is : " + TxtBoxContent3.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='938']")).sendKeys(RandomBloodSugar);
		WebElement TxtBoxContent4 = driver.findElement(By.xpath(".//*[@id='938']"));
		System.out.println(TxtBoxContent4.getAttribute("Name") + "Value is : " + TxtBoxContent4.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1017']")).sendKeys(GlycosylatedHemoglobinHbA1c);
		WebElement TxtBoxContent5 = driver.findElement(By.xpath(".//*[@id='1017']"));
		System.out.println(TxtBoxContent5.getAttribute("Name") + "Value is : " + TxtBoxContent5.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
		WebElement TxtBoxContent6 = driver.findElement(By.xpath(".//*[@id='1075']"));
		System.out.println(TxtBoxContent6.getAttribute("Name") + "Value is : " + TxtBoxContent6.getAttribute("value"));
		Thread.sleep(1000);
	    
	    //driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
	    //driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	}
	
	public void KIDNEY(String hoursUrineProtein,String Creatinine,String Urea,String UPCratio,String BloodUreaNitrogen,String UricAcidinBlood,String Sodium,String Potassium,String Chloride,String Bicarbonate,String Note) throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='1348']")).sendKeys(hoursUrineProtein);
		WebElement TxtBoxContent1 = driver.findElement(By.xpath(".//*[@id='1348']"));
		System.out.println(TxtBoxContent1.getAttribute("Name") + "Value is : " + TxtBoxContent1.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='517']")).sendKeys(Creatinine);
		WebElement TxtBoxContent2 = driver.findElement(By.xpath(".//*[@id='517']"));
		System.out.println(TxtBoxContent2.getAttribute("Name") + "Value is : " + TxtBoxContent2.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1022']")).sendKeys(Urea);
		WebElement TxtBoxContent3 = driver.findElement(By.xpath(".//*[@id='1022']"));
		System.out.println(TxtBoxContent3.getAttribute("Name") + "Value is : " + TxtBoxContent3.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1935']")).sendKeys(UPCratio);
		WebElement TxtBoxContent4 = driver.findElement(By.xpath(".//*[@id='1935']"));
		System.out.println(TxtBoxContent4.getAttribute("Name") + "Value is : " + TxtBoxContent4.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='501']")).sendKeys(BloodUreaNitrogen);
		WebElement TxtBoxContent5 = driver.findElement(By.xpath(".//*[@id='501']"));
		System.out.println(TxtBoxContent5.getAttribute("Name") + "Value is : " + TxtBoxContent5.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1021']")).sendKeys(UricAcidinBlood);
		WebElement TxtBoxContent6 = driver.findElement(By.xpath(".//*[@id='1021']"));
		System.out.println(TxtBoxContent6.getAttribute("Name") + "Value is : " + TxtBoxContent6.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1010']")).sendKeys(Sodium);
		WebElement TxtBoxContent7 = driver.findElement(By.xpath(".//*[@id='1010']"));
		System.out.println(TxtBoxContent7.getAttribute("Name") + "Value is : " + TxtBoxContent7.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1011']")).sendKeys(Potassium);
		WebElement TxtBoxContent8 = driver.findElement(By.xpath(".//*[@id='1011']"));
		System.out.println(TxtBoxContent8.getAttribute("Name") + "Value is : " + TxtBoxContent8.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1012']")).sendKeys(Chloride);
		WebElement TxtBoxContent9 = driver.findElement(By.xpath(".//*[@id='1012']"));
		System.out.println(TxtBoxContent9.getAttribute("Name") + "Value is : " + TxtBoxContent9.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1757']")).sendKeys(Bicarbonate);
		WebElement TxtBoxContent10 = driver.findElement(By.xpath(".//*[@id='1757']"));
		System.out.println(TxtBoxContent10.getAttribute("Name") + "Value is : " + TxtBoxContent10.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
		WebElement TxtBoxContent11 = driver.findElement(By.xpath(".//*[@id='1075']"));
		System.out.println(TxtBoxContent11.getAttribute("Name") + "Value is : " + TxtBoxContent11.getAttribute("value"));
		Thread.sleep(1000);
	}
	
	public void LIPID(String TCholesterol,String Triglycerides,String LDLC,String HDLC,String VLDL,String Note) throws InterruptedException
	{
		/*Actions action12 = new Actions(driver);
		action12.moveToElement(driver.findElement(By.xpath(".//*[@id='grdViewPatient']/div/div/h4"))); 
		driver.findElement(By.xpath(".//*[@id='grdViewPatient']/div/div/h4"));*/
		
		driver.findElement(By.xpath(".//*[@id='990']")).sendKeys(TCholesterol);
		WebElement TxtBoxContent1 = driver.findElement(By.xpath(".//*[@id='990']"));
		System.out.println(TxtBoxContent1.getAttribute("Name") + "Value is : " + TxtBoxContent1.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='991']")).sendKeys(Triglycerides);
		WebElement TxtBoxContent2 = driver.findElement(By.xpath(".//*[@id='991']"));
		System.out.println(TxtBoxContent2.getAttribute("Name") + "Value is : " + TxtBoxContent2.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='993']")).sendKeys(LDLC);
		WebElement TxtBoxContent3 = driver.findElement(By.xpath(".//*[@id='993']"));
		System.out.println(TxtBoxContent3.getAttribute("Name") + "Value is : " + TxtBoxContent3.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='992']")).sendKeys(HDLC);
		WebElement TxtBoxContent4 = driver.findElement(By.xpath(".//*[@id='1075']"));
		System.out.println(TxtBoxContent4.getAttribute("Name") + "Value is : " + TxtBoxContent4.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='994']")).sendKeys(VLDL);
		WebElement TxtBoxContent5 = driver.findElement(By.xpath(".//*[@id='994']"));
		System.out.println(TxtBoxContent5.getAttribute("Name") + "Value is : " + TxtBoxContent5.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
		WebElement TxtBoxContent6 = driver.findElement(By.xpath(".//*[@id='1075']"));
		System.out.println(TxtBoxContent6.getAttribute("Name") + "Value is : " + TxtBoxContent6.getAttribute("value"));
		Thread.sleep(1000);
	}
	
	public void LIVER(String Bilirubin,String SGOT,String SGPT,String AlkalinePhosphatase,String Albumin,String Globulin,String TotalProtein,String Note) throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='997']")).sendKeys(Bilirubin);
		WebElement TxtBoxContent1 = driver.findElement(By.xpath(".//*[@id='997']"));
		System.out.println(TxtBoxContent1.getAttribute("Name") + "Value is : " + TxtBoxContent1.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='505']")).sendKeys(SGOT);
		WebElement TxtBoxContent2 = driver.findElement(By.xpath(".//*[@id='505']"));
		System.out.println(TxtBoxContent2.getAttribute("Name") + "Value is : " + TxtBoxContent2.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1029']")).sendKeys(SGPT);
		WebElement TxtBoxContent3 = driver.findElement(By.xpath(".//*[@id='1029']"));
		System.out.println(TxtBoxContent3.getAttribute("Name") + "Value is : " + TxtBoxContent3.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1001']")).sendKeys(AlkalinePhosphatase);
		WebElement TxtBoxContent4 = driver.findElement(By.xpath(".//*[@id='1001']"));
		System.out.println(TxtBoxContent4.getAttribute("Name") + "Value is : " + TxtBoxContent4.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1003']")).sendKeys(Albumin);
		WebElement TxtBoxContent5 = driver.findElement(By.xpath(".//*[@id='1003']"));
		System.out.println(TxtBoxContent5.getAttribute("Name") + "Value is : " + TxtBoxContent5.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1004']")).sendKeys(Globulin);
		WebElement TxtBoxContent6 = driver.findElement(By.xpath(".//*[@id='1004']"));
		System.out.println(TxtBoxContent6.getAttribute("Name") + "Value is : " + TxtBoxContent6.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1002']")).sendKeys(TotalProtein);
		WebElement TxtBoxContent7 = driver.findElement(By.xpath(".//*[@id='1002']"));
		System.out.println(TxtBoxContent7.getAttribute("Name") + "Value is : " + TxtBoxContent7.getAttribute("value"));
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
		WebElement TxtBoxContent8 = driver.findElement(By.xpath(".//*[@id='1075']"));
		System.out.println(TxtBoxContent8.getAttribute("Name") + "Value is : " + TxtBoxContent8.getAttribute("value"));
		Thread.sleep(1000);
	}
	
	public void PREGNANCYDETAILS(String LastmenstrualDate,String EstimatedDateofDelivery,String Pregnancyhistory,String Sonographydetails,String Note) throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='2395']")).sendKeys(LastmenstrualDate);
		WebElement TxtBoxContent1 = driver.findElement(By.xpath(".//*[@id='2395']"));
		System.out.println(TxtBoxContent1.getAttribute("Name") + "Value is : " + TxtBoxContent1.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='3296']")).sendKeys(EstimatedDateofDelivery);
		WebElement TxtBoxContent2 = driver.findElement(By.xpath(".//*[@id='3296']"));
		System.out.println(TxtBoxContent2.getAttribute("Name") + "Value is : " + TxtBoxContent2.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='40']")).sendKeys(Pregnancyhistory);
		WebElement TxtBoxContent3 = driver.findElement(By.xpath(".//*[@id='40']"));
		System.out.println(TxtBoxContent3.getAttribute("Name") + "Value is : " + TxtBoxContent3.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='742']")).sendKeys(Sonographydetails);
		WebElement TxtBoxContent4 = driver.findElement(By.xpath(".//*[@id='742']"));
		System.out.println(TxtBoxContent4.getAttribute("Name") + "Value is : " + TxtBoxContent4.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
		WebElement TxtBoxContent5 = driver.findElement(By.xpath(".//*[@id='1075']"));
		System.out.println(TxtBoxContent5.getAttribute("Name") + "Value is : " + TxtBoxContent5.getAttribute("value"));
		Thread.sleep(1000);
	}
	
	public void THYROID(String FreeT3,String FreeT4,String TSH,String TotalT3,String TotalT4,String Note) throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='1365']")).sendKeys(FreeT3);
		WebElement TxtBoxContent1 = driver.findElement(By.xpath(".//*[@id='1365']"));
		System.out.println(TxtBoxContent1.getAttribute("Name") + "Value is : " + TxtBoxContent1.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1366']")).sendKeys(FreeT4);
		WebElement TxtBoxContent2 = driver.findElement(By.xpath(".//*[@id='1366']"));
		System.out.println(TxtBoxContent2.getAttribute("Name") + "Value is : " + TxtBoxContent2.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='508']")).sendKeys(TSH);
		WebElement TxtBoxContent3 = driver.findElement(By.xpath(".//*[@id='508']"));
		System.out.println(TxtBoxContent3.getAttribute("Name") + "Value is : " + TxtBoxContent3.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1008']")).sendKeys(TotalT3);
		WebElement TxtBoxContent4 = driver.findElement(By.xpath(".//*[@id='1008']"));
		System.out.println(TxtBoxContent4.getAttribute("Name") + "Value is : " + TxtBoxContent4.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1009']")).sendKeys(TotalT4);
		WebElement TxtBoxContent5 = driver.findElement(By.xpath(".//*[@id='1009']"));
		System.out.println(TxtBoxContent5.getAttribute("Name") + "Value is : " + TxtBoxContent5.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
		WebElement TxtBoxContent6 = driver.findElement(By.xpath(".//*[@id='1075']"));
		System.out.println(TxtBoxContent6.getAttribute("Name") + "Value is : " + TxtBoxContent6.getAttribute("value"));
		Thread.sleep(1000);
	}
		
	public void VITAMIN(String VitaminB12,String VitaminD3,String Note) throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='1020']")).sendKeys(VitaminB12);
		WebElement TxtBoxContent1 = driver.findElement(By.xpath(".//*[@id='1020']"));
		System.out.println(TxtBoxContent1.getAttribute("Name") + "Value is : " + TxtBoxContent1.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1415']")).sendKeys(VitaminD3);
		WebElement TxtBoxContent2 = driver.findElement(By.xpath(".//*[@id='1415']"));
		System.out.println(TxtBoxContent2.getAttribute("Name") + "Value is : " + TxtBoxContent2.getAttribute("value"));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
		WebElement TxtBoxContent3 = driver.findElement(By.xpath(".//*[@id='1075']"));
		System.out.println(TxtBoxContent3.getAttribute("Name") + "Value is : " + TxtBoxContent3.getAttribute("value"));
		Thread.sleep(1000);
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
