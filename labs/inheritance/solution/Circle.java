package labs.inheritance.solution;

public final class Circle extends Ellipse {

	public Circle(double radius){
		super(radius, radius);
	}

	public double circumference(){ return (this.getMinorAxis() + this.getMajorAxis()) * Math.PI; }

	/* Tests */
	void test(){
		testCircumference();
		testArea();
	}

	private void testCircumference(){
		this.setMinorAxis(3);
		this.setMajorAxis(3);
		assert(this.circumference() == (3 + 3) * Math.PI);
	}

	private void testArea(){
		this.setMinorAxis(3);
		this.setMajorAxis(3);
		assert(this.area() == Math.PI * 3 * 3);
	}

	public static void main(String... args){
		Circle c = new Circle(3);
		c.test();
	}
}