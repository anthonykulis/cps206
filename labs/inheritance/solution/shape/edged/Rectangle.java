package labs.inheritance.solution.shape.edged;

public class Rectangle extends EdgedShape {

	public Rectangle(double height, double width){
		super(height, width);
	}

	public final double area(){ return this.getHeight() * this.getWidth(); }
	public final double perimeter(){ return this.getHeight() * 2 + this.getWidth() * 2; }


}