package labs.inheritance.solution;

public class ExtraCredit {

	public static Square circleToSquare(Circle circle){
		double area = circle.area();
		double side = Math.sqrt(area);
		return new Square(side);
	}

	public static Circle squareToCircle(Square sqaure){
		double area = sqaure.area();
		double radiusSquared = area / Math.PI;
		double radius = Math.sqrt(radiusSquared);
		return new Circle(radius);
	}
}