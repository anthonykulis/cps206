package labs.interfaces.solution;


class Color {
	private final int red;
	private final int blue;
	private final int green;

	private Color(){
		this.red = this.green = this.blue = 0;
	}

	public Color(int red, int green, int blue){
		this.red = red;
		this.green = green;
		this.blue = blue;
	}


	public int getRed() {
		return red;
	}

	public int getBlue() {
		return blue;
	}

	public int getGreen() {
		return green;
	}

	/* tests */
	public static void main(String... args){
		Color color = new Color(1,2,3);
		assert(color.getRed() == 1);
		assert(color.getGreen() == 2);
		assert(color.getBlue() == 3);
	}
}