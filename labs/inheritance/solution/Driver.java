package labs.inheritance.solution;

import labs.inheritance.solution.shape.edged.Rectangle;
import labs.inheritance.solution.shape.edged.RightTriangle;
import labs.inheritance.solution.shape.edged.Square;
import labs.inheritance.solution.shape.ellipse.Circle;
import labs.inheritance.solution.shape.ellipse.Ellipse;

public class Driver {
	public static void main(String... args){
		Square square = new Square(4);
		Circle circle = new Circle(4.3);
		Ellipse ellipse = new Ellipse(3, 5);
		Rectangle rectangle = new Rectangle(3, 9);
		RightTriangle rightTriangle = new RightTriangle(8, 4);

		System.out.println("Square equals circle? " + square.equals(circle));
		System.out.println("Square equals right triangle? " + square.equals(rightTriangle));

		Circle fromSquare = Circle.toCircle(square);
		Square fromCircle = Square.toSquare(circle);
		Circle fromRightTriangle = Circle.toCircle(rightTriangle);
		Square fromEllise = Square.toSquare(ellipse);

		System.out.println("Square to Circle -> " + fromSquare + " <<< FROM >>> " + square);
		System.out.println("Circle to Square -> " + fromCircle + " <<< FROM >>> " + circle);
		System.out.println("RightTriangle to Circle -> " + fromRightTriangle + " <<< FROM >>> " + rightTriangle);
		System.out.println("Ellipse to Square -> " + fromEllise + " <<< FROM >>> " + ellipse);
	}
}