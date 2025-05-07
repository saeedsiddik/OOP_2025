package inheritance;

public class Rectangle extends Shape{

	private double length;
	private double width;

	public Rectangle(String name, double length, double width) {
		//super is used to connect with parent class Shape
		super(name);
		
		this.length = length;
		this.width = width;
	}
	
	/*
	 * method overwriting 
	 * @see inheritance.Shape#getArea()
	 */
	public double getArea(){
		double area = 0;
		area = length * width;	
		return area;
	}
	

}
