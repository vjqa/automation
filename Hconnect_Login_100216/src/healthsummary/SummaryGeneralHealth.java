package healthsummary;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class SummaryGeneralHealth extends BasetestScript {

	public SummaryGeneralHealth() throws IOException, InterruptedException {

		utility.Login(utility.UID, utility.PWD, driver); // Login
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("Enter User Credential");
		
		driver.findElement(By.xpath(".//*[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[3]/span/samp/span")).click();
		  //driver.get("https://www.hconnect.in/Report/PatientReportSummary");
		  //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		  
		  driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[1]")).getText();
		  System.out.println("print get text");
		  driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[2]"));
		  driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[4]"));
	}

}
