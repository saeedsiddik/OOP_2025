package overloading;

public class TestNumberProcess {
	
	public static void main(String[] args) {
		NumberProcessing num = new NumberProcessing();
		num.averageCalculate(10, 25);
		num.averageCalculate(25.5, 65.5, 10);
		num.averageCalculate(10, 20, 30, 40.0);
	}

}
