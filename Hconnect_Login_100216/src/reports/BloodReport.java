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

public class BloodReport extends BasetestScript {
	List<String> inputList = new ArrayList<String>();
	List<String> viewList = new ArrayList<String>();

	private boolean acceptNextAlert = true;

	@Test(priority = 1)
	public void AddBloodReports() throws IOException, InterruptedException {
		try{
		utility.Login(utility.UID, utility.PWD, driver);
		System.out.println("Enter User Credential");

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		String parentHandle = driver.getWindowHandle(); // get the current
														// window handle
		driver.findElement(By.id("A1")).click(); // click some link that opens a
													// new window

		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle); // switch focus of WebDriver to
													// the next found window
													// handle (that's your newly
													// opened window)
		}

		// driver.get("https://www.hconnect.in:8091/Display/CreateTemplate?MHxJZA==&MjU4MnxISWQ=&");

		BLOOD("17", "20", "7000", "444", "635", "7844", "124", "retest");
		System.out.println("Input Blood sucess");

		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(
				"D:\\temp\\AddReports\\Add_Blood_Report.jpeg"), true);

		Actions Blood = new Actions(driver);
		Blood.moveToElement(driver.findElement(By
				.xpath(".//*[@id='btnSavePatient']")));

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		System.out.println("Click on SavePatient");

		String alertText = "";
		WebDriverWait wait = new WebDriverWait(driver, 5);
		// This will wait for a maximum of 5 seconds, everytime wait is used

		driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();// causes
																			// page
																			// to
																			// alert()
																			// something

		wait.until(ExpectedConditions.alertIsPresent());
		// Before you try to switch to the so given alert, he needs to be
		// present.

		Alert alert = driver.switchTo().alert();
		alertText = alert.getText();
		alert.accept();

		System.out.println("Blood : " + alertText);
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
				.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptrPatientdetailsDateWise']/table/tbody/tr[2]/td[5]")));

		Thread.sleep(1000);
		// driver.findElement(By.xpath(".//*[@id='lnkReport']")).click();
		driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_rptrPatientdetailsDateWise']/table/tbody/tr[2]/td[5]")).click();
		// driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_btnDownloadLink']")).click();
		System.out.println("Blood View report link found");

		
		viewList.clear();
		
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

	public void BLOOD(String Haemoglobin, String TotalRedbloodCells,
			String TotalWhitebloodCells, String PlateletCount,
			String ErythrocyteSedimentationRate, String CReactiveProtein,
			String INR, String Note) throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='304']")).sendKeys(Haemoglobin);
		// driver.findElement(By.xpath(".//*[@id='304']")).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='305']")).sendKeys(
				TotalRedbloodCells);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='306']")).sendKeys(
				TotalWhitebloodCells);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='322']")).sendKeys(PlateletCount);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='2418']")).sendKeys(
				ErythrocyteSedimentationRate);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='1108']")).sendKeys(
				CReactiveProtein);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='2498']")).sendKeys(INR);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys(Note);
		Thread.sleep(1000);
		// driver.findElement(By.xpath(".//*[@id='btnSavePatient']")).click();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// System.out.println(inputList.add(driver.findElement(By.xpath(".//*[@id='304']")).getText()));
		inputList.add(Haemoglobin);
		inputList.add(TotalRedbloodCells);
		inputList.add(TotalWhitebloodCells);
		inputList.add(PlateletCount);
		inputList.add(ErythrocyteSedimentationRate);
		inputList.add(CReactiveProtein);
		inputList.add(INR);
		inputList.add(Note);
		System.out.println(inputList.size() + "-->" + inputList);
	}
}