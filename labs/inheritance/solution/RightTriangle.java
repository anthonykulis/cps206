package labs.inheritance.solution;

public final class RightTriangle extends Triangle {

	public RightTriangle(double height, double base){
		super(height, base);
	}

	public double perimeter(){
		double height = this.getHeight();
		double width = this.getWidth();
		double hypotenuse = Math.sqrt(height * height + width * width);
		return height + width + hypotenuse;
	}

	/* test */
	void test(){
		testPerimeter();
		testArea();
	}

	private void testPerimeter(){
		this.setHeight(10);
		this.setWidth(10);
		double h = Math.sqrt(10 * 10 + 10 * 10);
		assert(this.perimeter() == 10 + 10 + h);
	}

	private void testArea(){
		this.setHeight(10);
		this.setWidth(10);
		assert(this.area() == .5 * 10 * 10);
	}

	public static void main(String... args){
		RightTriangle rightTriangle = new RightTriangle(10, 10);
		rightTriangle.test();
	}
}