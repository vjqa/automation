package login;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import framework.BasetestScript;

public class charvalid extends BasetestScript{
			
	@Test(priority = 1)
	public void LoginwithMobile() throws IOException,InterruptedException
	{				
		Login("9016836027","123456");
		
		driver.get("https://www.hconnect.in/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtUserName']"));
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//input[@id='txtPassword']"));			
		
		//driver.findElement(By.xpath(".//input[@id='email']")).sendKeys("invalid.com");
		
		Actions build = new Actions(driver);
		build.moveToElement(driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")));
		
		driver.findElement(By.xpath(".//input[@id='imgBtnLogin']")).click();	
				
		/*File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copy(scrFile, new File("D:\\Vrajesh\\General\\workspace\\Hconnect_Login\\Screenshot"), true);
		System.out.println("Screenshot captured and save in directory");*/				 
							
		System.out.print("Successfully login with Mobile Number");				
	}
	
	public void Login(String user,String pass)
	{
		driver.findElement(By.id("txtUserName")).sendKeys(user);
		
		driver.findElement(By.id("txtPassword")).sendKeys(pass);;
		
		driver.findElement(By.id("imgBtnLogin")).click();
		
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
				
	}
}