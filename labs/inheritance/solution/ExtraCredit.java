package labs.inheritance.solution;

public class ExtraCredit {

	public static Square toSquare(TwoDimensionalShape shape){
		double area = shape.area();
		double side = Math.sqrt(area);
		return new Square(side);
	}

	public static Circle toCircle(TwoDimensionalShape shape){
		double area = shape.area();
		double radiusSquared = area / Math.PI;
		double radius = Math.sqrt(radiusSquared);
		return new Circle(radius);
	}
}