package healthcalculator;


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
		
		bmi = (weight)/(height*height) * 100 ;
		System.out.println("bmi : " + bmi);
		
		waistratio = waist/height;
		System.out.println("Waist/height ration is : " + waistratio);
	}
}
