package allforms;

import java.io.IOException;

import javax.swing.text.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class MedicationVerify extends BasetestScript{

	public MedicationVerify() throws IOException, InterruptedException {
		
		utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Login Sucess");
		
		driver.findElement(By.id("ctl00_lnkDig")).click();
	    driver.findElement(By.id("ctl00_txtDignosis")).clear();
	    driver.findElement(By.id("ctl00_txtDignosis")).sendKeys("Acne");
	    driver.findElement(By.id("ctl00_txtDignosis")).clear();
	    driver.findElement(By.id("ctl00_txtDignosis")).sendKeys("Acne");
	    driver.findElement(By.id("ctl00_imgStartDate")).click();
	    driver.findElement(By.id("ctl00_txtStartDate")).clear();
	    driver.findElement(By.id("ctl00_txtStartDate")).sendKeys("07-Feb-2016");
	    driver.findElement(By.id("ctl00_Image1")).click();
	    driver.findElement(By.id("ctl00_txtStopDate")).clear();
	    driver.findElement(By.id("ctl00_txtStopDate")).sendKeys("07-Feb-2016");
	    new Select(driver.findElement(By.id("ctl00_rdbAcute"))).selectByVisibleText("Acute");
	    driver.findElement(By.id("ctl00_txtComment")).clear();
	    driver.findElement(By.id("ctl00_txtComment")).sendKeys("test");
		
		
	}

}

