package myprofile;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class profile {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	/*System.setProperty("webdriver.chrome.driver", "D:\\Vrajesh\\General\\workspace\\Hconnect_Login\\src\\Driver\\chromedriver.exe");
	driver = new ChromeDriver();*/
	
	/*System.setProperty("webdriver.ie.driver", "D:\\SW\\Jmeter softwares\\selenium\\IEDriverServer.exe");
	driver = new InternetExplorerDriver();*/
	
	/*System.setProperty("webdriver.firefox.bin", "C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");  */
	driver = new FirefoxDriver();
	
    baseUrl = "https://www.hconnect.in/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testMyprofile() throws Exception {
   	driver.get(baseUrl + "/Login");
    driver.findElement(By.id("txtUserName")).clear();
    driver.findElement(By.id("txtUserName")).sendKeys("9016836027");
    driver.findElement(By.id("txtPassword")).clear();
    driver.findElement(By.id("txtPassword")).sendKeys("123456");
    driver.findElement(By.id("imgBtnLogin")).click();
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);    
    driver.findElement(By.cssSelector("i.healthsummary")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnEdit")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtFirstName")).sendKeys("vrajesh");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtLastName")).sendKeys("tilva");
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);   
    driver.findElement(By.linkText("2Contact Information")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtMobile")).sendKeys("9016836027");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtAddress")).sendKeys("Ashram road");
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave")).click();
    driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);   
    assertEquals(closeAlertAndGetItsText(), "Personal Profile Updated Successfully .");          
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
