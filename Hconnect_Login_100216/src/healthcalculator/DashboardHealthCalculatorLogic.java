package healthcalculator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.javascript.host.Element;
import com.kcs.utils.utility;
import com.thoughtworks.selenium.webdriven.commands.GetText;

import framework.BasetestScript;

public class DashboardHealthCalculatorLogic extends BasetestScript
{
	List<String> inputList = new ArrayList<String>();
	List<String> viewList = new ArrayList<String>();

@Test(priority = 1)
public void BMICalculation() throws IOException, InterruptedException 
{
	utility.Login(utility.UID, utility.PWD, driver); // Login
	System.out.println("Enter User Credential");
	
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='Main']/div/div[2]/div[2]/div[4]/div[1]/span/a[2]")).click(); // Click to Calculator
	
	CalculationInput("13-Feb-2016","32", "40", "160", "60", "Sedentary", "BMI");
	//System.out.println("Health Calculator input data Inserted Successfully");
	driver.findElement(By.id("ctl00_ContentPlaceHolder1_bntSave")).click();
	
	
	/*String alertText = "";
	Alert alert = driver.switchTo().alert();
	alertText = alert.getText();
	alert.accept();

	System.out.println("Calculator : " + alertText);*/
	Thread.sleep(2000);
	
	viewList.clear();
	viewList.add(driver
			.findElement(
					By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[2]")) //date
			.getText());
	viewList.add(driver
			.findElement(
					By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[3]")) //height
			.getText());
	viewList.add(driver
			.findElement(
					By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[4]")) //weight
			.getText());
	viewList.add(driver
			.findElement(
					By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[5]")) //BMI
			.getText());
	
	
	
	for (int i = 0; i < inputList.size(); i++) {
		if (inputList.get(i).equals(viewList.get(i))) {
			System.out.println("true : " + " inputValue " + " --> "
					+ inputList.get(i) + " viewList " + " --> "
					+ viewList.get(i));
		} else {
			System.out.println("false : " + " inputValue " + " --> "
					+ inputList.get(i) + " viewList " + " --> "
					+ viewList.get(i));
		}

	}
	System.out
			.println("Success "
					+ driver.findElement(
							By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[2]"))
							.getText());
}

public void CalculationInput(String date, String Waist, String Hips, String Height, String Weight,String activity, String BMI) throws InterruptedException 
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtDate']")).clear();
	driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_txtDate']")).sendKeys(date);
    //driver.findElement(By.id("ctl00_ContentPlaceHolder1_imgToDate")).click();
    //driver.findElement(By.id("ctl00_ContentPlaceHolder1_calBdayExtender_day_1_2")).click();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWaist")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWaist")).sendKeys(Waist);
    Thread.sleep(1000);
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHips")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHips")).sendKeys(Hips);
    Thread.sleep(1000);
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHeight")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtHeight")).sendKeys(Height);
    Thread.sleep(1000);
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWeight")).clear();
    driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtWeight")).sendKeys(Weight);
    Thread.sleep(1000);
    
    driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[5]")).sendKeys();
    new Select(driver.findElement(By.id("ctl00_ContentPlaceHolder1_drpActivelystatus"))).selectByVisibleText(activity);
    
    double bmi;
	double waistratio;
	double waist = 34;
	double hips = 40;
	double height = 1.6;
	double weight = 60;
	
	bmi = (weight)/(height*height) * 100 ;
	System.out.println("bmi : " + bmi);
	
	waistratio = waist/height;
	System.out.println("Waist/height ration is : " + waistratio);
	
    inputList.add(date);
	//inputList.add(Waist);
	//inputList.add(Hips);
	inputList.add(Height);
	inputList.add(Weight);
	//inputList.add(activity);
	inputList.add(BMI);
	System.out.println(inputList.size() + "-->" + inputList);
}

/*public static void main(String args[])
{
	void BMICal()
	{
		WebElement weight = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[4]")); //weight
		WebElement height = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divLoadAllData']/table/tbody/tr[2]/td[3]")); //height
		weight.getText();
		height.getText();
		String bmi;
		
	}

}*/

/*public class cal 
{
	public void main(String[] args) 
	{
		double bmi;
		double waistratio;
		double waist = 34;
		double hips = 40;
		double height = 1.6;
		double weight = 60;
		
		bmi = (weight)/(height*height) * 100 ;
		System.out.println("bmi : " + bmi);
		
		waistratio = waist/height;
		System.out.println("Waist/height ration is : " + waistratio);
	}
}*/
}
/* public void logic(String Weight,String Height)
  {
	 
	  
	  //general health
	  .//*[@id='ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[1]  //height
	  .//*[@id='ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[2]  //Weight
	  
	  .//*[@id='ctl00_ContentPlaceHolder1_divGeneralHealth']/table/tbody/tr[2]/td[4]   //BMI
  }

@Test
public void Logic() throws IOException, InterruptedException 
{
	  utility.Login(utility.UID, utility.PWD, driver); //Login
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  System.out.println("Enter User Credential");	  
	 
	 WebElement Height = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblHeight']")); 
	 String stng = Height.getText();
	 System.out.println("Height" + stng);
	 WebElement Weight = driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_lblWeight']"));
	 String stng1 = Weight.getText();
	 System.out.println("Weight" + stng1);
	 
	 
	 //driver.findElement(By.xpath(".//*[@id='ctl00_ContentPlaceHolder1_divBodyInfo']/table/tbody/tr[1]/td[2]")).getText();
	 
	 
	  //weight/(height*height)*100
}

@Test
public void testUntitled() throws Exception {
  
  driver.get("http://register.rediff.com/commonreg/index.php?redr=http://portfolio.rediff.com/money/jsp/loginnew.jsp?redr=home");

  int count = 0;
  String[] exp = {"Month", "JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};
  WebElement dropdown = driver.findElement(By.id("date_mon"));
  Select select = new Select(dropdown);

  List<WebElement> options = select.getOptions();
  for (WebElement we : options) {
      for (int i = 0; i < exp.length; i++) {
          if (we.getText().equals(exp[i])) {
              count++;
          }
      }
  }
  if (count == exp.length) {
      System.out.println("matched");
  } else {
      System.out.println("Houston, we have a problem.");
  }
}*/

