package labs.POJO.solution;

class Lid {
	double height;
	double diameter;
	Color color;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getDiameter() {
		return diameter;
	}

	public void setDiameter(double diameter) {
		this.diameter = diameter;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	/* Tests */
	void test(){
		testHeight();
		testDiameter();
		testColor();
	}

	private void testHeight(){
		this.setHeight(3.0);
		assert(this.getHeight() == 3.0);
	}

	private void testDiameter(){
		this.setDiameter(4.0);
		assert(this.getDiameter() == 4.0);
	}

	private void testColor(){
		Color blue = new Color(0, 0, 255);
		this.setColor(blue);
		assert(this.getColor() == blue);
	}

	public static void main(String... args){
		Lid lid = new Lid();
		lid.test();
	}
}