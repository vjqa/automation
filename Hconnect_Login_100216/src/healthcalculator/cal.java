/*package healthcalculator;

import java.text.DecimalFormat;
import java.util.Scanner;


public class cal
{
	public static void main(String[] args) 
	{
		double bmi;
		double waistratio;
		double waist = 34;
		double hips = 40;
		double height = 1.6;
		double weight = 60;
		
		bmi = ((weight)/(height*height) * 100) ;
		System.out.println("bmi : " + bmi);
		
		waistratio = waist/height;
		System.out.println("Waist/height ration is : " + waistratio);
		
		String Waist = "96";
		String Height = "173";
		double totalBmr;
		totalBmr = (Double.parseDouble(Waist) / Double.parseDouble(Height));
		DecimalFormat f1 = new DecimalFormat("##.00");
		f1.format(totalBmr);
		System.out.println("ratio" + f1);
		 
		Scanner input = new Scanner (System.in);
		System.out.println ("Enter a value for feet: ");
		  double meter = input.nextDouble();
		  double height = input.nextDouble();
		  double meters = meter/100;
		  double heights = height/100;
		  System.out.println (meters + " Cms is " + heights + " meters ");
		
		  double wmeters = Double.parseDouble("96") / 100;
			double hmeters = Double.parseDouble("173") / 100;
			double sqrt = Math.sqrt(hmeters);
			double totalBai = (100 * wmeters / hmeters * sqrt) - 18;
			DecimalFormat f = new DecimalFormat("##.00");
			f.format(totalBai);
			System.out.println("" + totalBai);
	}
}


public static String getToDate(String fromDate, String duration){
    try {
        String[] arrFromDate = fromDate.split("/");
        int fromMonth = Integer.parseInt(arrFromDate[0])-1;
        int fromDay = Integer.parseInt(arrFromDate[1]);
        int fromYear = Integer.parseInt(arrFromDate[2]);
        int intDuration = Integer.parseInt(duration);
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, fromDay);
        cal.set(Calendar.MONTH, fromMonth);
        cal.set(Calendar.YEAR, fromYear);   
        cal.add(Calendar.DAY_OF_MONTH, intDuration);
        String toDate = sdf.format(cal.getTime());
        return toDate;
    } catch (NumberFormatException e) {
        e.printStackTrace();
        return null;
    }
    
    String appToDate = driver.findElement(By.id("toDate")).getText();
    String myToDate = getToDate("01/01/2001","10");
    boolean isToDateCorrect = false;
    if (appToDate.equals(myToDate )){
        isToDateCorrect  = true;
    }

*/