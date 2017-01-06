package labs.inheritance.solution;

public class Rectangle extends EdgedShape {

	public Rectangle(double height, double width){
		super(height, width);
	}

	public double area(){ return this.getHeight() * this.getWidth(); }
	public double perimeter(){ return this.getHeight() * 2 + this.getWidth() * 2; }

	/* Tests */
	void test(){
		testArea();
		testPermieter();
	}

	private void testArea(){
		this.setHeight(3);
		this.setWidth(10);
		assert(this.area() == 3 * 10);
	}

	private void testPermieter(){
		this.setHeight(3);
		this.setWidth(10);
		assert(this.perimeter() == 3+3+10+10);
	}

	public static void main(String... args){
		Rectangle rectangle = new Rectangle(3,10);
		rectangle.test();
	}
}