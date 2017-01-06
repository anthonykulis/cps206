package labs.inheritance.solution;

abstract class EllipseShape extends TwoDimensionalShape {

	private double minorAxis;
	private double majorAxis;

	protected EllipseShape(double minorAxis, double majorAxis){
		this.setMinorAxis(minorAxis);
		this.setMajorAxis(majorAxis);
	}

	public double getMinorAxis() {
		return minorAxis;
	}

	public void setMinorAxis(double minorAxis) {
		this.minorAxis = minorAxis;
	}

	public double getMajorAxis() {
		return majorAxis;
	}

	public void setMajorAxis(double majorAxis) {
		this.majorAxis = majorAxis;
	}

	public double area(){ return this.getMajorAxis() * this.getMinorAxis() * Math.PI; }

	abstract double circumference();

	public String toString(){
		return "majorAxis: " + majorAxis + "  minorAxis: " + minorAxis + "   area: " + this.area();
	}
}