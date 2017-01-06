package labs.inheritance.solution;

public class Driver {
	public static void main(String... args){
		Square square = new Square(4);
		Circle circle = new Circle(4.3);
		Ellipse ellipse = new Ellipse(3, 5);
		Rectangle rectangle = new Rectangle(3, 9);
		RightTriangle rightTriangle = new RightTriangle(8, 4);

		System.out.println(square.equals(circle));
		System.out.println(square.equals(rightTriangle));

		Circle fromSquare = ExtraCredit.toCircle(square);
		Square fromCircle = ExtraCredit.toSquare(circle);
		Circle fromRightTriangle = ExtraCredit.toCircle(rightTriangle);
		Square fromEllise = ExtraCredit.toSquare(ellipse);

		System.out.println(fromSquare + " <<< >>> " + square);
		System.out.println(fromCircle + " <<< >>> " + circle);
		System.out.println(fromRightTriangle + " <<< >>>" + rightTriangle);
		System.out.println(fromEllise + " <<< >>>" + ellipse);
	}
}