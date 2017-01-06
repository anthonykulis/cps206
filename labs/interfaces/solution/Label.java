package labs.interfaces.solution;


class Label {

	private final Color color;
	private final String text;
	private final Image image;


	private Label(){
		this.color = null;
		this.text = null;
		this.image = null;
	}

	public Label(Color color, String text, Image image){
		this.color = color;
		this.text = text;
		this.image = image;
	}

	public Color getColor() {
		return color;
	}

	public String getText() {
		return text;
	}

	public Image getImage() {
		return image;
	}

	/* Tests */

	public static void main(String... args){

		Color color = new Color(1,12,11);
		String text = "label";
		Image image = new Image(400,600);

		Label label = new Label(color, text, image);

		assert(label.getColor() == color);
		assert(label.getImage() == image);
		assert(label.getText().equals(text));

	}
}