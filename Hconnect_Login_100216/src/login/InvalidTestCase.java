package login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import framework.BasetestScript;

public class InvalidTestCase extends BasetestScript{
		
	@Test(priority = 1)
	public void BlankUsername() throws IOException
	{
		try{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Login(" "," ");
		
		driver.get("http://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();
		
		System.out.println("leave Blank Username");
		}
		catch (org.openqa.selenium.UnhandledAlertException e) 
		{                
	         Alert alert = driver.switchTo().alert(); 
	         String alertText = alert.getText().trim();
	         System.out.println("Alert data: "+ alertText);
	         alert.dismiss();
	    }
	}
	
	@Test(priority = 2)
	public void BlankPassword() throws IOException
	{
		try{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Login("9016836027","");
		
		driver.get("http://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();
		
		System.out.println("Leave Blank Password");
		}
		catch (org.openqa.selenium.UnhandledAlertException e) 
		{                
	         Alert alert = driver.switchTo().alert(); 
	         String alertText = alert.getText().trim();
	         System.out.println("Alert data: "+ alertText);
	         alert.dismiss();
		}		
	}
	
	@Test(priority = 3)
	public void InvalidMobileNumber() throws IOException
	{
		try{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Login("123456789","123456");
		
		driver.get("http://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();
		
		System.out.println("Invalid Mobile Number");
		}
		catch (org.openqa.selenium.UnhandledAlertException e) 
		{                
	         Alert alert = driver.switchTo().alert(); 
	         String alertText = alert.getText().trim();
	         System.out.println("Alert data: "+ alertText);
	         alert.dismiss();
		}		
	}
	
	@Test(priority = 4)
	public void InvalidPwdwithMobile() throws IOException
	{
		try{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Login("9016836027","1234567");
		
		driver.get("http://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();
		
		System.out.println("Invalid Password login with Mobile");
		}
		catch (org.openqa.selenium.UnhandledAlertException e) 
		{                
	         Alert alert = driver.switchTo().alert(); 
	         String alertText = alert.getText().trim();
	         System.out.println("Alert data: "+ alertText);
	         alert.dismiss();
		}		
	}
	
	@Test(priority = 5)
	public void InvalidHconnectID() throws IOException
	{
		try{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Login("123456789@hconnect.in","123456");
		
		driver.get("http://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();
		
		System.out.println("Invalid Hconnect ID");
		}
		catch (org.openqa.selenium.UnhandledAlertException e) 
		{                
	         Alert alert = driver.switchTo().alert(); 
	         String alertText = alert.getText().trim();
	         System.out.println("Alert data: "+ alertText);
	         alert.dismiss();
		}		
	}
	
	@Test(priority = 6)
	public void InvalidPwdwithHconnectID() throws IOException
	{
		try{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Login("1276454473@hconnect.in","1234567");
		
		driver.get("http://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();
		
		System.out.println("Invalid Password login with HconnectID");
		}
		catch (org.openqa.selenium.UnhandledAlertException e) 
		{                
	         Alert alert = driver.switchTo().alert(); 
	         String alertText = alert.getText().trim();
	         System.out.println("Alert data: "+ alertText);
	         alert.dismiss();
		}		
	}
	
	@Test(priority = 7)
	public void InvalidEmailID() throws IOException
	{
		try{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Login("vrajeshh@kcspl.co.in","123456");
		
		driver.get("http://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();
		
		System.out.println("Invalid Email ID");
		}
		catch (org.openqa.selenium.UnhandledAlertException e) 
		{                
	         Alert alert = driver.switchTo().alert(); 
	         String alertText = alert.getText().trim();
	         System.out.println("Alert data: "+ alertText);
	         alert.dismiss();
		}		
	}
	
	@Test(priority = 8)
	public void InvalidPwdwithEmailID() throws IOException
	{
		try{
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		Login("vrajesh@kcspl.co.in","1234567");
		
		driver.get("http://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();
		
		System.out.println("Invalid Password login with HconnectID");
		}
		catch (org.openqa.selenium.UnhandledAlertException e) 
		{                
	         Alert alert = driver.switchTo().alert(); 
	         String alertText = alert.getText().trim();
	         System.out.println("Alert data: "+ alertText);
	         alert.dismiss();
		}		
	}
	
	public void Login(String user,String pass)
	{

		driver.findElement(By.id("txtUserName")).sendKeys(user);
		
		driver.findElement(By.id("txtPassword")).sendKeys(pass);;
		

		//driver.findElement(By.id("imgBtnLogin")).click();
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				
	}
}
