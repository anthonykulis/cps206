package labs.inheritance.solution.shape.edged;


import labs.inheritance.solution.shape.TwoDimensionalShape;

abstract class EdgedShape extends TwoDimensionalShape {
	private double height;
	private double width;

	public EdgedShape(double height, double width){
		this.setHeight(height);
		this.setWidth(width);
	}

	public final double getHeight() {
		return height;
	}

	public final void setHeight(double height) {
		this.height = height;
	}

	public final double getWidth() {
		return width;
	}

	public final void setWidth(double width) {
		this.width = width;
	}

	abstract public double area();
	abstract public double perimeter();

	public final String toString(){
		return "height: " + height + "  width: " + width + "   area: " + this.area();
	}
}
