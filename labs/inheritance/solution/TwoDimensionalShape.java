package labs.inheritance.solution;

abstract class TwoDimensionalShape {

	abstract double area();

	public final boolean equals(TwoDimensionalShape other){
		return this.area() == other.area();
	}

}