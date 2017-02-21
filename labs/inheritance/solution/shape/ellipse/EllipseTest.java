package labs.inheritance.solution.shape.ellipse;

public class EllipseTest {


	private void testCircumference(){
		System.out.println("Testing Ellipse::circumference");
		Ellipse ellipse = new Ellipse(3, 5);
		assert(ellipse.circumference() == 2 * Math.PI * Math.sqrt((9.0 + 25.0)/2));
	}

	private void testArea(){
		System.out.println("Testing Ellipse::area");
		Ellipse ellipse = new Ellipse(3, 5);
		assert(ellipse.area() == Math.PI * 3 * 5);
	}

	public static void main(String... args){
		EllipseTest test = new EllipseTest();
		test.testCircumference();
		test.testCircumference();
		System.out.println("Completed Ellipse tests");
	}
}
