package healthsummary;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.kcs.utils.HealthCal;
import com.kcs.utils.utility;

import framework.BasetestScript;

public class Summary extends BasetestScript {

	@Test(priority = 1)
	public void Logic() throws IOException, InterruptedException {

		utility.Login(utility.UID, utility.PWD, driver); // Login
		driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
		System.out.println("Enter User Credential");

		driver.findElement(
				By.xpath(".//*[@id='aspnetForm']/div[7]/div/div/div[2]/div[4]/a[3]/span/samp/span"))
				.click();
		// driver.get("https://www.hconnect.in/Report/PatientReportSummary");
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		driver.findElement(
				By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[1]"))
				.getText();
		System.out.println("print get text");
		driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[2]"));
		driver.findElement(By
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[4]"));
		// weight/(height*height)*100
	}

	public void logic(String Weight, String Height,String activity) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHeight"))
				.clear();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHeight"))
				.sendKeys(Height);
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWeight"))
				.clear();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWeight"))
				.sendKeys(Weight);
		Thread.sleep(1000);
		new Select(driver.findElement(By
				.id("ctl00_ContentPlaceHolder1_drpActivelystatus")))
				.selectByVisibleText(activity);

		HealthCal mCalc = new HealthCal();
		mCalc.setWeight(Weight);
		mCalc.setHeight(Height);
		double totalBmi = 100 * (Double.parseDouble(Weight)
				/ (Double.parseDouble(Height) * (Double.parseDouble(Height))) * 100);
		DecimalFormat f = new DecimalFormat("##.00");
		mCalc.setBmi("" + f.format(totalBmi));
		System.out.println("" + totalBmi);

		/*
		 * //general health .//*[@id=
		 * 'ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[1]
		 * //height .//*[@id=
		 * 'ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[2]
		 * //Weight
		 * 
		 * .//*[@id=
		 * 'ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[4]
		 * //BMI
		 */}
}
