package inheritance;

public class Circle extends Shape{
	
	private double radious;
	
	// final value are not changed and static during whole program lifetime
	final static double pi = 3.1416;
	
	public Circle(String name, double radious) {
		//super is used to connect with parent class Shape
		super(name);
		
		this.radious = radious;
	}
	
	/*
	 * method overwriting 
	 * @see inheritance.Shape#getArea()
	 */
	public double getArea(){
		double area = 0;
		area = pi * radious * radious;	
		return area;
	}
	

}
