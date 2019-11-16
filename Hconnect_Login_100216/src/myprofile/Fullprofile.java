package myprofile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import com.kcs.utils.utility;

import framework.BasetestScript;

public class Fullprofile extends BasetestScript {
  
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();


  @Test
  public void testUntitled() throws Exception {

	  utility screenshot = new utility();
	  utility.Login(utility.UID, utility.PWD, driver); //Login

	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	  
	//Personal Profile
    driver.findElement(By.id("ctl00_lnkHealthSummary")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnEdit")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).clear();
    
    WebElement Firstname = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName"));
    Firstname.sendKeys("test");
    System.out.println("FirstName is : " + Firstname.getAttribute("value"));
    
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).clear();
    WebElement Lastname = driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName"));
    Lastname.sendKeys("date");
    System.out.println("LastName is : " + Lastname.getAttribute("value"));
    
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgToDate")).click();
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpBloodGroup"))).selectByVisibleText("B -");
    
    driver.findElement(By.linkText("2Contact Information")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobile")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobile")).sendKeys("123456789");
    
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress")).sendKeys("Ahmedabad");
    
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPhone")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPhone")).sendKeys("987654321");
    
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtZipCode")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtZipCode")).sendKeys("362001");
    
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHosArea")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHosArea")).sendKeys("ahmedabad");
    
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpDocCity"))).selectByVisibleText("Ahmedabad");
    
    driver.findElement(By.linkText("3Advance Information")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPerAddress")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPerAddress")).sendKeys("junagadh");
    
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlEthnicity"))).selectByVisibleText("Don't want to disclose/Not Applicable");
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_ddlRace"))).selectByVisibleText("Asian");
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpNationality"))).selectByVisibleText("Indian");
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpMaritialStatus"))).selectByVisibleText("Single");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWorkPhone")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWorkPhone")).sendKeys("5558886664");
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpUIDNo"))).selectByVisibleText("Driving license");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtUIDNo")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtUIDNo")).sendKeys("GJ20161290");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnAddUID")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave")).click();
    assertEquals(closeAlertAndGetItsText(), "Personal Profile Updated Successfully .");
    screenshot.setCaptureScreenShot(driver);
    
    
    //Emergency Profile
    driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_liEmergency > p")).click();
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpEmergencyRelationship"))).selectByVisibleText("Father");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTitle")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTitle")).sendKeys("Hello");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFname")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFname")).sendKeys("C");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMName")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMName")).sendKeys("D");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLName")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLName")).sendKeys("Tilva");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmerHealthMessage")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmerHealthMessage")).sendKeys("Stay Healthy");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAdditional")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAdditional")).sendKeys("Good");
    driver.findElement(By.cssSelector("#Fifth > a")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMob")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMob")).sendKeys("654321456");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPhn")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPhn")).sendKeys("789654256");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmail")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtEmail")).sendKeys("contact@gmail.com");
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpCiti"))).selectByVisibleText("Junagadh");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtZip")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtZip")).sendKeys("362001");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress1")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress1")).sendKeys("Barsana");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress2")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress2")).sendKeys("Zanzarda road");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress3")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress3")).sendKeys("Jungadh");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnEmeSave")).click();
    assertEquals(closeAlertAndGetItsText(), "Emergency Profile Inserted Successfully.");
    
    screenshot.setCaptureScreenShot(driver);
    
    //Family History
    driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_liFamilyHistory > p")).click();
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drp"))).selectByVisibleText("Father");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFamilyAge")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFamilyAge")).sendKeys("56");
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpFamilyAge"))).selectByVisibleText("Years");
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpMedicalCondition"))).selectByVisibleText("Acid Indigestion and Upset Stomach");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSaveFamily")).click();    
    assertEquals(closeAlertAndGetItsText(), "Family History Inserted Successfully.");
    
    screenshot.setCaptureScreenShot(driver);
    
    //Occupational History
    driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_liOccupational > p")).click();
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpOccupationEmployement"))).selectByVisibleText("Employed (Full time/Part time)");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_chkOccupation6")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_chkOccupation4")).click();
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpOccupationFactorydetail"))).selectByVisibleText("Air pollution : toxics, waste");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnOccupationSave")).click();
    assertEquals(closeAlertAndGetItsText(), "Occupational History Inserted Successfully.");
    
    screenshot.setCaptureScreenShot(driver);
    
    //Appointments
    driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_liAppointments > p")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWhom")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWhom")).sendKeys("Dr. Deepak");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_ImgApointmemntDate")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_CalendarExtender3_day_1_6")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAppointmentstime")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAppointmentstime")).sendKeys("11");
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpAppointmentstime"))).selectByVisibleText("A.M");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtVisitReason")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtVisitReason")).sendKeys("Hello");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_Button2")).click();
    assertEquals(closeAlertAndGetItsText(), "Appointments Inserted Successfully.");
    
    screenshot.setCaptureScreenShot(driver);
    
    //Security Question
    driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_liSecurity > p")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnsecurityedit")).click();
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpSecurity"))).selectByVisibleText("What is the name of your first School?");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAnswer")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAnswer")).sendKeys("Noble");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnsecuritySave")).click();
    screenshot.setCaptureScreenShot(driver);
    
    //Insurance Profile
    driver.findElement(By.cssSelector("#ctl00_ContentPlaceHolder1_liInsurance > p")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtInsCom")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtInsCom")).sendKeys("LIC");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPlan")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPlan")).sendKeys("LICPLAN");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPoNo")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPoNo")).sendKeys("LIC20196024563");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAmount")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAmount")).sendKeys("500000");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_Image1")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCoverage")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtCoverage")).sendKeys("Hello");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtContactInfo")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtContactInfo")).sendKeys("Hi");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtNo")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtNo")).sendKeys("Good");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnInuSave")).click();
    assertEquals(closeAlertAndGetItsText(), "Insurance Profile Inserted Successfully.");
    screenshot.setCaptureScreenShot(driver);
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
