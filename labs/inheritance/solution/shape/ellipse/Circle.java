package labs.inheritance.solution.shape.ellipse;

public final class Circle extends Ellipse {

	public Circle(double radius){
		super(radius, radius);
	}

	public final double circumference(){ return (this.getMinorAxis() + this.getMajorAxis()) * Math.PI; }

	public final String toString(){
		return "radius: " + super.getMajorAxis() + "   area: " + this.area();
	}
}