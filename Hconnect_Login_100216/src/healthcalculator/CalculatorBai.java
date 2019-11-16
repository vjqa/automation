package healthcalculator;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.kcs.utils.HealthCal;
import com.kcs.utils.utility;

import framework.BasetestScript;

public class CalculatorBai extends BasetestScript {
	List<HealthCal> inputList = new ArrayList<HealthCal>();
	List<HealthCal> viewList = new ArrayList<HealthCal>();

	@Test(priority = 1)
	public void CalculatorBMI() throws IOException, InterruptedException {
		utility.Login(utility.UID, utility.PWD, driver); // Login
		System.out.println("Enter User Credential");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath(".//*[@id='Main']/div/div[2]/div[2]/div[4]/div[1]/span/a[2]"))
				.click(); // Click to Calculator

		CalculationInput("14-Feb-2016", "96", "40", "170", "70", "Sedentary");
		// System.out.println("Health Calculator input data Inserted Successfully");

		driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave")).click();

		/*
		 * String alertText = ""; Alert alert = driver.switchTo().alert();
		 * alertText = alert.getText(); alert.accept();
		 * 
		 * System.out.println("Calculator : " + alertText);
		 */
		Thread.sleep(2000);

		HealthCal mCalc = new HealthCal();
		mCalc.setHeight(driver
				.findElement(
						By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[3]"))
				.getText());
		mCalc.setWeight(driver
				.findElement(
						By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[4]"))
				.getText());
		mCalc.setBmi(driver
				.findElement(
						By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[5]"))
				.getText());
		viewList.add(mCalc);

		for (int i = 0; i < inputList.size(); i++) {
			if (inputList.get(i).getWeight()
					.equals(viewList.get(i).getWeight())
					&& inputList.get(i).getHeight()
							.equals(viewList.get(i).getHeight())
					&& inputList.get(i).getBmi()
							.equals(viewList.get(i).getBmi())) {
				System.out.println("true : " + " inputWeight " + " --> " 
						+ inputList.get(i).getWeight() + " inputHeight :" + " --> "
						+ inputList.get(i).getHeight() + " calculateBmi " + " --> "
						+ inputList.get(i).getBmi() + " \t \n resultWeight " + " --> "
						+ viewList.get(i).getWeight() + " resultHeight :" + " --> "
						+ viewList.get(i).getHeight() + " resultBmi :" + " --> "
						+ viewList.get(i).getBmi());
			} else {
				System.out.println("false : " + " inputWeight " + " --> "
						+ inputList.get(i).getWeight() + " inputHeight " + " --> "
						+ inputList.get(i).getHeight() + " calculateBmi " + " --> "
						+ inputList.get(i).getBmi() + "\t \n  resultWeight " + " --> "
						+ viewList.get(i).getWeight() + " resultHeight : " + " --> "
						+ viewList.get(i).getHeight() + " resultBmi : " + " --> "
						+ viewList.get(i).getBmi());
			}

		}
		System.out
				.println("Success "
						+ driver.findElement(
								By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[2]"))
								.getText());
	}

	public void CalculationInput(String date, String Waist, String Hips,
			String Height, String Weight, String activity)
			throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(
				By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtDate']"))
				.clear();
		driver.findElement(
				By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtDate']"))
				.sendKeys(date);
		// driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgToDate")).click();
		// driver.findElement(By.id("ctl00_ContentPlaceHolder1_calBdayExtender_day_1_2")).click();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWaist")).clear();
		
		WebElement waist = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWaist"));
		waist.sendKeys(Waist);
		
		Thread.sleep(1000);
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHips")).clear();
		driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHips"))
				.sendKeys(Hips);
		Thread.sleep(1000);
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
		mCalc.setWeight(Waist);
		mCalc.setHeight(Height);
		double wmeters = Double.parseDouble(Waist) / 100;
		double hmeters = Double.parseDouble(Height) / 100;
		double sqrtmeter = Double.parseDouble(Height);
		double sqrt = Math.sqrt(sqrtmeter);
		double totalBai = (100 * wmeters) / (hmeters * sqrt) - 18;
		DecimalFormat f = new DecimalFormat("##.00");
		mCalc.setBmi("" + f.format(totalBai));
		System.out.println("" + totalBai);

	}
}
