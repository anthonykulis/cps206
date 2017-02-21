package labs.inheritance.solution;

public final class Circle extends Ellipse {

	public Circle(double radius){
		super(radius, radius);
	}

	public final double circumference(){ return (this.getMinorAxis() + this.getMajorAxis()) * Math.PI; }


}