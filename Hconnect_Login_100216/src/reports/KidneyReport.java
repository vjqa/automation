package reports;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class KidneyReport extends BasetestScript {
	List<String> inputList = new ArrayList<String>();
	List<String> viewList = new ArrayList<String>();

	private boolean acceptNextAlert = true;

	@Test(priority = 4)
	public void AddKidneyReports() throws IOException,InterruptedException
	{				
		try{
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
		
		// redirect to reports
		driver.get("https://www.hconnect.in/Dashboard/DashBoard_Individual");

		Thread.sleep(2000);
		WebElement element = driver.findElement(By
				.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

		/*
		 * Actions action = new Actions(driver);
		 * action.moveToElement(driver.findElement
		 * (By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0")));
		 */

		driver.findElement(
				By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0"))
				.click();
		System.out.println("Date element Find");
		Thread.sleep(1000);

		Actions action1 = new Actions(driver);
		action1.moveToElement(driver.findElement(By
				.xpath(".//*[@id='lnkReport']")));

		Thread.sleep(1000);
		// driver.findElement(By.xpath(".//*[@id='lnkReport']")).click();
		driver.findElement(By.linkText("View Report")).click();
		// driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnDownloadLink']")).click();
		System.out.println("Bone View report link found");

		//viewList.clear();
		
//		viewList.add("22");
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[4]/td[2]/label"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[5]/td[2]/label"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[6]/td[2]/label"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[7]/td[2]/label"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[8]/td[2]/label"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[9]/td[2]/label"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[10]/td[2]/label"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[11]/td[2]/label"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[12]/td[2]/label"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[13]/td[2]/label"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='PrintData']/table/tbody/tr[14]/td[2]/label"))
				.getText());
		
		for (int i = 0; i < inputList.size(); i++) {
			if (inputList.get(i).equals(viewList.get(i))) {
				System.out.println("true : " + "inputValue" + "-->"
						+ inputList.get(i) + "viewList" + "-->"
						+ viewList.get(i));
			} else {
				System.out.println("false : " + "inputValue" + "-->"
						+ inputList.get(i) + "viewList" + "-->"
						+ viewList.get(i));
			}

		}
		System.out
				.println("Success "
						+ driver.findElement(
								By.xpath(".//*[@id='PrintData']/table/tbody/tr[4]/td[2]/label"))
								.getText());
		
		}catch(WebDriverException e)
		{
			System.out.println(e);
		}

	}

	public void KIDNEY(String hoursUrineProtein,String Creatinine,String Urea,String UPCratio,String BloodUreaNitrogen,String UricAcidinBlood,String Sodium,String Potassium,String Chloride,String Bicarbonate,String Note) throws InterruptedException
	{
		driver.findElement(By.xpath(".//*[@id='1348']")).sendKeys(hoursUrineProtein);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='517']")).sendKeys(Creatinine);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1022']")).sendKeys(Urea);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='1935']")).sendKeys(UPCratio);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath(".//*[@id='501']")).sendKeys(BloodUreaNitrogen);
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1021']")).sendKeys(UricAcidinBlood);
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1010']")).sendKeys(Sodium);
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1011']")).sendKeys(Potassium);
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1012']")).sendKeys(Chloride);
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1757']")).sendKeys(Bicarbonate);
		Thread.sleep(1000);
	    
		driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
		Thread.sleep(1000);
	
		driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		
		inputList.add(hoursUrineProtein);
		inputList.add(Creatinine);
		inputList.add(Urea);
		inputList.add(UPCratio);
		inputList.add(BloodUreaNitrogen);
		inputList.add(UricAcidinBlood);
		inputList.add(Sodium);
		inputList.add(Potassium);
		inputList.add(Chloride);
		inputList.add(Bicarbonate);
		inputList.add(Note);
		System.out.println(inputList.size() + "-->" + inputList);
	}
}