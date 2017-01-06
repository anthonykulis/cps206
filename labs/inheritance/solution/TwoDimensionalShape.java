package labs.inheritance.solution;

abstract class TwoDimensionalShape {

	abstract double area();

	public boolean equals(TwoDimensionalShape other){
		return this.area() == other.area();
	}

}