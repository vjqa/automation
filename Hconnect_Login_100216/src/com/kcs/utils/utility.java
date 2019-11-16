package com.kcs.utils;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class utility 
{
	
	//Hconnect web application
	public static final String BASEURL = "https://www.hconnect.in/";
	public static final String UID = "9016836027";
	public static final String PWD = "123456";
	
	// Capturing Date Time wise screenshot
	public void setCaptureScreenShot(WebDriver driver) throws IOException {
		  
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         //The below method will save the screen shot in d drive with name "screenshot.png"
			String strFileName="screenshot"+getCurrentDateTime()+".png";
            FileUtils.copyFile(scrFile, new File(".\\screenshot\\" + strFileName));
	}

	public String getCurrentDateTime() {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH_mm_ss");
		Date date = new Date();
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.add(Calendar.DAY_OF_YEAR, 0);
	return dateFormat.format(cal.getTime()).toString();
	}    
	
	public static void Login(String user,String pass,WebDriver driver)
	{
		driver.findElement(By.id("txtUserName")).sendKeys(user);
		
		driver.findElement(By.id("txtPassword")).sendKeys(pass);
		
		driver.findElement(By.id("imgBtnLogin")).click();
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				
	}
}