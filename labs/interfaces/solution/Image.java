package labs.interfaces.solution;


class Image {

	private final double height;
	private final double width;

	private Image(){
		this.height = this.width = 0;
	}

	public Image(double height, double width){
		this.height = height;
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

	/* Tests */
	void test(){
		testHeight();
		testWidth();
	}

	private void testHeight(){
		assert(this.getHeight() == 1.0);
	}

	private void testWidth(){
		assert(this.getWidth() == 2.3);
	}

	public static void main(String... args){
		Image image = new Image(1, 2.3);
		image.test();
	}
}