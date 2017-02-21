package labs.inheritance.solution.shape.edged;

public class RightTriangleTest {

	private void testPerimeter(){
		System.out.println("Testing RightTriangle::perimeter");
		RightTriangle rightTriangle = new RightTriangle(10, 10);
		double h = Math.sqrt(10 * 10 + 10 * 10);
		assert(rightTriangle.perimeter() == 10 + 10 + h);
	}

	private void testArea(){
		System.out.println("Testing RightTriangle::area");
		RightTriangle rightTriangle = new RightTriangle(10, 10);
		assert(rightTriangle.area() == .5 * 10 * 10);
	}

	public static void main(String... args){
		RightTriangleTest rightTriangleTest = new RightTriangleTest();
		rightTriangleTest.testPerimeter();
		rightTriangleTest.testArea();
		System.out.println("Completes RightTriangle tests");
	}

}
