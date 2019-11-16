package login;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.interactions.Actions;
import org.testng.TestListenerAdapter;
import org.testng.annotations.Test;

import com.kcs.utils.TestListener;
import com.kcs.utils.utility;

import framework.BasetestScript;

public class FunctionalTestCase extends BasetestScript{
	
		
	@Test(priority = 1)
	public void LoginwithMobile() throws IOException,InterruptedException
	{				
		Login("9016836027","123456");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Login\\LoginwithMobile.jpeg"),true);
		
		driver.get("https://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));			
		
		//driver.findElement(By.xpath(".//input[@id='email']")).sendKeys("invalid.com");
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();	
												
		System.out.print("Successfully login with Mobile Number");	
				 
	}
	
	@Test(priority = 2)
	public void LoginwithHconnectID() throws IOException
	{
		Login("1276454473@hconnect.in","123456");
				
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Login\\LoginwithHconnectID.jpeg"),true);
		 
		driver.get("https://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));
		
		//driver.findElement(By.id("logo")).sendKeys(logoFile);
		
		//driver.findElement(By.xpath(".//input[@id='email']")).sendKeys("invalid.com");
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();
		
		System.out.print("Successfully login with HconnectID");
						
	}
	
	@Test(priority = 3)
	public void LoginwithEmail() throws IOException
	{
		Login("vrajesh@kcspl.co.in","123456");
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		 FileUtils.copyFile(scrFile,new File("D:\\temp\\Login\\LoginwithEmail.jpeg"),true);
		
		driver.get("https://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));
		
		//driver.findElement(By.id("logo")).sendKeys(logoFile);
		
		//driver.findElement(By.xpath(".//input[@id='email']")).sendKeys("invalid.com");
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();
		
		System.out.println("Successfully login with Email");	
	
	}	
	
	public void Login(String user,String pass)
	{
		driver.findElement(By.id("txtUserName")).sendKeys(user);
		
		driver.findElement(By.id("txtPassword")).sendKeys(pass);;
		
		//driver.findElement(By.id("imgBtnLogin")).click();
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				
	}
}
