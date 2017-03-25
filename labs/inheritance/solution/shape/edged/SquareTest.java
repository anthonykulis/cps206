package labs.inheritance.solution.shape.edged;

public class SquareTest {


	public void testToSquare(){
		System.out.println("Testing Square::toSquare");
		RightTriangle rightTriangle = new RightTriangle(3, 5);
		Square square = Square.toSquare(rightTriangle);
		assert(rightTriangle.area() == square.area());
	}

	public static void main(String... args){
		SquareTest squareTest = new SquareTest();
		squareTest.testToSquare();
		System.out.println("Completed Square tests");

	}
}
