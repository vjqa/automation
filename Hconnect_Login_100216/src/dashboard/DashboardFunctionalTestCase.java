package dashboard;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class DashboardFunctionalTestCase extends BasetestScript{
			
	@Test(priority = 1)
	public void VerifyDashboard() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Enter User Credential");	
		
		driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		System.out.println("Open User Dashboard");	
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		System.out.println("wait");
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lbHconnectHome']/div/span[1]"));
		System.out.println("finding Home xpath");
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		System.out.println("wait");
		
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblUsername']"));
		System.out.println("Username verify");
		
		if(driver.getTitle().contains("MyDashboard"))
			System.out.println("Page Title contains is: " + driver.getTitle());
		else
			System.out.println("Page Title doesn't contains is: " + driver.getTitle());
			
		System.out.println("Verify Title");			
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Dashboard\\Dashboard.jpeg"),true);
	}
	
	@Test(priority = 2)
	public void VerifyHome() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		
		driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_iPatientDashboard']/span"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_iPatientDashboard']/span")).click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Dashboard\\Home.jpeg"),true);
							
	}
	
	@Test(priority = 3)
	public void VerifyProfile() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		
		driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkHealthSummary']/span"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkHealthSummary']/span")).click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Dashboard\\MyProfile.jpeg"),true);
					
	}
	
	@Test(priority = 4)
	public void VerifyMedicalCondition() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		
		driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkDig']/span"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkDig']/span")).click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
			
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Dashboard\\MedicalCondition.jpeg"),true);
		 
		/*if(driver.getWindowHandle().compareTo(Medical Condition)
			System.out.println("Page Title contains is: " + driver.());
		else
			System.out.println("Page Title doesn't contains is: " + driver.getTitle());
			
		System.out.print("Verify Title");*/				
	}
	
	@Test(priority = 5)
	public void VerifyAllergy() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		
		driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkAllergy']/span"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkAllergy']/span")).click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Dashboard\\Allergy.jpeg"),true);
			
		/*if(driver.getWindowHandle().compareTo(Medical Condition)
			System.out.println("Page Title contains is: " + driver.());
		else
			System.out.println("Page Title doesn't contains is: " + driver.getTitle());
			
		System.out.print("Verify Title");*/								
	}
	
	@Test(priority = 6)
	public void VerifyMyDiet() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		
		driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkDiet']/span"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkDiet']/span")).click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Dashboard\\MyDiet.jpeg"),true);
			
		/*if(driver.getWindowHandle().compareTo(Medical Condition)
			System.out.println("Page Title contains is: " + driver.());
		else
			System.out.println("Page Title doesn't contains is: " + driver.getTitle());
			
		System.out.print("Verify Title");*/								
	}
	
	@Test(priority = 7)
	public void VerifyExercise() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		
		driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkExercise']/span"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkExercise']/span")).click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Dashboard\\Exercise.jpeg"),true);
			
		/*if(driver.getWindowHandle().compareTo(Medical Condition)
			System.out.println("Page Title contains is: " + driver.());
		else
			System.out.println("Page Title doesn't contains is: " + driver.getTitle());
			
		System.out.print("Verify Title");*/								
	}
	
	@Test(priority = 8)
	public void VerifyMedication() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		
		driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkMedication']/span"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkMedication']/span")).click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Dashboard\\Medication.jpeg"),true);
			
		/*if(driver.getWindowHandle().compareTo(Medical Condition)
			System.out.println("Page Title contains is: " + driver.());
		else
			System.out.println("Page Title doesn't contains is: " + driver.getTitle());
			
		System.out.print("Verify Title");*/								
	}
	
	@Test(priority = 9)
	public void VerifyMyReports() throws IOException,InterruptedException
	{			
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		
		driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkProblemList']/span"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_lnkProblemList']/span")).click();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);		
		
		Thread.sleep(5000);
		
		Alert alert = driver.switchTo().alert(); 
	    String alertText = alert.getText().trim();
	    System.out.println("Alert data: "+ alertText);
	    //alert.accept();
	     
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Dashboard\\MyReports.jpeg"),true);	
        
        //Reports .//*[@id='ctl00_LinkButton1']
		//Helath Calculator .//*[@id='ctl00_lnkBodyDimension']									
	}
			
	@Test(priority = 10)
	public void VerifyHealthEducation() throws IOException,InterruptedException
	{				
		Actions action = new Actions(driver);
		  utility screenshot = new utility();
		  utility.Login(utility.UID, utility.PWD, driver);
		
		driver.get("https://www.hconnect.in/Dashboard/MyDashBoard?PatientId=MTI3NjQ1NDQ3Mw==");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_iContent']/span"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//*[@id='ctl00_iContent']/span")).click();
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		//About basic body profile .//*[@id='ctl00_lnkDiagnosisContent']/li[1]/a
		//Alzheimer Disease .//*[@id='ctl00_lnkDiagnosisContent']/li[2]/a
		//Anemia Profile .//*[@id='ctl00_lnkDiagnosisContent']/li[3]/a
		//Arthritis .//*[@id='ctl00_lnkDiagnosisContent']/li[4]/a
		//Asthma .//*[@id='ctl00_lnkDiagnosisContent']/li[5]/a
		// and all disease
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Dashboard\\HealthEducation.jpeg"),true);									
	}
	
}
