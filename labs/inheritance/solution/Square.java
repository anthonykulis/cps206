package labs.inheritance.solution;

public final class Square extends Rectangle {

	public Square(double side){
		super(side, side);
	}

	/* Tests - for equals only - note this is a BAD place to test that class */

	public static void main(String... args){
		Square square = new Square(1);
		Square square1 = new Square(2);
		Square square2 = new Square(1);
		assert(square.equals(square2));
		assert(!square.equals(square1));
	}
}