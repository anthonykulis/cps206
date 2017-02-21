package labs.inheritance.solution.shape.edged;

import labs.inheritance.solution.shape.TwoDimensionalShape;

public final class Square extends Rectangle {

	public Square(double side){
		super(side, side);
	}

	public static Square toSquare(TwoDimensionalShape twoDimensionalShape){
		double area = twoDimensionalShape.area();
		double side = Math.sqrt(area);
		return new Square(side);
	}
}