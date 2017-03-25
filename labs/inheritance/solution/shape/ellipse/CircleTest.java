package labs.inheritance.solution.shape.ellipse;

public class CircleTest {

	private void testCircumference(){
		System.out.println("Testing Circle::circumference");
		Circle circle = new Circle(3);
		assert(circle.circumference() == (3 + 3) * Math.PI);
	}

	private void testArea(){
		System.out.println("Testing Circle::area");
		Circle circle = new Circle(3);
		assert(circle.area() == Math.PI * 3 * 3);
	}

	private void testToCircle(){
		System.out.println("Testing Circle::toCircle");

		// purposely making a circle. hard to test for round off error
		Ellipse ellipse = new Ellipse(3, 3);
		Circle circle = Circle.toCircle(ellipse);

		assert(ellipse.area() == circle.area());
	}

	public static void main(String... args){
		CircleTest test = new CircleTest();
		test.testCircumference();
		test.testArea();
		test.testToCircle();
		System.out.println("Completed Circle tests");
	}
}
