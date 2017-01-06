package labs.inheritance.solution;

public class Ellipse extends EllipseShape {


	public Ellipse(double minorAxis, double majorAxis){
		super(minorAxis, majorAxis);
	}

	public double circumference(){
		double a = this.getMinorAxis();
		double b = this.getMajorAxis();
		return 2 * Math.PI * Math.sqrt((a*a + b*b)/2);
	}

	/* tests */
	void test(){
		testCircumference();
		testArea();
	}

	private void testCircumference(){
		this.setMinorAxis(3);
		this.setMajorAxis(4);
		assert(this.circumference() == 2 * Math.PI * Math.sqrt((9.0 + 16.0)/2));
	}

	private void testArea(){
		this.setMinorAxis(3);
		this.setMajorAxis(4);
		assert(this.area() == Math.PI * 3 * 4);
	}

	public static void main(String... args){
		Ellipse ellipse = new Ellipse(3,4);
		ellipse.test();
	}
}