package overloading;

public class NumberProcessing {
	
	private double average;
	
	public void averageCalculate(double a, double b){
		average = (a + b) / 2;
		System.out.println("Average of " + a + " and " + b + " is:  " + average);
	}
	
	public void averageCalculate(double a, double b, double c){
		average = (a + b + c) / 3;
		System.out.println("Average of " + a + ", " + b +  " and " + c + " is:  " + average);
	}
	
	public void averageCalculate(double a, double b, double c, double d){
		average = (a + b + b + c) / 4;
		System.out.println("Average of " + a + ", " + b +  ", " + c +  " and " + d + " is:  " + average);
	}

}
