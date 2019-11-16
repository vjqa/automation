package reports;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReportOld {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @BeforeClass(alwaysRun = true)
  public void setUp() throws Exception {
	/*System.setProperty("webdriver.chrome.driver", "D:\\Vrajesh\\General\\workspace\\Hconnect_Login\\src\\Driver\\chromedriver.exe");
	
	driver = new ChromeDriver();*/
	
	System.setProperty("webdriver.ie.driver", "D:\\SW\\Jmeter softwares\\selenium\\IEDriverServer.exe");
	driver = new InternetExplorerDriver();
	driver.manage().window().maximize();
	
    baseUrl = "https://www.hconnect.in/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testReport() throws Exception {
    driver.get(baseUrl + "/Login");
    driver.findElement(By.id("txtUserName")).sendKeys("9016836027");
    driver.findElement(By.id("txtPassword")).sendKeys("123456");;
    driver.findElement(By.id("imgBtnLogin")).click();
    driver.findElement(By.xpath("//h1[@id='ctl00_ContentPlaceHolder1_hdHealthRecords']/a")).click();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    // ERROR: Caught exception [ERROR: Unsupported command [waitForPopUp |  | 30000]]
    // ERROR: Caught exception [Error: locator strategy either id or name must be specified explicitly.]
    
    driver.findElement(By.xpath(".//*[@id='304']")).clear();
    driver.findElement(By.xpath(".//*[@id='304']")).sendKeys("14");
    System.out.println("1st element get");
    
    driver.findElement(By.xpath(".//*[@id='305']")).clear();
    driver.findElement(By.xpath(".//*[@id='305']")).sendKeys("500");
    System.out.println("2nd element get");
    
    driver.findElement(By.xpath(".//*[@id='306']")).clear();
    driver.findElement(By.xpath(".//*[@id='306']")).sendKeys("500");
    System.out.println("3rd element get");
    
    driver.findElement(By.xpath(".//*[@id='322']")).clear();
    driver.findElement(By.xpath(".//*[@id='322']")).sendKeys("6000");
    System.out.println("4th element get");
    
    driver.findElement(By.xpath(".//*[@id='2418']")).clear();
    driver.findElement(By.xpath(".//*[@id='2418']")).sendKeys("25");
    System.out.println("5th element get");
    
    driver.findElement(By.xpath(".//*[@id='1108']")).clear();
    driver.findElement(By.xpath(".//*[@id='1108']")).sendKeys("22");
    System.out.println("6th element get");
    
    driver.findElement(By.xpath(".//*[@id='2498']")).clear();
    driver.findElement(By.xpath(".//*[@id='2498']")).sendKeys("65");
    System.out.println("7th element get");
    
    driver.findElement(By.xpath(".//*[@id='1075']")).clear();
    driver.findElement(By.xpath(".//*[@id='1075']")).sendKeys("hello");
    System.out.println("8th element get");
    
    driver.findElement(By.id("btnSavePatient")).click();
    assertEquals(closeAlertAndGetItsText(), "Error in View Detail");
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
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
