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

		Circle fromSquare = ExtraCredit.squareToCircle(square);
		Square fromCircle = ExtraCredit.circleToSquare(circle);

		System.out.println(fromSquare + " <<< >>> " + square);
		System.out.println(fromCircle + " <<< >>> " + circle);
	}
}