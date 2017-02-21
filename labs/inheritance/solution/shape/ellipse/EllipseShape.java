package labs.inheritance.solution.shape.ellipse;

import labs.inheritance.solution.shape.TwoDimensionalShape;

abstract class EllipseShape extends TwoDimensionalShape {

	private double minorAxis;
	private double majorAxis;

	protected EllipseShape(double minorAxis, double majorAxis){
		this.setMinorAxis(minorAxis);
		this.setMajorAxis(majorAxis);
	}

	public final double getMinorAxis() {
		return minorAxis;
	}

	public final void setMinorAxis(double minorAxis) {
		this.minorAxis = minorAxis;
	}

	public final double getMajorAxis() {
		return majorAxis;
	}

	public final void setMajorAxis(double majorAxis) {
		this.majorAxis = majorAxis;
	}

	public final double area(){ return this.getMajorAxis() * this.getMinorAxis() * Math.PI; }

	abstract double circumference();

	public String toString(){
		return "majorAxis: " + majorAxis + "  minorAxis: " + minorAxis + "   area: " + this.area();
	}
}