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

	public static void main(String... args){
		CircleTest test = new CircleTest();
		test.testCircumference();
		test.testArea();
		System.out.println("Completed Circle tests");
	}
}
