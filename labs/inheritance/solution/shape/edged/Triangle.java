package labs.inheritance.solution.shape.edged;

abstract class Triangle extends EdgedShape {

	public Triangle(double height, double base){
		super(height, base);
	}

	public double area(){
		return this.getHeight() * this.getWidth() * .5;
	}
}