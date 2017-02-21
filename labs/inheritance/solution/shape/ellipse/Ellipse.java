package labs.inheritance.solution.shape.ellipse;

public class Ellipse extends EllipseShape {


	public Ellipse(double minorAxis, double majorAxis){
		super(minorAxis, majorAxis);
	}

	public double circumference(){
		double a = this.getMinorAxis();
		double b = this.getMajorAxis();
		return 2 * Math.PI * Math.sqrt((a*a + b*b)/2);
	}


}