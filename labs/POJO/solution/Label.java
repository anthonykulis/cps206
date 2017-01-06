package labs.POJO.solution;


class Label {

	Color color;
	String text;
	Image image;


	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	/* Tests */
	void test(){
		testColor();
		testImage();
		testText();
	}

	private void testColor(){
		Color blue = new Color(0,0,255);
		this.setColor(blue);
		assert(this.getColor() == blue);
	}

	private void testImage(){
		Image image = new Image();
		this.setImage(image);
		assert(this.getImage() == image);
	}

	private void testText(){
		this.setText("root beer");
		assert(this.getText().equals("root beer"));
	}

	public static void main(String... args){
		Label label = new Label();
		label.test();
	}
}