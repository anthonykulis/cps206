package labs.inheritance.solution.shape.ellipse;

import labs.inheritance.solution.shape.TwoDimensionalShape;

public final class Circle extends Ellipse {

	public Circle(double radius){
		super(radius, radius);
	}

	public final double circumference(){ return (this.getMinorAxis() + this.getMajorAxis()) * Math.PI; }

	public final String toString(){
		return "radius: " + super.getMajorAxis() + "   area: " + this.area();
	}

	public static Circle toCircle(TwoDimensionalShape twoDimensionalShape){
		double area = twoDimensionalShape.area();
		double radiusSquared = area / Math.PI;
		double radius = Math.sqrt(radiusSquared);
		return new Circle(radius);
	}
}