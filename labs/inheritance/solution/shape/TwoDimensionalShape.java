package labs.inheritance.solution.shape;

abstract public class TwoDimensionalShape {

	abstract public double area();

	public final boolean equals(TwoDimensionalShape other){
		return this.area() == other.area();
	}

}