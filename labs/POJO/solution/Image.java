package labs.POJO.solution;


class Image {
	double height;
	double width;

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	/* Tests */
	void test(){
		testHeight();
		testWidth();
	}

	private void testHeight(){
		this.setHeight(1.0);
		assert(this.getHeight() == 1.0);
	}

	private void testWidth(){
		this.setWidth(2.3);
		assert(this.getWidth() == 2.3);
	}

	public static void main(String... args){
		Image image = new Image();
		image.test();
	}
}