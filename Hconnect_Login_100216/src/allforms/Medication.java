/*package allforms;

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
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class Medication extends BasetestScript {
	List<String> inputList = new ArrayList<String>();
	List<String> viewList = new ArrayList<String>();

	private boolean acceptNextAlert = true;

	@Test(priority = 1)
	public void medication() throws IOException, InterruptedException {
		try{
		utility screen = new utility();
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

		Medication("Acid Indigestion and Upset Stomach", "11-Feb-2016", "12-Feb-2016", "Acute", "test");
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

		driver.findElement(By.xpath(".//*[@id='ctl00_btnDignosisSave']")).click();// causes
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
		//driver.get("https://www.hconnect.in/Dashboard/DashBoard_Individual");

		Thread.sleep(2000);
		WebElement element = driver.findElement(By
				.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0"));
		Actions actions = new Actions(driver);
		actions.moveToElement(element).click().perform();

		
		 * Actions action = new Actions(driver);
		 * action.moveToElement(driver.findElement
		 * (By.id("ctl00_ContentPlaceHolder1_rblDateTemplateOpt_0")));
		 
		
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
		screen.setCaptureScreenShot(driver);
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

	public void Medication(String Condition, String StartDate,String EndDate, String Type,String Comment) throws InterruptedException {
		driver.findElement(By.xpath(".//*[@id='ctl00_txtDignosis']")).sendKeys(Condition);
		// driver.findElement(By.xpath(".//*[@id='304']")).getText();
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ctl00_txtStartDate']")).sendKeys(StartDate);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ctl00_txtStopDate']")).sendKeys(EndDate);
		Thread.sleep(1000);
		new Select(driver.findElement(By.id(".//*[@id='ctl00_rdbAcute']"))).selectByVisibleText(Type);
		Thread.sleep(1000);
		driver.findElement(By.xpath(".//*[@id='ctl00_txtComment']")).sendKeys(Comment);
		
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		// System.out.println(inputList.add(driver.findElement(By.xpath(".//*[@id='304']")).getText()));
		inputList.add(Condition);
		inputList.add(StartDate);
		inputList.add(EndDate);
		inputList.add(Type);
		inputList.add(Comment);
		System.out.println(inputList.size() + "-->" + inputList);
	}
}*/

package allforms;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.*;

import static org.testng.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class Medication extends BasetestScript {
	
	private boolean acceptNextAlert = true;
	private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testUntitled() throws Exception {

	utility.Login(utility.UID, utility.PWD, driver); // Login
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	
	driver.findElement(By.cssSelector("i.diagnosis")).click();
    driver.findElement(By.id("ctl00_txtDignosis")).clear();
    driver.findElement(By.id("ctl00_txtDignosis")).sendKeys("Acid Indigestion and Upset Stomach");
    driver.findElement(By.id("ctl00_txtDignosis")).clear();
    driver.findElement(By.id("ctl00_txtDignosis")).sendKeys("Acid Indigestion and Upset Stomach");
    driver.findElement(By.id("ctl00_imgStartDate")).click();
    driver.findElement(By.id("ctl00_CalendarExtender2_day_1_3")).click();
    driver.findElement(By.id("ctl00_Image1")).click();
    driver.findElement(By.id("ctl00_CalendarExtender3_day_1_4")).click();
    driver.findElement(By.id("ctl00_txtStopDate")).clear();
    driver.findElement(By.id("ctl00_txtStopDate")).sendKeys("11-Feb-2016");
    new Select(driver.findElement(By.id("ctl00_rdbAcute"))).selectByVisibleText("Acute");
    driver.findElement(By.id("ctl00_txtComment")).clear();
    driver.findElement(By.id("ctl00_txtComment")).sendKeys("test");
    driver.findElement(By.id("ctl00_btnDignosisSave")).click();
    Thread.sleep(1000);
    //driver.findElement(By.xpath(".//*[@id='showbehavoiurAllergy_backgroundElement']"));
    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    assertEquals(closeAlertAndGetItsText(), "Diagnosis Information inserted successfully.");
    
    /*driver.findElement(By.id("ctl00_btnDignosisView")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnBack")).click();*/
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
