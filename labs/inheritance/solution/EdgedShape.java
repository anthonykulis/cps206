package labs.inheritance.solution;


abstract class EdgedShape extends TwoDimensionalShape {
	private double height;
	private double width;

	public EdgedShape(double height, double width){
		this.setHeight(height);
		this.setWidth(width);
	}

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

	abstract double area();
	abstract double perimeter();

	public String toString(){
		return "height: " + height + "  width: " + width + "   area: " + this.area();
	}
}
