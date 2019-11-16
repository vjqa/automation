package allforms;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class AllForms extends BasetestScript {
	
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test(priority = 1)
  public void testMedicalcondition() throws Exception,UnhandledAlertException {
    try
    {
      Actions action = new Actions(driver);
	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver);
		 
	  String parentHandle = driver.getWindowHandle(); // get the current window handle
	 		
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
    
    
    String alertText = "";
	WebDriverWait wait = new WebDriverWait(driver, 5);
	// This will wait for a maximum of 5 seconds, everytime wait is used

	driver.findElement(By.id("ctl00_btnDignosisSave")).click();//causes page to alert() something

	screenshot.setCaptureScreenShot(driver);
	wait.until(ExpectedConditions.alertIsPresent());
	// Before you try to switch to the so given alert, he needs to be present.

	screenshot.setCaptureScreenShot(driver);
	
	Alert alert = driver.switchTo().alert();
	alertText = alert.getText();
	Thread.sleep(2000);
	alert.accept();
	
	System.out.println("Diet : " + alertText);
	
    }catch(Exception e)
    {
    	System.out.println(e.toString());
		//driver.switchTo().window(parentHandle);
    }
			
  }
  
  @Test(priority = 2)
  public void testAllergy() throws Exception {
    try
    {
      Actions action = new Actions(driver);
	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver);
		
	  driver.findElement(By.id("ctl00_lnkAllergy")).click();
	  	new Select(driver.findElement(By.id("ctl00_drpAllergyType"))).selectByVisibleText("Food Allergy");
	    new Select(driver.findElement(By.id("ctl00_drpAllergyType"))).selectByVisibleText("bananas");
	    driver.findElement(By.cssSelector("option[value=\"32\"]")).click();
	    new Select(driver.findElement(By.id("ctl00_drpSkin"))).selectByVisibleText("Itchiness");
	    new Select(driver.findElement(By.id("ctl00_drpLocal"))).selectByVisibleText("Runny Nose");
	    new Select(driver.findElement(By.id("ctl00_drpAbdominal"))).selectByVisibleText("Diarrhea");
	    new Select(driver.findElement(By.id("ctl00_drpSystemic"))).selectByVisibleText("Difficulty speaking or swallowing");
	    new Select(driver.findElement(By.id("ctl00_drpSeverity"))).selectByVisibleText("Severe");
	    driver.findElement(By.id("ctl00_Image2")).click();
	    driver.findElement(By.id("ctl00_CalendarExtender4_day_1_0")).click();
	    driver.findElement(By.id("ctl00_txtStartDateAllergy")).clear();
	    driver.findElement(By.id("ctl00_txtStartDateAllergy")).sendKeys("07-Feb-2016");
	    driver.findElement(By.id("ctl00_Image3")).click();
	    driver.findElement(By.id("ctl00_CalendarExtender5_day_1_0")).click();
	    driver.findElement(By.id("ctl00_txtStopDateAllergy")).clear();
	    driver.findElement(By.id("ctl00_txtStopDateAllergy")).sendKeys("07-Feb-2016");
	    driver.findElement(By.id("ctl00_txtAllergyCmt")).clear();
	    driver.findElement(By.id("ctl00_txtAllergyCmt")).sendKeys("test");
	   
	    
	     String alertText = "";
	WebDriverWait wait = new WebDriverWait(driver, 5);
	// This will wait for a maximum of 5 seconds, everytime wait is used

	 driver.findElement(By.id("ctl00_btnAllergySave")).click();//causes page to alert() something

	screenshot.setCaptureScreenShot(driver);
	wait.until(ExpectedConditions.alertIsPresent());
	// Before you try to switch to the so given alert, he needs to be present.

	Alert alert = driver.switchTo().alert();
	alertText = alert.getText();
	alert.accept();
		
	System.out.println("Allergy : " + alertText);
	
  }catch(Exception e){
  		
	  System.out.println(e.toString());
		//driver.switchTo().window(parentHandle);
	
  }
  }
  
  @Test(priority = 3)
  public void testMydiet() throws Exception {
    try{    	
	  Actions action = new Actions(driver);
	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver);
		
	  driver.findElement(By.id("ctl00_lnkDiet")).click();
	  driver.findElement(By.id("ctl00_imgDietDate")).click();
	  driver.findElement(By.id("ctl00_CalendarExtender1_day_1_0")).click();
	  driver.findElement(By.id("ctl00_txtDietDate")).clear();
	  driver.findElement(By.id("ctl00_txtDietDate")).sendKeys("07-Feb-2016");
	  driver.findElement(By.id("ctl00_txtDietName")).clear();
	  driver.findElement(By.id("ctl00_txtDietName")).sendKeys("Food");
	  driver.findElement(By.id("ctl00_txtServingSize")).clear();
	  driver.findElement(By.id("ctl00_txtServingSize")).sendKeys("5");
	  driver.findElement(By.id("ctl00_txtDietServing")).clear();
	  driver.findElement(By.id("ctl00_txtDietServing")).sendKeys("5");
	  driver.findElement(By.id("ctl00_txtDietMeal")).clear();
	  driver.findElement(By.id("ctl00_txtDietMeal")).sendKeys("Dinner");
	  driver.findElement(By.id("ctl00_txtDietCalories")).clear();
	  driver.findElement(By.id("ctl00_txtDietCalories")).sendKeys("2000");
	  driver.findElement(By.id("ctl00_txtDietNote")).clear();
	  driver.findElement(By.id("ctl00_txtDietNote")).sendKeys("test");
	 
	    
	     String alertText = "";
	WebDriverWait wait = new WebDriverWait(driver, 5);
	// This will wait for a maximum of 5 seconds, everytime wait is used

	 driver.findElement(By.id("ctl00_btnDietInsert")).click();//causes page to alert() something

	screenshot.setCaptureScreenShot(driver);
	wait.until(ExpectedConditions.alertIsPresent());
	// Before you try to switch to the so given alert, he needs to be present.

	Alert alert = driver.switchTo().alert();
	alertText = alert.getText();
	alert.accept();
	
	System.out.println("Diet : " + alertText);
	//driver.switchTo().window(parentHandle);
	
  }catch(Exception e){
		
	  System.out.println(e.toString());
		//driver.switchTo().window(parentHandle);
	
  }
  }
  
  @Test(priority = 4)
  public void testExercise() throws Exception {
    try{
	  Actions action = new Actions(driver);
	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver);
		
	  driver.findElement(By.cssSelector("#ctl00_lnkExercise > span")).click();
	  driver.findElement(By.id("ctl00_txtExcriseActivity")).clear();
	  driver.findElement(By.id("ctl00_txtExcriseActivity")).sendKeys("Running");
	  driver.findElement(By.id("ctl00_imgToDate")).click();
	  driver.findElement(By.id("ctl00_txtExDate")).clear();
	  driver.findElement(By.id("ctl00_txtExDate")).sendKeys("07-Feb-2016");
	  driver.findElement(By.id("ctl00_txtExeTime")).clear();
	  driver.findElement(By.id("ctl00_txtExeTime")).sendKeys("8");
	  driver.findElement(By.id("ctl00_txtExciseDescription")).clear();
	  driver.findElement(By.id("ctl00_txtExciseDescription")).sendKeys("Running activity");
	  driver.findElement(By.id("ctl00_txtExDuration")).clear();
	  driver.findElement(By.id("ctl00_txtExDuration")).sendKeys("1");
	  driver.findElement(By.id("ctl00_txtExdis")).clear();
	  driver.findElement(By.id("ctl00_txtExdis")).sendKeys("2");
	  driver.findElement(By.id("ctl00_txtExNo")).clear();
	  driver.findElement(By.id("ctl00_txtExNo")).sendKeys("3");
	  driver.findElement(By.id("ctl00_txtExNote")).clear();
	  driver.findElement(By.id("ctl00_txtExNote")).sendKeys("Exercise");
	  
	 
	    
	     String alertText = "";
	WebDriverWait wait = new WebDriverWait(driver, 5);
	// This will wait for a maximum of 5 seconds, everytime wait is used

	driver.findElement(By.id("ctl00_btnExSave")).click();//causes page to alert() something

	screenshot.setCaptureScreenShot(driver);
	wait.until(ExpectedConditions.alertIsPresent());
	// Before you try to switch to the so given alert, he needs to be present.

	Alert alert = driver.switchTo().alert();
	alertText = alert.getText();
	alert.accept();
	
	System.out.println("Exercise : " + alertText);
	//driver.switchTo().window(parentHandle);
	
    }catch(Exception e){
		
	  System.out.println(e.toString());
		//driver.switchTo().window(parentHandle);
	  }
  }
  
  @Test(priority = 5)
  public void testMedication() throws Exception {
    try{
	  Actions action = new Actions(driver);
	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver);
		
	  driver.findElement(By.cssSelector("i.medication")).click();
	  new Select(driver.findElement(By.id("ctl00_txtMeName"))).selectByVisibleText("Abacavir");
	  driver.findElement(By.id("ctl00_txtBrandName")).clear();
	  driver.findElement(By.id("ctl00_txtBrandName")).sendKeys("abc");
	  driver.findElement(By.id("ctl00_txMetStrength")).click();
	  driver.findElement(By.id("ctl00_txMetStrength")).clear();
	  driver.findElement(By.id("ctl00_txMetStrength")).sendKeys("aaa");
	  driver.findElement(By.id("ctl00_txtMeStrengthUnit")).clear();
	  driver.findElement(By.id("ctl00_txtMeStrengthUnit")).sendKeys("23");
	  driver.findElement(By.id("ctl00_txtMeDose")).clear();
	  driver.findElement(By.id("ctl00_txtMeDose")).sendKeys("2");
	  new Select(driver.findElement(By.id("ctl00_txtMeDoseUnit"))).selectByVisibleText("Eye drop");
	  new Select(driver.findElement(By.id("ctl00_txtMeIntakeMetod"))).selectByVisibleText("Oral (by mouth)");
	  new Select(driver.findElement(By.id("ctl00_txtMeFre"))).selectByVisibleText("Twice a day");
	  driver.findElement(By.id("ctl00_txtMeReason")).clear();
	  driver.findElement(By.id("ctl00_txtMeReason")).sendKeys("bbb");
	  driver.findElement(By.id("ctl00_txtMeNotes")).clear();
	  driver.findElement(By.id("ctl00_txtMeNotes")).sendKeys("Medication");
	  
	 
	    
	     String alertText = "";
	WebDriverWait wait = new WebDriverWait(driver, 5);
	// This will wait for a maximum of 5 seconds, everytime wait is used

	driver.findElement(By.id("ctl00_btnMecaSave")).click();//causes page to alert() something

	screenshot.setCaptureScreenShot(driver);
	wait.until(ExpectedConditions.alertIsPresent());
	// Before you try to switch to the so given alert, he needs to be present.

	Alert alert = driver.switchTo().alert();
	alertText = alert.getText();
	alert.accept();
	
	System.out.println("Exercise : " + alertText);
	//driver.switchTo().window(parentHandle);
	
	/*assertEquals(closeAlertAndGetItsText(), "Medication Information inserted successfully.");
	  driver.findElement(By.id("ctl00_btnMeView")).click();
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  assertEquals(driver.getTitle(), "Summary");
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  assertEquals(driver.findElement(By.id("Medication")).getText(), "Current Medication Detail");*/
	  
    }catch(Exception e){
		
	  System.out.println(e.toString());
		//driver.switchTo().window(parentHandle);
	  }
  }

}
