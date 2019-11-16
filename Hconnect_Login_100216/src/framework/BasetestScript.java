package framework;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.kcs.utils.utility;

public class BasetestScript {

	public WebDriver driver = null;

	@BeforeMethod 
	public void OpenBrowser(){
		
		/*System.setProperty("webdriver.chrome.driver", "D:\\Vrajesh\\General\\workspace\\Hconnect_Login\\src\\Driver\\chromedriver.exe");
		
		driver = new ChromeDriver();
		*/
		/*System.setProperty("webdriver.ie.driver", "D:\\SW\\eclipse-java-luna-SR1-RC3-win32-x86_64\\IEDriverServer.exe");
		driver = new InternetExplorerDriver();*/
		driver = new FirefoxDriver();
				
		driver.manage().window().maximize();
		
		driver.get(utility.BASEURL);
		
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	}
	
	@AfterMethod 
	public void closebrowser()
	{
			 driver.quit();
	}
}
	
	/*public void takeScreenShotOnFailure(ITestResult testResult) throws IOException 
	 { 
		 if (testResult.getStatus() == ITestResult.FAILURE) 
		 { 
			 System.out.println(testResult.getStatus()); 
			 File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
			 FileUtils.copyFile(scrFile, new File("D:\\testScreenShot.jpg"));
		 }
		 else
		 {
			 driver.quit();
		 }
		 
	 }*/