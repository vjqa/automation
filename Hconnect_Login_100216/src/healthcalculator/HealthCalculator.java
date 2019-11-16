package healthcalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class HealthCalculator extends BasetestScript 
{
	List<String> inputList = new ArrayList<String>();
	List<String> viewList = new ArrayList<String>();

	@Test(priority = 1)
	public void AddCalculator() throws IOException, InterruptedException 
	{
		utility.Login(utility.UID, utility.PWD, driver); // Login
		System.out.println("Enter User Credential");
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='Main']/div/div[2]/div[2]/div[4]/div[1]/span/a[2]")).click(); // Click to Calculator
		
		CalculationInput("13-Feb-2016","32", "40", "160", "60", "Sedentary");
		//System.out.println("Health Calculator input data Inserted Successfully");
		
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave")).click();
		
		/*String alertText = "";
		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();

		System.out.println("Calculator : " + alertText);*/
		Thread.sleep(2000);
		
		viewList.clear();
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[2]"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[3]"))
				.getText());
		viewList.add(driver
				.findElement(
						By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[4]"))
				.getText());
		
		
		for (int i = 0; i < inputList.size(); i++) {
			if (inputList.get(i).equals(viewList.get(i))) {
				System.out.println("true : " + " inputValue " + " --> "
						+ inputList.get(i) + " viewList " + " --> "
						+ viewList.get(i));
			} else {
				System.out.println("false : " + " inputValue " + " --> "
						+ inputList.get(i) + " viewList " + " --> "
						+ viewList.get(i));
			}

		}
		System.out
				.println("Success "
						+ driver.findElement(
								By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[2]"))
								.getText());
	}

	public void CalculationInput(String date, String Waist, String Hips, String Height, String Weight,String activity) throws InterruptedException 
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtDate']")).clear();
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtDate']")).sendKeys(date);
	    //driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgToDate")).click();
	    //driver.findElement(By.id("ctl00_ContentPlaceHolder1_calBdayExtender_day_1_2")).click();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWaist")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWaist")).sendKeys(Waist);
	    Thread.sleep(1000);
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHips")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHips")).sendKeys(Hips);
	    Thread.sleep(1000);
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHeight")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHeight")).sendKeys(Height);
	    Thread.sleep(1000);
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWeight")).clear();
	    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWeight")).sendKeys(Weight);
	    Thread.sleep(1000);
	    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpActivelystatus"))).selectByVisibleText(activity);
	    
	    inputList.add(date);
		//inputList.add(Waist);
		//inputList.add(Hips);
		inputList.add(Height);
		inputList.add(Weight);
		//inputList.add(activity);
		System.out.println(inputList.size() + "-->" + inputList);
	}
}
