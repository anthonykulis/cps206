package labs.inheritance.solution.shape.edged;

public class RectangleTest {


	private void testArea(){
		System.out.println("Testing Rectangle::area");
		Rectangle rectangle = new Rectangle(3,10);
		assert(rectangle.area() == 3 * 10);
	}

	private void testPerimeter(){
		System.out.println("Testing Rectangle::perimeter");
		Rectangle rectangle = new Rectangle(3,10);
		assert(rectangle.perimeter() == 3+3+10+10);
	}

	public static void main(String... args){
		RectangleTest test = new RectangleTest();
		test.testArea();
		test.testPerimeter();
		System.out.println("Rectangle tests completed");
	}
}
