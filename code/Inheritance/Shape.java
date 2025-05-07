package inheritance;

/*
 * abstract class contains at least one abstract method 
 */

public abstract class Shape {
	
	private String shape_name;
	
	public Shape(String name){
		this.shape_name = name;
	}
	
	/*
	 * abstract method contains only the method declaration  
	 * no method body 
	 */
	public abstract double getArea();

}
