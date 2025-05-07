package inheritance;

import java.util.Scanner;

public class MainClass {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		Shape shape;
		
		do{
			System.out.println("Press 0 -> Exit");
			System.out.println("Press 1 -> Circle");
			System.out.println("Press 2 -> Rectangle");
			
			int choice = scan.nextInt();
			
			if(choice == 0)
				break;
			else if(choice == 1){
				
				System.out.println("Eneter radious of a circle: ");
				double radious = scan.nextDouble();
				
				shape = new Circle("Circle 1", radious);
				System.out.println("Area of Circle1 is: " + shape.getArea());
			}
			
			else if(choice == 2){
				System.out.println("Eneter length of a rectangle: ");
				double length = scan.nextDouble();
				System.out.println("Eneter width of a rectangle: ");
				double width = scan.nextDouble();
				
				shape = new Rectangle("Rectangle 1", length, width);
				System.out.println("Area of Circle1 is: " + shape.getArea());
			}
			
		}while(true);

		System.out.println("Thank you. Program exit.");
		
		scan.close();
	}

}
